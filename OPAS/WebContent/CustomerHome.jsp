<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
<script type="text/javascript">

	var auto = setInterval(    function ()
	{
		$('#notify').load('notification2.jsp').fadeIn("slow");
	}, 1000); // refresh **** milliseconds
	   
	function myStopFunction() {
		clearInterval(auto);
	}  
	window.onload = function(){
    	$('#load').load('load.jsp').fadeIn("slow");
   	}
	
	$(document).ready(function(){
		$('#searchText').keyup(function(){
			var text=$('#searchText').val();
			var type=$('#searchType').val();
			
			$.ajax({
				type:'get',
				data:{
					text : text,
					type : type
				},
				url:'searchLoad.jsp',
				success:function(result){
					$('#load').html(result);
				}	
			});
		});
	});
	$(document).ready(function(){
		$('#sortby').click(function(){
			var type=$('#sortby').val();
			
			$.ajax({
				type:'get',
				data:{
					type : type
				},
				url:'sortLoad.jsp',
				success:function(result){
					$('#load').html(result);
				}	
			});
		});
	});
</script>
</head>
<body>
		<%
			System.getProperties().setProperty("oracle.jdbc.J2EE13Compliant","true");
		%>
<div class="mainContainer">
	
	<div style="float:left;width:70%;">
		<%-- <c:if test="${not empty dispList1 }"> --%>
		
		<div id="load" style="width:70%;height:500px;float:left;margin-left:14%;margin-top:5%;">
			
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
		
		<%-- </c:if> --%>
		<%-- <c:if test="${empty dispList }">
			<div style="width:100%;height:500px;float:left;">
			</div>
		</c:if> --%>
		
	</div>
	
	<div class="outerNotificationBar">
		<h1 style="text-align:center;width:100%;border:2px solid white;">Notification Bar</h1>	
			<div class="innerNotificationBar" id="notify">
				
			</div>
	</div>	
</div>	


</body>
</html>