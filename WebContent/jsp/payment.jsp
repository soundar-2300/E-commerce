<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="navbar.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional/ /EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PAYMENT</title>
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
<center><h2>PAYMENT</h2></center>
</div>

<div style="width: 45%">
	<form:form id="paymentform" method="POST" action="/RedKart/saved"
		modelAttribute="orderBean1" enctype="multipart/form-data">
 	<input path="email" type="hidden" name="email" value="${userBean.email}">
	<input path="datetime" type="hidden" name="datetime"
		value="${orderBean.datetime}">
		
	<input path="totalQuantity" type="hidden" name="totalQuantity" value="${orderBean.totalQuantity }"/>

<input path="totalAmount" type="hidden" name="totalAmount"value="${orderBean.totalAmount }"/>

<input path="payout" type="hidden" name="payout" value="${orderBean.payout }"/>

    

<div class="card-body" style="background-color: #DCDCDC;width: 100%;" />
	
TOTALQUANTITY:${orderBean.totalQuantity }
<br>
<br>
<br>
TOTALAMOUNT:${orderBean.totalAmount }
<br>
<br>
<br>
PAYOUT:${orderBean.payout }
<br>
<br>
<br>
PAYMENT METHOD:<input type="radio" name="paymentmethod" value="cod"
		id="COD-radio"> <label for="COD-radio">COD<img
		src="COD.gif"></label> <input type="radio" name="paymentmethod"
		value="card" id="CARD-radio"> <label for="CARD-radio"><img
		src="CARD.gif">CARD</label> 
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