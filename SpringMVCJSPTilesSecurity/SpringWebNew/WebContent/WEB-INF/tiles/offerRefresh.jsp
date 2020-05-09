<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page isELIgnored="false"%>


<div id="offerRefresh"></div>

<script type="text/javascript">
	function showOfferRefresh() {
		$("divofferRefresh").html("");
		for (var i = 0; i <= data.offers.length; i++) {
			var offer = data.offers[i];

			var offerDiv = document.createElement("div");
			offerDiv.setAttribute("class", "offer");

			var nameSpan = document.createElement("span");
			offerDiv.setAttribute("class", "username");
			offerDiv.appendChild(document.createTextNode(offers.username));

			var emailSpan = document.createElement("span");
			offerDiv.setAttribute("class", "email");
			offerDiv.appendChild(document.createTextNode(offers.email));

			offerDiv.appendChild(nameSpan);
			offerDiv.appendChild(emailSpan);
			$("divofferRefresh").append(offerDiv);

		}
	}

	function updatePage() {

		$.getJSON("<c:url  value="/getoffers" />", showOfferRefresh);

	}

	function onLoad() {
		updatePage();
		window.setInterval(updatePage, 5000);
	}

	$(document).ready(onLoad);
</script>
