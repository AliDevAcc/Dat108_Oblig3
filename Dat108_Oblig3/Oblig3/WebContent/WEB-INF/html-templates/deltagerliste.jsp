<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		
<select>
    <c:forEach items="${deltager}" var="d">
        <c:choose>
            <c:when test="${d.nr == nr}">
            <tr bgcolor="#aaffaa">
			<td>${d.kjonn}</td>
			<td>${d.fornavn} ${d.etternavn}</td>
			<td>${d.nr}</td>
		</tr> 
            </c:when>
            <c:otherwise>
           		<tr bgcolor="#ffffff">
			<td align="center">&#9792;</td>
			<td>${deltager.fornavn} ${deltager.etternavn}</td>
			<td>${deltager.nr}</td>
		</tr> 
            </c:otherwise>
        </c:choose>
    </c:forEach>
</select>
		<c:forEach var="deltager" items="${Deltagerliste}"> 
		<tr bgcolor="#aaffaa">
			<td align="center">&#9792;</td>
			<td>${deltager.fornavn} ${deltager.etternavn}</td>
			<td>${deltager.nr}</td>
		</tr>
		</c:forEach>
		<tr bgcolor="#ffffff">
			<td align="center">&#9794;</td>
			<td>Arne Arnesen</td>
			<td>901 23 456</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td align="center">&#9794;</td>
			<td>Per Viskeler</td>
			<td>112 23 344</td>
		</tr>
	</table>
	<p>
		<a href="loggut">Ferdig</a>
	</p>
</body>
</html>