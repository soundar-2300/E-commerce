<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Welcome</title>
</head>
<body bgcolor="lightyellow">

	<center>
		<font size="5" color="lightred">Welcome ${userBean.email}</font>
	</center>

	<center>
		<font size="5" color="green">${message}</font>
	</center>
	
	<!--  <a href="profile/?id=${userBean.email}">View Profile</a>-->

</body>
</html>

