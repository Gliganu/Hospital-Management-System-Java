<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
	
<table class="normalTable" border=1>
	<tr>
		<th>Room Number</th>
		<th>Floor</th>
		<th>Janitor On Duty</th>
	</tr>

	<c:forEach var="room" items="${roomList}">
		<tr>
			<td>${room.number}</td>
			<td>${room.floor}</td>
			<td>${room.janitor.name}</td>
		</tr>
	</c:forEach>

</table>
