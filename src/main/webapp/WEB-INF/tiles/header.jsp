
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<p>

<div id="topMenuDiv">
			<ul>
				<li><a class="linkList" href= <c:url value="/"/> >Home</a></li>
				<li><a class="linkList" href= <c:url value="/showAllPatients"/> >Patients</a></li>
				<li><a class="linkList" href= <c:url value="/showAllDoctors"/> >Doctors </a></li>
				<li><a class="linkList" href= <c:url value="/showAllDrugs"/> >Drugs</a></li>
				<li><a class="linkList" href= <c:url value="/showAllInterns"/> >Interns </a></li>
				<li><a class="linkList" href= <c:url value="/showAllJanitors"/> >Janitors</a></li>
				<li><a class="linkList" href= <c:url value="/showAllSections"/> >Sections</a></li>
				<li><a class="linkList" href= <c:url value="/showAllRooms"/> >Rooms</a></li>
				<li><a class="linkList" href= <c:url value="/showAllDiseases"/> >Diseases</a></li>
			</ul>
</div>
	

 
 <sec:authorize access="!isAuthenticated()"> 
	<a class="login" href=<c:url value="/login"/>>Log in</a>
	<br />
	<br />
</sec:authorize>


<sec:authorize access="isAuthenticated()">
	<a class="login" href=<c:url value="/editProfile"/>>Edit profile</a>
	<br />
	<br />
</sec:authorize>

