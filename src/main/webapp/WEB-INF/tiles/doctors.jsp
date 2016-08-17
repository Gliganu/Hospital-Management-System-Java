<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
	
<table class="normalTable" border=1>
	<tr>
		<th>Name</th>
		<th>Age</th>
		<th>Years In Practice</th>
		<th>Section Assigned</th>
	</tr>

	<c:forEach var="doctor" items="${doctorList}">
		<tr>
			<td>${doctor.name}</td>
			<td>${doctor.age}</td>
			<td>${doctor.yearsInPractice}</td>
			<td>${doctor.section.name}</td>
		</tr>
	</c:forEach>

</table>
