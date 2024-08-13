<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
  <img src="images/sh.jpg" width= "100px" height= "100px" alt="img2">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
 	
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
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


<meta charset="UTF-8">

<title>Order Summary</title>
</head>
<body>

	<br>
	<br>
	<div class="container">
		<div class="card w-100 mx-auto my-6">
			<div class="card-header">
				<h1 style="background-color:Cyan;"><center>Summary</center></h1>

			</div>
			</div>
			<div class="card-body" style="background-color:  #D5D8DC 
">
				<h5>Delivery To:</h5>

				NAME: ${orderBean.userBean.firstName} <br>
				Email:${orderBean.userBean.email}<br>
				DeliveryAddress: ${orderBean.userBean.flatno},${orderBean.userBean.area},${orderBean.userBean.towncity},${orderBean.userBean.pincode},${orderBean.userBean.state},${orderBean.userBean.country}<br>
				<br>

			</div>

			<div class="card-body" style="background-color: #D5D8DC 
">
				<h5>Order Details:</h5>
				Ordered On ${detail.date}
				<p>
					Total Items=<b>${orderBean.cartBean.totalQuantity}&nbspNos</b>
				</p>

				<c:forEach var="items" items="${orderBean.entryBean}">
					<img src="data:image/png;base64,${items.prod.pic}" width="120"
						height="100">
						${items.prod.productName} &nbsp&nbsp&nbsp&nbsp
                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                        Qty:<b>${items.quantity}</b> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <b>Price:-&#8377.${items.totalCost}</b>
					<p></p>
				</c:forEach>
			</div>

			<div class="card-body" style="background-color: #D5D8DC "/>

				<h5>Payment Method:-</h5>
				Payment Type:-<b>${orderBean.paymentmethod}</b> 
				<br> Total Amount Paid:-<b>&#8377.${orderBean.payout}</b>
			</div>

		</div>
	</div>
	<br>
	<br>

</body>
</html>