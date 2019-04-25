<%@include file="Header.jsp"%>

<form action="<c:url value="/updateCategory"/>" method="post">
<table align="center">
	<tr>
		<td colspan="2"><center>Category Detail</center></td>
	</tr>
	<tr>
		<td>Category ID</td>
		<td><input type="text" name="catid" value="${category.categoryId}" readonly/></td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catName" value="${category.categoryName}"/></td>
	</tr>
	<tr>
		<td>Category Description</td>
		<td><textarea rows="6" cols="30" name="catDesc">${category.categoryDesc}</textarea>
	</tr>
	<tr>
		<td colspan="2">
		<center><input type="submit" value="Update Category"/></center>
		</td>
	</tr>

</table>
</form>

</body>
</html>