-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
SELECT city_name, state_abbreviation
FROM city
WHERE city_name = 'Columbus';

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
SELECT city_name, state_name
FROM state AS s
INNER JOIN city AS c ON c.state_abbreviation = s.state_abbreviation
WHERE city_name = 'Columbus';

-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT park_name, state_abbreviation
FROM park
INNER JOIN park_state USING (park_id);

-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT park_name, state_name
FROM park
INNER JOIN park_state USING (park_id)
INNER JOIN state USING (state_abbreviation);

-- Modify the previous query to include the name of the state's capital city.
SELECT park_name, state_name, city_name AS capital_city_name
FROM park
INNER JOIN park_state USING (park_id)
INNER JOIN state USING (state_abbreviation)
INNER JOIN city ON city.city_id = state.capital;

-- Modify the previous query to include the area of each park.
SELECT park_name, state_name, city_name AS capital_city_name, park.area AS park_area
FROM park
INNER JOIN park_state USING (park_id)
INNER JOIN state USING (state_abbreviation)
INNER JOIN city ON city.city_id = state.capital;

-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT city_name, city.population
FROM city
INNER JOIN state USING (state_abbreviation)
WHERE census_region = 'Midwest';

-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT state_abbreviation, COUNT(city_name)
FROM city
INNER JOIN state USING (state_abbreviation)
WHERE census_region = 'Midwest'
GROUP BY state_abbreviation;

-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT state_abbreviation, COUNT(city_name) AS number_of_cities
FROM city
INNER JOIN state USING (state_abbreviation)
WHERE census_region = 'Midwest'
GROUP BY state_abbreviation
ORDER BY number_of_cities DESC;


-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) 
-- for every record in the state table that has park records associated with it.
SELECT state_name, MIN(date_established) AS earliest_date_established
FROM state
INNER JOIN park_state USING (state_abbreviation)
INNER JOIN park USING (park_id)
GROUP BY state_name;


-- Modify the previous query so the results include entries for all the records in the state table, 
-- even if they have no park records associated with them.
SELECT state_name, MIN(date_established)
FROM state
LEFT JOIN park_state USING (state_abbreviation)
LEFT JOIN park USING (park_id)
GROUP BY state_name
ORDER BY state_name;


/*
	state_name	state.state_abbrev    park_state.state_abbrev		park_state.park_id		park.park_id		park.date_estab
	Alabama		 AL						null							null					null				null
	Alaska		 AK						AK								17						17					1917-02-26
	Alaska		 AK						AK								20						20					1980-12-02				
*/


-- UNION

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. (Washington is the name of a city and a state--how many times does it appear in the results?)
SELECT result_set.place_name
FROM
	(
		SELECT city_name AS place_name FROM city WHERE city_name LIKE 'W%'

		UNION

		SELECT state_name AS place_name FROM state WHERE state_name LIKE 'W%' 

		ORDER BY place_name
	) AS result_set
WHERE result_set.place_name LIKE 'Wa%';

-- Modify the previous query to include a column that indicates whether the place is a city or state.
SELECT city_name AS place_name, 'City' AS place_type FROM city WHERE city_name LIKE 'W%'

UNION ALL

SELECT state_name AS place_name, 'State' AS place_type FROM state WHERE state_name LIKE 'W%' 

ORDER BY place_name;


-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in pgAdmin and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres
SELECT genre_name FROM genre;

-- The titles of all the Comedy movies
SELECT title
FROM movie
INNER JOIN movie_genre USING (movie_id)
INNER JOIN genre USING (genre_id)
WHERE genre.genre_name = 'Comedy';
