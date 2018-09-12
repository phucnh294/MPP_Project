Create Database TDM;
use TDM;

CREATE TABLE TRANSPORT (
	ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(16),
	PRICE DECIMAL,
	BRAND VARCHAR(32),
	DATE_CREATED DATE,
	MODEL VARCHAR(32),
	MANUFACTURER VARCHAR(32),
	DESCRIPTION VARCHAR(150),
	SEAT_CAPACITY INTEGER,
	FUEL_TYPE VARCHAR(16),
	MILEAGE INTEGER,
	TRANMISSION_TYPE VARCHAR(16),
    NUMBER_OF_ENGINE INTEGER,
    TRANSPORT_TYPE VARCHAR(16)
);


CREATE TABLE PARTY (
	ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(16),
	PHONE VARCHAR(16),
	EMAIL VARCHAR(32),
	BIRTHDATE DATE,
	PASSWORD VARCHAR(50),
	TYPE VARCHAR(16),
	HOBBIES VARCHAR(150),
	MARRIAGE_STATUS INT
);

CREATE TABLE ORDER_ (
	ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
	AMOUNT DECIMAL,
	ORDER_DATE DATE,
	CUSTOMER_ID INTEGER NOT NULL,
    DEALER_ID INTEGER NOT NULL
);


CREATE TABLE ORDER_TRANSPORT (
	ORDER_ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
	TRANSPORT_ID INTEGER,
	PRICE DECIMAL
);

