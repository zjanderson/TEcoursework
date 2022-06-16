-- 9. The titles of movies directed by James Cameron (6 rows)
SELECT title
FROM movie
JOIN person ON director_id = person_id
WHERE person_name = 'James Cameron';
