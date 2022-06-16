-- 17. The titles and taglines of movies that are in the "Family" genre and Samuel L. Jackson has acted in (4 rows)


SELECT title, tagline
FROM movie
JOIN movie_genre USING (movie_id)
JOIN genre USING (genre_id)
JOIN movie_actor USING (movie_id)
WHERE genre_name = 'Family' AND
	  actor_id = (SELECT person_id
					  FROM person
					  WHERE person_name = 'Samuel L. Jackson');
