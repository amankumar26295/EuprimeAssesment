<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search result</title>
</head>
<body>

	<div class="maincontainer" style="height:1500px;">
	<div style="width:80%;float:left;margin-left:5%;">
		<div style="width:12%;float:left;margin-left:2%;">
			<button onclick="document.getElementById('105').style.display='block'" id="loginButton" style="width:100%;">Sort</button>
		</div>
		<div style="width:12%;float:left;margin-left:2%;">
			<button onclick="document.getElementById('104').style.display='block'" id="loginButton" style="width:100%;">Filter</button>
		</div>
	</div>
		<div class="orderlist" >
			<table class="table1">
				<tr>
					<th>Shop Name</th><th>Locality</th><th>Type</th><th>Rating</th><th>Action</th>
				</tr>
				<c:forEach var="i" items="${search_shop_list}">
					<tr>
						<td><p style="text-align:center;">${i.shop_name}</p></td>
						<td><p style="text-align:center;">${i.locality}</p></td>
						<td><p style="text-align:center;">${i.shop_type}</p></td>
						<td><p style="text-align:center;">${i.rating}</p></td>
						<td>
						<a  href="appoint?shop_id=${i.id }" style="color:white;text-decoration:none"><button id="bookingButton">Take Appointment</button></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
	</div>
	
	
	
</body>
</html>