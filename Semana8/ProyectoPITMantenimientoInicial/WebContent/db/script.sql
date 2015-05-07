USE MASTER 
GO

--DROP DATABASE PROYECTO_PIT
--GO

CREATE DATABASE PROYECTO_PIT
GO

USE PROYECTO_PIT
GO



CREATE TABLE ROLES(
	rolId int primary key identity(1,1),
	descripcion varchar(50)
)
GO

CREATE TABLE MENUS(
	menuId int primary key identity(1,1),
	descripcion varchar(150),
	url varchar(250),
	menuPadre int
)
GO

CREATE TABLE USUARIOS(
	usuarioId int primary key identity(1,1),
	nombres	varchar(250),
	correo varchar(250),
	login varchar(10),
	clave varchar(10)	,
	rolId int
)
GO

CREATE TABLE ROLES_MENUS(
	rolMenuId int primary key identity(1,1),
	rolId int,
	menuId int
)

