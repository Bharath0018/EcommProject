<%@include file="Header.jsp" %>

<div class="container">

<form action="<c:url value="/addSupplier"/>" method="post">
<table align="center" class="table table-bordered">
	<tr class="info">
		<td colspan="2"><center>Supplier Details</center></td>
	</tr>
	<tr>
		<td>Supplier Name</td>
		<td><input type="text" name="supName" id="supName"/></td>
	</tr>
	<tr>
		<td>Supplier Description</td>
		<td><textarea rows="6" cols="30" name="supDesc"></textarea>
	</tr>
	<tr>
		<td colspan="2">
		<center>
		<input type="submit" value="Add Supplier" class="btn btn-success"/>
		</center>
		</td>
	</tr>

</table>
</form>
</div>
<table align="center" class="table table-bordered">
<tr bgcolor="orange">
	<td colspan="4"><center>Supplier Details</center></td>
</tr>
<tr>
	<td>ID</td>
	<td>Name</td>
	<td>Description</td>
	<td>Operation</td>
</tr>
<c:forEach items="${listSuppliers}" var="supplier">
<tr>
	<td>${supplier.supplierId}</td>
	<td>${supplier.supplierName}</td>
	<td>${supplier.supplierDesc}</td>
	<td>
		&nbsp;
		<a href="<c:url value="/editSupplier/${supplier.supplierId}"/>">
		<img src="<c:url value="/resources/images/editIcon.jpg"/>" alt="Edit" width="15" height="15"/>
		</a>
		&nbsp;&nbsp;&nbsp;
		<a href="<c:url value="/deleteSupplier/${supplier.supplierId}"/>">
		<img src="<c:url value="/resources/images/deleteIcon.jpg"/>" alt="Delete" width="15" height="15"/>
		</a>
	</td>
</c:forEach>
</table>
</body>
</html>