BEGIN TRANSACTION;
DROP TABLE IF EXISTS Members;

CREATE TABLE Members
(
	member_id serial,
	last_name varchar(64) not null,
	first_name varchar(64) not null,
    email varchar(100) not null,
	phone varchar(11) null,
	date_of_birth date,
	wants_email_reminder boolean null,

	constraint pk_Members primary key (member_id)
);

INSERT INTO Members (last_name, first_name, email, phone, date_of_birth, wants_email_reminder)
VALUES ('Crahan', 'Shawn', 'scrahan@gmail.com', '4152556464', '09/24/1969', false),
       ('Jones', 'Craig', 'cjones@gmail.com', '4152346464', '02/11/1972', true),
       ('Thomson', 'Mick', 'mct@gmail.com', '4124556464', '11/03/1973', false),
       ('Taylor', 'Corey', 'coreyt@gmail.com', '2415456297', '12/08/1973', true),
       ('Wilson', 'Sid', 'sidddboywilson@gmail.com', '4199876938', '01/20/1977', false),
       ('Root', 'Jim', 'jimtheroot@gmail.com', '7452868855', '10/02/1971', false),
       ('Weinberg', 'Jay', 'weinbergthethird@gmail.com', '7243228209', '09/08/1990', false),
       ('Pfaff', 'Michael', 'heymikeyhelikesit@gmail.com', '4143219008', '01/24/176', true);
	   
SELECT * FROM Members;


DROP TABLE IF EXISTS Interest_Group;

CREATE TABLE Interest_Group
(
	group_id serial,
	group_name varchar(64) UNIQUE not null,

	constraint pk_Interest_Group primary key (group_id)
);


INSERT INTO Interest_Group (group_name)
VALUES ('Free Diving Cocomo'),
       ('Cheese Artisans'),
       ('Fish Costume Designers');	   

SELECT * FROM Interest_Group;



DROP TABLE IF EXISTS Memberships;

CREATE TABLE Memberships
(
	member_id int not null,
	group_id int not null,

	constraint pk_Memberships primary key (member_id, group_id)
);

INSERT INTO Memberships (member_id, group_id)
VALUES (1, 1),
	   (2, 1),
	   (3, 2),
	   (4, 2),
	   (5, 3),
	   (6, 3),
	   (7, 1),
	   (8, 2);
	   
SELECT * FROM Memberships;

DROP TABLE IF EXISTS Events;

CREATE TABLE Events
(
	event_id SERIAL not null,
	name varchar(64) not null,
	description varchar(864) not null,
	start_date TIMESTAMP not null,
	duration int,
	CHECK (duration >= 30),
	hosting_group int,

	constraint pk_Events primary key (event_id),
	constraint fk_hosting_group foreign key (hosting_group) references Interest_Group(group_id)
);


INSERT INTO Events (name, description, start_date, duration, hosting_group)
VALUES ('Dive Deep, No Sleep', 'Early AM Freediving Session - free for members', '07/04/2022 02:00:00', 240, (SELECT group_id FROM Interest_Group WHERE group_name = 'Free Diving Cocomo')),
       ('Boring Cheese: an opera', 'pretty much what you would expect', '06/22/2022 13:30:00', 389, (SELECT group_id FROM Interest_Group WHERE group_name = 'Cheese Artisans')),
       ('Bass Hats & Those Who Love Them', 'I SAW A FISH--- in a hat', '08/05/2023 17:45:15', 30, (SELECT group_id FROM Interest_Group WHERE group_name = 'Fish Costume Designers')),
       ('10 Things I Hate About Brie', 'iS bRiE eVeN aRtIsAnAl?!', '12/24/2025 16:00:01', 2345, (SELECT group_id FROM Interest_Group WHERE group_name = 'Cheese Artisans'));

SELECT * FROM Events;

DROP TABLE IF EXISTS Attendees;

CREATE TABLE Attendees
(
	member_id int not null,
	event_id int not null,

	constraint pk_Attendees primary key (member_id, event_id)
);

INSERT INTO Attendees (member_id, event_id)
VALUES (1, 1),
	   (2, 1),
	   (3, 2),
	   (4, 2),
	   (5, 3),
	   (6, 3),
	   (7, 4),
	   (8, 4);
	   
SELECT * FROM Attendees;


COMMIT;