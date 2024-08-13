<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>SUMMARY</title>
<h2>
	<center>
		<font style="background-color: DARKORANGE;"> REDKART SUMMARY </font>
	</center>
</h2>
<a href="home">home</a>
<a href="subCat">subCat</a>
<a href="brand">brand</a>
<a href="list">list</a>
<a href="productDetail">productDetail</a>
<select onchange="color(this.value)">
	<option value="">color</option>
	<option value="blue">Blue</option>
	<option value="white">White</option>
	<option value="yellow">Yellow</option>
	<option value="pink">Pink</option>
	<option value="black">Black</option>
	<option value="orange">Orange</option>
</select>
<script>
	function color(value) {
		document.body.style.backgroundColor = value;
	}
</script>

<style type="text/css">
</style>
</head>
<body>
	<h5>
		totalQuantity:${orderBean.totalQuantity} <br>
		totalAmount:${orderBean.totalAmount} <br>
	</h5>
	<h4>

		<div class="container">
			<div class="row">


						 NAME: ${orderBean.userBean.firstName} <br> <br>
				Email:${orderBean.userBean.email } <br> <br>
		DeliveryAddress: ${orderBean.userBean.address} <br> <br> 
				pincode:${orderBean.userBean.pincode} <br> <br>
				paymentmethod:${orderBean.paymentmethod} <br> <br>
				deliveryCharges:${orderBean.cartBean.charges } <br> <br>
				totalPayOut:${orderBean.payout} <br> <br>

			</div>
		</div>
	</h4>

	<rightcorner>
	<div class="row">
		<div id="main">
			<div class="column">
				<p>
				<div class="container">

					<div class="row">
						<c:forEach var="document" items="${orderBean.entryBean}">

							<div class="column">

								<div class="col-sm-12" style="margin-left: 40px">

									<img src="data:image/jpg;image/png;base64,${document.prod.pic}"
										width="150" height="150" />
									<form:form id="updateform" method="post"
										action="updateQuantity" modelAttribute="update">
										<input type="hidden" name="productId"
											value="${document.productId}">
										<input type="hidden" name="totalCost"
											value="${document.totalCost}">
										<input type="hidden" name="cartId" value="${document.cartId}">
									</form:form>

								</div>
							</div>
							<div class="col-sl-8" style="padding-left: 150px">
								<p>${details.prod.productName}</p>
								<p>Quantity:${document.quantity }</p>
								<p>BasicPrice:${document.price}</p>
								<p></p>
							</div>
					</div>

					<p>
				</div>
				</c:forEach>
			</div>

		</div>
	</rightcorner>
	<div class="footer container">BuyMyShop created@Sound@r</div>
</body>
</html>