<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<ul>
	<li><a href=<c:url value="/addPatient"/>>Add Patient</a></li>
	<li><a href=<c:url value="/addDoctor"/>>Add Doctor</a></li>
	<li><a href=<c:url value="/addDrug"/>>Add Drug</a></li>
	<li><a href=<c:url value="/addIntern"/>>Add Intern</a></li>
	<li><a href=<c:url value="/addJanitor"/>>Add Janitor</a></li>
	<li><a href=<c:url value="/addSection"/>>Add Section</a></li>
	<li><a href=<c:url value="/addRoom"/>>Add Room</a></li>
	<li><a href=<c:url value="/addDisease"/>>Add Disease</a></li>
</ul>

