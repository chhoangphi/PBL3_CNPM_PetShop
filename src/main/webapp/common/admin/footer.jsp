<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!-- Footer Start -->
<div id="layoutSidenav">
	<div id="layoutSidenav_nav">
		<nav class="sb-sidenav accordion sb-sidenav-dark"
			id="sidenavAccordion">
			<div class="sb-sidenav-menu">
				<div class="nav">
					<div class="sb-sidenav-menu-heading">Core</div>
					<a class="nav-link" href="/petshop-5/trang-chu">
						<div class="sb-nav-link-icon">
							<i class="fas fa-tachometer-alt"></i>
						</div> Trang chủ
					</a>


					<c:forEach var="itemType" items="${dataItemType}">

						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapsePages" aria-expanded="false"
							aria-controls="collapsePages">
							<div class="sb-nav-link-icon">
								<i class="fas fa-book-open"></i>
							</div> Quản lý sản phẩm ${itemType.name}

							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapsePages"
							aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav accordion"
								id="sidenavAccordionPages">
								<c:forEach var="itemTypeOfCategory" items="${typeOfCategory}">
									<c:if test="${itemType.item_id==itemTypeOfCategory.item_id}">
										<a class="nav-link collapsed" href="#"
											data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth"
											aria-expanded="false" aria-controls="pagesCollapseAuth">
											${itemTypeOfCategory.type_name}
											<div class="sb-sidenav-collapse-arrow">
												<i class="fas fa-angle-down"></i>
											</div>
										</a>
										<div class="collapse" id="pagesCollapseAuth"
											aria-labelledby="headingOne"
											data-bs-parent="#sidenavAccordionPages">
											<nav class="sb-sidenav-menu-nested nav">
												<c:forEach var="itemCategory" items="${productCategory}">
													<c:if
														test="${itemCategory.type_id==itemTypeOfCategory.type_id}">
														<a class="nav-link"
															href="<c:url value="/admin/danh-sach-san-pham/the-loai/${itemCategory.product_categ_id}/1"/>">${itemCategory.product_categ_name}</a>
													</c:if>
												</c:forEach>
											</nav>
										</div>
									</c:if>
								</c:forEach>
							</nav>
						</div>


					</c:forEach>
					<div class="sb-sidenav-menu-heading">Addons</div>
					<a class="nav-link" href="/petshop-5/admin/quan-ly-don-hang/1">
						<div class="sb-nav-link-icon">
							<i class="fas fa-chart-area"></i>
						</div> Quản lý đơn hàng
					</a>

				</div>
			</div>
			<div class="sb-sidenav-footer">
				<div class="small">Logged in as:</div>
				${LoginInfo.userName}
			</div>
		</nav>
	</div>
</div>