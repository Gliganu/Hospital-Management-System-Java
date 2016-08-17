<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
	
<table class="normalTable" border=1>
	<tr>
		<th>Name</th>
		<th>Rooms assigned</th>
	</tr>

	<c:forEach var="janitor" items="${janitorList}">
		<tr>
			<td>${janitor.name}</td>
			<td><a  href="<c:url value='/getRoomsDetails?jid=${janitor.id}'/>">See ${janitor.name}'s rooms</a></td>
		</tr>
	</c:forEach>

</table>
