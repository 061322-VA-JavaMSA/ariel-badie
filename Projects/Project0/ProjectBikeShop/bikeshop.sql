drop table users;
CREATE TABLE IF NOT EXISTS USERS (
    ID SERIAL UNIQUE PRIMARY KEY,
	USERNAME VARCHAR(30) UNIQUE NOT NULL CHECK(LENGTH(USERNAME) > 2),
	PASSWORD VARCHAR(30) NOT NULL,
    clearance INT
);
insert into users (username, password, clearance) values ('ariel', 'topgun', '1');
insert into users (username, password, clearance) values ('rwoltering0', 'tGbPfDx3b3q', '3');
insert into users (username, password, clearance) values ('jtoovey1', '5hE57W', '3');
insert into users (username, password, clearance) values ('jdevonport3', 'sp1I8fW', '2');
insert into users (username, password, clearance) values ('mrehn5', 'XpvygMKQ', '2');


drop table items;
create table if not exists items (
	ID SERIAL UNIQUE PRIMARY key,
	itemName varchar(50),
	itemDesc varchar(75),
	itemOffer int,
	status int,
	ownedBy int
);

insert into items (itemName, itemDesc, itemOffer, status, ownedBy) values ('Chain', 'For fixie bikes', '10', '2', '2');
insert into items (itemName, itemDesc, itemOffer, status, ownedBy) values ('Pedals', 'For fixie bikes', '15', '1', '1');
insert into items (itemName, itemDesc, itemOffer, status, ownedBy) values ('Helmet', 'For saftey', '7', '1', '1');

drop table if exists offers;
create table if not exists offers (
	ID SERIAL UNIQUE PRIMARY key,
	custID	int,
	itemID int,
	amount float,
	status int
);

insert into offers (custID, ItemID, amount, status) values ('2', '1', '15.30', '0');
insert into offers (custID, ItemID, amount, status) values ('3', '1', '12.50', '0');
insert into offers (custID, ItemID, amount, status) values ('3', '2', '17.20', '0');