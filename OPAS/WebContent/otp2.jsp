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
	
	<%	
	 	String msg=(String)request.getAttribute("otp_error_msg");
	 	if(msg!=null){
	 %>
	 <p><%= msg.toUpperCase() %></p>
	 <%} %>
	 
	 <div class="form">
			
		<form action="reset2" method="post" >
			
			<legend style="color:yellow; margin-left:10%; font-weight:bold;">Enter OTP sent to your Email id</legend>
			<br>
			
			<input type="text" name="user_otp" autofocus required><br> 
			<input type="submit" value="submit" style="float: right;">
			</form> 
	</div>
</body>
</html>