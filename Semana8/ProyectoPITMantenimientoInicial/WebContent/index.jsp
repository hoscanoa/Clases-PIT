<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sj:head jqueryui="false" />
<sb:head includeScripts="true" includeScriptsValidation="true" />
</head>

<body>
	<s:actionerror theme="bootstrap" />
	<s:actionmessage theme="bootstrap" />

	<s:form action="ALogueo" id="frm" theme="bootstrap"
		cssClass="form-horizontal" label="Logueo de Usuario">

		<s:textfield label="Login" name="usuariobean.login"
			requiredLabel="true" tooltip="Enter your Name here" />

		<s:password label="Clave" name="usuariobean.clave"
			requiredLabel="true" tooltip="Enter your Name" />
		<div class="form-actions">

			<s:submit cssClass="btn btn-inverse" value="Entrar" formIds="frm" />

		</div>

	</s:form>


</body>
</html>
<!-- 
<script language="javascript">
//document.getElementById("txtlogin").value="hola";
$("#txtlogin").val("Holaxxx");

</script>
 -->

