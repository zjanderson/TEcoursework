-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)

SELECT DISTINCT person_name, birthday
FROM person
JOIN movie_actor ON actor_id = person_id
JOIN movie USING (movie_id)
WHERE person.birthday BETWEEN '01/01/1950' AND '12/31/1959'
	AND release_date BETWEEN '01/01/1985' AND '12/31/1985';