<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>MAS_PR2 - Client's orders</title>
	</head>
	<body>
		<div class="dClient" align="center">
			<table>
				<tr>
					<th>ID</th>
					<th>Company Name</th>
					<th>NIP</th>
					<th>REGON</th>
					<th>Address</th>
					<th>Phone Numbers</th>
					<th>E-mails</th>
					<th>Orders</th>
				</tr>
				<tr>
					<td>${client.getId()}</td>
					<td>${client.getCompanyName()}</td>
					<td>${client.getNIP()}</td>
					<td>${client.getREGON()}</td>
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
								<th>No.</th>
								<th>Placed On</th>
								<th>Closed On</th>
								<th>Current State</th>
								<th>Total price</th>
								<%int i=1;%>
								<c:forEach items="${client.orders}" var="order">
								<tr>
									<td><%=i++%></td>
									<td>${order.getOrderDate()}</td>
									<td>${order.getOrderCloseDate()}</td>
									<td>${order.getOrderState()}</td>
									<td>${order.getPrice()}</td>
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
	</body>
</html>