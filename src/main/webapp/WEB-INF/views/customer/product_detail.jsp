<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
<style>
.rating {
	float: left;
}

/* :not(:checked) is a filter, so that browsers that don’t support :checked don’t 
      follow these rules. Every browser that supports :checked also supports :not(), so
      it doesn’t make the test unnecessarily selective */
.rating:not(:checked)>input {
	position: absolute;
	top: -9999px;
	clip: rect(0, 0, 0, 0);
}

.rating:not(:checked)>label {
	float: right;
	width: 1em;
	/* padding:0 .1em; */
	overflow: hidden;
	white-space: nowrap;
	cursor: pointer;
	font-size: 300%;
	/* line-height:1.2; */
	color: #ddd;
}

.rating:not(:checked)>label:before {
	content: '★ ';
}

.rating>input:checked ~ label {
	/* color: dodgerblue; */
	color: #E51F28 !important;
}

.rating:not(:checked)>label:hover, .rating:not(:checked)>label:hover ~
	label {
	/* color: dodgerblue; */
	color: #E51F28 !important;
}

.rating>input:checked+label:hover, .rating>input:checked+label:hover ~
	label, .rating>input:checked ~ label:hover, .rating>input:checked ~
	label:hover ~ label, .rating>label:hover ~ input:checked ~ label {
	/* color: dodgerblue; */
	color: #E51F28 !important;
}

.rating>label:active {
	position: relative;
	top: 2px;
	left: 2px;
}
</style>
<link href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css" rel="stylesheet">
</head>

