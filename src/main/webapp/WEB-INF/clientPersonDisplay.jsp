<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>MAS_PR2 - Client's Details</title>
	</head>
	<body>
		<div class="container" align="center">
			<h1>Client's Details</h1>
			<div class="menu">
				<table>
					<tr>
						<td><a href="/MAS_PR2/">Home</a></td>
						<td><a href="/MAS_PR2/clients">Clients</a></td>
						<td><a href="/MAS_PR2/orders">Orders</a></td>
					</tr>
				</table>
			</div>
			<div class="dClient">
				<table>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Address</th>
						<th>Phone Numbers</th>
						<th>E-mails</th>
						<th>Orders</th>
					</tr>
					<tr>
						<td>${client.getId()}</td>
						<td>${client.getFirstname()}</td>
						<td>${client.getLastname()}</td>
						<td>${client.getAddress()}</td>
						
						<td>
							<table>
								<c:forEach items="${client.getPhoneNumbers()}" var="phoneNumber">
								<td>${phoneNumber}</td>
								</c:forEach>
							</table>
						</td>
						
						<td>
							<table>
								<c:forEach items="${client.getEmails()}" var="email">
								<td>${email}</td>
								</c:forEach>
							</table>
						</td>
						
						<td>
							<c:choose>
								<c:when test="${client.getOrders().size()!=0}">
									<table>
										<tr>
											<th>No.</th>
											<th>Placed On</th>
											<th>Closed On</th>
											<th>Current State</th>
											<th>Total price</th>
										</tr>
										
										<%int i=1;%>
										<c:forEach items="${client.getOrders()}" var="order">
										<tr>
											<td><%=i++%>
											<td>${order.getOrderDate()}</td>
											<td>${order.getOrderCloseDate()}</td>
											<td>${order.getOrderState()}</td>
											<td>${order.getPrice()}</td>
											<td><a href="/MAS_PR2/orders/${order.getId()}">View Details</a></td>
										</tr>
										</c:forEach>
									</table>
								</c:when>
								<c:when test="${client.getOrders().size()==0}">
									Client has no orders
								</c:when>
							</c:choose>
						</td>
					</tr>
			</table>
			</div>
		</div>
	</body>
</html>