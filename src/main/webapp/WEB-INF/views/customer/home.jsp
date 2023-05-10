<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="utf-8">
<title>PET SHOP</title>
</head>
<body>
	<div class="container-fluid mb-5">
		<div class="row border-top px-xl-5">
			<div class="col-lg-3 d-none d-lg-block">
				<a
					class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100"
					data-toggle="collapse" href="#navbar-vertical"
					style="height: 65px; margin-top: -1px; padding: 0 30px;">
					<h6 class="m-0">Categories</h6> <i
					class="fa fa-angle-down text-dark"></i>
				</a>
				<!--   <nav class="collapse show navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0" id="navbar-vertical">
                    <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link" data-toggle="dropdown">Dresses <i class="fa fa-angle-down float-right mt-1"></i></a>
                            <div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
                                <a href="" class="dropdown-item">Men's Dresses</a>
                                <a href="" class="dropdown-item">Women's Dresses</a>
                                <a href="" class="dropdown-item">Baby's Dresses</a>
                            </div>
                        </div>
                        <a href="" class="nav-item nav-link">Shirts</a>
                        <a href="" class="nav-item nav-link">Jeans</a>
                        <a href="" class="nav-item nav-link">Swimwear</a>
                        <a href="" class="nav-item nav-link">Sleepwear</a>
                        <a href="" class="nav-item nav-link">Sportswear</a>
                        <a href="" class="nav-item nav-link">Jumpsuits</a>
                        <a href="" class="nav-item nav-link">Blazers</a>
                        <a href="" class="nav-item nav-link">Jackets</a>
                        <a href="" class="nav-item nav-link">Shoes</a>
                    </div>
                </nav> -->
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
					</a> <a class="carousel-control-next" href="" data-slide="next">
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
					<h5 class="font-weight-semi-bold m-0">Quality Product</h5>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center border mb-4"
					style="padding: 30px;">
					<h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
					<h5 class="font-weight-semi-bold m-0">Free Shipping</h5>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center border mb-4"
					style="padding: 30px;">
					<h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
					<h5 class="font-weight-semi-bold m-0">14-Day Return</h5>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center border mb-4"
					style="padding: 30px;">
					<h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
					<h5 class="font-weight-semi-bold m-0">24/7 Support</h5>
				</div>
			</div>
		</div>
	</div>
	<!-- Featured End -->

	<!-- Categories Start -->
	<div class="container-fluid pt-5">
		<div class="row px-xl-5 pb-3">
			<div class="col-lg-4 col-md-6 pb-1">
				<div class="cat-item d-flex flex-column border mb-4"
					style="padding: 30px;">
					<p class="text-right">15 Products</p>
					<a href="" class="cat-img position-relative overflow-hidden mb-3">
						<img class="img-fluid" src="img/cat-1.jpg" alt="">
					</a>
					<h5 class="font-weight-semi-bold m-0">Men's dresses</h5>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 pb-1">
				<div class="cat-item d-flex flex-column border mb-4"
					style="padding: 30px;">
					<p class="text-right">15 Products</p>
					<a href="" class="cat-img position-relative overflow-hidden mb-3">
						<img class="img-fluid" src="img/cat-2.jpg" alt="">
					</a>
					<h5 class="font-weight-semi-bold m-0">Women's dresses</h5>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 pb-1">
				<div class="cat-item d-flex flex-column border mb-4"
					style="padding: 30px;">
					<p class="text-right">15 Products</p>
					<a href="" class="cat-img position-relative overflow-hidden mb-3">
						<img class="img-fluid" src="img/cat-3.jpg" alt="">
					</a>
					<h5 class="font-weight-semi-bold m-0">Baby's dresses</h5>
				</div>
			</div>
		</div>
	</div>
	<!-- Categories End -->

	<!-- Products Start -->
	<div class="container-fluid pt-5">
		<div class="text-center mb-4">
			<h2 class="section-title px-5">
				<span class="px-2">Trandy Products</span>
			</h2>
		</div>
		<div class="row px-xl-5 pb-3">
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="card product-item border-0 mb-4">
					<div
						class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
						<img class="img-fluid w-100" src="img/product-8.jpg" alt="">
					</div>
					<div
						class="card-body border-left border-right text-center p-0 pt-4 pb-3">
						<h6 class="text-truncate mb-3">Colorful Stylish Shirt</h6>
						<div class="d-flex justify-content-center">
							<h6>$123.00</h6>
							<h6 class="text-muted ml-2">
								<del>$123.00</del>
							</h6>
						</div>
					</div>
					<div
						class="card-footer d-flex justify-content-between bg-light border">
						<a href="" class="btn btn-sm text-dark p-0"><i
							class="fas fa-eye text-primary mr-1"></i>View Detail</a> <a href=""
							class="btn btn-sm text-dark p-0"><i
							class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
					</div>
				</div>
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
</body>

</html>