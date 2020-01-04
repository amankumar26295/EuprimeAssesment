<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search result 2</title>
</head>
<body>

	<div class="maincontainer" style="height:1500px;">
		<div class="orderlist" style="width:50%;margin-left:25%;">
			<form action="orderRequest" method="post">
				<table class="table1" style="width:100%;">
						<tr>
							<th style="font-size:25px;">Menu Name</th>
							<th style="font-size:25px;">Price</th>
							<th style="font-size:25px;">Choose</th>
						</tr>
					<c:forEach var="i" items="${search_menu_list}" varStatus="stat">
						<tr >
							<td style="padding:10px;font-size:25px;">${i.menu_name}</td>
							<td style="padding:10px;">Rs ${i.price}</td>
							<td style="padding:10px;">
								<input type="hidden" name="menu${stat.count}" value="${i.menu_name}">
 								<input type="checkbox" name="price${stat.count}" value="${i.price}" style="width:20px;height:20px;">
							</td>
						</tr>
						<c:if test="${stat.last}">
							<c:set var="totalCount" value="${stat.count}"></c:set>
						</c:if>
					</c:forEach>
				</table>
				<input type="hidden" name="shop_id" value="${shop_id}">
				<input type="hidden" name="totalCount" value="${totalCount}">
				<input type="submit" value="submit" style="float:right;width:30%;padding:2%;margin-right:33%;">
			</form>
		</div>
	</div>
	
	
</body>
</html>