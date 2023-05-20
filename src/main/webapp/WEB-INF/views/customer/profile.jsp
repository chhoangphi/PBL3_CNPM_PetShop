<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin-top: 20px;
	color: #1a202c;
	text-align: left;
}

.main-body {
	padding: 15px;
}

.nav-link {
	color: #4a5568;
}

h6 {
	padding: 6px;
}

.card {
	box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .1), 0 1px 2px 0
		rgba(0, 0, 0, .06);
}

.card {
	position: relative;
	display: flex;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 0 solid rgba(0, 0, 0, .125);
	border-radius: .25rem;
}

.card-body {
	flex: 1 1 auto;
	min-height: 1px;
	padding: 1rem;
}

.gutters-sm {
	margin-right: -8px;
	margin-left: -8px;
}

.gutters-sm>.col, .gutters-sm>[class*=col-] {
	padding-right: 8px;
	padding-left: 8px;
}

.mb-3, .my-3 {
	margin-bottom: 1rem !important;
}

.bg-gray-300 {
	background-color: #e2e8f0;
}

.h-100 {
	height: 100% !important;
}

.shadow-none {
	box-shadow: none !important;
}

input {
	margin: 15px;
	font-family: inherit;
	font-size: inherit;
	line-height: inherit;
}

.red {
	color: red
}

nav.order-status {
	padding: 10px;
}

nav.order-status ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	display: flex;
}

nav.order-status li {
	margin-right: 10px;
}

nav.order-status a {
	display: block;
	color: #333;
	padding: 15px;
	text-decoration: none;
}

nav.order-status a:hover {
	background-color: #ddd;
}

nav.order-status a.active {
	color: #E51F28;
}

.btn-view-order {
	background-color: #E51F28;
	border: none;
	margin-bottom: 10px;
	color: white;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	float: right;
	margin-top: 10px;
}

.btn-view-order:hover {
	background-color: #c94b50
}

nav.order-status li.active {
	border-bottom: 2px solid #E51F28;
	border-bottom-color: #E51F28;
}

.hKbGrP {
	margin: 20px 0 0;
	font-size: 18px;
	line-height: 1.4;
	color: rgba(0, 0, 0, .8);
}

