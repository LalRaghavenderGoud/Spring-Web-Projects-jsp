<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
	<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery.js"></script>

<tiles:insertAttribute name="includes"></tiles:insertAttribute>

</head>
<body>
	<div class="header">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<div class="toolbar">
		<tiles:insertAttribute name="toolbar"></tiles:insertAttribute>
	</div>
	<div class="content">
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
	</div>
	<div class="footer">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>

</body>
</html>