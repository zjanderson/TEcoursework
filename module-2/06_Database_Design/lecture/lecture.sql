CREATE TABLE state_v2
(
	state_abbreviation character(2) NOT NULL,
	state_name varchar(50) NOT NULL,
	population int NOT NULL CHECK (population >= 0),
	area int NOT NULL CHECK (area >= 0),
	capital int UNIQUE REFERENCES city (city_id),
	sales_tax numeric(5,3) NOT NULL,
	state_nickname varchar(100),
	census_region varchar(10), 
	
	CONSTRAINT pk_state2 PRIMARY KEY (state_abbreviation),
	CONSTRAINT fk_state_city2 FOREIGN KEY (capital) REFERENCES city (city_id),
	CONSTRAINT uq_state_name2 UNIQUE (state_name),
	CONSTRAINT chk_census_region2 CHECK (census_region IN ('Northeast', 'Midwest', 'South', 'West'))
);

DROP TABLE state_v2;



--------------NORMALIZATION EXERCISES------------------
/*
Name,   Address,                                 Address Type,  Tax Amount,     Biography
Walt    410 Scott Drive Pittsburgh, PA 15237      Primary            3.0        Instructor at Tech Elevator
Oliver  410 Scott Drive Pittsburgh, PA 15237      Primary            3.0        Cat that interrupts class
Oliver  412 Scott Drive Pittsburgh, PA 15237      Secondary          3.0        Cat that interrupts class
Taylor   55 House Road New York, New York 10001   Primary            4.0        Aspiring comedian
		
1st Normal Form  -every individual piece of data has it's own column

Name,   House #, 	Street, 		City, 		State, 	 ZIP,    Address Type,  Tax Amount,     Biography
Walt    410 		Scott Drive 	Pittsburgh, PA 		15237      Primary            3.0        Instructor at Tech Elevator
Oliver  410 		Scott Drive 	Pittsburgh, PA 		15237      Primary            3.0        Cat that interrupts class
Oliver  412 		Scott Drive 	Pittsburgh, PA 		15237      Secondary          3.0        Cat that interrupts class
Taylor   55 		House Road 		New York, 	NY 		10001      Primary            4.0        Aspiring comedian

2nd Normal Form  -this table has partial dependencies, which need to be addressed by making this into 2 tables with corresponding data in each
Person ID, 	Name, 	Biography
1			Walt	Instructor at Tech Elevator
2			Oliver 	Cat that interrupts class
3			Taylor	Aspiring comedian

Address ID, 	House #, 	Street, 		City, 		State, 	 ZIP,  	Tax Amount
1				410 		Scott Drive 	Pittsburgh, PA 		15237    3.0
2				412 		Scott Drive 	Pittsburgh, PA 		15237    3.0
3				55 			House Road 		New York, 	NY 		10001    4.0

person ID, 		Address ID,    Address Type
1				1				Primary
2				1				Primary
2				2				Secondary
3				3				Primary

3rd Normal Form - eliminate transitive dependencies (column relies on another column which relies on the primary key)

Person ID, 	Name, 	Biography
1			Walt	Instructor at Tech Elevator
2			Oliver 	Cat that interrupts class
3			Taylor	Aspiring comedian

Address ID, 	House #, 	Street, 		City, 		State, 	 ZIP
1				410 		Scott Drive 	Pittsburgh, PA 		15237 
2				412 		Scott Drive 	Pittsburgh, PA 		15237
3				55 			House Road 		New York, 	NY 		10001

person ID, 		Address ID,    Address Type
1				1				Primary
2				1				Primary
2				2				Secondary
3				3				Primary
State, 		Tax Amount
PA			3.0
NY			4.0




----breakout room------

customer 
customer_id primary key int, customer_name, Address, phone

artist
artist_id primary key int, artist name, style

painting
painting_id primary key int, painting_name, painted_by

purchase
purchase_id primary key int, customer_id, painting_id, date, sale_price
*/