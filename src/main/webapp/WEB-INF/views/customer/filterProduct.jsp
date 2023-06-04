<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
.category {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 20px;
}

.category-title {
	font-size: 18px;
	font-weight: bold;
	color: #4c4c4c;
}

.view-all {
	color: black;
	text-decoration: none;
	font-size: 16px;
	margin-left: 200px;
}
.img-logo{
	MAX-WIDTH: 100%;
    height: auto;
    padding-bottom: 15px;
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
			</div>
		</div>
	<!-- Page Header End -->

	
	<!-- Shop Start -->
	<div class="container-fluid pt-5">
		<div class="row px-xl-5">
			<!-- Shop Sidebar Start -->
			<div class="col-lg-3 col-md-12">
				<!-- Price Start -->
				<div class="border-bottom mb-4 pb-4">
					<c:if test="${param.shop=='item01'}">
					<img class="img-logo" src="https://i.imgur.com/UkZCWsu.png" alt="">
					</c:if>
						<c:if test="${param.shop=='item02'}">
					<img class="img-logo" src="https://www.petcity.vn/media/banner/banner_357a6fdf.jpg" alt="">
					</c:if>
					<c:forEach var="item" items="${ItemType.typeOfCategoryList}">
						<form>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input" checked
									id="price-all"> <a class=""
									href='<c:url value="/san-pham/${item.type_id}?sort=price-asc"/>'
									for="price-all">${item.type_name}</a>
							</div>
						</form>
					</c:forEach> 
					 <h5 class="font-weight-semi-bold mb-4">Khoảng giá</h5>
                    <form>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" checked id="price-all">
                            <c:if test="${param.min!='-333' && param.max!='-333'}">
                            <label class="custom-control-label" for="price-1">${param.min}đ - ${param.max}đ</label>
                            </c:if>
                            <c:if test="${param.min!='-333' && param.max=='-333'}">
                            <label class="custom-control-label" for="price-1">Trên ${param.min}đ</label>
                            </c:if>
                            <c:if test="${param.min=='-333' && param.max!='-333'}">
                            <label class="custom-control-label" for="price-1">Dưới ${param.max}đ</label>
                            </c:if>
                            <span class="badge border font-weight-normal">150</span>
                        </div>
                    </form>
				</div>
			</div>
			
			<!-- Shop Sidebar End -->


			<!-- Shop Product Start -->

			<div class="col-lg-9 col-md-12">


				<div class="row pb-3">
					<div class="col-12 pb-1">
						<div
							class="d-flex align-items-center justify-content-between mb-4">
							<div class="category">
								<h2 class="category-title">Tất cả</h2>
							</div>
						</div>
					</div>
					<c:forEach var="item" items="${productFilter}">
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
				<c:if test="${productFilter.size()=='0'}">
				<div>Không tìm thấy sản phẩm nào</div>
				</c:if>
				</div>

			</div>
			





		</div>
	</div>
	<!-- Shop Product End -->
	 <content tag="script"> 
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	 <script>
	function add(product_id) {
        $.ajax({
            url: "/petshop-5/add-to-cart/" + product_id,
            type: "get",
            success: function () {
                $("#addtocart").load(" #addtocart>*",""); 
                Toastify({
		    		  text: "Thêm vào giỏ hàng thành công!",
		    		  duration: 3000,
		    		  newWindow: true,
		    		  close: true,
		    		  gravity: "top", // hiển thị ở trên cùng màn hình
		    		  position: "center", // căn giữa theo chiều ngang
		    		  backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)",
		    		}).showToast();
            }
        });
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/toastify-js"></script>
	<script src="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	 </content> 

</body>
</html>