DROP TABLE IF EXISTS review, hotel, address;

CREATE TABLE address
(
    address_id serial PRIMARY KEY,
    address varchar(100) NOT NULL,
    address2 varchar(100),
    city varchar(100) NOT NULL,
    state varchar(100) NOT NULL,
    zip varchar(5) NOT NULL
);

CREATE TABLE hotel
(
    hotel_id serial PRIMARY KEY,
    address_id int NOT NULL,
    name varchar(100) NOT NULL,
    rooms_available int NOT NULL,
    cost_per_night numeric(6,2) NOT NULL,
    cover_image varchar(100),

    CONSTRAINT fk_address_id FOREIGN KEY (address_id) REFERENCES address (address_id),
    CONSTRAINT chk_cost_is_positive CHECK (cost_per_night > 0),
    CONSTRAINT chk_rooms_available_is_positive CHECK (rooms_available > 0)
);

CREATE TABLE users
(
    user_id serial PRIMARY KEY,
    username varchar(50) UNIQUE NOT NULL
);

CREATE TABLE review
(
    review_id serial PRIMARY KEY,
    hotel_id int NOT NULL,
    author varchar(100),
    title varchar(100) NOT NULL,
    description text,
    stars int NOT NULL,
    user_id int,

    CONSTRAINT fk_hotel_id FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id),
    CONSTRAINT chk_stars_in_range CHECK (stars >= 1 AND stars <= 5),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

INSERT INTO address (address, address2, city, state, zip)
VALUES  ('address', 'address2', 'city', 'state', 'zip');

INSERT INTO hotel (address_id, name, rooms_available, cost_per_night)
VALUES  (1, 'hotel name', 10, 250);

INSERT INTO users (username) VALUES ('user'), ('admin');

INSERT INTO review (hotel_id, author, title, description, stars, user_id)
VALUES  (1, 'Walt', 'Great Hotel!', 'GREAT!!!', 5, 1);

INSERT INTO review (hotel_id, author, title, description, stars, user_id)
VALUES  (1, 'Bob', 'Terrible Hotel!', 'Awful!!!', 1, 2);