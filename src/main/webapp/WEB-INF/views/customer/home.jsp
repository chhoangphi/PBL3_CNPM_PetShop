<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="utf-8">
<title>PET SHOP</title>
<style>
.img-fetured{
max-width: 100%;
height: 130px;
}
.title-product-list-2 {
    background-color: #dc6435;
        position: relative;
    padding: 19px 0;
    text-align: center;
    text-transform: uppercase;
    margin: 0 0 20px;
    color: #ececec;
    font-size: 30px;
    font-weight: 400;
    text-transform: uppercase;
}
.button3 {
  background-color: white; 
  color: black; 
  border: 2px solid #f44336;
  margin-left: 750px;
}
.button3:hover{
  background-color: #f44336; 
  color: #fff; 
  border: 2px solid #f44336;
}

</style>
<link href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid mb-5">
		<div class="row border-top px-xl-5">
			<div class="col-lg-3 d-none d-lg-block">
                <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                    <h6 class="m-0">Danh mục</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse show navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0" id="navbar-vertical">
                    <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                    
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link" data-toggle="dropdown">Shop Cún<i class="fa fa-angle-down float-right mt-1"></i></a>
                            <div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
                           <c:forEach var="type01" items="${itemType01.typeOfCategoryList}">
                                <a href='<c:url value="/san-pham/${type01.type_id}"/>' class="dropdown-item">${type01.type_name}</a>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link" data-toggle="dropdown">Shop mèo<i class="fa fa-angle-down float-right mt-1"></i></a>
                            <div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
                           <c:forEach var="type02" items="${itemType02.typeOfCategoryList}">
                                <a href='<c:url value="/san-pham/${type02.type_id}"/>' class="dropdown-item">${type02.type_name}</a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
			<div class="col-lg-9">

				<div id="header-carousel" class="carousel slide"
					data-ride="carousel">
					<div class="carousel-inner">
						<div class="carousel-item active" style="height: 410px;">
							<img class="img-fluid" src="https://i.imgur.com/BC7Q4Dw.jpg"
								alt="Image">
							<div
								class="carousel-caption d-flex flex-column align-items-center justify-content-center">
								<div class="p-3" style="max-width: 700px;">
									<h4 class="text-light text-uppercase font-weight-medium mb-3"></h4>
									<h3 class="display-4 text-white font-weight-semi-bold mb-4"></h3>

								</div>
							</div>
						</div>
						<div class="carousel-item" style="height: 410px;">
							<img class="img-fluid" src="https://i.imgur.com/H8rvxj6.jpg"
								alt="Image">
							<div
								class="carousel-caption d-flex flex-column align-items-center justify-content-center">
								<div class="p-3" style="max-width: 700px;">
									<h4 class="text-light text-uppercase font-weight-medium mb-3"></h4>
									<h3 class="display-4 text-white font-weight-semi-bold mb-4"></h3>

								</div>
							</div>
						</div>
					</div>
					<a class="carousel-control-prev" href="#header-carousel"
						data-slide="prev">
						<div class="btn btn-dark" style="width: 45px; height: 45px;">
							<span class="carousel-control-prev-icon mb-n2"></span>
						</div>
					</a> <a class="carousel-control-next" href="#header-carousel" data-slide="next">
						<div class="btn btn-dark" style="width: 45px; height: 45px;">
							<span class="carousel-control-next-icon mb-n2"></span>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Featured Start -->
	<div class="container-fluid pt-5">
		<div class="row px-xl-5 pb-3">
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center border mb-4"
					style="padding: 30px;">
					<h1 class="fa fa-check text-primary m-0 mr-3"></h1>
					<h5 class="font-weight-semi-bold m-0">Cam kết chất lượng</h5>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center border mb-4"
					style="padding: 30px;">
					<h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
					<h5 class="font-weight-semi-bold m-0">Miễn phí vận chuyển</h5>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center border mb-4"
					style="padding: 30px;">
					<h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
					<h5 class="font-weight-semi-bold m-0">14 ngày trả hàng</h5>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center border mb-4"
					style="padding: 30px;">
					<h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
					<h5 class="font-weight-semi-bold m-0">Hỗ trợ 24/7</h5>
				</div>
			</div>
		</div>
	</div>
	<!-- Featured End -->

	<!-- Categories Start -->
	<div class="container-fluid pt-5">
	<div class="text-center mb-4">
			<h2 class="section-title px-5">
				<span class="px-2">Danh mục nổi bật</span>
			</h2>
		</div>
		<div class="row px-xl-5 pb-3">
		<c:forEach var="featured" items="${featuredCateg}">
			<div class="col-lg-4 col-md-6 pb-1">
				<div class="cat-item d-flex flex-column border mb-4"
					style="padding: 30px;">
					<a href='<c:url value="/san-pham/the-loai/${featured.product_categ_id}?sort=price-asc"/>' class="cat-img position-relative overflow-hidden mb-3">
						<img class="img-fetured" src="${featured.img}" alt="">
					</a>
					<a href='<c:url value="/san-pham/the-loai/${featured.product_categ_id}?sort=price-asc"/>'>
					<h5 class="font-weight-semi-bold m-0">${featured.product_categ_name}</h5>
					</a>
				</div>
			</div>
		
		</c:forEach>
		</div>
	</div>
	<!-- Categories End -->

	<!-- Products Start -->
	<div class="container-fluid pt-5">
		<div class="row px-xl-5">

			<!-- Shop Sidebar End -->
