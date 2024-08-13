<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<style type="text/css">
</style>
</head>
<body>
	
	<div class="row" style="width: 100%;display: flex;flex-direction: column">
		<div id="main">
			<div class="column">
				<p>
				<div class="card-body" style="background-color: #D5D8DC; display: flex;  
  flex-wrap: wrap;">			
	<h5>
		totalQuantity:${files.totalQuantity} <br>
		totalAmount:${files.totalAmount} <br>
	</h5>
	
					<c:forEach var="items" items="${files.entryBean}">
						<div class="containerstyle=" width: 100%">
	
							<div class="row">
								<div class="column">
									<div class="col-sm-12" style="margin-left: 40px">
										<img src="data:image/jpg;image/png;base64,${items.prod.pic}"
											width="150" height="150" /> 
											<form:form id="updateform" method="post" action="updateQuantity"
										modelAttribute="update">
					    Quantity:<input type="number" name="quantity" value= "${items.quantity}">
						<input type="hidden" name="productId" value="${items.productId}">
						<input type="hidden" name="totalCost" value="${items.totalCost}">
						<input type="hidden" name="cartId" value="${items.cartId}">
						<input type="submit" class="btn btn-primary" value="Qty" />
					</form:form>

									</div>
								</div>
								<div class="col-sl-8" style="padding-left: 190px">
									<p>${items.prod.productName}</p>
									<p>Quantity:${items.quantity }</p>
									<p>BasicPrice:${items.price}</p>
									<form:form id="delete" method="post" action="delete"
										modelAttribute="delete">
										<input type="hidden" name="Id" value="${items.remove}">
										<input type="submit" class="btn btn-primary" value="delete">
                                           </form:form>
										<p>
											<a href="BuyNow">BuyNow</a>
										</p>
								</div>
							</div>
					</c:forEach>
				<p>
				<a href="checkout">checkout</a>
	
			
	
	</div>
	</div>
	<div class="footer container">BuyMyShop created@Sound@r</div>
	</div>
		</div>
</body>
</html>