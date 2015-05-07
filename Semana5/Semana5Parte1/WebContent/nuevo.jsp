<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<s:form action="AGrabar">

	<s:if test="%{estado==0}">
		<s:textfield label="Codigo Ciudad" name="ciudadbean.idCiu"></s:textfield>
	</s:if>
	<s:else>
		<s:hidden name="ciudadbean.idCiu"/>	
	</s:else>
		
	<s:textfield label="Descripcion" name="ciudadbean.desCiu"></s:textfield>

	<!-- 
	<s:textfield label="Codigo Pais" name="ciudadbean.idPais"></s:textfield>
	 -->
	 <s:select list="paises"
	 listKey="idPais" listValue="desPais" 
	 headerKey="0" headerValue="--Seleccione--"
	 name="ciudadbean.idPais"
	 />
	
	<s:hidden name="estado"></s:hidden>
	<s:submit value="Grabar"></s:submit>
</s:form>

</body>
</html>