-- 6. The name, abbreviation, population, and area of states with an area greater than 200,000 square kilometers (16 rows)

SELECT state_name, population, state_abbreviation, area FROM state WHERE (area > 200000)
