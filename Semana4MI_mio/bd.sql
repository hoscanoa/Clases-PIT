
CREATE TABLE pais (
idpais varchar(2) primary key,
 
despais varchar(50));


INSERT INTO pais VALUES ('PE', 'PERU');

INSERT INTO pais VALUES ('MX', 'MEXICO');



CREATE TABLE ciudad (
  idciu varchar(2) primary key,
 
desciu varchar(30),
  idpais varchar(2))

;

INSERT INTO ciudad VALUES ('LI', 'LIMA', 'PE');

INSERT INTO ciudad VALUES ('CU', 'CUZCO', 'PE');

 


