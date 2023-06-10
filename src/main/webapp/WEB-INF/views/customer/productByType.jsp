<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css" rel="stylesheet">
<style>
.category-title {
	font-size: 18px;
	font-weight: bold;
	color: #4c4c4c;
}

</style>
</head>
<body>
	<!-- Page Header Start -->
	<div class="container-fluid bg-secondary mb-5">
		<div 
			class="d-flex flex-column align-items-center justify-content-center"
			style="background-image: url('https://scontent.fdad3-4.fna.fbcdn.net/v/t1.15752-9/348378228_272886985146896_4538280699377459573_n.png?_nc_cat=107&ccb=1-7&_nc_sid=ae9488&_nc_ohc=rDKqPnitzA4AX_GLPbP&_nc_ht=scontent.fdad3-4.fna&oh=03_AdRE20ASOy-6CrLhYsPmWE_0Rd-HiOCj5MssGS0z0yQlwA&oe=64AB6909'); background-repeat: no-repeat; min-height: 300px; background-size: 100%">
			</div>
		</div>
	<!-- Page Header End -->
	
	<!-- Page Header End -->
	<!-- Shop Start -->
	<div class="container-fluid pt-5">
		<div class="row px-xl-5">
			<!-- Shop Sidebar Start -->
			<div class="col-lg-3 col-md-12">
				<!-- Price Start -->
				<div class="border-bottom mb-4 pb-4">
					<h5 class="font-weight-semi-bold mb-4">${typeOfCategory.type_name}</h5>
					<c:forEach var="item" items="${typeOfCategory.productCategoryList}">
						<form>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input" checked
									id="price-all"> <a class=""
									href='<c:url value="/san-pham/the-loai/${item.product_categ_id}"/>'
									for="price-all">${item.product_categ_name}</a>
							</div>
							</form>
					</c:forEach>
				</div>
				<!-- Price End -->
				
			</div>
			<!-- Shop Sidebar End -->


			<!-- Shop Product Start -->

			<div class="col-lg-9 col-md-12">


				<div class="row pb-3">
					<div class="col-12 pb-1">
						<div
							class="d-flex align-items-center justify-content-between mb-4">
							<div class="category">
								<h3 class="category-title">Tất cả</h3>
							</div>
							<div class="dropdown ml-4">
								<button class="btn border dropdown-toggle" type="button"
									id="triggerId" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Sắp xếp theo</button>
								<div class="dropdown-menu dropdown-menu-right"
									aria-labelledby="triggerId">
									<a class="dropdown-item" href="<c:url value="/san-pham/${type_id}?sort=price-asc&currentPage=${param.currentPage}"/>">Giá tăng dần</a> <a
										class="dropdown-item" href="<c:url value="/san-pham/${type_id}?sort=price-desc&currentPage=${param.currentPage}"/>">Giá giảm dần</a> <a
										class="dropdown-item" href="<c:url value="/san-pham/${type_id}?sort=product_name-asc&currentPage=${param.currentPage}"/>">Tên A->Z</a>
								</div>
							</div>
						</div>
					</div>
					<c:forEach var="item" items="${ProductPaginate}">
						<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
							<div class="card product-item border-0 mb-4">
								<div
									class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
									<a href="<c:url value="/chi-tiet-san-pham/${item.product_id}"/>"> <img class="img-fluid w-100" src="${item.img}" alt=""></a>
								</div>
								<div
									class="card-body border-left border-right text-center p-0 pt-4 pb-3">
							       <a href="<c:url value="/chi-tiet-san-pham/${item.product_id}"/>"> <h6 class="text-truncate mb-3">${item.product_name}</h6></a>
									<div class="d-flex justify-content-center">
										<h6>${item.price}đ</h6>
										<h6 class="text-muted ml-2"></h6>
									</div>
								</div>
								<div
									class="card-footer d-flex justify-content-between bg-light border">
									<a onclick="add('${item.product_id}')" class="btn btn-sm text-dark p-0"><i
											class="fas fa-shopping-cart text-primary mr-1 add-to-cart"></i>Thêm vào giỏ hàng</a> 
								</div>
							</div>
						</div>
					</c:forEach>

					 <div class="col-12 pb-1">
						<nav aria-label="Page navigation">

							<ul class="pagination justify-content-center mb-3">
								<c:forEach var="item" begin="1" end="${pageinfo.totalPage}"
									varStatus="loop">
									<c:if test="${loop.index==pageinfo.currentPage}">
										<li class="page-item active"><a class="page-link"
											href='<c:url value="/san-pham/${type_id}?sort=${param.sort}&currentPage=${loop.index}"/>'>${loop.index}</a>
										</li>
									</c:if>
									<c:if test="${loop.index!=pageinfo.currentPage}">
										<li class="page-item"><a class="page-link"
											href='<c:url value="/san-pham/${type_id}?sort=${param.sort}&currentPage=${loop.index}"/>'>${loop.index}</a>
										</li>
									</c:if>
								</c:forEach>


							</ul>

						</nav>

					</div> 

				</div>

			</div>

		</div>
	</div>
	<content tag="script"> <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script>
		function add(product_id) {
			$
					.ajax({
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