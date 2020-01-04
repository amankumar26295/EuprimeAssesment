<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<c:if test="${not empty error_msg}">
		<div style="width:50%;float:left;margin-left:25%;margin-top:2%;padding:2%;border:2px solid gray;">
			<p style="font-size:30px;text-align:center;">${fn:toUpperCase(error_msg)}</p>
			<br><br>
			<p style="font-size:20px;text-align:center;">You will be redirected to Home page in 5 seconds.</p>
			<p style="font-size:20px;text-align:center;">If not ? <a style="text-decoration:underline;color:black;" href="home.jsp">click here</a></p>
			<%response.setHeader("refresh","5;url=home.jsp");%>
		</div>
	</c:if>
	
	<c:if test="${not empty user_added}">
		<div style="width:50%;float:left;margin-left:25%;margin-top:2%;padding:2%;border:2px solid gray;">
			<p style="font-size:30px;text-align:center;">${fn:toUpperCase(user_added)}</p>
			<br><br>
			<p style="font-size:20px;text-align:center;">You will be redirected to Home page in 5 seconds.</p>
			<p style="font-size:20px;text-align:center;">If not ? <a style="text-decoration:underline;color:black;" href="home.jsp">click here</a></p>
			<%response.setHeader("refresh","5;url=home.jsp");%>
		</div>
	</c:if>
	<c:if test="${not empty menu_updated}">
		<div style="width:50%;float:left;margin-left:25%;margin-top:2%;padding:2%;border:2px solid gray;">
			<p style="font-size:30px;text-align:center;">${fn:toUpperCase(user_added)}</p>
			<br><br>
			<p style="font-size:20px;text-align:center;">You will be redirected to Home page in 5 seconds.</p>
			<p style="font-size:20px;text-align:center;">If not ? <a style="text-decoration:underline;color:black;" href="ShopkeeperHome.jsp">click here</a></p>
			<%response.setHeader("refresh","5;url=ShopkeeperHome.jsp");%>
		</div>
	</c:if>
	<c:if test="${not empty order_placed}">
		<div style="width:50%;float:left;margin-left:25%;margin-top:2%;padding:2%;border:2px solid gray;">
			<p style="font-size:30px;text-align:center;">${fn:toUpperCase(order_placed)}</p>
			<br><br>
			<p style="font-size:20px;text-align:center;">You will be redirected to Home page in 5 seconds.</p>
			<p style="font-size:20px;text-align:center;">If not ? <a style="text-decoration:underline;color:black;" href="CustomerHome.jsp">click here</a></p>
			<%response.setHeader("refresh","5;url=CustomerHome.jsp");%>
		</div>
	</c:if>
	<c:if test="${not empty user_already_exist}">
		<div style="width:50%;float:left;margin-left:25%;margin-top:2%;padding:2%;border:2px solid gray;">
			<p style="font-size:30px;text-align:center;">${fn:toUpperCase(user_already_exist)}</p>
			<br><br>
			<p style="font-size:20px;text-align:center;">You will be redirected to Home page in 5 seconds.</p>
			<p style="font-size:20px;text-align:center;">If not ? <a style="text-decoration:underline;color:black;" href="home.jsp">click here</a></p>
			<%response.setHeader("refresh","5;url=home.jsp");%>
		</div>
	</c:if>
	<c:if test="${not empty not_exists}">
		<div style="width:50%;float:left;margin-left:25%;margin-top:2%;padding:2%;border:2px solid gray;">
			<p style="font-size:30px;text-align:center;">${fn:toUpperCase(not_exists)}</p>
			<br><br>
			<p style="font-size:20px;text-align:center;">You will be redirected to Home page in 5 seconds.</p>
			<p style="font-size:20px;text-align:center;">If not ? <a style="text-decoration:underline;color:black;" href="home.jsp">click here</a></p>
			<%response.setHeader("refresh","5;url=home.jsp");%>
		</div>
	</c:if>
	<c:if test="${not empty pwd_rst}">
		<div style="width:50%;float:left;margin-left:25%;margin-top:2%;padding:2%;border:2px solid gray;">
			<p style="font-size:30px;text-align:center;">${fn:toUpperCase(pwd_rst)}</p>
			<br><br>
			<p style="font-size:20px;text-align:center;">You will be redirected to Home page in 5 seconds.</p>
			<p style="font-size:20px;text-align:center;">If not ? <a style="text-decoration:underline;color:black;" href="home.jsp">click here</a></p>
			<%response.setHeader("refresh","5;url=home.jsp");%>
		</div>
	</c:if>
	
</body>
</html>