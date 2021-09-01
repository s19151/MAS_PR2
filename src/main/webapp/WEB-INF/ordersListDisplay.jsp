<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>MAS_PR2 - List all orders</title>
	</head>
	<body>
		<h1 align="center">Orders List</h1>
		<div class="ordersList" align="center">
			<table>
				<tr>
					<th>ID</th>
					<th>Placed On</th>
					<th>Closed On</th>
					<th>Current State</th>
					<th>Price</th>
				</tr>
				
				<c:forEach items="${ordersList}" var="order">
					<tr>
						<td>${order.getId()}</td>
						<td>${order.getOrderDate()}</td>
						<td>${order.getOrderCloseDate()}</td>
						<td>${order.getOrderState()}</td>
						<td>${order.getPrice()}</td>
						<td><a href="/MAS_PR2/orders/${order.getId()}">View Details</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>