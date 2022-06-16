-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later (6 rows)

SELECT DISTINCT genre_name
FROM genre
JOIN movie_genre USING (genre_id)
JOIN movie USING (movie_id)
JOIN movie_actor USING (movie_id)
JOIN person ON person_id = actor_id
WHERE person_name = 'Robert De Niro'
	  AND movie.release_date > '01/01/2010';
