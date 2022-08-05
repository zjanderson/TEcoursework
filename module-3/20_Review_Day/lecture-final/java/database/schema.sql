BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, list_item, list;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE list
(
	list_id serial,
	user_id int NOT NULL,
	name varchar(50) NOT NULL,
	CONSTRAINT pk_list PRIMARY KEY (list_id),
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE list_item
(
	list_item_id serial,
	list_id int NOT NULL,
	item_name varchar(50) NOT NULL,
	is_completed boolean DEFAULT (false),
	CONSTRAINT pk_list_item PRIMARY KEY (list_item_id),
	CONSTRAINT fk_list_id FOREIGN KEY (list_id) REFERENCES list (list_id)
);

COMMIT TRANSACTION;
