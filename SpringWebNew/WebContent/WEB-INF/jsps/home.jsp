<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Raghav JSP Page</title>
</head>
<body>

<%-- <c:out value="$(name)"></c:out> <p/> --%>

<%-- <sql:query var="rs" dataSource="jdbc/TestDB">
select id, name, email, text from offers
</sql:query> --%>

<p><a href="${pageContext.request.contextPath}/offers">Show Current offers</a></p>
<p><a href="${pageContext.request.contextPath}/createoffer">Add New offers</a></p> 
</body>
</html>