<%@include file="Header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<br>
	<hr>

<form action="<c:url value="/addToCart/${product.productId}"/>">
	<div class="card">
		<div class="row">
			<aside class="col-sm-5 border-right">
				<article class="gallery-wrap">
					<div class="img-big-wrap">
						<div>
							<a href="#"><img
								src="<c:url value="/resources/images/${product.productId}.jpg"/>"style="height: 95%;width: 95%"></a>
						</div>
					</div>
				</article>
				<!-- gallery-wrap .end// -->
			</aside>
			<aside class="col-sm-7">
				<article class="card-body p-5">
					<h3 class="title mb-3">${product.productName}</h3>

					<p class="price-detail-wrap">
						<span class="price h3 text-warning"> <span class="currency">INR </span><span class="num">${product.price}/-</span>
						</span> 
					</p>
					<!-- price-detail-wrap .// -->
					<dl class="item-property">
						<dt>Description</dt>
						<dd>
							<p>${product.productDesc}</p>
						</dd>
					</dl>
					
					<!-- item-property-hor .// -->
					<dl class="param param-feature">
						<dt>Delivery</dt>
						<dd>Across India</dd>
					</dl>
					<!-- item-property-hor .// -->

					<hr>
					<div class="row">
						<div class="col-sm-5">
							<dl class="param param-inline">
								<dt>Quantity:</dt>
								<dd>
									<select class="form-control form-control-sm"
										style="width: 70px" name="quantity">
										<option> 1 </option>
										<option> 2 </option>
										<option> 3 </option>
										<option> 4 </option>
										<option> 5 </option>
										<option> 6 </option>
									</select>
								</dd>
							</dl>
							<!-- item-property .// -->
						</div>
						
					</div>
					<!-- row.// -->
					<hr>
					 <button type="submit" class="btn btn-info btn-lg" >
          <span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart
       </button>
				</article>
				<!-- card-body.// -->
			</aside>
			<!-- col.// -->
		</div>
		<!-- row.// -->
	</div>
	<!-- card.// -->

</form>
</div>
<!--container.//-->


<br>
<br>
<br>

</body>
</html>