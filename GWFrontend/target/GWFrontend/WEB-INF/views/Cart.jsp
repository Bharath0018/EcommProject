<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
<div class="container">
<table class="table table-bordered responsive">
	<tr class="success">
		<td colspan="6"> Your Cart</td>
	</tr>
	<tr class="warning">
		<th>SL#</th>
		<th>Product Name</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Image</th>
		<th>Total Price</th>
		<th> </th>
	</tr>
	<c:forEach items="${cartItemList}" var="cart">
	<form action="<c:url value="/updateCartItem/${cart.cartItemId}"/>">
	<tr>
		<td></td>
		<td>${cart.productName}</td>
		<td>${cart.price}</td>
		<td><input type="text" name="quantity" value="${cart.quantity}"/></td>
		<td><img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="50" height="50"/></td>
		<td>${cart.price * cart.quantity}</td>
		<td>
		<input type="submit" value="Update" class="btn btn-success"/> &nbsp;&nbsp;&nbsp;
		<a href="<c:url value="/deleteCartItem/${cart.cartItemId}"/>" class="btn btn-danger">Delete</a>
		</td>
	</tr>
		</form>
		</c:forEach>
		<tr bgcolor="yellow">
			<td colspan="4">Grand Total</td>
			<td colspan="3">${grandTotal}</td>
		</tr>
		<tr bgcolor="cyan">
			<td colspan="4"><a href="<c:url value="/productDisplay"/>">Continue Shopping</a></td>
			<td colspan="4"><a href="<c:url value="/checkout"/>">Checkout</a></td>
		</tr>
</table>
</div>
</body>
</html>