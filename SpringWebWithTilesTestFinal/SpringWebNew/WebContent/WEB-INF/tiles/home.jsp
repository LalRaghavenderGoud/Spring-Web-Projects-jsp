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

<p />

<c:choose>
	<c:when test="${hasOffers}">
		<p>
			<a href="${pageContext.request.contextPath}/createoffer">Edit/Delete Your Current Offer</a>
		</p>
	</c:when>
	<c:otherwise>
		<p>
			<a href="${pageContext.request.contextPath}/createoffer">Add New
				Offers</a>
		</p>
	</c:otherwise>
</c:choose>



<p>
	<a href="${pageContext.request.contextPath}/newaccount">Create New
		Account</a>
</p>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<p>
		<a href="<c:url  value="/admin" />">Admin</a>
	</p>
</sec:authorize>

