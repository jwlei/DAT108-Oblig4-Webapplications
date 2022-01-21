<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
	
		<tr bgcolor="#cccccc">
			<th>Kjønn:</th>
			<th align="left">Navn:</th>
			<th align="left">Mobil:</th>
		</tr>
		<c:forEach items="${liste}" var="person">
			<c:choose>
				<c:when test="${fn:replace(person.mobil,' ', '')==mobil}">
					<tr bgcolor="#aaffaa">
				</c:when>
				<c:otherwise>
					<tr bgcolor="#ffffff">
				</c:otherwise>
			</c:choose>
			<td align="center"><c:choose>
					<c:when test="${person.kjonn=='Mann'}">${person.kjonn}</c:when>
					<c:otherwise>${person.kjonn}</c:otherwise>
				</c:choose></td>
			<td>${person.fornavn} ${person.etternavn}</td>
			<td>${person.mobil}</td>
			</tr>
			
		</c:forEach>
	</table>
	<form action="FerdigServlet" method="post">
		<p><input type="submit" value="Logg ut" /></p>
	</form>
</body>
</html>
