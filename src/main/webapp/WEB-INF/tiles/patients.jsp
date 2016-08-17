<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<table class="normalTable" border=1>
	<tr>
		<th>Name</th>
		<th>Age</th>
		<th>Date of Admission</th>
		<th>Disease</th>
		<th>Section</th>
		<th>Room</th>
		<th>Doctor</th>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<th>Edit</th>
			<th>Delete</th>
		</sec:authorize>

	</tr>

	<c:forEach var="patient" items="${patientList}">
		<tr>
			<td>${patient.name}</td>
			<td>${patient.age}
			<td>${patient.dateOfAdmission}</td>
			<td>${patient.disease.name}</td>
			<td>${patient.section.name}</td>
			<td>${patient.room.number}</td>
			<td>${patient.doctor.name}</td>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<th><a  href= <c:url value="/editPatient?pid=${patient.id}"/> >Edit ${patient.name}</a></th>
				<th><a  href= <c:url value="/deletePatient?pid=${patient.id}"/> >Delete ${patient.name}</a></th>
			</sec:authorize>
		</tr>
	</c:forEach>

</table>
