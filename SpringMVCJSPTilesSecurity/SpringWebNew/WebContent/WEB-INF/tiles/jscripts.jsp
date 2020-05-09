<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ page isELIgnored="false"%>
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