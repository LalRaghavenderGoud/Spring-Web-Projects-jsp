<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery.js"></script>
<script type="text/javascript">
	function onLoad() {
		
		$("#password").keyup(checkPasswordMatch);
		$("#confirmpass").keyup(checkPasswordMatch);
		$("#details").submit(confirmSubmit)
	}

	function confirmSubmit() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();

		if (password == confirmpass) {
			return true;
		} else {
			alert("<fmt:message key='UnmatchedPassowrds.user.password'/>");
			return false;
		}
	}
	function checkPasswordMatch() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();
		if (password.length > 3 && confirmpass.length > 3) {

			if (password == confirmpass) {
				$("#matchpass").text("<fmt:message key='MathedPasswords.user.password'/>");
				$("#matchpass").addClass("valid");
				$("#matchpass").removeClass("error");
			} else {
				$("#matchpass").text("<fmt:message key='UnmatchedPassowrds.user.password'/>");
				$("#matchpass").addClass("error");
				$("#matchpass").removeClass("valid");
			}
		}
	}

	$(document).ready(onLoad);
</script>
<meta charset="ISO-8859-1">
<title>Create Offer</title>

</head>
<body>
	<h2>Create New Account</h2>
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
</body>
</html>