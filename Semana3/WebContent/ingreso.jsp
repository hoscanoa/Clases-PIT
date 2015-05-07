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

<s:form action="AValidar">
	<s:textfield label="Ingrese Login" name="usuariobean.login"/>
	<s:password label="Ingrese password" name="usuariobean.pwd" />
	<s:submit value="Entrar"/>
</s:form>

</body>
</html>




