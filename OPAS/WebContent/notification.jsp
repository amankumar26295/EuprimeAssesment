<%@page contentType="text/html" import="java.util.Date" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<head>
<link rel="stylesheet"  type="text/css" href="css/form2.css">
<link rel="stylesheet"  type="text/css" href="https://fonts.googleapis.com/css?family=Raleway:100">
<!-- <link rel="stylesheet"  type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"> -->
</head>
	
<c:if test="${not empty sessionScope.shop_id}">	

	<sql:setDataSource var="db" driver="oracle.jdbc.driver.OracleDriver" 
	 url="jdbc:oracle:thin:@localhost:1521:XE" 
	 user="system"  
	 password="root"/>
	 
	 
	<sql:query dataSource="${db}" var="rs">  
		select service_name,request_id from ordertable where status='requested' and  shop_id=${sessionScope.shop_id}              
	</sql:query>
	
	
	<c:forEach var="i" items="${rs.rows}"> 
		<br> 
		<table class="notificationTable" style="width:90%;margin-left:5%;margin-top:2%;float:left;">
				<tr>
					<td style="padding:5px;">
						<p></p>
						<p style="text-align:center;font-family:Raleway;font-weight:900;font-size:25px;"><span style="color:green"">Appointment Request !</span></span></p><br>
					</td>
				</tr>
				<tr style="background-color: #dddddd">
					<td><span>For : </span>${i.service_name}</td>
				</tr>
				<tr style="background-color: #dddddd">
					<td >Request Id : ${i.request_id}</td>
				</tr>
				<tr>
					<td>
						<div style="float:left;">
							<form action="order11" method="post">
							<input type="hidden" name="request_id" value="${i.request_id}">
							<input type="hidden" name="s" value="reject">
							<input type="submit" value="Reject Request" style="float:right;width:110%;margin-top:41%;">
				 			</form>
						</div>
						<div style="float:right;width:58%;">
							<form action="order11" method="post">
							<input type="hidden" name="request_id" value="${i.request_id}">
							<input type="hidden" name="s" value="accept">
							<select name="time"  onclick="myStopFunction()" required style="width:70%;float:right;padding:5px;">
								<option value="15">15 minutes</option>
								<option value="30">30 minutes</option>
								<option value="45">45 minutes</option>
								<option value="60">60 minutes</option>	
							</select>
							<input type="submit" value="Accept Request" style="width:70%;float:right;">
				 			</form>
						</div>
					</td>
				</tr>
		</table>
	</c:forEach>
	
</c:if>