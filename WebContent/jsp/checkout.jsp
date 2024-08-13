<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="navbar.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional/ /EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CHECK OUT</title>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
  <img src="images/sh.jpg" width= "100px" height= "100px" alt="img2">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
 	
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="showCart">Cart</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          User
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="login">Login</a>
          <a class="dropdown-item" href="register">Register</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
</nav>

</head>
<body>
<div> 
<div>
<h1 style="background-color:Cyan;"><center>RED KART</center></h1>

</div>
<div style="display:flex;flex-direction: column;width: 100%; justtify-content:center;align-items:center;margin-top: 20px;">
<div style="display:flex;flex-direction: column;width: 45%;height:50px; justtify-content:center;background-color: CYAN;">
<center><h2>CHECKOUT</h2></center>
</div>
<div style="width: 45%">
	<form:form id="paymentform" method="GET" action="payment"
		modelAttribute="orderBean1" enctype="multipart/form-data">
    

<div class="card-body" style="background-color: #DCDCDC;width: 100%;" />
	
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
	LandMark:${userBean.landmark }
	<br>
	<br>
	TownCity:${userBean.towncity}
	<br>
	<br>
	state:${userBean.state}
	<br>
	<br>
	Country:${userBean.country }
	<br>
	<br>
	addaddress:${userBean.addaddress}
	<br>
	<br>
	<a href="profile/edit/?email=${userBean.email}">EditDetails</a>
	<br>
	<br>
    <input type="submit" value="submit"/>	
	
	</div>
	<br>
	<br>

</form:form>

</div>
</div>



</div>
</body>
</html>