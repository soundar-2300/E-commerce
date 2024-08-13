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
<title>Profile</title>
</head>

<form:form  method="post" action="payment" modelAttribute="orderBean1" enctype="multipart/form-data" >
	<h1>
		<font color="maroon" size="5">Your Details</font>
	</h1>
	<img width="200" height="200" src="data:image/jpg;base64,${userBean.pic}"/>
	<br>
	<br>
	FirstName : ${userBean.firstName}
	<br>
	<br> 
	LastName : ${userBean.lastName}
	<br>
	<br> 
	Email : ${userBean.email}
	<br>
	<br> 
	Mobile Number : ${userBean.mobile}
	<br>
	<br>
	flat No:${userBean.flatno}
	<br>
	<br>
	Area Name:${userBean.area }
	<br>
	<br>
	Pincode:${userBean.pincode}
	<br>
	<br>
	LankMark:${userBean.lankmark }
	<br>
	<br>
	TownCity:${userBean.towncity}
	<br>
	<br>
	state:${userBean.state}
	<br>
	<br>
	Country:${userBean.country}
	<br>
	<br>

	<a href="edit/?id=${userBean.email}">Edit</a>
	</form:form>
	</body>
</html>