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
) WITH (
  OIDS=FALSE
);



CREATE TABLE Customers (
	id int NOT NULL,
	login varchar NOT NULL UNIQUE,
	password varchar NOT NULL,
	fio varchar NOT NULL,
	address varchar NOT NULL UNIQUE,
	phone varchar(15) NOT NULL UNIQUE,
	CONSTRAINT Customers_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);



CREATE TABLE Requirements (
	id int NOT NULL,
	brand varchar(50) NOT NULL,
	type varchar(10) NOT NULL,
	mileage int NOT NULL,
	horsepower int NOT NULL,
	gearbox varchar(10) NOT NULL,
	year varchar NOT NULL,
	color varchar(10) NOT NULL,
	wheel varchar(5) NOT NULL,
	price int
) WITH (
  OIDS=FALSE
);



CREATE TABLE Orders (
	auto_id int NOT NULL,
	customer_id int NOT NULL,
	fio varchar NOT NULL,
	address varchar NOT NULL,
	phone varchar NOT NULL,
	supp_id int NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE Suppliers (
	supp_id serial NOT NULL,
	supp_name varchar NOT NULL,
	CONSTRAINT Suppliers_pk PRIMARY KEY (supp_id)
) WITH (
  OIDS=FALSE
);



CREATE TABLE Types (
	type varchar(10) NOT NULL UNIQUE
) WITH (
  OIDS=FALSE
);



CREATE TABLE Brands (
	brand_name varchar NOT NULL UNIQUE
) WITH (
  OIDS=FALSE
);



CREATE TABLE Gearboxes (
	gearbox varchar(10) NOT NULL UNIQUE
) WITH (
  OIDS=FALSE
);



CREATE TABLE Wheels (
	wheel varchar NOT NULL UNIQUE
) WITH (
  OIDS=FALSE
);



ALTER TABLE Auto ADD CONSTRAINT "Auto_fk0" FOREIGN KEY (brand) REFERENCES Brands(brand_name);
ALTER TABLE Auto ADD CONSTRAINT "Auto_fk1" FOREIGN KEY (type) REFERENCES Types(type);
ALTER TABLE Auto ADD CONSTRAINT "Auto_fk2" FOREIGN KEY (wheel) REFERENCES Wheels(wheel);
ALTER TABLE Auto ADD CONSTRAINT "Auto_fk3" FOREIGN KEY (gearbox) REFERENCES Gearboxes(gearbox);


ALTER TABLE Requirements ADD CONSTRAINT "Requirements_fk0" FOREIGN KEY (id) REFERENCES Customers(id);

ALTER TABLE Orders ADD CONSTRAINT Orders_fk0 FOREIGN KEY (auto_id) REFERENCES Auto(auto_id);
ALTER TABLE Orders ADD CONSTRAINT Orders_fk1 FOREIGN KEY (customer_id) REFERENCES Customers(id);
ALTER TABLE Orders ADD CONSTRAINT Orders_fk2 FOREIGN KEY (address) REFERENCES Customers(address);
ALTER TABLE Orders ADD CONSTRAINT Orders_fk3 FOREIGN KEY (phone) REFERENCES Customers(phone);
ALTER TABLE Orders ADD CONSTRAINT Orders_fk4 FOREIGN KEY (supp_id) REFERENCES Suppliers(supp_id);