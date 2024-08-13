<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>

<style>
body{
background-color: white}
.swiper-wrapper{
display: flex;
flex-direction: row;
}
.content-2{
    margin: 200px 0 0 150px;
    /* display: flex; */
        width: 70%
    
}

.swiper-slide img{
	 /* height: 350px;
	width: 430px;
	margin: 25px 100px 0 0; 
	transition: transform .7s;
	border-radius: 10%;
	background-color: pink;  */
	height: 250px;
	margin: 10px 0 30px 35px;
	border-radius: 20px;
	transition: transform .6s;
	cursor: pointer;
}
.swiper-slide img:hover{
	transform: scale(1.1);
	transition: transform .4s;

}
.swiper .swiper-button-prev, .swiper .swiper-button-next{
	color: rgb(255, 255, 255);
	size: 30px;
	transition: 0.8s ease;
}
.swiper-navbtn:hover{
	color: #ff9d00;
	font-size: 30px;
}
.swiper-pagination{
	color: rgb(255, 255, 255);
}
</style>

<link rel="stylesheet href="https://fonts.googleleapis.com/css2?familg=Materials+symbols
+Rounded:opsz,wght,Fill,GRAD@48,400,0,0">
<!--  -->
 </p>
 </style>
<!--<!-- Google Fonts Link For Icons -->
<style>
body{

}</style>

<nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
  <img src="images/sh.jpg" width= "100" height= "100">
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
          <a class="dropdown-item" href="register">Register</a>
          <a class="dropdown-item" href="userLogin">userLogin</a>
          
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
<div style="background-color: " class="container">
<div style=" background-color: " class="container-fluid">

			<div style=" background-color: " class="swiper">
				<!-- Additional required wrapper -->
				<div  " class="swiper-wrapper">
				  <!-- Slides -->
				  <div class="swiper-slide"><img src="images/advertising.jpg" alt="Grill Chicken"></div>
				  <div class="swiper-slide"><img src="images/amazon.jpg" alt="Shawarma"></div>
				  <div class="swiper-slide"><img src="images/arrivel.jpg" alt="Shawarma"></div>
				  <div class="swiper-slide"><img src="images/basketball.jpg" alt="Shawarma"></div>
				 <div class="swiper-slide"><img src="images/circket.jpg" alt="Shawarma"></div>
				 <div class="swiper-slide"><img src="images/cycle1.jpg" alt="Shawarma"></div>
				 <div class="swiper-slide"><img src="images/flat.jpg" alt="Shawarma"></div>
				 <div class="swiper-slide"><img src="images/football.jpg" alt="Shawarma"></div>
				 <div class="swiper-slide"><img src="images/footplay.jpg" alt="Shawarma"></div>
				 <div class="swiper-slide"><img src="images/grand.jpg" alt="Shawarma"></div>
				 <div class="swiper-slide"><img src="images/kit.jpg" alt="Shawarma"></div>
				 <div class="swiper-slide"><img src="images/net.jpg" alt="Shawarma"></div>
				 <div class="swiper-slide"><img src="images/now.jpg" alt="Shawarma"></div>
				<div class="swiper-slide"><img src="images/sale.jpg" alt="Shawarma"></div>
				<div class="swiper-slide"><img src="images/trend.jpg" alt="Shawarma"></div>
				</div>
				<!-- If we need pagination -->
				<div class="swiper-pagination"></div>
			  
				<!-- If we need navigation buttons  -->
				 <div style="background-color: black" class="swiper-button-prev swiper-navbtn"></div>
				<div class="swiper-button-next swiper-navbtn"></div> 
			  </div>
		</div>
	<br>
<title>welcome to RedKart</title>
</leftcorner>
<CENTER>

 </div>
</h1>
  </CENTER> 
		<br>
	<br>
	<div class="card-body" style="background-color: #D5D8DC; display: flex;  
  flex-wrap: wrap;">			
	<c:forEach var="customer" items="${main}">
		<div class="col-sm-4">
			<div class="container" style="display: ">
				<div class="row" >
					<div class="col-sm-3" style="margin-left: 100px">
						<div class="row">${customer.categoryname}</div>

					</div>
					
					<div class="row" >
						<div class="col-sm-3 " style="margin-left: 80px;background-color: ;">
							<form:form
								action="http://localhost:8080/RedKart/subCat/${customer.categoryid}"
								method="get">

								<input type="hidden" name="id" value="${customer.categoryid}">

								<a
									href="http://localhost:8080/RedKart/subCat/${customer.categoryid}">
									<img src="data:image/jpg;base64,${customer.image }" width="200"
									height="150" style="margin-right: 150px" />
								</a>
							</form:form>
					
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</c:forEach>
	<p>
	</div>
	</tc>
	</div>
	<div class="footer container">BuyMyShop created@Sound@r</div>
<script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
					<script>
						<!--alert("hii")-->
					const swiper = new Swiper('.swiper', {
						autoplay:{
							delay:3000,
							disableOnInteraction:true,
						},
						loop: true,
					  
						pagination: {
						  el: '.swiper-pagination',
						  clickable:true,
						  dynamicBullets:true,
						
						},
					  
						// navigation: {
						//   nextEl: '.swiper-button-next',
						//   prevEl: '.swiper-button-prev',
						// },
					  
						
					  });
					</script>
	
</body>