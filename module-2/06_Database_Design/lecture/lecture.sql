CREATE TABLE state_v2
(
	state_abbreviation character(2),
	state_name varchar(50) NOT NULL,
	population integer NOT NULL,
	area integer NOT NULL CHECK (area >= 0),
	capital integer UNIQUE,
	sales_tax numeric(5, 3) NOT NULL,
	state_nickname varchar(100) UNIQUE,
	census_region varchar(10),
	
	CONSTRAINT pk_state2 PRIMARY KEY (state_abbreviation),
	CONSTRAINT uq_state_name2 UNIQUE (state_name),
	CONSTRAINT chk_population2 CHECK (population > 0),
	CONSTRAINT fk_state_city2 FOREIGN KEY (capital) REFERENCES city (city_id),
	CONSTRAINT chk_census_region2 CHECK (census_region IN ('Northeast', 'Midwest', 'South', 'West'))
	
);


DROP TABLE state_v2;



------- Normalization Exercises ----------------
/*
Name,   Address,                                 Address Type,  Tax Amount,     Biography
Walt    410 Scott Drive Pittsburgh, PA 15237      Primary            3.0        Instructor at Tech Elevator
Oliver  410 Scott Drive Pittsburgh, PA 15237      Primary            3.0        Cat that interrupts class
Oliver  412 Scott Drive Pittsburgh, PA 15237      Secondary          3.0        Cat that interrupts class
Taylor   55 House Road New York, New York 10001   Primary            4.0        Aspiring comedian

1NF 
Name,   House #,	Street,		City,		State,		Zip,	Address Type,  Tax Amount,     Biography
Walt    410 		Scott Drive Pittsburgh, PA 			15237      Primary            3.0        Instructor at Tech Elevator
Oliver  410 		Scott Drive Pittsburgh, PA 			15237      Primary            3.0        Cat that interrupts class
Oliver  412 		Scott Drive Pittsburgh, PA 			15237      Secondary          3.0        Cat that interrupts class
Taylor   55 		House Road  New York, 	NY 			10001      Primary            4.0        Aspiring comedian

2NF
Person ID,	Name,	Biography
1			Walt	Instructor at Tech Elevator
2			Oliver	Cat that interrupts class
3			Taylor	Aspiring comedian

Address ID,		House #,	Street,		City,		State,		Zip,	  Tax Amount
1				410 		Scott Drive Pittsburgh, PA 			15237         3.0
2				412 		Scott Drive Pittsburgh, PA 			15237         3.0
3				 55 		House Road  New York, 	NY 			10001         4.0

Person ID,		Address ID,		Address Type
1				1				Primary
2				1				Primary	
2				2				Secondary
3				3				Primary

3NF

Person ID,	Name,	Biography
1			Walt	Instructor at Tech Elevator
2			Oliver	Cat that interrupts class
3			Taylor	Aspiring comedian

Address ID,		House #,	Street,		City,		State,		Zip,	  
1				410 		Scott Drive Pittsburgh, PA 			15237       
2				412 		Scott Drive Pittsburgh, PA 			15237         
3				 55 		House Road  New York, 	NY 			10001         

Person ID,		Address ID,		Address Type
1				1				Primary
2				1				Primary	
2				2				Secondary
3				3				Primary

State,		Tax Amount
PA			3.0
NY			4.0





------------- Art Gallery Results ------------

artist
id
name
work
sold (boolean)

customer
id
name
address
phone number
work purchased

work
id
title
price
is purchased

-----
customer
id serial pk
name varchar 
billing address varchar
phone number varchar

artist
id serial pk
name varchar
style varchar

painting
id serial pk
name varchar
painted_by fk artist (id)

purchase
id serial pk
customer_id fk customer (id)
painting_id fk painting (id)
date_sold timestamp
sale_price money

---
customer
id

artist
id

artwork
id

purchase
transaction_id
customer_id
artwork_id
date
price

---

artist_artwork



*/


BEGIN TRANSACTION;

CREATE TABLE customers
(
	customer_id serial,
	name varchar(64) not null,
	address varchar(100) not null,
	phone varchar(11) null,

	constraint pk_customers primary key (customer_id)
);

CREATE TABLE artists
(
	artist_id serial,
	first_name varchar(64) not null,
	last_name varchar(64) not null,

	constraint pk_artists primary key (artist_id)
);

CREATE TABLE art
(
	art_code_id serial,
	title varchar(64) not null,
	artist_id int not null,

	constraint pk_art primary key (art_code_id),
	constraint fk_art_artists foreign key (artist_id) references artists (artist_id)
);

CREATE TABLE customer_purchases
(
	customer_id int not null,
	art_code_id int not null,
	purchase_date timestamp not null,
	price money not null,

	constraint pk_customer_purchases primary key (customer_id, art_code_id, purchase_date),
	constraint fk_customer_purchases_customer foreign key (customer_id) references customers (customer_id),
	constraint fk_customer_purchases_art foreign key (art_code_id) references art(art_code_id)
);



COMMIT;






