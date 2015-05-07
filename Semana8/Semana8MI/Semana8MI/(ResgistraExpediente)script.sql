create database BD_Judicial
go
use BD_Judicial
go
create table Persona(
idpersona int primary key identity(1,1),
nombres varchar(150),
tipodocumento VARCHAR(5), 
nrodocumento varchar(11),
tipopersona VARCHAR(20)
)
go
INSERT INTO Persona values('RAMON VALDES SANTO','DNI','77378490','DEMANDANTE')
INSERT INTO Persona values('MARIA DE LA TORRE ACEBEDO','DNI','77378490','DEMANDADO')
INSERT INTO Persona values('JENIFFER CASTO VALENCIA','DNI','77378490','DEMANDANTE')
go

create table Responsable(
idresponsable int primary key identity(1,1),
dni varchar(8),
nombres varchar(150),
email varchar(100)
)
INSERT INTO Responsable values('DNI','CLAUDIA REYNOSO FAVIAN','CLAU@GMAIL.COM')
INSERT INTO Responsable values('DNI','MARIA SANI RAMIRES','MARIA@GMAIL.COM')

go
create table Proceso(
idproceso int primary key identity(1,1),
codigo varchar(8),
nombres varchar(150),
costo decimal(10,2)
)
GO

INSERT INTO Proceso values('PRO_001','PROCESO JUDICIAL I',20)
INSERT INTO Proceso values('PRO_002','PROCESO JUDICIAL II',50)

GO
CREATE TABLE expediente(
	idexpediente int primary key IDENTITY(1,1) ,
	idproceso int FOREIGN KEY REFERENCES Proceso (idproceso),
	idresponsable int FOREIGN KEY REFERENCES Responsable (idresponsable),
	fechaapertura smalldatetime,
	inicioprogramacion smalldatetime,
)
go
CREATE TABLE expedientedetalle(
	idexpedientedetalle int primary key IDENTITY(1,1),
	idexpediente int FOREIGN KEY REFERENCES expediente(idexpediente),
	idpersona int FOREIGN KEY REFERENCES Persona(idpersona)
)
