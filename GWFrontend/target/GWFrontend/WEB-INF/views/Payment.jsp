<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
<div class="container">
<form action="<c:url value="/receipt"/>" method="post">
<table class="table table-bordered responsive">
	<tr class="success">
		<td colspan="4" class="text-center"> Payment Detail</td>
	</tr>
	<tr>
		<td colspan="4">
			<center>
			<input type="radio" name="pmode" value="COD">Cash On Delivery
			<input type="radio" name="pmode" value="CC">Credit Card
			</center>
		</td>
	</tr>
	<tr>
		<td colspan="2"> Card No </td>
		<td colspan="2"><input type="text" name="cardNo"/></td>
	</tr>
	<tr>
		<td>CVV</td>
		<td><input type="text" name="cvv"/></td>
		<td> Valid Upto </td>
		<td><input type="text" name="valid"/></td>
	</tr>
	<tr>
		<td colspan="4">
			<input type="submit" value="Pay"/>
		</td>
		
	</tr>
</table>
</form>
</div>
