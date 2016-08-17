<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<h3>Create New Drug</h3>

<c:url var="ADD_DRUG_URL" value="/doAddDrug"></c:url>


<form:form id="details" action="${ADD_DRUG_URL}" method="post"
	commandName="drug">
	<table>
		<tr>
			<td>Name:</td>
			<td><form:input name="name" path="name" type="text" /></td>
			<td><form:errors path="name" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Substances:</td>
			<td><form:input id="substances" name="substances" path="substances"
					type="text" /></td>
			<td><form:errors path="substances" cssClass="error" /></td>
		</tr>
		<tr>
			<td><input value="Create new drug" type="submit" /></td>
		</tr>
	</table>
</form:form>

