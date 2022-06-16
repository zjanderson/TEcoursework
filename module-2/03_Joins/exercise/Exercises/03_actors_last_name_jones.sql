-- 3. For all actors with the last name of "Jones", display the actor's name and movie titles they appeared in.
-- Order the results by the actor names (A-Z). (48 rows)
SELECT person.person_name, movie.title
FROM person
JOIN movie_actor ON person_id = actor_id
JOIN movie ON movie.movie_id = movie_actor.movie_id
WHERE person_name LIKE '% Jones'
--GROUP BY person.person_name, movie.title
ORDER BY person_name;

