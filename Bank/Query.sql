

CREATE USER 'rohan' IDENTIFIED BY 'Rohankar@11';

GRANT ALL PRIVILEGES ON *.* TO 'rohan'@'localhost';

FLUSH PRIVILEGES;

create database ATM;

use ATM;

create table login( cardno varchar(16), pin varchar(4));

-- insert into login values( 1234567812345678, 1234);

create table signup( appNo int(100) AUTO_INCREMENT primary key, name varchar(25), gname varchar(25), date int(2), month varchar(9), year int(4), gender varchar(6), email varchar(40), maritalStatus varchar(9), address varchar(100), city varchar(25), pincode varchar(6), state varchar(25));

-- insert into signup(name, gname, date, month, year, gender, email, maritalStatus, address, city, pincode, state) values('rohan','rohan','1','February','1998','male','@gmail.com','married','satya','bhad','122217','WB');

create table signup2( appNo int(100) primary key, religion varchar(10), category varchar(10), income varchar(15), education varchar(20), occupation varchar(20), panNo varchar(25), aadhaarNo varchar(25), senior varchar(3), existing varchar(3));

create table signup3( appNo int(100) primary key, type_of_account varchar(25), services varchar(100));

create table bank(slno int(20) AUTO_INCREMENT primary key, cardno varchar(16), pin varchar(4), credit double(14,4), debit double(14,4), balance double(14,4));

-- 5040936081509918