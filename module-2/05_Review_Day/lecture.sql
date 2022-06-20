-- is using outer join any different than using R/L join where _____ IS NOT NULL

SELECT movie.title, collection.collection_name
FROM movie
INNER JOIN collection USING (collection_id)
ORDER BY collection.collection_name;

-- INSERT
-- 1 row at a time
INSERT INTO collection (collection_id, collection_name) VALUES (10000000, 'New Collection');

-- many rows at a time
INSERT INTO collection (collection_id, collection_name) 
VALUES  (10000000, 'New Collection'), 
		(10000001, 'New Collection number 2');

-- insert from a select query
INSERT INTO collection (collection_id, collection_name) 
SELECT collection_id + 1, collection_name || ' version 2'
FROM collection
WHERE collection_name = 'Bill Murray Collection' OR collection_name = 'The Dark Knight Collection';

-- UPDATE
SELECT * FROM movie WHERE title LIKE '%Batman%';

UPDATE movie
SET title = 'Batman',
    length_minutes = 360
WHERE title LIKE '%Batman%';

-- DELETE
DELETE FROM movie WHERE title LIKE '%Batman%';

-- CONSTRAINTS
/*
	1. NOT NULL 
	2. UNIQUE 
	3. PRIMARY KEY (NOT NULL, UNIQUE)
	4. FOREIGN KEY (REFERENCES A UNIQUE COLUMN)
	5. CHECK
	6. DEFAULT
*/

-- TRANSACTIONS
START TRANSACTION;

COMMIT;



