<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="../resource/client/images/favicon.png">
<title>List products by category</title>
<link href="/resource/client/css/bootstrap.css" rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100'
	rel='stylesheet' type='text/css'>
<link href="/resource/client/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="resource/client/css/flexslider.css"
	type="text/css" media="screen" />
<link href="/resource/client/css/sequence-looptheme.css"
	rel="stylesheet" media="all" />
<link href="/resource/client/css/style.css" rel="stylesheet">
</head>
<body id="home">
	<div class="wrapper">
		<%@include file="common/header.jsp"%>

		<div class="container_fullwidth">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<div class="category leftbar">
							<h3 class="title">Categories</h3>
							<ul>
								<c:forEach items="${categories}" var="category">
									<li><a
										href="product-grid?categoryId=${category.categoryId}">${category.categoryName}</a></li>
								</c:forEach>
							</ul>
						</div>

						<div class="price-filter leftbar">
							<h3 class="title">Price</h3>
							<form class="pricing" action="search" method="get">
								<select name="pricing" onchange='this.form.submit()'>
									<option
										<c:if test="${pricing eq 'default'}">
										selected="selected"
										</c:if>
										value="default">Find by price</option>
									<option
										<c:if test="${pricing eq 'under50'}">
										selected="selected"
										</c:if>
										value="under50">under 50 dollars</option>
									<option
										<c:if test="${pricing eq '50to70'}">
										selected="selected"
										</c:if>
										value="50to70">50 dollars to 70 dollars</option>
									<option
										<c:if test="${pricing eq 'greaterthan70'}">
										selected="selected"
										</c:if>
										value="greaterthan70">greater than 70 dollars</option>
									<input type="hidden" name="categoryId" value="${categoryId}" />
									<input type="hidden" name="text" value="${text}" />
								</select>
							</form>
						</div>

						<div class="clearfix"></div>
						<div class="others leftbar">
							<h3 class="title">Others</h3>
						</div>
						<div class="clearfix"></div>
						<div class="clearfix"></div>
						<div class="leftbanner"></div>
					</div>
					<div class="col-md-9">
						<div class="clearfix"></div>
						<div class="products-grid">

							<!-- Tool Bar -->
							<jsp:include page="common/toolbar.jsp" />

							<div class="clearfix"></div>
							<div class="row">
								<c:forEach items="${products}" var="product">
									<div class="col-md-4 col-sm-6">
										<div class="products">
											<div class="offer">-${product.sale.salePercent}%</div>
											<div class="thumbnail">
												<a href="product-details?productId=${product.productId}"><img
													style="width: 90%;"
													src="../download?image=${product.image}" alt="Product Name"></a>
											</div>
											<div class="productname">${product.productName}</div>

											<c:if test="${product.sale.salePercent == 0}">
												<span class="price"
													style="font-size: 15px; color: black; text-decoration: line-through; margin-bottom: 0px; margin-top: -5px;">.</span>
												<span class="price">$${product.price - (product.price
													* product.sale.salePercent / 100)}0</span>
											</c:if>

											<c:if test="${product.sale.salePercent != 0}">
												<span class="price"
													style="font-size: 15px; color: black; text-decoration: line-through; margin-bottom: 0px; margin-top: -5px;">$${product.price}0</span>
												<span class="price">$${product.price - (product.price
													* product.sale.salePercent / 100)}0</span>
											</c:if>

											<div class="button_group">
												<a class="button add-cart" type="button"
													href="add-to-cart?productId=${product.productId}">Add
													To Cart</a>
												<button class="button compare" type="button">
													<i class="fa fa-exchange"></i>
												</button>
												<button class="button wishlist" type="button">
													<i class="fa fa-heart-o"></i>
												</button>
											</div>
										</div>
									</div>
								</c:forEach>
								<div class="clearfix"></div>

								<!-- Tool Bar -->
								<jsp:include page="common/toolbar.jsp" />


								<div class="clearfix"></div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		<%@include file="common/footer.jsp"%>
	</div>
	<!-- Bootstrap core JavaScript==================================================-->
	<script type="text/javascript"
		src="../resource/client/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript"
		src="../resource/client/js/jquery.easing.1.3.js"></script>
	<script type="text/javascript"
		src="../resource/client/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="../resource/client/js/jquery.sequence-min.js"></script>
	<script type="text/javascript"
		src="../resource/client/js/jquery.carouFredSel-6.2.1-packed.js"></script>
	<script defer src="../resource/client/js/jquery.flexslider.js"></script>
	<script type="text/javascript"
		src="../resource/client/js/script.min.js"></script>
</body>
</html>