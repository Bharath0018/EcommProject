<%@include file="Header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">

	<c:url var="addAction" value="/InsertProduct"/>
	<form:form action="${addAction}"
		modelAttribute="product" enctype="multipart/form-data" method="post">
		<table align="center" class="table table-bordered">
			<tr class="info">
				<td colspan="2"><center>Enter Product</center></td>
			</tr>
			<tr>
				<td>Product Name</td>
				<td><form:input path="productName" required="true"/></td>
			</tr>
			<tr>
				<td>Product Description</td>
				<td><form:input path="productDesc" required="true"/></td>
			</tr>
			<tr>
				<td>Stock</td>
				<td><form:input path="stock" required="true"/></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><form:input path="price" required="true"/></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><form:select path="categoryId" >
						<form:option value="0" label="--Select List--"/>
						<form:options items="${categoryList}"/>
					</form:select></td>
			</tr>
			<tr>
				<td>Supplier</td>
				<td><form:select path="supplierId" >
						<form:option value="0" label="--Select List--"/>
						<form:options items="${supplierList}"/>
					</form:select></td>
			</tr>
			<tr>
				<td>Product Image</td>
				<td><form:input type="file" path="pimage" required="true"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<center>
						<input type="submit" value="Add Product" class="btn btn-success" />
					</center>
				</td>
			</tr>
		</table>
	</form:form>

	<br />
	<br />

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
</div>