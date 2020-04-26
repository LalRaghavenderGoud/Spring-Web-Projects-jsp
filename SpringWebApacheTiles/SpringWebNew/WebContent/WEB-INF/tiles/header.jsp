<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<%@ page isELIgnored="false" %>

<a class="title"  href="<c:url value="/"/>">Offers</a>

<sec:authorize access="!isAuthenticated()">
<a class="login" href = "<c:url  value="/login" />">Login</a>
</sec:authorize>
 <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>

<sec:authorize access="isAuthenticated()">
<c:url var="logoutUrl" value="/logout" />        
  <a class="login" href="javascript:formSubmit()"> Logout</a>

<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}"     value="${_csrf.token}" />
</form>
</sec:authorize>