<%@include file="Header.jsp" %>

</div class="container">

<form action="<c:url value="/addCategory"/>" method="post">
<table align="center" class="table table-bordered">
	<tr class="info">
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
		<center>
		<input type="submit" value="Add Category" class="btn btn-success"/>
		</center>
		</td>
	</tr>

</table>
</form>
</div>
<table align="center" class="table table-bordered">
<tr bgcolor="orange">
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
		&nbsp;
		<a href="<c:url value="/editCategory/${category.categoryId}"/>">
		<img src="<c:url value="/resources/images/editIcon.jpg"/>" alt="Edit" width="15" height="15"/>
		</a>
		&nbsp;&nbsp;&nbsp;
		<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">
		<img src="<c:url value="/resources/images/deleteIcon.jpg"/>" alt="Delete" width="15" height="15"/>
		</a>
	</td>
</c:forEach>
</table>
</body>
</html>