<body>
	<!-- Page Header Start -->
	<div class="container-fluid bg-secondary mb-5">
		<div 
			class="d-flex flex-column align-items-center justify-content-center"
			style="background-image: url('https://www.petcity.vn/media/banner/banner_839ab468.png'); background-repeat: no-repeat; min-height: 300px; background-size: 100%">
			<!-- <h1 class="font-weight-semi-bold text-uppercase mb-3" > Shop
				Detail </h1>
			<div class="d-inline-flex">
				<p class="m-0">
					<a href="">Home</a>
				</p>
				<p class="m-0 px-2">-</p>
				<p class="m-0">Shop Detail</p> -->
			</div>
		</div>
	<!-- Page Header End -->


	<!-- Shop Detail Start -->
	<div class="container-fluid py-5">
		<div class="row px-xl-5">
			<div class="col-lg-5 pb-5">
				<div id="product-carousel" class="carousel slide"
					data-ride="carousel">
					<div class="carousel-inner border">
						<div class="carousel-item active">
							<img class="w-100 h-100" src='<c:url value="${product.img}"/>'
								alt="Image">
						</div>

					</div>
					<a class="carousel-control-prev" href="#product-carousel"
						data-slide="prev"> <i class="fa fa-2x fa-angle-left text-dark"></i>
					</a> <a class="carousel-control-next" href="#product-carousel"
						data-slide="next"> <i
						class="fa fa-2x fa-angle-right text-dark"></i>
					</a>
				</div>
			</div>

			<div class="col-lg-7 pb-5">
				<h3 class="font-weight-semi-bold">${product.product_name}</h3>
				<div class="d-flex mb-3">
					<div class="text-primary mr-2">
						<c:forEach begin="1" end="${intAvgRating}" varStatus="loop">
							<small class="fas fa-star"></small>
						</c:forEach>
						<c:choose>
							<c:when test="${avgRating - intAvgRating <= 0.1}">
								<small class="far fa-star"></small>
							</c:when>
							<c:when test="${avgRating - intAvgRating > 0.1 && avgRating - intAvgRating < 0.8}">
								<small class="fas fa-star-half-alt"></small>
							</c:when>

							<c:when test="${avgRating - intAvgRating >= 0.8}">
								<small class="fas fa-star"></small>
							</c:when>
						</c:choose>
						<c:forEach begin="${intAvgRating+2}" end="5" varStatus="loop">
							<small class="far fa-star"></small>
						</c:forEach>
						<!-- <small class="fas fa-star"></small> <small class="fas fa-star"></small>
						<small class="fas fa-star"></small> <small
							class="fas fa-star-half-alt"></small> <small class="far fa-star"></small> -->
					</div>
					<small class="font-weight-semi-bold mb-4">${avgRating}/5</small>
				</div>
				<h3 class="font-weight-semi-bold mb-4">${product.price}đ</h3>
				<div class="d-flex align-items-center mb-4 pt-2">
					<a  onclick="add('${product.product_id}')" type="submit"
						class="btn btn-sm text-dark p-0">
						<i class="fas fa-shopping-cart text-primary mr-1 add-to-cart"></i>
						Thêm vào giỏ hàng
					</a>
				</div>
				<div class="d-flex pt-2">
					<p class="text-dark font-weight-medium mb-0 mr-2">Chia sẻ</p>
					<div class="d-inline-flex">
						<a class="text-dark px-2" href=""> <i
							class="fab fa-facebook-f"></i>
						</a> <a class="text-dark px-2" href=""> <i class="fab fa-twitter"></i>
						</a> <a class="text-dark px-2" href=""> <i
							class="fab fa-linkedin-in"></i>
						</a> <a class="text-dark px-2" href=""> <i
							class="fab fa-pinterest"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="row px-xl-5">
			<div class="col">
				<div
					class="nav nav-tabs justify-content-center border-secondary mb-4">
					<a class="nav-item nav-link active" data-toggle="tab"
						href="#tab-pane-1">CHI TIẾT</a> <a class="nav-item nav-link"
						data-toggle="tab" href="#tab-pane-3">ĐÁNH GIÁ ${amountOfReviews}</a>
				</div>
				<div class="tab-content">
					<div class="tab-pane fade show active" id="tab-pane-1">
						<h4 class="mb-3">Mô tả sản phẩm</h4>
						<p>${product.description}</p>

					</div>

					<div class="tab-pane fade" id="tab-pane-3">
						<div class="row">

							<div class="col-md-6">
								<h4 class="mb-4">${amountOfReviews} review for ${productName}</h4>
								<c:forEach var="item" items="${dataReviewsByProductID}">
									<div class="media mb-4">
										<img src="img/user.jpg" alt="Image"
											class="img-fluid mr-3 mt-1" style="width: 45px;">
										<div class="media-body">
											<h6>
												${item.customerID}<small> - <i>${item.reviewDate }</i></small>
											</h6>
											<div class="text-primary mb-2">
												<!-- <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
													class="fas fa-star"></i> <i class="fas fa-star-half-alt"></i>
												<i class="far fa-star"></i> -->
												<c:forEach begin="1" end="${item.rating }">
													<i class="fas fa-star"></i>
												</c:forEach>
												<c:forEach begin="${item.rating+1 }" end="5">
													<i class="far fa-star"></i>
												</c:forEach>
											</div>
											<p>${item.reviewText}</p>
										</div>
									</div>
								</c:forEach>
							</div>

							<c:if test="${(not empty listOrderDetail) }">
								<div class="col-md-6">
									<h4 class="mb-4">Leave a review</h4>
									<small>Your email address will not be published.
										Required fields are marked *</small>
									<%-- <div class="d-flex my-3">
										<p class="mb-0 mr-2">Your Rating</p>
										<hr>
										<div class="container">
											<div class="row">
												<div class="rating">
													<!-- <input type="radio" id="star5" name="rating" value="5" />
													<label for="star5" title="Meh">5 stars</label> <input
														type="radio" id="star4" name="rating" value="4" /><label
														for="star4" title="Kinda bad">4 stars</label> <input
														type="radio" id="star3" name="rating" value="3" /><label
														for="star3" title="Kinda bad">3 stars</label> <input
														type="radio" id="star2" name="rating" value="2" /><label
														for="star2" title="Sucks big tim">2 stars</label> <input
														type="radio" id="star1" name="rating" value="1" /><label
														for="star1" title="Sucks big time">1 star</label> -->
													<c:forEach begin="1" end="5"
														varStatus="loop">
														<form:radiobutton type="radio" id="star5" name="rating" value="${loop.index}" />
													<label for="star5" title="Meh">${loop.index} stars</label>
														</c:forEach>
												</div>
											</div>
										</div>
									</div> --%>
									<form:form action="/petshop-5/chi-tiet-san-pham/${product_id}"
										method="POST" modelAttribute="reviews">
										<div class="d-flex my-3">
											<p class="mb-0 mr-2">Your Rating</p>
											<hr>
											<div class="container">
												<div class="row">
													<div class="rating">
														<!-- <input type="radio" id="star5" name="rating" value="5" />
													<label for="star5" title="Meh">5 stars</label> <input
														type="radio" id="star4" name="rating" value="4" /><label
														for="star4" title="Kinda bad">4 stars</label> <input
														type="radio" id="star3" name="rating" value="3" /><label
														for="star3" title="Kinda bad">3 stars</label> <input
														type="radio" id="star2" name="rating" value="2" /><label
														for="star2" title="Sucks big tim">2 stars</label> <input
														type="radio" id="star1" name="rating" value="1" /><label
														for="star1" title="Sucks big time">1 star</label> -->
														<c:forEach begin="1" end="5" varStatus="loop">
															<input type="radio" id="star${loop.index}" name="rating"
																value="${6-loop.index}" />
															<label for="star${loop.index}" title="Meh">${loop.index}
																stars</label>
														</c:forEach>
													</div>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label for="message">Your Review *</label>
											<form:textarea id="message" cols="30" rows="5"
												class="form-control" path="reviewText" />
										</div>
										<div class="form-group mb-0">
											<input type="submit" value="Leave Your Review"
												class="btn btn-primary px-3" />
										</div>
									</form:form>
								</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Shop Detail End -->


	<!-- Products Start -->
	<div class="container-fluid py-5">
		<div class="text-center mb-4">
			<h2 class="section-title px-5">
				<span class="px-2">Sản Phẩm Tương Tự</span>
			</h2>
		</div>
		<div class="row px-xl-5">
			<div class="col">
				<div class="owl-carousel related-carousel">
					<c:forEach var="item" items="${productByCategory}">
						<div class="card product-item border-0">
							<div
								class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
								<a
									href="<c:url value="/chi-tiet-san-pham/${product.product_id}"/>">
									<img class="img-fluid w-100" src="${item.img}" alt="">
								</a>
							</div>
							<div
								class="card-body border-left border-right text-center p-0 pt-4 pb-3">
								<a
									href="<c:url value="/chi-tiet-san-pham/${product.product_id}"/>">
									<h6 class="text-truncate mb-3">${item.product_name}</h6>
								</a>
								<div class="d-flex justify-content-center">
									<h6>${item.price}đ</h6>
								</div>
							</div>
							<div
								class="card-footer d-flex justify-content-between bg-light border">
								<a onclick="add('${product.product_id}')"
									class="btn btn-sm text-dark p-0"><i
									class="fas fa-shopping-cart text-primary mr-1 add-to-cart"></i>Thêm
									vào giỏ hàng</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<content tag="script"> <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script>
		function add(product_id) {
					$.ajax({
						url : "/petshop-5/add-to-cart/" + product_id,
						type : "get",
						success : function() {
							$("#addtocart").load(" #addtocart>*", "");
							Toastify(
									{
										text : "Thêm vào giỏ hàng thành công!",
										duration : 3000,
										newWindow : true,
										close : true,
										gravity : "top", // hiển thị ở trên cùng màn hình
										position : "center", // căn giữa theo chiều ngang
										backgroundColor : "linear-gradient(to right, #00b09b, #96c93d)",
									}).showToast();
						}
					});
		}
	</script> <script src="https://cdn.jsdelivr.net/npm/toastify-js"></script> <script
		src="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
	</content>
</body>
</html>