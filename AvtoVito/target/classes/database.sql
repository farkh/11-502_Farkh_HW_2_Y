CREATE TABLE Customers (
	id VARCHAR NOT NULL,
	login varchar NOT NULL UNIQUE,
	password varchar NOT NULL,
	fio varchar NOT NULL,
	address varchar NOT NULL,
	phone varchar NOT NULL UNIQUE,
	CONSTRAINT Customers_pk PRIMARY KEY (id)
);

CREATE TABLE Cookies (
	id VARCHAR NOT NULL,
	token varchar NOT NULL UNIQUE,
	CONSTRAINT Cookies_pk PRIMARY KEY (id)
);

CREATE TABLE Auto (
	id VARCHAR NOT NULL UNIQUE,
	brand varchar NOT NULL,
	photo_link varchar NOT NULL,
	CONSTRAINT Auto_pk PRIMARY KEY (id)
);

ALTER TABLE Cookies ADD CONSTRAINT Cookies_fk0 FOREIGN KEY (id) REFERENCES Customers(id);