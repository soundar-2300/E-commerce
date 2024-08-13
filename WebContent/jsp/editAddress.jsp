<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional/ /EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EditAddress</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<font size="4" color="red">${message}</font>
<h1>EditAddress</h1>
<form:form id="editaddressform" method="POST" action="/RedKart/updateaddress"
		modelAttribute="orderBean1" enctype="multipart/form-data">
    <div class="card-body" style="background-color: #D5D8DC 
">

	<input path="email" type="hidden" name="email" value="${user.email}">

	<form:label path="address">Enter your HomeAddress:</form:label>
	<form:input id="address" name="address" path="address"
		value="${user.address}" />
	<br>
	<br>
	<form:label path="address2">Enter your OfficeAddress:</form:label>
	<form:input id="address2" name="address2" path="address2"
		value="${user.address2}" />
	<br>
	<br>
	<input type="submit" value="Submit" />
</div>
</form:form>
</body>
</html>
