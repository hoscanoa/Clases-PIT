use master
go

CREATE DATABASE PIT
GO

USE PIT
GO

CREATE TABLE pais (
	idpais varchar(2) primary key,
	despais varchar(50)
)
GO


INSERT INTO pais VALUES ('PE', 'PERU');
INSERT INTO pais VALUES ('MX', 'MEXICO');
GO

CREATE TABLE ciudad (
	idciu varchar(2) primary key,
	 desciu varchar(30),
	 idpais varchar(2)
)
GO

INSERT INTO ciudad VALUES ('LI', 'LIMA', 'PE');
INSERT INTO ciudad VALUES ('CU', 'CUZCO', 'PE');
GO