.form-group .edit-link {
	display: inline-block;
	float: right;
	margin-left: 10px; /* tùy chỉnh khoảng cách giữa input và a */
}
</style>
</head>
<body>
	<div class="container">

		<!-- Breadcrumb -->
		<nav aria-label="breadcrumb" class="main-breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index.html">Trang chủ</a></li>
				<li class="breadcrumb-item active" aria-current="page">Chỉnh
					sửa tài khoản</li>
			</ol>
		</nav>
		<!-- /Breadcrumb -->

		<div class="row gutters-sm">
			<div class="col-md-4 d-none d-md-block">
				<div class="card">
					<div class="card-body">
						<nav class="nav flex-column nav-pills nav-gap-y-1">
							<a href='<c:url value="/thong-tin-ca-nhan"/>'
								class="nav-item nav-link has-icon nav-link-faded ${page=='personalInfopage' ? 'active' : ''}">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-user mr-2">
									<path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
									<circle cx="12" cy="7" r="4"></circle></svg>Thông tin cá nhân
							</a> <a href='<c:url value="/tai-khoan-va-bao-mat"/>'
								class="nav-item nav-link has-icon nav-link-faded ${page=='accountpage' ? 'active' : ''}">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-settings mr-2">
									<circle cx="12" cy="12" r="3"></circle>
									<path
										d="M19.4 15a1.65 1.65 0 0 0 .33 1.82l.06.06a2 2 0 0 1 0 2.83 2 2 0 0 1-2.83 0l-.06-.06a1.65 1.65 0 0 0-1.82-.33 1.65 1.65 0 0 0-1 1.51V21a2 2 0 0 1-2 2 2 2 0 0 1-2-2v-.09A1.65 1.65 0 0 0 9 19.4a1.65 1.65 0 0 0-1.82.33l-.06.06a2 2 0 0 1-2.83 0 2 2 0 0 1 0-2.83l.06-.06a1.65 1.65 0 0 0 .33-1.82 1.65 1.65 0 0 0-1.51-1H3a2 2 0 0 1-2-2 2 2 0 0 1 2-2h.09A1.65 1.65 0 0 0 4.6 9a1.65 1.65 0 0 0-.33-1.82l-.06-.06a2 2 0 0 1 0-2.83 2 2 0 0 1 2.83 0l.06.06a1.65 1.65 0 0 0 1.82.33H9a1.65 1.65 0 0 0 1-1.51V3a2 2 0 0 1 2-2 2 2 0 0 1 2 2v.09a1.65 1.65 0 0 0 1 1.51 1.65 1.65 0 0 0 1.82-.33l.06-.06a2 2 0 0 1 2.83 0 2 2 0 0 1 0 2.83l-.06.06a1.65 1.65 0 0 0-.33 1.82V9a1.65 1.65 0 0 0 1.51 1H21a2 2 0 0 1 2 2 2 2 0 0 1-2 2h-.09a1.65 1.65 0 0 0-1.51 1z"></path></svg>Tài
								khoản và bảo mât
							</a> <a href='<c:url value="/don-hang/pending"/>'
								class="nav-item nav-link has-icon nav-link-faded ${page=='orderpage' ? 'active' : ''}">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-credit-card mr-2">
									<rect x="1" y="4" width="22" height="16" rx="2" ry="2"></rect>
									<line x1="1" y1="10" x2="23" y2="10"></line></svg>Đơn hàng của tôi
							</a>
						</nav>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<div class="card">
					<div class="card-body tab-content">
						<c:if test="${page=='personalInfopage'}">
							<div class="tab-pane active" id="profile">
								<h6>Thông tin cá nhân</h6>
								<hr>
								<span class="red">${changeStatus}</span>
								<form:form action="thong-tin-ca-nhan" method="post"
									modelAttribute="personalInfo">
									<div class="form-group">
										<label for="fullName">Họ và tên</label>
										<form:input type="text" class="form-control" path="fullName"
											required="required"></form:input>

									</div>
									<div class="form-group">
										<label for="email">Địa chỉ Email</label>
										<form:input type="text" class="form-control" path="email"
											required="required"></form:input>

									</div>
									<div class="form-group">
										<label for="phoneNumber">Số điện thoại</label>
										<form:input type="text" class="form-control"
											path="phoneNumber" required="required"></form:input>
									</div>
									<input class="btn btn-primary form-control" type="submit"
										value="Lưu thay đổi" name="submit" id="submit" />
								</form:form>
							</div>
						</c:if>
						<c:if test="${page=='accountpage'}">
							<div class="tab-pane active" id="account">
								<h6>Tài khoản và bảo mật</h6>
								<hr>
								<form action="tai-khoan-va-bao-mat" method="post">
									<div class="form-group">
										<label for="username">Tên đăng nhập</label> <input type="text"
											class="form-control" id="username"
											value="${account.username}" readonly>
									</div>
									<hr>


									<div class="form-group">
										<label class="d-block">Thay đổi mật khẩu</label> <span
											class="red">${changeStatus}</span> <input id="oldPassword"
											placeholder="Nhập mật khẩu cũ" class="form-control"
											type="password" name="oldPassword" required="required"
											autocomplete="new-password"> <input id="newPassword"
											placeholder="Nhập mật khẩu mới" class="form-control"
											type="password" name="newPassword" onkeyup="kiemTraMatKhau()"
											required="required"> <input id="confirmPassword"
											placeholder="Xác nhận mật khẩu cũ" class="form-control"
											type="password" onkeyup="kiemTraMatKhau()"
											required="required"> <span id="msg" class="red"></span>
									</div>
									<input class="btn btn-primary form-control" type="submit"
										value="Lưu mật khẩu" name="submit" id="submit" />
									<hr>

								</form>
							</div>
						</c:if>
						<c:if test="${page=='orderpage'}">
							<div class="tab-pane active" id="billing">
								<h6>Quản lý đơn hàng</h6>
								<nav class="order-status">
									<ul>
										<li class="${status=='all' ? 'active' : ''}"><a
											href='<c:url value="/don-hang/all"/>'
											class="${status=='all' ? 'active' : ''}">Tất cả</a></li>
										<li class="${status=='pending' ? 'active' : ''}"><a
											href='<c:url value="/don-hang/pending"/>'
											class="${status=='pending' ? 'active' : ''}">Chờ xác nhận</a></li>
										<li class="${status=='to_ship' ? 'active' : ''}"><a
											href='<c:url value="/don-hang/to_ship"/>'
											class="${status=='to_ship' ? 'active' : ''}">Chờ lấy hàng</a></li>
										<li class="${status=='to_receive' ? 'active' : ''}"><a
											href='<c:url value="/don-hang/to_receive"/>'
											class="${status=='to_receive' ? 'active' : ''}">Đang giao</a></li>
										<li class="${status=='completed' ? 'active' : ''}"><a
											href='<c:url value="/don-hang/completed"/>'
											class="${status=='completed' ? 'active' : ''}">Đã giao</a></li>
										<li class="${status=='canceled' ? 'active' : ''}"><a
											href='<c:url value="/don-hang/canceled"/>'
											class="${status=='canceled' ? 'active' : ''}">Đã hủy</a></li>
									</ul>
								</nav>
								<hr>
								<form>
									<div class="form-group">
										<c:if test="${empty dataOrder}">
											<div class="hKbGrP">Chưa có đơn hàng</div>
										</c:if>
										<c:if test="${not empty Order && status != 'all'}">
											<c:forEach var="order" items="${Order}">
												<div class="card mb-4">

													<div class="card-body">
														<div class="mb-3 d-flex justify-content-between">
															<div>
																<span class="me-3">Trạng thái</span> <span
																	class="badge rounded-pill bg-info">${status=='pending' ? 'Chờ xác nhận' : ((status=='to_ship') ? 'Chờ lấy hàng ' : (status=='to_receive')  ?  'Đang giao hàng' : (status=='completed') ? 'Đã giao' : 'Đã hủy')}</span>
															</div>
														</div>
														<table class="table table-borderless">
															<tbody>
																<c:forEach var="item" items="${order.orderDetailList}">
																	<tr>
																		<td>
																			<div class="d-flex mb-2">
																				<div class="flex-shrink-0">
																					<img src="${item.product.img}" alt="" width="35"
																						class="img-fluid">
																				</div>
																				<div class="flex-lg-grow-1 ms-3">
																					<h6 class="small mb-0">
																						<a href="#" class="text-reset">${item.product_name}</a>
																					</h6>
																					<span class="small">Số lượng:
																						${item.quantity}</span>
																				</div>
																			</div>
																		</td>
																		<td></td>
																		<td class="text-end">${item.price}đ</td>
																	</tr>
																</c:forEach>
															</tbody>
															<tfoot>

																<tr class="fw-bold">
																	<td colspan="2">Thành tiền</td>
																	<td class="text-end">${order.totalPrice}đ</td>
																</tr>
															</tfoot>
														</table>


													</div>
													<a
														href='<c:url value="/chi-tiet-don-hang/${order.orderId}"/>'><span
														class="btn-view-order">Xem chi tiết</span></a>
												</div>
											</c:forEach>
										</c:if>
										<c:if test="${not empty dataOrder && status == 'all'}">
											<c:forEach var="order" items="${dataOrder}">
												<div class="card mb-4">													
														<div class="card-body">
														<div class="mb-3 d-flex justify-content-between">
															<div>
																<span class="me-3">Trạng thái</span> <span
																	class="badge rounded-pill bg-info">${order.status}</span>
															</div>
														</div>
															<table class="table table-borderless">
																<tbody>
																	<c:forEach var="item"
																		items="${order.orderDetailList}">
																		<tr>
																			<td>
																				<div class="d-flex mb-2">
																					<div class="flex-shrink-0">
																						<img src="${item.product.img}" alt="" width="35"
																							class="img-fluid">
																					</div>
																					<div class="flex-lg-grow-1 ms-3">
																						<h6 class="small mb-0">
																							<a href="#" class="text-reset">${item.product_name}</a>
																						</h6>
																						<span class="small">Số lượng:
																							${item.quantity}</span>
																					</div>
																				</div>
																			</td>
																			<td></td>
																			<td class="text-end">${item.price}đ</td>
																		</tr>
																	</c:forEach>
																</tbody>
																<tfoot>

																	<tr class="fw-bold">
																		<td colspan="2">Thành tiền</td>
																		<td class="text-end">${order.totalPrice}đ</td>
																	</tr>
																</tfoot>
															</table>


														</div>

													
													<a
														href='<c:url value="/chi-tiet-don-hang/${order.orderId}"/>'><span
														class="btn-view-order">Xem chi tiết</span></a>
												</div>
											</c:forEach>
										</c:if>
									</div>

								</form>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>