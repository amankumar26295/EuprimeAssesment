<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ShopkeeperHome</title>
<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
<script type="text/javascript">
    
</script>
</head>
<body>
	<div class="mainContainer">
		<div style="width:80%;height:500px;float:left;">
			<c:if test="${not empty shop_list}">
			<div class="shopList">
			<h1 style="text-align:center;">Shop List</h1><br><br>
				<c:forEach var="shop" items="${shop_list}">
					<table class="shopListTable">
						
						<tr style="background-color: #dddddd">
							<c:set var="name" scope="page" value="${shop.shop_name}"/>
							<td >
								<div style="float:left;width:60%;">
									<div style="float:left;width:100%;">
										<h2 style="text-align:left">${fn:toUpperCase(name)}</h2>
									</div>
									<div style="float:left;width:100%;margin-top:10px;">
										<div style="float:left;width:10%;">
											<img src="images/location" style="width:40%;margin-left:2%;">
										</div>
										<div style="float:left;width:40%;margin-top:10px;">
											<p style="text-align:left">${shop.locality} , ${shop.city}</p>
										</div>
									</div>
									<%-- <div style="float:left;width:100%;text-align:left;margin-top:10px;margin-left:2px;">
										<div style="width:30%;float:left;">
											<c:if test="${shop.shop_type eq 'men'}">
												<img src="images/male" style="width:30%;">
											</c:if>
											<c:if test="${shop.shop_type eq 'women'}">
												<img src="images/female" style="width:30%;">
											</c:if>
											<c:if test="${shop.shop_type eq 'both'}">
												<img src="images/male" style="width:30%;"><img src="images/plus" style="width:10%;margin-left:2%;"> <img src="images/female" style="width:35%;margin-left:2%;">
											</c:if>
										</div>
									</div> --%>
								</div >
								
								
								<div style="float:left;width:28%;text-align:right;">
									<img src="images/star2" style="width:17%;margin-left:5%;">
								</div>
								<div style="float:left;width:10%;margin-top:15px;text-align:left;">
									<p style="margin-left:15%;font-size:25px;font-weight:bold;">${shop.rating}<c:if test="${empty shop.rating}">0</c:if></p>
								</div>
								<div style="width:20%;float:right;margin-top:10px;">
									<form action="ShopkeeperHome2.jsp" method="post">
										<input type="hidden" name="shop_id" value="${shop.id}">
										<input type="submit" value="Open Dashboard" id="openButton" style="width:100%;">
									</form>
								</div>
								
								
							</td>
						</tr>
						<tr>
							<td >
								<div style="width:30%;float:left;">
									<form action="AddMenu" method="post">
										<input type="hidden" name="shop_type" value="${shop.shop_type}">
										<input type="hidden" name="shop_id" value="${shop.id}">
										<input type="submit" value="Add/Update Menu" id="openButton" style="width:100%;float:left;">
									</form>
								</div>
								<div style="width:30%;float:right;">
									<c:if test="${shop.open eq 'n'}">
										<form action="OpenCloseShop" method="post">
											<input type="hidden" value="${shop.id}" name="shop_id">
											<input type="hidden" value="y" name="action">
											<input type="submit" value="OPEN NOW" style="width:67%;padding:13px;margin-left:32%;background-color:#4b794b;">
										</form>
									</c:if>
									<c:if test="${shop.open eq 'y'}">
										<form action="OpenCloseShop" method="post">
											<input type="hidden" value="${shop.id}" name="shop_id">
											<input type="hidden" value="n" name="action">
											<input type="submit" value="CLOSE NOW" style="width:67%;padding:13px;margin-left:32%;background-color:#a66161;">
										</form>
									</c:if>
								</div>
								<div style="float:right;width:20%;text-align:right;margin-top:20px;">
									<c:if test="${shop.open eq 'y'}">
										<span style="color:green;font-size:30px;">OPEN</span>
									</c:if>
									<c:if test="${shop.open eq 'n'}">
										<span style="color:red;font-size:30px;">CLOSED</span>
									</c:if>
								</div>
								
							</td>
							<!-- <td >
								<a href="#"><button id="openButton" style="float:right;">Open Now</button></a>
							</td> -->
							
						</tr>
					</table>
					<br>
				</c:forEach>
			</div>
			</c:if>
			<c:if test="${empty shop_list}">
				<h1 style="text-align:center;"> Add Shop </h1>
				<br><br>
			</c:if>
			
		</div>
		
		<div style="width:19%;float:left;height:200px;margin-top:1%;position:sticky;top:60px;">
			<div class="notification">
			<form action="search" method="post">
			 	<div style="width:95%; float:left;margin-left:2px;padding:3px;">
			 		<div  style="margin-top:2%;">
			 			<!-- <p style="color:black; font-size:30px;">Parlour Type :</p> -->
						<select name="type"  required>
						  	<option value="women">Women</option>
						  	<option value="men">Men</option>
						  	<option value="both">Both</option>
						</select>
					</div>
			 	</div>
		 		<div style="width:95%; float:left;margin-left:2px;padding:3px;">
		 			<div style="margin-top:2%;">
					<!-- <p style="color:black; font-size:30px;">Locality :</p> -->
	 					<input  type="text" placeholder="Search for locality" name="locality" required>
	 					</div>
		 		</div>
		 		<div style="width:95%; float:left;margin-left:2px;padding:3px;">
		 			<input type="submit" value="Search Parlours" style="margin-top:4%;width:60%;">
		 		</div>	
  			</form>
			</div>
		</div>
		
	</div>	
</body>
</html>