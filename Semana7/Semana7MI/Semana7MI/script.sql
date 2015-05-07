USE MASTER 
GO

if exists(select name from sys.sysdatabases where name='PROYECTO_PIT')
DROP DATABASE PROYECTO_PIT

GO

CREATE DATABASE PROYECTO_PIT
GO

USE PROYECTO_PIT
GO



CREATE TABLE ROLES(
	rolId int primary key identity(1,1),
	descripcion varchar(50)
)
GO

insert into ROLES values('VENTA')
insert into ROLES values('GERENCIA')

go
CREATE TABLE MENUS(
	menuId int primary key identity(1,1),
	descripcion varchar(150),
	url varchar(250),
	menuPadre int
)
GO
insert into MENUS values('Mantenimiento','',0)
insert into MENUS values('Consulta','',0)
insert into MENUS values('Herramientas','',0)


insert into MENUS values('Cliente','AListadoCliente',1)
insert into MENUS values('Producto','AListadoProducto',1)
insert into MENUS values('Ventas','AListadoVentas',2)
insert into MENUS values('Pedidos','AListadoPedidos',2)
insert into MENUS values('Mensajes','AListadoMensajes',2)
go

CREATE TABLE USUARIOS(
	usuarioId int primary key identity(1,1),
	nombres	varchar(250),
	correo varchar(250),
	login varchar(10),
	clave varchar(10)	,
	rolId int
)
GO

insert into USUARIOS values('JUANA LOPEZ','juana@gmail.com','JUANA','1234',1)
insert into USUARIOS values('ANA LOPEZ','ana@gmail.com','ANA','1234',1)
insert into USUARIOS values('LUIS CASTILLO','luis@gmail.com','LUIS','1234',2)
GO

CREATE TABLE ROLES_MENUS(
	rolMenuId int primary key identity(1,1),
	rolId int,
	menuId int
)

GO
INSERT INTO ROLES_MENUS VALUES(1,2)
INSERT INTO ROLES_MENUS VALUES(1,4)
INSERT INTO ROLES_MENUS VALUES(1,5)
INSERT INTO ROLES_MENUS VALUES(2,1)
INSERT INTO ROLES_MENUS VALUES(2,2)
INSERT INTO ROLES_MENUS VALUES(2,3)
INSERT INTO ROLES_MENUS VALUES(2,4)
INSERT INTO ROLES_MENUS VALUES(2,5)
INSERT INTO ROLES_MENUS VALUES(2,6)
INSERT INTO ROLES_MENUS VALUES(2,7)
INSERT INTO ROLES_MENUS VALUES(2,8)