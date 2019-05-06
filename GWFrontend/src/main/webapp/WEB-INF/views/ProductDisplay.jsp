<%@include file="Header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">


<div class="row text-center text-lg-left">
<div class="row">

	<c:forEach items="${productlist}" var="product" >
	
		<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
	
		<c:if test="${product.stock > 0}">
			<a href="<c:url value="/totalProductDisplay/${product.productId}"/>">
		</c:if>
				<div class="thumbnail" style="width:100%;height:30%"><img src="<c:url value="/resources/images/${product.productId}.jpg"/>"style="height: 105%;width: 95%"></div>
			</a>
			
			<p>${product.productName}</p>
			
			<p>Price : INR ${product.price}/-</p>
			
			<p>Stock : <c:if test="${product.stock > 0}">
						${product.stock}
						</c:if>
					   <c:if test="${product.stock <= 0}">
					   <font color="red">Out of Stock</font>
					   </c:if>
			</p>					   
		</div>
	
	</c:forEach>
	
</div>
</div>
</div>


</body>
</html>
