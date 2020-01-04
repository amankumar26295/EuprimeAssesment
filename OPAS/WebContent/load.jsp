<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<head>
<link rel="stylesheet"  type="text/css" href="css/style.css"> 
</head>

	<sql:setDataSource var="db" driver="oracle.jdbc.driver.OracleDriver" 
	 url="jdbc:oracle:thin:@localhost:1521:XE" 
	 user="system"  
	 password="root"/>
	 
	 <sql:query dataSource="${db}" var="rs">  
		select * from opas_shop    
	</sql:query>
	
	<c:forEach var="i" items="${rs.rows}">
		<table class="shopListTable2">
						
			<tr style="background-color: #dddddd">
				<c:set var="name" scope="page" value="${i.shop_name}"/>
				<td colspan="2">
					<div style="float:left;width:80%;">
						<div style="float:left;width:100%;">
							<h4 style="text-align:left;margin-left:10px;">${fn:toUpperCase(name)}</h4>
						</div>
						<div style="float:left;width:100%;">
							<div style="float:left;width:10%;">
								<img src="images/location" style="width:40%;margin-left:2%;">
							</div>
							<div style="float:left;width:80%;margin-top:2px;">
								<p style="text-align:left">${i.city} , ${i.locality}</p>
							</div>
							
						</div>
					</div >
					<div style="float:left;width:10%;">
						<img src="images/star2" style="width:50%;margin-left:2%;">
					</div>
					<div style="float:left;width:5%;margin-top:5px;">
						<p>${i.rating}<c:if test="${empty i.rating}">0</c:if></p>
					</div>
				</td>
			
			</tr>
			<tr>
				<td style="text-align:left;">
					<c:if test="${i.shop_type eq 'men'}">
						<img src="images/male" style="width:15%;margin-left:2%;">
					</c:if>
					<c:if test="${i.shop_type eq 'women'}">
						<img src="images/female" style="width:15%;margin-left:2%;margin-bottom:5px;">
					</c:if>
					<c:if test="${i.shop_type eq 'both'}">
						<img src="images/male" style="width:15%;margin-left:2%;margin-top:4%;"><img src="images/plus" style="width:10%;margin-left:2%;"> <img src="images/female" style="width:15%;margin-left:2%;">
					</c:if>
				</td>
				<td >
					<div style="float:right">
						<c:if test="${i.open eq 'n'}">
							<span style="color:red"> Currently Closed</span>
						</c:if>
						<c:if test="${i.open eq 'y'}">
							<form action="appoint" method="post">
								<input type="hidden" name="shop_id" value="${i.id}">
								<input type="submit" value="Take Appointment" id="openButton" style="width:100%;">
							</form>
						</c:if>
						
					</div>
				</td>
			</tr>
		</table>
		<br>
	</c:forEach>
	