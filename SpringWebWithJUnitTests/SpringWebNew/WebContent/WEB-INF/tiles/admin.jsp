<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h3>Authorized persons only!!</h3>
	
	<p><b>List Of Users</b></p>
	<table class="usertable">
		<tr>
			<td><b>User Name</b></td>
			<td><b>Email</b></td>
			<td><b>Role</b></td>
			<td><b>Enable</b></td>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.username}</td>
				<td>${user.email}</td>
				<td>${user.authority}</td>
				<td>${user.enabled}</td>
			</tr>
		</c:forEach>
	</table>
