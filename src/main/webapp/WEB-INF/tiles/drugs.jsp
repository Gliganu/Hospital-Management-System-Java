<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	

<table class="normalTable" border=1>
	<tr>
		<th>Name</th>
		<th>Substances Contained</th>
	</tr>

	<c:forEach var="drug" items="${drugList}">
		<tr>
			<td>${drug.name}</td>
			<td>${drug.substances}</td>
		</tr>
	</c:forEach>

</table>
