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

	<c:set var="shop_id" scope="session" value="${shop_id}"/>
	
	<form action="addmenu2" method="post">
		
		<div style="width:100%;float:left;">
		
			<c:forEach var="i" items="${menu_list}" varStatus="stat">
				<div style="width:28%;float:left;margin-left:10px;">
					<div style="float:left;">
						<p style="line-height:50px;font-size:20px;">${i.menu_name} : </p>
					</div>
					<div style="float:right;">
						<input type="hidden" name="menu${stat.count}" value="${i.menu_id}">
						<td><input type="number" value="${i.price}" name="price${stat.count}"></td>
					</div>
				</div>
				<c:if test="${stat.last}">
					<c:set var="totalCount" value="${stat.count}"></c:set>
				</c:if>
			</c:forEach>
			
		</div>
		<input type="hidden" name="totalCount" value="${totalCount}">
		<input type="submit" value="submit" style="float:right;width:10%;margin-right:23%;">
	</form>
	
</div>

</body>
</html>