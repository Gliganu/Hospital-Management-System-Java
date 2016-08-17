
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<h3>Edit Patient</h3>

<c:url var="ADD_PATIENT_URL" value="/doAddPatient"></c:url>

<form:form id="details" action="${ADD_PATIENT_URL}" method="post"
	commandName="patient">
	<table>
		<tr>
			<td><form:input id="dateOfAdmission" name="dateOfAdmission"
					path="dateOfAdmission" type="hidden" /></td>
		</tr>
		
		<tr>
			<td>Name:</td>
			<td><form:input name="name" path="name" type="text" /></td>
			<td><form:errors path="name" cssClass="error" /></td>
		</tr>
		
		<tr>
			<td>Age:</td>
			<td><form:input id="age" name="age" path="age" type="text" /></td>
			<td><form:errors path="age" cssClass="error" /></td>
		</tr>

		<tr>
			<td>Disease:</td>
			<td><form:select id="disease" path="disease"
					items="${diseaseList}" itemValue="name" itemLabel="name" /></td>
			<td><form:errors path="disease" cssClass="error" /></td>
		</tr>

		<tr>
			<td>Section:</td>
			<td><form:select id="section" path="section"
					items="${sectionList}" itemValue="name" itemLabel="name" /></td>
			<td><form:errors path="section" cssClass="error" /></td>
		</tr>

		<tr>
			<td>Room:</td>
			<td><form:select id="room" path="room" items="${roomList}"
					itemValue="number" itemLabel="number" /></td>
			<td><form:errors path="room" cssClass="error" /></td>
		</tr>

		<tr>
			<td>Doctor:</td>
			<td><form:select id="doctor" path="doctor" items="${doctorList}"
					itemValue="id" itemLabel="name" /></td>
			<td><form:errors path="doctor" cssClass="error" /></td>
		</tr>
		<tr>
			<td><input value="Create new patient" type="submit" /></td>
		</tr>

	</table>
</form:form>

