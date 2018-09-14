insert into APP.Customer ( name, phone, email, birthdate, password, type, hobbies, marriage_status) 
values               ( 'Kien Pham', '6122242661', 'kien.ptx@gmail.com', null, '123456',1, '', 1);


select * from App.Customer;

CREATE TABLE APP.TEST (
	NAME VARCHAR(16),
	PRICE DECIMAL,
	BRAND VARCHAR(32),
	DATE_CREATED DATE,
	MODEL VARCHAR(32),
	MANUFACTURER VARCHAR(32),
	DESCRIPTION VARCHAR(150),
	SEAT_CAPACITY INTEGER,
	FUEL_TYPE INTEGER,
	MILEAGE INTEGER,
	TRANMISSION_TYPE INTEGER
);