<c:forEach var="itemtype" items="${listItem}">
<div class="container-fluid pt-5">
		<div class="row px-xl-5">
			<!-- Shop Sidebar Start -->
			<div class="col-lg-3 col-md-12">
				<!-- Price Start -->
				<div class="border-bottom mb-4 pb-4">
					 <h5 class="title-product-list-2">${itemtype.name}</h5> 
					 <c:if test="${itemtype.item_id=='item01'}">
					<c:forEach var="item" items="${featuredCategByItem01}">
						<form>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input" checked
									id="price-all"> <a class=""
									href='<c:url value="/san-pham/the-loai/${item.product_categ_id}?sort=price-asc"/>'
									for="price-all">${item.product_categ_name}</a>
							</div>
							
						</form>
					</c:forEach> 
					<img border="0" src="https://bizweb.dktcdn.net/100/346/633/themes/710500/assets/banner_1_fashion.png?1679482122764" width="271" height="363">
					</c:if>
					<c:if test="${itemtype.item_id=='item02'}">
					<c:forEach var="item" items="${featuredCategByItem02}">
						<form>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input" checked
									id="price-all"> <a class=""
									href='<c:url value="/san-pham/the-loai/${item.product_categ_id}?sort=price-asc"/>'
									for="price-all">${item.product_categ_name}</a>
							</div>
						</form>
					</c:forEach> 
					<img border="0" src="https://bizweb.dktcdn.net/100/346/633/themes/710500/assets/banner_1_electronic.png?1679482122764" width="271" height="363">
					</c:if>
					
				</div>
				<!-- Price End -->

		
			</div>
			<!-- Shop Sidebar End -->


			<!-- Shop Product Start -->
			 <c:if test="${itemtype.item_id=='item01'}">
			<div class="col-lg-9 col-md-12">
					<div class="row pb-3">
						<c:forEach var="product" items="${productLimit12ByItem01}">
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
						</c:forEach>
						<a href="<c:url value="/san-pham?shop=item01"/>"><button class="button button3">Xem tất cả ></button></a>
					</div>
				
			</div>
			<img border="0" src="https://bizweb.dktcdn.net/100/448/728/themes/852257/assets/section_hot_banner.png?1686199049736" width="1300" height="113">
			</c:if>
			
			 <c:if test="${itemtype.item_id=='item02'}">
			<div class="col-lg-9 col-md-12">
					<div class="row pb-3">
						<c:forEach var="product" items="${productLimit12ByItem02}">
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
						</c:forEach>
					<a href="<c:url value="/san-pham?shop=item02"/>">	<button class="button button3">Xem tất cả ></button></a>
					</div>
				
			</div>
			</c:if>



		</div>
	</div>
</c:forEach>
</div>
</div>


		<style type="text/css">
* html div#fl813691 {
	position: absolute;
	overflow: hidden;
	top: expression(eval(document.compatMode &&      
 document.compatMode == 'CSS1Compat')?      
 documentElement.scrollTop+(documentElement.clientHeight-this.clientHeight):
		 document.body.scrollTop+(document.body.clientHeight-this.clientHeight));
}

#fl813691 {
	font: 12px Arial, Helvetica, sans-serif;
	color: #666;
	position: fixed;
	_position: absolute;
	right: 0;
	bottom: 0;
	height: 150px;
}

#eb951855 {
	width: 150px;
	padding-right: 7px;
	background:
		url(http://3.bp.blogspot.com/-pjTpLDeCS8I/Uas87l_nF0I/AAAAAAAADWM/EycEXhv_mhw/s1600/rightp.gif)
		no-repeat right top;
}

