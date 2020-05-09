<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
function onDeleteClick(event){

	var doDelete = confirm("Do you want to delete the offer?");
	if(doDelete == false){
		event.preventDefault();
	}
}

function onReady(){
	$("#delete").click(onDeleteClick)
}
$(document).ready(onReady);
</script>
<sf:form class="formtable" method="post"
	action="${pageContext.request.contextPath}/docreate"
	modelAttribute="offers">
	<sf:input type="hidden" name="id" path="id" />
	<table>
		<tr>
			<td class="label">Your Offer:</td>
			<td><sf:textarea class="control" path="text" name="text"
					rows="10" cols="10"></sf:textarea><br /> <sf:errors path="text"
					cssClass="error">
				</sf:errors></td>
		</tr>
		<tr>
			<td class="label"></td>
			<td><input class="control" value="Submit Offer" type="submit" /></td>
		</tr>
		<c:if test="${offers.id != 0}">
			<tr>
				<td class="label"></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
			<td class="label"></td>
				<td><input id="delete" class="delete control" name="delete" value="Delete Offer"
					type="submit" /></td>
			</tr>
		</c:if>
	</table>
</sf:form>
