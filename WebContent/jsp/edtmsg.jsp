<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Redirect Page</title>
</head>
<body>
	<br>
	<br>
	<center>
		<font size="6" color="green">${message}</font>
	</center>
	<br>
	<br>
	<a href="update/?id=${email}">Updated Profile</a>

	<p>
	<a href="welcome">Home</a>
	</p>
	
	<p>
	<a href="login">Login</a>
	</p>


</body>
</html>