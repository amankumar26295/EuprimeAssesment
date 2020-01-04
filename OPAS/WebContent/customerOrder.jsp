<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Orders</title>

</head>
<body>

<div class="mainContainer">
	<div style="float:left;width:70%;">
		
		<c:if test="${not empty dispList1 }">
		
		<div style="width:70%;height:500px;float:left;margin-left:10%;margin-top:5%;">
			
			<div class="orderlist">
				<table class="table1">
						<tr>
							<th>Request Id</th>
							<th>Shop Name</th>
							<th>Service Name</th>
							<th>Time</th>
							<th>Total Price</th>
						</tr>
					<c:forEach var='l' items='${dispList1}'>
						<tr>
							<td><p style="text-align:center;">${l.request_id}</p></td>
							<td><p style="text-align:center;">${l.shop_name}</p></td>
							<td><p style="text-align:center;">${l.service_name}</p></td>
							<td><p style="text-align:center;">${l.time_int}</p></td>
							<td><p style="text-align:center;">${l.price}</p></td>
						</tr>
					</c:forEach>	
				</table>
			</div>
		</div>
		</c:if>
		<c:if test="${empty dispList1 }">
		<div style="width:70%;height:500px;float:left;margin-left:10%;margin-top:5%;">
			<h2 style="text-align:center;">No waiting/served/requested Orders....</h2>
		</div>	
		</c:if>
	</div>
	
</div>	
	

</body>
</html>