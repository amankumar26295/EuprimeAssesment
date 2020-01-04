<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Update Menu</title>
</head>
<body>
<div class="mainContainer">
	
	<form action="addmenu2" method="post">
		<table>
		<tr>
			<th>Menu Name</th>
			<th>Price</th>
			<th>Menu Name</th>
			<th>Price</th>
		</tr>
		<c:set var="shop_id" scope="session" value="${param.id}"/>
		<tr>
			<c:forEach var="i" items="${menu_list}" varStatus="stat">
				<td>${i.menu_name}</td>
				<input type="hidden" name="menu${stat.count}" value="${i.menu_id}">
				<td><input type="number" name="price${stat.count}"></td>
			</c:forEach>
		</tr>
		</table>
		<input type="hidden" name="totalCount" value="${totalCount}">
		<input type="submit" value="submit">
	</form>

	
		
</div>

</body>
</html>