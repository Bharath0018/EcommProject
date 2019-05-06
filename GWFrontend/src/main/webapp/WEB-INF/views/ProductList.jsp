<%@ page language="java" contentType="text/html"%>

<html>
<head>
<%@include file="Header.jsp" %>
<title>Products List</title>
</head>
<body>
<table align="center" class="table table-bordered">
		<tr bgcolor="orange">
			<td colspan="8"><center>Product Detail</center></td>
		</tr>
		<tr class="info">
			<td>SL#</td>
			<td>Product Name</td>
			<td>Stock</td>
			<td>Price</td>
			<td>Category</td>
			<td>Supplier</td>
			<td>Image</td>
			<td>Operation</td>
		</tr>

		<c:forEach items="${productlist}" var="product">
			<tr>
				<td></td>
				<td>${product.productName}</td>
				<td>${product.stock}</td>
				<td>${product.price}</td>
				<td>${product.categoryId}</td>
				<td>${product.supplierId}</td>
				<td><img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="100" height="50"/></td>
				<td>&nbsp; <a
					href="<c:url value="/editProduct/${product.productId}"/>"> <img
						src="<c:url value="/resources/images/editIcon.jpg"/>" alt="Edit"
						width="15" height="15" />
				</a> &nbsp;&nbsp;&nbsp; <a
					href="<c:url value="/deleteProduct/${product.productId}"/>"> <img
						src="<c:url value="/resources/images/deleteIcon.jpg"/>"
						alt="Delete" width="15" height="15" />
				</a>
				</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>