-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT population 
FROM state 
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. 
-- The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT census_region, state_name
FROM state
ORDER BY census_region DESC, state_name ASC;

-- The biggest park by area
SELECT park_name, area FROM park ORDER BY area DESC LIMIT 1;


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population
FROM city
ORDER BY population DESC
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT park_name, DATE_PART('year', date_established) AS year_established
FROM park
ORDER BY year_established ASC, park_name
LIMIT 20;



-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT (city_name || ', ' || state_abbreviation) AS city_state_name
FROM city;

-- The all parks by name and date established.
SELECT park_name || ' established on ' || date_established AS park_name_established
FROM park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
-- census region: state_name

SELECT census_region || ': ' || state_name AS census_region_state_name
FROM state
WHERE census_region IN ('West', 'Midwest')
ORDER BY census_region_state_name;



-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS avg_population FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS total_population_west_south
FROM state
WHERE census_region IN ('West', 'South');

-- The number of cities with populations greater than 1 million
SELECT COUNT(population)
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT state_name, state_nickname FROM state;

SELECT COUNT(state_nickname)
FROM state;

-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest_park_area, MAX(area) AS largest_park_area
FROM park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.

/*
	1, PA, Pittsburgh
	2, PA, Philadelphia
	3, OH, Cleveland
	4, OH, Columbus

	PA -> 2
	OH -> 2
*/
SELECT state_abbreviation, COUNT(city_name) AS city_count
FROM city
GROUP BY state_abbreviation
ORDER BY city_count DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT AVG(area), has_camping
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population) AS total_city_population
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest_city_population
FROM city
GROUP BY state_abbreviation
HAVING MIN(population) > 15000
ORDER BY smallest_city_population;


/*
	SELECT
	FROM
	WHERE
	GROUP BY
	HAVING
	ORDER BY
	LIMIT
*/


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT city_name, population
FROM city
ORDER BY city_name
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT (SELECT state_name FROM state WHERE ci.state_abbreviation = state.state_abbreviation), COUNT(city_name) AS number_of_cities
FROM city AS ci
GROUP BY state_abbreviation
ORDER BY state_abbreviation;


-- Include the names of the smallest and largest parks
SELECT park.park_name, park.area
FROM park,
		(
			SELECT MIN(area) AS smallest_park_area, MAX(area) AS largest_park_area
			FROM park
		) AS min_max_park_areas
WHERE park.area = min_max_park_areas.smallest_park_area
      OR park.area = min_max_park_areas.largest_park_area
ORDER BY area DESC;

-- List the capital cities for the states in the Northeast census region.
SELECT city_name, state_abbreviation
FROM city
WHERE city.city_id IN (SELECT capital FROM state WHERE census_region = 'Northeast');

