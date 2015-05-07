<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
<%@ taglib uri="/struts-jquery-grid-tags" prefix="sjq"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sj:head/>
</head>
<body>
	<s:url id="URLista" action="AListadoEspecialidad" />

	<sjq:grid gridModel="especialidades" title="Listado" dataType="json"
		href="%{URLista}"> 
		<sjq:gridColumn name="idespecialidad" title="Codigo"/>
		<sjq:gridColumn name="desespecialidad" title="Descripcion"/>
	</sjq:grid>
</body>
</html>