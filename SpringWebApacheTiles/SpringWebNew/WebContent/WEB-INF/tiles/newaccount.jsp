<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ page isELIgnored="false"%>

	<sf:form id="details" class="formtable" method="post"
		action="${pageContext.request.contextPath}/createaccount"
		modelAttribute="user">
		<table>
			<tr>
				<td class="label">User Name:</td>
				<td><sf:input class="control" path="username" name="username"
						type="text" /><br />
				<div Class="error">
						<sf:errors path="username" type="text">
						</sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td><sf:input id="password" class="control" path="password"
						name="password" type="password" /><br />
				<div Class="error">
						<sf:errors path="password" type="text">
						</sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Confirm Password:</td>
				<td><input id="confirmpass" class="control"
					path="confirmpassword" name="confirmpassword" type="password" />
				<div id="matchpass"></div></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input class="control" path="email" name="email"
						type="text" /><br />
				<div Class="error">
						<sf:errors path="email"></sf:errors>
					</div></td>
			</tr>

			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create Account" type="submit" /></td>
			</tr>
		</table>
	</sf:form>