#cob263512 {
	background:
		url(http://2.bp.blogspot.com/-eykde4kjuGM/Uas9FM1ijfI/AAAAAAAADWU/IJ6hHuu6pNU/s1600/fulld.gif)
		no-repeat left top;
	height: 150px;
	padding-left: 7px;
}

#coh963846 {
	color: #690;
	display: block;
	height: 20px;
	line-height: 20px;
	font-size: 11px;
	width: 265px;
	
}

#coh963846 a {
	color: #690;
	text-decoration: none;
}

#coc67178 {
	float: right;
	padding: 0;
	margin: 0;
	list-style: none;
	overflow: hidden;
	height: 15px;
}

#coc67178 li {
	display: inline;
}

#coc67178 li a {
	background-image:
		url(http://2.bp.blogspot.com/-91xti1kHuts/Uas9N_aBAYI/AAAAAAAADWc/s5DbPY-R7EQ/s1600/closebutton.gif);
	background-repeat: no-repeat;
	width: 30px;
	height: 0;
	padding-top: 15px;
	overflow: hidden;
	float: left;
}

#coc67178 li a.close {
	background-position: 0 0;
}

#coc67178 li a.close:hover {
	background-position: 0 -15px;
}

#coc67178 li a.min {
	background-position: -30px 0;
}

#coc67178 li a.min:hover {
	background-position: -30px -15px;
}

#coc67178 li a.max {
	background-position: -60px 0;
}

#coc67178 li a.max:hover {
	background-position: -60px -15px;
}

#co453569 {
	display: block;
	margin: 0;
	padding: 0;
	height: 123px;
	border-style: solid;
	border-width: 1px;
	border-color: #111 #999 #999 #111;
	line-height: 1.6em;
	overflow: hidden;
}
</style>
		<div id="fl813691" style="height: 152px;">
			<div id="eb951855">
				<div id="cob263512">
					<div id="coh963846">
						<ul id="coc67178">
							<li id="pf204652hide"><a class="min"
								href="javascript:pf204652clickhide();" title="&#7848;n  &#273;i">&#7848;n</a></li>
							<li id="pf204652show" style="display: none;"><a class="max"
								href="javascript:pf204652clickshow();"
								title="Hi&#7879;n  l&#7841;i">Xem </a></li>
						</ul>
						<!-- &nbsp;HỖ TRỢ TƯ VẤN 24/7 -->
						<!— TIÊU ĐỀ CỦA LIVE CHAT -->

					</div>
					<div id="co453569">
						<!-- code ads -->
						<a href="https://zalo.me/84377382067"
							target="_blank" rel="nofollow"> <!—USER ID FACEBOOK --> <img
							style="margin: 3px 1px 1px 3px;" border="0" width="100%"
							src="https://i.imgur.com/UHGzsC4.png"
							height="100%" width="100%" title=""
							alt="" />
						<!—HÌNH ẢNH NV LIVE CHAT -->
						</a>
						<!-- End code ads -->

					</div>
				</div>
			</div>
		</div>
		<script>
			pf204652bottomLayer = document.getElementById('fl813691');
			var pf204652IntervalId = 0;
			var pf204652maxHeight = 150;//Chieu cao khung quang cao      
			var pf204652minHeight = 20;
			var pf204652curHeight = 0;
			function pf204652show() {
				pf204652curHeight += 2;
				if (pf204652curHeight > pf204652maxHeight) {
					clearInterval(pf204652IntervalId);
				}
				pf204652bottomLayer.style.height = pf204652curHeight + 'px';
			}
			function pf204652hide() {
				pf204652curHeight -= 3;
				if (pf204652curHeight < pf204652minHeight) {
					clearInterval(pf204652IntervalId);
				}
				pf204652bottomLayer.style.height = pf204652curHeight + 'px';
			}
			pf204652IntervalId = setInterval('pf204652show()', 5);
			function pf204652clickhide() {
				document.getElementById('pf204652hide').style.display = 'none';
				document.getElementById('pf204652show').style.display = 'inline';
				pf204652IntervalId = setInterval('pf204652hide()', 5);
			}
			function pf204652clickshow() {
				document.getElementById('pf204652hide').style.display = 'inline';
				document.getElementById('pf204652show').style.display = 'none';
				pf204652IntervalId = setInterval('pf204652show()', 5);
			}
			function pf204652clickclose() {
				document.body.style.marginBottom = '0px';
				pf204652bottomLayer.style.display = 'none';
			}
		</script>
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