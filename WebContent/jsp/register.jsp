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
<title>Register your details</title>
</head>
<body>
 <div> 
<div>
<h1 style="background-color:Cyan;"><center>RED KART</center></h1>

</div>
<div style="display:flex;flex-direction: column;width: 100%; justtify-content:center;align-items:center;margin-top: 20px;">
<div style="display:flex;flex-direction: column;width: 45%;height:50px; justtify-content:center;background-color: CYAN;">
<center><h2>REGISTER</h2></center>
</div>
<div style="width: 45%">
<form:form id="registerform" method="post" action="register"
modelAttribute="userBean" enctype="multipart/form-data">
<div class="card-body" style="background-color: #DCDCDC;width: 100%;" />
	<br>

	<form:label path="firstName">FirstName:</form:label>
		<form:input id="firstName" name="firstName" path="" />
		<form:errors path="firstName" cssClass="error" />
		<br>
		<br>

		<form:label path="lastName">LastName:</form:label>
		<form:input id="lastName" name="lastName" path="" />
		<form:errors path="lastName" cssClass="error" />
		<br>
		<br>

		<form:label path="email">Email:</form:label>
		<form:input id="email" type="email" name="email" path="" />
		<form:errors path="email" cssClass="error" />
		<br>
		<br>

		<form:label path="password">Enter Password:</form:label>
		<form:password id="password" name="password" path="" />
		<form:errors path="password" cssClass="error" />
		<br>
		<br>

		<form:label path="confirmPassword">Password:</form:label>
		<form:password id="confirmPassword" name="confirmPassword" path="" />
		<form:errors path="confirmPassword" cssClass="error" />
		<br>
		<br>

		<form:label path="mobile">MobileNumber:</form:label>
		<form:input id="mobile" name="mobile" path="" maxlength="10" />
		<form:errors path="mobile" cssClass="error" />
		<br>
		<br>
			<form:label path="flatno">Flat No:</form:label>
		<form:input id="flatno" type="flatno" name="flatno" path="" />
		<form:errors path="flatno" cssClass="error" />
		<br>
		<br>
			<form:label path="area"> area/Street:</form:label>
		<form:input id="area" type="area" name="area" path="" />
		<form:errors path="area" cssClass="error" />
		<br>
		<br>
			<form:label path="pincode">pincode:</form:label>
		<form:input id="pincode" type="pincode" name="pincode" path="" />
		<form:errors path="pincode" cssClass="error" />
		<br>
		<br>
			<form:label path="landmark">landmark</form:label>
		<form:input id="landmark" type="landmark" name="landmark" path="" />
		<form:errors path="landmark" cssClass="error" />
		<br>
		<br>
			<form:label path="towncity">towncity:</form:label>
		<form:input id="towncity" type="towncity" name="towncity" path="" />
		<form:errors path="towncity" cssClass="error" />
		<br>
		<br>
			<form:label path="State">State :</form:label>
		<form:input id="State" type="State" name="State" path="" />
		<form:errors path="State" cssClass="State" />
		<br>
		<br>
			<form:label path="country">country :</form:label>
		<form:input id="country" type="country" name="country" path="" />
		<form:errors path="country" cssClass="error" />
		<br>
		<br>
			<form:label path="addaddress">addaddress:</form:label>
		<form:input id="addaddress" type="addaddress" name="addaddress" path="" />
		<form:errors path="addaddress" cssClass="error" />
		<br>
		<br>
		<form:label path="image">Profile Image:</form:label>
		<form:input type="file" id="image" name="image" path="" />
	      <br>
		<input type="submit" value="Submit" />
		</div>
		<br>
		<br>
</form:form>

</div>
</div>
</body>
</html>
