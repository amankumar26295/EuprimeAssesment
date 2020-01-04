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
	 	String msg=(String)request.getAttribute("pwd_not_match");
	 	if(msg!=null){
	 %>
	 <p><%= msg.toUpperCase() %></p>
	 <%} %>
	
	 <div class="form">
			
		<form action="reset3" method="post" >
						<legend style="color:yellow; margin-left:40%; font-size:25px; font-weight:bold">Forgot Password</legend>	
						<br>
						<table  style="width:100%;">
							<tr>
								<th></th>
								<th style="width:65%;"></th>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">New Password :</p></td>
								<td>
									<input type="text" name="pass1" autofocus required>
				 				</td>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:left;">Confirm Password :</p></td>
								<td>
									<input type="password" name="pass2" autofocus required>
				 				</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<input type="submit" value="next" style="width:50%;">
				 				</td>
							</tr>
						</table>
					</form> 
	</div>
	
</body>
</html>