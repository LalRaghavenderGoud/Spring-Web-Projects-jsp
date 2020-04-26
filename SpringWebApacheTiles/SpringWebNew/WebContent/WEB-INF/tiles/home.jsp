<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page isELIgnored="false"%>




<p>
	<a href="${pageContext.request.contextPath}/offers">Show Current Offers</a>
</p>
<p>
	<a href="${pageContext.request.contextPath}/createoffer">Add New Offers</a>
</p>
<p>
	<a href="${pageContext.request.contextPath}/newaccount">Create New Account</a>
</p>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<p>
		<a href="<c:url  value="/admin" />">Admin</a>
	</p>
</sec:authorize>

