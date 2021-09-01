<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>MAS_PR2 - Order Details</title>
	</head>
	<body>
		<div class="container" align="center">
			<h1>Order Details</h1>
			<div class="menu"">
				<table>
					<tr>
						<td><a href="/MAS_PR2/">Home</a></td>
						<td><a href="/MAS_PR2/clients">Clients</a></td>
						<td><a href="/MAS_PR2/orders">Orders</a></td>
					</tr>
				</table>
			</div>
			<div class="dOrder">
				<table>
					<tr>
						<th>ID</th>
						<th>Placed By</th>
						<th>Placed On</th>
						<th>Closed On</th>
						<th>Current State</th>
						<th>Products</th>
						<th>Total Price</th>
					</tr>
					<tr>
						<td>${order.getId()}</td>
						<td><a href="/MAS_PR2/clients/${order.getClient().getId()}">${order.getClient().printName()}</a></td>
						<td>${order.getOrderDate()}</td>
						<td>${order.getOrderCloseDate()}</td>
						<td>${order.getOrderState()}</td>
						
						<td>
							<table>
								<tr>
									<th>Product ID</th>
									<th>Product Name</th>
									<th>Product Type</th>
									<th>Amount</th>
									<th>Price</th>
								</tr>
								
								<c:forEach items="${order.getProducts()}" var="product">
									<tr>
										<td>${product.getId()}</td>
										<td>${product.getName()}</td>
										<td>${product.getProductType()}</td>
										<td>${product.getAmount()}</td>
										<td>${product.getPrice()}</td>
									</tr>
								</c:forEach>
							</table>
						</td>
						
						<td>${order.getPrice()}</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>