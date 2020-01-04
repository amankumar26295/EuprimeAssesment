<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"  type="text/css" href="css/style.css"> 
<link rel="stylesheet"  type="text/css" href="css/form.css">
<link rel="stylesheet"  type="text/css" href="css/popup.css">
<link rel="stylesheet"  type="text/css" href="css/shopSearchNavBar.css">
<!-- <link rel="stylesheet"  type="text/css" href="css/test2.css"> -->
</head>
<body>
	<div class="menu">
	     	<div class="leftmenu">
	     		<!-- <p style="font-size:50px;float:left;margin-left:30%;color:#7272b0;">Online Parlour Appointment System</p> -->
	        	<img src="images/opaslogo" style="width:66%;margin-left:2%;">	 
	    	</div>
	    	<div class="rightmenu">	
   				<c:if test="${empty sessionScope.customer && empty sessionScope.shopkeeper}">
        			<button onclick="document.getElementById('101').style.display='block'" id="loginButton">Login</button>
				</c:if>
				<c:if test="${not empty sessionScope.customer || not empty sessionScope.shopkeeper}">
					<a href="logout" style="color:black;text-decoration:none"><button id="loginButton">Logout</button></a>
				</c:if>
	 			<c:if test="${not empty sessionScope.customer || not empty sessionScope.shopkeeper}">
	      			<div style="float:right;margin-right:2%;"><p1 style="font-size:140%;">${fn:toUpperCase(sessionScope.customer.name)}${fn:toUpperCase(sessionScope.shopkeeper.name)}</p1></</div>
				</c:if>	 
	    	</div>
	</div>
	<div class="navigation">
		<ul>
			<c:if test="${not empty sessionScope.customer }">
				<li><a href="CustomerHome.jsp">Home</a></li>
			</c:if>
			<c:if test="${not empty sessionScope.shopkeeper}">
				<li><a href="ShopkeeperHome.jsp">Home</a></li>
			</c:if>
			<c:if test="${empty sessionScope.shopkeeper && empty sessionScope.customer && empty sessionScope.admin}">
				<li><a href="home.jsp">Home</a></li>
				<li><a href="#beautytips">Beauty Tips</a></li>
				<li><a href="#contact">Contact</a></li>
				<li><a href="#about">About</a></li>
			</c:if>
				
			<c:if test="${not empty sessionScope.shopkeeper}">
				<li onclick="document.getElementById('103').style.display='block'" style="align:right"><a href="#">Add Shop</a></li>
			</c:if>
			<c:if test="${not empty sessionScope.customer}">
				<li>
					<div class="dropdown">
					    <button class="dropbtn">My Orders</button>
					    <div class="dropdown-content">
					      <a href="userServed?user_id=${sessionScope.customer.id}&action=waiting">Requested Order</a>
					      <a href="userServed?user_id=${sessionScope.customer.id}&action=served">Served Order</a>
					      <a href="#">Waiting Order</a>
					    </div>
				  	</div>
				 </li>
				 <li style="border:1px solid white;border-radius:3px;width:226px;">
				 <span style="color:white;margin-left:5px;">Sort By : </span>
					<select style="width:100px;font-size:18px;" id="sortby">
				  		<option value="desc">Rating: High-Low</option>
					    <option value="asc">Rating: Low-High</option>
					 </select>
				  </li>
				 <li style="width: 380px;border:1px solid white;border-radius:3px;">
					<form>
						<div style="width:55%;float:left;">
							<input type="text" placeholder="Search for shop by : " id="searchText" style="font-size:20px;margin-left:5px;">
					  	</div>
						<select style="width:38%;float:left;margin-left:5%;font-size:18px;" id="searchType">
					  		<option value="shop_name">Shop Name</option>
					  		<option value="locality">Shop Locality</option>
						    <option value="shop_type">Shop Type (Men / Women / Both)</option>
					  	</select>
		  				</form>
				  </li>
				  
				<!-- <li><a href="intialSearch">Search Shop</a></li>
				<li onclick="document.getElementById('104').style.display='block'" style="align:right"></li> -->
			</c:if>
		</ul>
	</div>
	
	<div>
		<div id="101" class="modal">	  
			<div class="modal-content animate" >
			<div class="container11" >
				<div class="form">
					<form action="login" method="post" >
						<legend style="color:yellow; margin-left:43%; font-size:25px; font-weight:bold">LOGIN</legend>	
						
						<table  style="width:100%;">
							<tr>
								<th></th>
								<th style="width:65%;"></th>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Login As :</p></td>
								<td>
									
									<select name="role" required>
										<option value="user">customer</option>
										<option value="shopkeeper">shopkeeper</option>
										<!-- <option value="admin">admin</option> -->
									</select><br>
				 				</td>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Email Id :</p></td>
								<td>
									<input type="text" name="email_id" autofocus required>
				 				</td>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Password :</p></td>
								<td>
									<input type="password" name="password"  required>
				 				</td>
							</tr>
						</table>
						<table style="width:100%;">
							<tr >
								<th></th>
								<th style="width:60%;"></th>
							</tr>
							<tr>
								<td></td>
								<td>
									<input type="submit" value="LOGIN" style="width:50%;">
				 				</td>
							</tr>
							
							<tr>
								<td><p style="color:white; font-size:20px;text-align:right;">Not registered yet??</p></td>
								<td>
									<button onclick="document.getElementById('101').style.display='none' ; document.getElementById('102').style.display='block'" id="registerButton">REGISTER</button>
				 				</td>
							</tr>
							<tr>
								<td style="float:right;"></td>
								<td>
									<a href="forgotPass.jsp"><p>forgot password??</p></a>
				 				</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			</div> 		  
		</div>
		
		<div id="102" class="modal">	  
			<div class="modal-content animate" >
			<div class="container11" >
				<div class="form">
					<form action="signup" method="get" >
						<legend style="color:yellow; margin-left:39%; font-weight:bold">REGISTER</legend>
						<table  style="width:100%;">
							<tr>
								<th></th>
								<th style="width:65%;"></th>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Register As :</p></td>
								<td>
									
									<select name="role" required>
										<option value="user">customer</option>
										<option value="shopkeeper">shopkeeper</option>
										<!-- <option value="admin">admin</option> -->
									</select><br>
				 				</td>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Full Name :</p></td>
								<td>
									<input type="text" name="name" autofocus required>
				 				</td>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Email Id :</p></td>
								<td>
									<input type="text" name="email_id" autofocus required>
				 				</td>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Password :</p></td>
								<td>
									<input type="password" name="password"  required>
				 				</td>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Phone :</p></td>
								<td>
									<input type="text" name="mobile_no" autofocus required>
				 				</td>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">City :</p></td>
								<td>
									<input type="text" name="city" autofocus required>
				 				</td>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Locality :</p></td>
								<td>
									<input type="text" name="locality"  required>
				 				</td>
							</tr>
						</table>
						<input type="submit" value="Register" style="float:right;margin-right:3%;">
					</form>
					<!-- <button  onclick="document.getElementById('102').style.display='none'"  id="cancleButton">Cancel</button> -->
				</div>
			</div>
			</div> 		  
		</div>
		
		<div id="103" class="modal">	  
			<div class="modal-content animate" >
			<div class="container11" >
				<div class="form">
					<form action="addShop1" method="post">
						<legend style="color:yellow; margin-left:43%; font-size:25px; font-weight:bold">ADD SHOP</legend>	
						
						<table  style="width:100%;">
							<tr>
								<th></th>
								<th style="width:60%;"></th>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Shop Type :</p></td>
								<td><select name="shop_type" required>
										<option value="men">Men</option>
										<option value="women">Women</option>
										<option value="both">Both</option>
									</select>
				 				</td>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Shop Name :</p></td>
								<td><input type="text" name="shop_name" autofocus required></td>
				 			</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Shop Email :</p></td>
								<td><input type="text" name="shop_email_id"></td>
				 			</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Shop Mobile No :</p></td>
								<td><input type="text" name="shop_mobile_no" required></td>
				 			</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">City :</p></td>
								<td>
									<input type="text" name="city" required>
				 				</td>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Locality :</p></td>
								<td><input type="text" name="locality" required></td>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">GSTIN No :</p></td>
								<td><input type="text" name="gst_no"  required></td>
							</tr>
						</table>
						<table style="width:100%;">
							<tr >
								<th></th>
								<th style="width:60%;"></th>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="Next" style="width:50%;"></td>	
							</tr>
						</table>
					</form>
				</div>
			</div>
			</div> 		  
		</div>
		<div id="104" class="modal">	  
			<div class="modal-content animate" >
			<div class="container11" >
				<div class="notification" style="width:30%;margin-left:40%;float:left;">
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
		 			<input type="submit" value="Search Parlours" style="margin-top:4%;margin-left:30%;width:40%;">
		 		</div>	
  			</form>
			</div>
				</div>
			</div>
			</div> 
			
			<div id="105" class="modal">	  
			<div class="modal-content animate" >
			<div class="container11" >
				<div class="notification" style="width:30%;margin-left:40%;float:left;">
			<form action="sortController" method="post">
			 	<div style="width:95%; float:left;margin-left:2px;padding:3px;">
			 	
			 		<div  style="margin-top:2%;">
			 		
						<select name="option"  required>
						  	<option value="rating">Rating</option>
						</select>
					</div>
					<div  style="margin-top:2%;">
			 		
						<select name="type"  required>
						  	<option value="low">Low - High</option>
						  	<option value="high">High - Low</option>
						</select>
						<input type="submit" value="search">
					</div>
			 	</div>
  			</form>
			</div>
				</div>
			</div>
			</div> 
					  
		</div>
	
	
<script>
	// Get the modal
	var m1 = document.getElementById('101');
	var m2 = document.getElementById('102');
	var m3 = document.getElementById('103');
	var m4 = document.getElementById('104');
	var m5 = document.getElementById('105');
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == m1 || event.target == m2 || event.target == m3 || event.target == m4 || event.target == m5 ) {
	        m1.style.display = "none";
	        m2.style.display = "none";
	        m3.style.display = "none";
	        m4.style.display = "none";
	        m5.style.display = "none";
	    }
	    
	}
	
</script>
</body>
</html>