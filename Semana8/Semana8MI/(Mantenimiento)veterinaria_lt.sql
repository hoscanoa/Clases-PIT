create database bdsql
go
use bdsql
go
CREATE TABLE especialidad (
  idespecialidad int primary key identity(1,1),
  desespecialidad varchar(30) default NULL

) 
go
INSERT INTO especialidad VALUES ('Cirujano');
INSERT INTO especialidad VALUES ('Radiolog');
go

CREATE TABLE mascota (
  idmascota int primary key identity(1,1),
  nombre varchar(30) default NULL,
  imagen varbinary(max)
 )
go
INSERT INTO mascota VALUES ('Peluchin', null);
INSERT INTO mascota VALUES ('Sasha', null);
INSERT INTO mascota VALUES ('DINO', null);
INSERT INTO mascota VALUES ('CEREBRO', null);
INSERT INTO mascota VALUES ('AAAA', null);
INSERT INTO mascota VALUES ('DINO 876', null);
go
CREATE TABLE doctor (
  iddoctor int primary key identity(1,1),
  nombre varchar(30) default NULL,
  idespecialidad int  foreign key REFERENCES especialidad(idespecialidad)
) 

go 
INSERT INTO doctor VALUES ('Henry Libias Villavicencio', 1);
INSERT INTO doctor VALUES ('Jean Carlo Taype Sayas ', 2);
go
CREATE TABLE horario (
  idhorario int primary key NOT NULL identity(1,1),
  fecha date default NULL,
  horaini date default NULL,
  horafin date default NULL,
  iddoctor int foreign KEY references doctor(iddoctor)
    
) 
go
INSERT INTO horario VALUES ('2014-06-05', '2014-06-04', '2014-06-05', 1);
INSERT INTO horario VALUES ('2014-06-05', '2014-06-04', '2014-06-05', 2);
INSERT INTO horario VALUES ('2014-07-03', '2014-07-03', '2014-07-03', 2);
go
CREATE TABLE cita (
  idcita int primary key identity(1,1),
  idmascota int foreign key references mascota(idmascota),
  idhorario int foreign key references horario(idhorario),
  iddoctor int foreign key references doctor(iddoctor)
) 
go
INSERT INTO cita VALUES (1, 1, 1);
INSERT INTO cita VALUES (2, 2, 2);
INSERT INTO cita VALUES (1, 1, 1);
INSERT INTO cita VALUES (2, 1, 1);
INSERT INTO cita VALUES (1, 1, 2);
INSERT INTO cita VALUES (2, 2, 1);
