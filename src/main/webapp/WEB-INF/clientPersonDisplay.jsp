<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>${client.getId()}</td>
			<td>${client.getFirstname()}</td>
			<td>${client.getLastname()}</td>
			<td>${client.address}</td>
			<c:forEach items="${client.orders}" var="order">
				<td>${order.getId()}</td>
				<td>${order.getOrderDate()}</td>
				<td>${order.getOrderCloseDate()}</td>
				<td>${order.getOrderState()}</td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>