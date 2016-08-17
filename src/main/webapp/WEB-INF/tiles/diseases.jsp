<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
	
<table class="normalTable" border=1>
	<tr>
		<th>Name</th>
		<th>Severity</th>
	</tr>

	<c:forEach var="disease" items="${diseaseList}">
		<tr>
			<td>${disease.name}</td>
			<td>${disease.severity}</td>
		</tr>
	</c:forEach>

</table>
