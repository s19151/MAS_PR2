<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MAS_PR2 - List all clients</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>client</th>
		</tr>
		<c:forEach items="${clientsList}" var="client">
		<tr>
			<td>${client.id}</td>
			<td>${client}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>