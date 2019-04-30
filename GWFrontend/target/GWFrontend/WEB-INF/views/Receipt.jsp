<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
<div class="container">
	<table class="table table-bordered">
	<tr>
		<td colspan="4" class="text-center">Invoice</td>
	</tr>
		<tr bgcolor="silver">
			<td>ORDER ID</td>
			<td>${orderDetail.orderId}</td>
			<td>Customer Name</td>
			<td>${orderDetail.username}</td>
		</tr>
		<tr bgcolor="maroon">
			<td>Shopping Amount</td>
			<td>${grandTotal}</td>
			<td>Order Date</td>
			<td>${orderDetail.orderDate}</td>
		</tr>
		<td colspan="4">
			<table class="table table-bordered responsive">
				<tr class="success">
					<td colspan="7" class="text-center">Your Order</td>
				</tr>
				<tr class="warning">
					<th>SL#</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Image</th>
					<th>Total Price</th>
					<th></th>
				</tr>
				<c:forEach items="${cartItemList}" var="cart">
					<tr>
						<td></td>
						<td>${cart.productName}</td>
						<td>${cart.price}</td>
						<td>${cart.quantity}</td>
						
						<td><img
							src="<c:url value="/resources/images/${cart.productId}.jpg"/>"
							width="50" height="50" /></td>
						<td>${cart.price * cart.quantity}</td>
					</tr>
				</c:forEach>
			</table>
		</td>
		
		<tr bgcolor="olive">
			<td colspan="4">Address</td>
		</tr>
		<tr>
			<td>${user.address}</td>
		</tr>
	</table>
	</div>