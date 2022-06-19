-- 3. Did you know Eric Stoltz was originally cast as Marty McFly in "Back to the Future"?
--Add Eric Stoltz to the list of actors for "Back to the Future" (1 row)

INSERT INTO person (person_name)
VALUES ('Eric Stoltz') RETURNING person_id --3984916
INSERT INTO movie_actor (actor_id, movie_id)
VALUES (3984916, (SELECT movie_id FROM movie WHERE title= 'Back to the Future'));  --THIS WORKS