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
		<h1 align="center">Clients List</h1>
		<div class="clientsList" align="center">
			<table>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Type</th>
				</tr>
				<c:forEach items="${clientsList}" var="client">
				<tr>
					<td>${client.getId()}</td>
					<td>
						<c:choose>
							<c:when test="${client.getClientType().getVal()==0}">
								${client.getFirstname()} ${client.getLastname()}
							</c:when>
							<c:when test="${client.getClientType().getVal()==1}">
								${client.getCompanyName()}
							</c:when>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${client.getClientType().getVal()==0}">
								Person
							</c:when>
							<c:when test="${client.getClientType().getVal()==1}">
								Company
							</c:when>
						</c:choose>
					</td>
					<td><a href="/MAS_PR2/clients/${client.getId()}">View</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>