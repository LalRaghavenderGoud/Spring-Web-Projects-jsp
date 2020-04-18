<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Offer</title>
<link href="${pageContext.request.contextPath}/static/resources/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<sf:form class="formtable" method="post"
		action="${pageContext.request.contextPath}/docreate" modelAttribute="offers">
		<table>
			<tr>
				<td class="label">Name:</td>
				<td><sf:input class="control" path="name" name="name" type="text" /><br/><sf:errors path="name" type="text"  cssClass="error"> </sf:errors></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input class="control" path="email" name="email" type="text"/><br/><sf:errors path="email" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Your Offer:</td>
				<td><sf:textarea class="control" path="text" name="text" rows="10" cols="10"></sf:textarea><br/> <sf:errors path="text" cssClass="error"> </sf:errors></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Submit Offer" type="submit" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>