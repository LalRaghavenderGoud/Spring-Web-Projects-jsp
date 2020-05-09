<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page isELIgnored="false"%>


<table class="offers">
	<tr>
		<td>Name</td>
		<td>Email</td>
		<td>Offers</td>
	</tr>

	<c:forEach var="offer" items="${offers}">
		<tr>
			<td><c:out value="${offer.user.name}"></c:out></td>
			<td><c:out value="${offer.user.email}"></c:out></td>
			<td><c:out value="${offer.text}"></c:out></td>
		</tr>
	</c:forEach>
</table>




<script type="text/javascript">
	function updatePage() {

		$.getJSON("<c:url  value="/getoffers" />", updateMessageLink);

	}
	function updateMessageLink(data) {
		$("#noofOffers").text(data.number);
	}
	function onLoad() {
		updatePage();
		window.setInterval(updatePage, 5000);
	}

	$(document).ready(onLoad);
</script>
