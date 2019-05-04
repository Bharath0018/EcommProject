<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
<div class="container">
<table class="table table-bordered">
	<tr class="success">
		<td colspan="8"> Your Cart</td>
	</tr>
	<tr class="warning">
		<th>SL#</th>
		<th>Product Name</th>
		<th>Price</th>
		<th >Quantity</th>
		<th>Image</th>
		<th>Total Price</th>
		
	</tr>
	<c:forEach items="${cartItemList}" var="cart">
	<form action="<c:url value="/updateCartItem/${cart.cartItemId}"/>">
	<tr>
		<td></td>
		<td>${cart.productName}</td>
		<td>${cart.price}</td>
		<td ><input type="number" max="99" min="1" name="quantity" value="${cart.quantity}" disabled/></td>
		<td><img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="50" height="50"/></td>
		<td><i class="fa fa-rupee">${cart.price * cart.quantity}</i></td>
		
	</tr>
		</form>
		</c:forEach>
		<tr bgcolor="yellow">
			<td colspan="4">Grand Total</td>
			<td colspan="3">${grandTotal}</td>
		</tr>
		<tr bgcolor="cyan">
			<td colspan="4"><a href="<c:url value="/showCart"/>">Edit Cart</a></td>
			<td colspan="4"><a href="<c:url value="/payment"/>">Proceed to Payment</a></td>
		</tr>
</table>
</div>
</body>
</html>