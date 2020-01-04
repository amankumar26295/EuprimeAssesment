<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ShopkeeperHome2</title>
<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
<script type="text/javascript">
     var auto = setInterval(    function ()
     {
          $('#notify').load('notification.jsp').fadeIn("slow");
     }, 1000); // refresh **** milliseconds
     
     function myStopFunction() {
    	  clearInterval(auto);
    }
</script>
</head>
<body>
	<div class="mainContainer">
	
	<c:set var="shop_id" scope="session" value="${param.shop_id}"/>
	<c:if test="${not empty requestScope.shop_id}">
		<c:set var="shop_id" scope="session" value="${requestScope.shop_id}"/>
		
	</c:if>
	
	<div style="float:left;width:65%;">
		<div style="width:100%;height:50px;float:left;margin-top:3%;margin-left:20%;">
				
				<div style="width:20%;float:left;margin-top:2px;margin-left:5%;">
					<a href="served?shop_id=${sessionScope.shop_id}&action=waiting"><button id="openListButton">Waiting Order</button></a>
				</div>
				<div style="width:20%;float:left;margin-top:2px;margin-left:8%;">
					<a href="served?shop_id=${sessionScope.shop_id}&action=served"><button id="openListButton">Served Order</button></a>
				</div>
		</div>
		<c:if test="${not empty dispList }">
		
		<div style="width:100%;height:500px;float:left;">
			
			<div class="orderlist">
			<h1 style="text-align:center;">${shop_name}</h1><br>
				
				<table class="table1">
						<tr>
							<th>Request Id</th>
							<th>User Name</th>
							<th>Service Name</th>
							<th>Status</th>
							<th>Time</th>
							<c:if test="${not empty action2 }">
								<th>Action</th>
							</c:if>
							<c:if test="${not empty action1 }">
								<th>Rating</th>
							</c:if>
						</tr>
					<c:forEach var='l' items='${dispList}'>
						<tr>
							<td><p style="text-align:center;">${l.request_id}</p></td>
							<td><p style="text-align:center;">${l.user_name}</p></td>
							<td><p style="text-align:center;">${l.service_name}</p></td>
							<td><p style="text-align:center;">${l.status}</p></td>
							<td><p style="text-align:center;">${l.time_int}</p></td>
							<c:if test="${not empty action2 }">
								<td><a href="service?request_id=${l.request_id}"><button id="openListButton">Order Served</button></a></td>
							</c:if>
							<c:if test="${not empty action1 }">
								<td>${l.rating}</td>
							</c:if>
						</tr>
					</c:forEach>	
				</table>
			</div>
		</div>
		</c:if>
		<c:if test="${empty dispList }">
			<div style="width:70%;height:500px;float:left;">
			</div>
		</c:if>
	</div>
	
		
	<div class="outerNotificationBar" >
		<h1 style="text-align:center;">Notification Bar</h1>	
		<div class="innerNotificationBar" id="notify">
			
		</div>
	</div>
		
	</div>
	
	
</body>
</html>