-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie (73 rows)
-- we need person, movie, movie.actor

SELECT movie.title, person.person_name
FROM movie
INNER JOIN movie_actor USING (movie_id)
INNER JOIN person ON person.person_id = movie.director_id
                  AND person.person_id = movie_actor.actor_id
