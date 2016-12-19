CREATE TABLE Auto (
	auto_id serial NOT NULL,
	brand varchar(50) NOT NULL,
	type varchar(20) NOT NULL,
	price int NOT NULL,
	color varchar(20) NOT NULL,
	wheel varchar(5) NOT NULL,
	mileage int NOT NULL,
	horsepower int NOT NULL,
	gearbox varchar NOT NULL,
	year varchar NOT NULL,
  image_link TEXT,
	CONSTRAINT Auto_pk PRIMARY KEY (auto_id),
	CONSTRAINT Not_neg CHECK (price > 0)
);

CREATE TABLE Users (
	id serial NOT NULL,
	login varchar NOT NULL UNIQUE,
	password varchar NOT NULL,
	CONSTRAINT Users_pk PRIMARY KEY (id)
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
	type varchar(20) NOT NULL UNIQUE
);

CREATE TABLE Colors (
	color varchar(20) NOT NULL UNIQUE
);

CREATE TABLE Gearboxes (
	gearbox varchar(15) NOT NULL UNIQUE
);

CREATE TABLE Wheels (
	wheel varchar(5) NOT NULL UNIQUE
);

CREATE TABLE Customers (
	id serial NOT NULL,
	name varchar NOT NULL,
	surname varchar NOT NULL,
	city varchar NOT NULL,
	street varchar NOT NULL,
	house varchar NOT NULL,
	phone varchar NOT NULL,
	CONSTRAINT Customers_pk PRIMARY KEY (id)
);

ALTER TABLE Auto ADD CONSTRAINT Auto_fk1 FOREIGN KEY (type) REFERENCES Types(type) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Auto ADD CONSTRAINT Auto_fk2 FOREIGN KEY (wheel) REFERENCES Wheels(wheel);
ALTER TABLE Auto ADD CONSTRAINT Auto_fk3 FOREIGN KEY (gearbox) REFERENCES Gearboxes(gearbox);
ALTER TABLE Auto ADD CONSTRAINT Auto_fk4 FOREIGN KEY (color) REFERENCES Colors(color) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Orders ADD CONSTRAINT Orders_fk0 FOREIGN KEY (auto_id) REFERENCES Auto(auto_id);
ALTER TABLE Orders ADD CONSTRAINT Orders_fk1 FOREIGN KEY (customer_id) REFERENCES Users(id);
ALTER TABLE Orders ADD CONSTRAINT Orders_fk2 FOREIGN KEY (supp_id) REFERENCES Suppliers(supp_id);

ALTER TABLE Customers ADD CONSTRAINT Customers_fk0 FOREIGN KEY (id) REFERENCES Users(id);