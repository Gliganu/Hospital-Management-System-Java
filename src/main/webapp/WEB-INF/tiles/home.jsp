<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<h2>This is the home page for the Hospital Management Database</h2>

<sec:authorize access="hasRole('ROLE_ADMIN')">

	<a href=<c:url value="/admin"/>>Admin page</a>

</sec:authorize>








