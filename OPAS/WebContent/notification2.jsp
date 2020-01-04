<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date" %>
<%@page contentType="text/html" import="java.math.BigDecimal" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<head>
<link rel="stylesheet"  type="text/css" href="css/form2.css">
<link rel="stylesheet"  type="text/css" href="https://fonts.googleapis.com/css?family=Raleway:100">
<link rel="stylesheet"  type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
<style type="text/css">
*{
	margin:0px;
	padding:0px;
}
</style>
</head>

<c:if test="${not empty sessionScope.customer.id}">

	<sql:setDataSource var="db" driver="oracle.jdbc.driver.OracleDriver" 
 	url="jdbc:oracle:thin:@localhost:1521:XE" 
 	user="system"  
 	password="root"/>
 
	<sql:query dataSource="${db}" var="rs1">  
		select a.service_name,a.request_id,a.time_int,a.order_time,b.shop_name from ordertable a left join opas_shop b
		on a.shop_id=b.id where status='waiting' and  user_id=${sessionScope.customer.id}         
	</sql:query>
	
	
	<c:forEach var="i" items="${rs1.rows}">  
		<table class="notificationTable" style="width:90%;margin-left:5%;margin-top:2%;float:left;">
				
				<tr>
					<td>
						<p></p>
						<p style="text-align:center;font-family:Raleway;font-weight:900;font-size:25px;"> Your order has been <span style="color:green">Accepted</span> from <span style="color:#b04242">${i.shop_name}</span></p><br>
					</td>
				</tr>
				<tr style="background-color: #dddddd">
					<td >Request Id : ${i.request_id}</td>
					
				</tr>
				<tr style="background-color: #dddddd">
					<td >Service Opted : ${i.service_name}</td>
				</tr >
				<tr style="background-color:#8abd8a">
					<td>Expected Time : <fmt:formatDate type="time" value="${i.order_time}" pattern="hh:mm a"/><br></td>
				</tr>
				<tr>
					
				</tr>
		</table>
	</c:forEach> 
	
	 <sql:query dataSource="${db}" var="rs2">  
		select a.request_id,a.service_name,a.shop_id,b.shop_name from ordertable a left join opas_shop b 
		on a.shop_id=b.id where a.status='served' and a.user_id=${sessionScope.customer.id} and a.rating is null           
	</sql:query>
	
	<c:forEach var="i" items="${rs2.rows}"> 
		<form action="rateController" method="post"> 
		<table class="notificationTable" style="width:90%;margin-left:5%;margin-top:2%;float:left;">
				
				<tr >
					<td colspan="2"><p style="text-align:center;font-family:Raleway;font-weight:900;font-size:25px;">Rate <span style="color:#b04242">${i.shop_name}</span> for the service</p><br></td>
				</tr>
				<tr style="background-color: #dddddd">
					<td colspan="2">Service Opted : ${i.service_name}</td>
				</tr>
				<tr style="background-color: #dddddd">
					<td colspan="2">
					<div class="star-rating">
					  <fieldset>
					  	<input type="hidden" value="${i.request_id}" name="request_id">
						<input type="hidden" value="${i.shop_id}" name="shop_id">
					    <input onclick="myStopFunction()" type="radio" id="star5" name="rate" value="5" /><label for="star5" title="Outstanding">5 stars</label>
					    <input onclick="myStopFunction()" type="radio" id="star4" name="rate" value="4" /><label for="star4" title="Very Good">4 stars</label>
					    <input onclick="myStopFunction()" type="radio" id="star3" name="rate" value="3" /><label for="star3" title="Good">3 stars</label>
					    <input onclick="myStopFunction()" type="radio" id="star2" name="rate" value="2" /><label for="star2" title="Poor">2 stars</label>
					    <input onclick="myStopFunction()" type="radio" id="star1" name="rate" value="1" /><label for="star1" title="Very Poor">1 star</label>
					  </fieldset>
					</div>
					</td>
				</tr>
				<!-- <tr style="background-color:gray">
					<td ><input onclick="myStopFunction()" type="radio" name="rate" value="1"> 1</td>
					<td ><input onclick="myStopFunction()" type="radio" name="rate" value="2"> 2</td>
				</tr>
				<tr style="background-color:gray">
					<td><input onclick="myStopFunction()" type="radio" name="rate" value="3"> 3</td>
					<td><input onclick="myStopFunction()" type="radio" name="rate" value="4"> 4</td>
				</tr>
				<tr style="background-color:gray">
					<td colspan="2"><input onclick="myStopFunction()" type="radio" name="rate" value="5">5</td>
				</tr> -->
				<tr>
					<td><input type="submit" value="Rate  " style="width:100%;"></td>
					<td><input type="submit" value="cancel" style="width:100%;background-color:#d56c6c;"></td>
				</tr>
		</table>
		</form>
	</c:forEach>
	
</c:if>