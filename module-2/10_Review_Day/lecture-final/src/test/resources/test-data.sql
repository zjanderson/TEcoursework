BEGIN TRANSACTION;

DROP TABLE IF EXISTS movie_genre, movie_actor, movie, collection, person, genre CASCADE;
DROP SEQUENCE IF EXISTS genre_serial, person_serial, collection_serial, movie_serial;


CREATE SEQUENCE genre_serial;
CREATE TABLE genre (
    genre_id int NOT NULL DEFAULT nextval('genre_serial'),
    genre_name varchar(50) NOT NULL,
	CONSTRAINT PK_genre PRIMARY KEY(genre_id)
);

CREATE SEQUENCE person_serial;
CREATE TABLE person (
    person_id int NOT NULL DEFAULT nextval('person_serial'),
    person_name varchar(200) NOT NULL,
    birthday date NULL,
    deathday date NULL,
    biography text NULL,
    profile_path varchar(200) NULL,
    home_page varchar(200) NULL,
	CONSTRAINT PK_person PRIMARY KEY(person_id)
);

CREATE SEQUENCE collection_serial;
CREATE TABLE collection (
    collection_id int NOT NULL DEFAULT nextval('collection_serial'),
    collection_name varchar(200) NOT NULL,
    CONSTRAINT PK_collection PRIMARY KEY(collection_id)
);

CREATE SEQUENCE movie_serial;
CREATE TABLE movie (
    movie_id int NOT NULL DEFAULT nextval('movie_serial'),
    title varchar(200) NOT NULL,
    overview text NULL,
    tagline varchar(400) NULL,
    poster_path varchar(200) NULL,
    home_page varchar(200) NULL,
    release_date date NULL,
    length_minutes int NOT NULL,
    director_id int NULL,
    collection_id int NULL,
	CONSTRAINT PK_movie PRIMARY KEY(movie_id),
    CONSTRAINT FK_movie_director FOREIGN KEY(director_id) REFERENCES person(person_id),
    CONSTRAINT FK_movie_collection FOREIGN KEY(collection_id) REFERENCES collection(collection_id)
);

CREATE TABLE movie_actor (
    movie_id int NOT NULL,
    actor_id int NOT NULL,
	CONSTRAINT PK_movie_actor PRIMARY KEY(movie_id, actor_id),
    CONSTRAINT FK_movie_actor_movie FOREIGN KEY(movie_id) REFERENCES movie(movie_id),
    CONSTRAINT FK_movie_actor_actor FOREIGN KEY(actor_id) REFERENCES person(person_id)
);

CREATE TABLE movie_genre (
    movie_id int NOT NULL,
    genre_id int NOT NULL,
	CONSTRAINT PK_movie_genre PRIMARY KEY(movie_id, genre_id),
    CONSTRAINT FK_movie_genre_movie FOREIGN KEY(movie_id) REFERENCES movie(movie_id),
    CONSTRAINT FK_movie_genre_genre FOREIGN KEY(genre_id) REFERENCES genre(genre_id)
);

-- Insert Collections
INSERT INTO collection (collection_name)
VALUES ('Collection 1');

-- Insert Person
INSERT INTO person (person_name)
VALUES ('Person 1');

-- Insert movies

INSERT INTO movie (title, overview, length_minutes, director_id, collection_id)
VALUES ('Star Wars', 'Space Drama with starships. Lots of them. I''ve seen 2. Nobody likes Anakin.', 60, 1, 1),
       ('Harry Potter', 'Magic children vs. Inept Lizard Man.', 120, 1, 1),
       ('Titanic', 'World''s largest metaphor sinks in the North Atlantic. Too long, didn''t finish.', 360, 1, 1);


COMMIT;