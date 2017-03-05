DROP TABLE IF EXISTS invoices;
DROP TABLE IF EXISTS toppings;
DROP TABLE IF EXISTS bottoms;
DROP TABLE IF EXISTS users;

CREATE TABLE users(
userId int(25) not null auto_increment,
email varchar(255) not null,
userPass varchar(255) not null,
balance int(25) not null,
PRIMARY KEY (userId)
);

ALTER TABLE users auto_increment=1;

CREATE TABLE bottoms(
bId int(25) not null auto_increment,
bName varchar(255) not null,
bPrice int(25) not null,
PRIMARY KEY (bId)
);

ALTER TABLE bottoms auto_increment=1000;

CREATE TABLE toppings(
tId int(25) not null auto_increment,
tName varchar(255) not null,
tPrice int(25) not null,
PRIMARY KEY (tId)
);

ALTER TABLE toppings auto_increment=2000;

CREATE TABLE invoices(
userId int(25) not null ,
email varchar(255) not null,
tPriceTotal int(25) not null,
bPriceTotal int(25) not null,
FOREIGN KEY (userId) REFERENCES users(userId),
PRIMARY KEY (userId)
);

insert into users(email, userPass, balance) values ('test@mail.com', '123', 70);
insert into users(email, userPass, balance) values ('test2@mail.com', 'abc', 80);
insert into users(email, userPass, balance) values ('test3@mail.com', 'password', 150);

insert into bottoms(bName, bPrice) values ('Chocolate', 5.00);
insert into bottoms(bName, bPrice) values ('Vanila', 5.00);
insert into bottoms(bName, bPrice) values ('Nutmeg', 5.00);
insert into bottoms(bName, bPrice) values ('Pistacio', 6.00);
insert into bottoms(bName, bPrice) values ('Almond', 7.00);

insert into toppings(tName, tPrice) values ('Chocolate', 5.00);
insert into toppings(tName, tPrice) values ('Blueberry', 5.00);
insert into toppings(tName, tPrice) values ('Rasberry', 5.00);
insert into toppings(tName, tPrice) values ('Crispy', 6.00);
insert into toppings(tName, tPrice) values ('Strawberry', 6.00);
insert into toppings(tName, tPrice) values ('Rum/Raisin', 7.00);
insert into toppings(tName, tPrice) values ('Orange', 8.00);
insert into toppings(tName, tPrice) values ('Lemon', 8.00);
insert into toppings(tName, tPrice) values ('Blue Cheese', 9.00);

