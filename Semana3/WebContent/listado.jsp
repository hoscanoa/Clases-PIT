<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Descripcion</td>
			<td>Pais</td>
			<td>Eliminar</td>
			<td>Buscar</td>
		</tr>
		<s:iterator value="ciudades" var="c">
			<tr>
				<td><s:property value="idCiu"/></td>
				<td><s:property value="desCiu"/></td>
				<td><s:property value="idPais"/></td>
				<s:url id="URLEliminar" action="AEliminar">
					<s:param name="ciudadbean.idCiu" value="idCiu"/>					
				</s:url>				
				<td><s:a href="%{URLEliminar}">Eliminar</s:a></td>
				
				<s:url id="URLBuscar" action="ABuscar">
					<s:param name="ciudadbean.idCiu" value="idCiu"/>					
				</s:url>
				<td><s:a href="%{URLBuscar}">Mostrar</s:a></td>
			</tr>
		</s:iterator>		
	</table>
	<s:a action="ANuevo">Nueva Ciudad</s:a>
</center>
</body>
</html>




