<%@include file="Header.jsp" %>

<form action="<c:url value="/addCategory"/>" method="post">
<table align="center">
	<tr>
		<td colspan="2"><center>Category Detail</center></td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catName" id="catName"/></td>
	</tr>
	<tr>
		<td>Category Description</td>
		<td><textarea rows="6" cols="30" name="catDesc"></textarea>
	</tr>
	<tr>
		<td colspan="2">
		<center><input type="submit" value="Add Category"/></center>
		</td>
	</tr>

</table>
</form>
<table align="center">
<tr>
	<td colspan="4"><center>Category Detail</center></td>
</tr>
<tr>
	<td>ID</td>
	<td>Name</td>
	<td>Description</td>
	<td>Operation</td>
</tr>
<c:forEach items="${listCategories}" var="category">
<tr>
	<td>${category.categoryId}</td>
	<td>${category.categoryName}</td>
	<td>${category.categoryDesc}</td>
	<td>
		<a href="<c:url value="/editCategory/${category.categoryId}"/>">EDIT</a> /
		<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">DELETE</a>
	</td>
</c:forEach>
</table>
</body>
</html>