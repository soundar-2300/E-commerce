<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional/ /EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body{
background-image:url('images/gif.gif');
}</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UPDATE 	PROFILE </title>
</head>

	<form:form id="updateaddressform" method="GET" action="checkout"
		modelAttribute="orderBean1" enctype="multipart/form-data">
    
	<center>
		<h1><font style="background-color: LIGHTyellow	;">  UPDATE PROFILE DETAILS</font></h1>
	</center>
	<input path="email" type="hidden" name="email" value="${user.email}">
<input type="submit" value="update"/>	

</form:form>
</body>
</html>