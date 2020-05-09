<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page isELIgnored="false"%>
<c:choose>
	<c:when test="${hasOffers}">

		<a href="${pageContext.request.contextPath}/createoffer">Edit/Delete
			Your Current Offer</a>

	</c:when>
	<c:otherwise>
		<a href="${pageContext.request.contextPath}/createoffer">Add New
			Offers </a>

	</c:otherwise>
</c:choose>

&nbsp;

<a href="${pageContext.request.contextPath}/newaccount">Create New
	Account</a>
&nbsp;

<sec:authorize access="hasRole('ROLE_ADMIN')">

	<a href="<c:url  value="/admin" />">Admin</a>

</sec:authorize>
&nbsp;
<sec:authorize access="isAuthenticated()">

	<a href="<c:url  value="/offers" />">Offers</a>(<span id="noofOffers">0</span>)

</sec:authorize>