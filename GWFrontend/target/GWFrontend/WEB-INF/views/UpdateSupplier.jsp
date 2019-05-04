<%@include file="Header.jsp"%>

<form action="<c:url value="/updateSupplier"/>" method="post">
<table align="center" class="table table-bordered">
	<tr>
		<td colspan="2"><center>Supplier Detail</center></td>
	</tr>
	<tr>
		<td>Supplier ID</td>
		<td><input type="text" name="supid" value="${supplier.supplierId}" readonly/></td>
	</tr>
	<tr>
		<td>Supplier Name</td>
		<td><input type="text" name="supName" value="${supplier.supplierName}"/></td>
	</tr>
	<tr>
		<td>Supplier Description</td>
		<td><textarea rows="6" cols="30" name="supDesc">${supplier.supplierDesc}</textarea>
	</tr>
	<tr>
		<td colspan="2">
		<center><input type="submit" value="Update Supplier"/></center>
		</td>
	</tr>

</table>
</form>

</body>
</html>