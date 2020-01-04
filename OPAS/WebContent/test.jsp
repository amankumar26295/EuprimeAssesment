<%@page contentType="text/html" import="java.util.Date" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<body>
	<%
		System.getProperties().setProperty("oracle.jdbc.J2EE13Compliant", "true");
	%>

	<sql:setDataSource var="db" driver="oracle.jdbc.driver.OracleDriver" 
	 url="jdbc:oracle:thin:@localhost:1521:XE" 
	 user="system"  
	 password="root"/>
	 
	 <sql:query dataSource="${db}" var="rs1">  
		select * from ordertable      
	</sql:query>
	
	<c:forEach var="i" items="${rs1.rows}">
			
			<c:set var="now" value="${i.order_time}"/>
			<fmt:formatDate type="date" value="${i.order_time}" pattern="hh:MM a"/><br>
			<%-- <c:out value="${now}"/><br> --%>
			
	</c:forEach>
</body>
</html>