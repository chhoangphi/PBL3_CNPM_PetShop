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
			style="background-image: url('https://scontent.fdad3-4.fna.fbcdn.net/v/t1.15752-9/348378228_272886985146896_4538280699377459573_n.png?_nc_cat=107&ccb=1-7&_nc_sid=ae9488&_nc_ohc=rDKqPnitzA4AX_GLPbP&_nc_ht=scontent.fdad3-4.fna&oh=03_AdRE20ASOy-6CrLhYsPmWE_0Rd-HiOCj5MssGS0z0yQlwA&oe=64AB6909'); background-repeat: no-repeat; min-height: 300px; background-size: 100%">
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
									href='<c:url value="/san-pham/${item.type_id}"/>'
									for="price-all">${item.type_name}</a>
							</div>
						</form>
					</c:forEach> 
					 <h5 class="font-weight-semi-bold mb-4">Khoảng giá</h5>
                    <form>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
							 <a href='<c:url value="/loc-san-pham-theo-gia?min=0&max=49000"/>'>
                            <label class="custom-control-label" for="price-1">Dưới 50.000đ</label>
                            </a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href='<c:url value="/loc-san-pham-theo-gia?min=50000&max=69000"/>'>
                            <label class="custom-control-label" for="price-2">50.000đ - 69.000đ</label>
                            </a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href='<c:url value="/loc-san-pham-theo-gia?min=70000&max=990000"/>'>
                            <label class="custom-control-label" for="price-2">70.000đ - 99.000đ</label>
                            </a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href='<c:url value="/loc-san-pham-theo-gia?min=100000&max=199000"/>'>
                            <label class="custom-control-label" for="price-3">100.000đ - 199.000đ</label>
                            </a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href='<c:url value="/loc-san-pham-theo-gia?min=200000&max=499000"/>'>
                            <label class="custom-control-label" for="price-4">200.000đ - 499.000đ</label>
                            </a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href='<c:url value="/loc-san-pham-theo-gia?min=500000&max=699000"/>'>
                            <label class="custom-control-label" for="price-4">500.000đ - 699.000đđ</label>
                            </a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between">	
                            <a href='<c:url value="/loc-san-pham-theo-gia?min=700000&max=50000"/>'>
                            <label class="custom-control-label" for="price-5">Trên 700.000đ</label>
                            </a>
                        </div>
                    </form>
				</div>
			</div>
			
			<!-- Shop Sidebar End -->


			<!-- Shop Product Start -->

			<div class="col-lg-9 col-md-12">
				<c:set var="start" value="0"></c:set>
				<c:set var="finish" value="7"></c:set>
				<c:set var="count" value="1"></c:set>
				<c:forEach var="type" items="${ItemType.typeOfCategoryList}">
					<c:set var="res" value="1"></c:set>
					<div class="category">
						<h3 class="category-title">${type.type_name}</h3> <a
							href='<c:url value="/san-pham/${type.type_id}"/>'
							class="view-all">Xem tất cả ></a>
					</div>
					<div class="row pb-3">
						<c:forEach var="product" items="${productByTypeID}"
							begin="${start}" end="${finish}">
							<c:set var="count" value="${count+1}"></c:set>
							<c:set var="res" value="${res+1}"></c:set>
							<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
								<div class="card product-item border-0 mb-4">
									<div
										class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
										<a
											href="<c:url value="/chi-tiet-san-pham/${product.product_id}"/>"><img
											class="img-fluid w-100" src="${product.img}" alt=""></a>
									</div>
									<div
										class="card-body border-left border-right text-center p-0 pt-4 pb-3">
										<a
											href="<c:url value="/chi-tiet-san-pham/${product.product_id}"/>"><h6
												class="text-truncate mb-3">${product.product_name}</h6> </a>
										<div class="d-flex justify-content-center">
											<h6>${product.price}đ</h6>

										</div>
									</div>
									<div
										class="card-footer d-flex justify-content-between bg-light border">
											<a onclick="add('${product.product_id}')" class="btn btn-sm text-dark p-0"><i
											class="fas fa-shopping-cart text-primary mr-1 add-to-cart"></i>Thêm vào giỏ hàng</a>  
						
									</div>
								</div>
							</div>
							<c:if test="${res==8}">
								<c:set var="start" value="${count}"></c:set>
								<c:set var="finish" value="${count+7}"></c:set>

							</c:if>
						</c:forEach>
					</div>
				</c:forEach>
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