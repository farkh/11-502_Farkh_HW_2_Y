CREATE TABLE Auto (
	auto_id int NOT NULL,
	brand varchar(50) NOT NULL,
	type varchar(10) NOT NULL,
	price int NOT NULL,
	color varchar(10) NOT NULL UNIQUE,
	wheel varchar(5) NOT NULL UNIQUE,
	mileage int NOT NULL,
	horsepower int NOT NULL,
	gearbox varchar NOT NULL,
	year DATE NOT NULL,
	CONSTRAINT Auto_pk PRIMARY KEY (auto_id)
);

CREATE TABLE Customers (
	id int NOT NULL,
	login varchar NOT NULL UNIQUE,
	password varchar NOT NULL,
	name varchar NOT NULL,
	surname varchar NOT NULL,
	city varchar NOT NULL,
	street varchar NOT NULL,
	house varchar NOT NULL,
	phone varchar(15) NOT NULL UNIQUE,
	CONSTRAINT Customers_pk PRIMARY KEY (id)
);

CREATE TABLE Requirements (
	id int NOT NULL,
	brand varchar(50) NOT NULL,
	type varchar(10) NOT NULL,
	price int NOT NULL,
	color varchar(10) NOT NULL,
	wheel varchar(5) NOT NULL,
	mileage int NOT NULL,
	horsepower int NOT NULL,
	gearbox varchar(10) NOT NULL,
	year varchar NOT NULL
);

CREATE TABLE Orders (
	id serial NOT NULL,
	auto_id int NOT NULL,
	customer_id int NOT NULL,
	supp_id int NOT NULL,
	CONSTRAINT Orders_pk PRIMARY KEY (id)
);

CREATE TABLE Suppliers (
	supp_id serial NOT NULL,
	supp_name varchar NOT NULL,
	CONSTRAINT Suppliers_pk PRIMARY KEY (supp_id)
);

CREATE TABLE Types (
	type varchar(10) NOT NULL UNIQUE
);

CREATE TABLE Brands (
	brand_name varchar NOT NULL UNIQUE
);

CREATE TABLE Gearboxes (
	gearbox varchar(10) NOT NULL UNIQUE
);

CREATE TABLE Wheels (
	wheel varchar NOT NULL UNIQUE
);

ALTER TABLE Auto ADD CONSTRAINT Auto_fk0 FOREIGN KEY (brand) REFERENCES Brands(brand_name);
ALTER TABLE Auto ADD CONSTRAINT Auto_fk1 FOREIGN KEY (type) REFERENCES Types(type);
ALTER TABLE Auto ADD CONSTRAINT Auto_fk2 FOREIGN KEY (wheel) REFERENCES Wheels(wheel);
ALTER TABLE Auto ADD CONSTRAINT Auto_fk3 FOREIGN KEY (gearbox) REFERENCES Gearboxes(gearbox);

ALTER TABLE Requirements ADD CONSTRAINT Requirements_fk0 FOREIGN KEY (id) REFERENCES Customers(id);

ALTER TABLE Orders ADD CONSTRAINT Orders_fk0 FOREIGN KEY (auto_id) REFERENCES Auto(auto_id);
ALTER TABLE Orders ADD CONSTRAINT Orders_fk1 FOREIGN KEY (customer_id) REFERENCES Customers(id);
ALTER TABLE Orders ADD CONSTRAINT Orders_fk4 FOREIGN KEY (supp_id) REFERENCES Suppliers(supp_id);