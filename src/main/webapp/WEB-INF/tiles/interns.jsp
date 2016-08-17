<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
	
<table class="normalTable" border=1>
	<tr>
		<th>Name</th>
		<th>Age</th>
		<th>Section Assigned To</th>
	</tr>

	<c:forEach var="intern" items="${internList}">
		<tr>
			<td>${intern.name}</td>
			<td>${intern.age}</td>
			<td>${intern.section.name}</td>
		</tr>
	</c:forEach>

</table>
