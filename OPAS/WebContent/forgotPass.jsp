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
	
	 <div class="form" style="margin-top:5%;">
		<form action="reset" method="post" >
						<legend style="color:yellow; margin-left:40%; font-size:25px; font-weight:bold">Forgot Password</legend>	
						<br>
						<table  style="width:100%;">
							<tr>
								<th></th>
								<th style="width:65%;"></th>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Role :</p></td>
								<td>
									
									<select name="role" required>
										<option value="user">customer</option>
										<option value="shopkeeper">shopkeeper</option>
										<!-- <option value="admin">admin</option> -->
									</select><br>
				 				</td>
							</tr>
							<tr>
								<td><p style="color:white; font-size:25px; text-align:right;">Email Id :</p></td>
								<td>
									<input type="text" name="email_id" autofocus required>
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