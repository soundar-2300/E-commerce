<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional/ /EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body{
background-image:url('images/background.jpg');
}</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shoppingLogin</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body >
<div> 
<div>
<h1 style="color:White;"><center>RED KART</center></h1>

</div>
<div style="display:flex;flex-direction: column;width: 100%; justtify-content:center;align-items:center;margin-top: 20px;">
<div style="display:flex;flex-direction: column;width: 45%;height:50px; justtify-content:center;background-color: CYAN;">
<center><h2>USERLOGIN</h2></center>
</div>
<div style="width: 45%">
		<form:form id="userloginForm" method="POST" action="userLogin"
		modelAttribute="userBean">


<div class="card-body" style="background-color: #DCDCDC;width: 100%;" />
	<br>
	<center>	<form:label path="email"> Email-Id:</form:label>
		<form:input id="email" name="email" path="" />
		<form:errors path="email" cssClass="error" />
		<br>
		<br>
	 	<form:label path="password">Password</form:label>
		<form:password id="password" name="password" path="" />
		<br>
		<br>
		<input type="submit" value="Submit" />
		</div>
	<br>
	<br>

</form:form>

</div>
</div>
</div>
</body>
</html>
