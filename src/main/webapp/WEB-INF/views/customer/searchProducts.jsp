<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Page Header Start -->
	<div class="container-fluid bg-secondary mb-5">
		<div 
			class="d-flex flex-column align-items-center justify-content-center"
			style="background-image: url('https://www.petcity.vn/media/banner/banner_839ab468.png'); background-repeat: no-repeat; min-height: 300px; background-size: 100%">
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
					<h5 class="font-weight-semi-bold mb-4">Kết quả tìm kiếm của : ${searchCondition}</h5>
					<%-- <c:forEach var="item" items="${typeOfCategory.productCategoryList}">
						<form>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input" checked
									id="price-all"> <a class=""
									href='<c:url value="/san-pham/${item.product_categ_id}/1"/>'
									for="price-all">${item.product_categ_name}</a>
							</div>
							</form>
					</c:forEach> --%>
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
								<a class="category-title">Tất cả</a>
							</div>
							<div class="dropdown ml-4">
								<button class="btn border dropdown-toggle" type="button"
									id="triggerId" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Sắp xếp theo</button>
								<div class="dropdown-menu dropdown-menu-right"
									aria-labelledby="triggerId">
									<a class="dropdown-item" href="#">Giá tăng dần</a> <a
										class="dropdown-item" href="#">Giá giảm dần</a> <a
										class="dropdown-item" href="#">Tên A->Z</a>
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
									<a href="<c:url value="/add-to-cart/${item.product_id}"/>" class="btn btn-sm text-dark p-0"><i
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
											href='<c:url value="/san-pham/the-loai/${product_cate_id}/${loop.index}"/>'>${loop.index}</a>
										</li>
									</c:if>
									<c:if test="${loop.index!=pageinfo.currentPage}">
										<li class="page-item"><a class="page-link"
											href='<c:url value="/san-pham/the-loai/${product_cate_id}/${loop.index}"/>'>${loop.index}</a>
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
	<!-- Shop Product End -->

	<!-- Shop End -->
</body>
</html>