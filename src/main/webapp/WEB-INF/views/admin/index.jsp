<%@ page language="java" contentType="text/html; charset=UTF-8"

	 pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        
    </head>
    <style>
    .v-detail{
    padding:30px;
    }
    </style>
    <body class="sb-nav-fixed">
        
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Dữ liệu bán hàng</h1>
                        <h2 class="mt-4">Tháng ${currentMonth}/${currentYear}</h2>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">Tổng doanh thu</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <div class="small text-yellow stretched-link">${totalPriceInMonth}đ</div>
                                        
                                    </div>
                                </div>
                            </div>
                       
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">Số đơn hàng: ${totalOrderInMonth}</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="<c:url value="/admin/quan-ly-don-hang/all/1?year=${currentYear}&month=${currentMonth}"/>">Xem chi tiết</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                Dữ liệu bán hàng trong năm 2023
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                       		<th>Tháng</th>
                                            <th>Tổng doanh thu</th>
                                            <th>Số đơn hàng</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${dataOrder}">                               
                                         <tr>
                                            <td>${item.monthOfOrder}/2023</td>
                                            <td>${item.totalPriceOfMonth}</td>
                                     		<td>${item.totalOrderOfMonth}<a class="v-detail" href="<c:url value="/admin/quan-ly-don-hang/all/1?year=2023&month=${item.monthOfOrder}"/>"> Xem chi tiết</a></td>
                                        </tr>
                                       </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card mb-4">
					<div class="card-header">
							<i class="fas fa-table me-1"></i> Lịch sử hoạt động trong năm 2023
						</div>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Tháng</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="item" items="${monthOfActivity}">
								<tr>
									<td>${item}/2023</td>
									<td><a class="v-detail"
												href="<c:url value="/admin/quan-ly-hoat-dong/1?year=2023&month=${item}"/>">
													Xem chi tiết</a></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
                    </div>
                </main>
            </div>
        </div>
	<c:forEach var="itemType" items="${dataItemType}">
		<div id="addItemType${itemType.item_id }" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form
						action="/petshop-5/admin/them-dong-san-pham/${itemType.item_id}"
						method="POST">

						<div class="modal-header">
							<h4 class="modal-title">Thêm dòng sản phẩm cho
								${itemType.name}</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">


							<div class="form-group">
								<label>Tên dòng sản phẩm <label> <input
										type="text" class="form-control" id="typeOfCategoryName"
										name="typeOfCategoryName" required="required" value="" />
							</div>
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="Cancel"> <input type="submit"
								class="btn btn-success" value="Add">
						</div>
					</form>
				</div>
			</div>
		</div>
	</c:forEach>
	<c:forEach var="itemTypeOfCategory" items="${typeOfCategory}">
		<div id="addTypeOfCategory${itemTypeOfCategory.type_id }"
			class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form
						action="/petshop-5/admin/them-loai-san-pham/${itemTypeOfCategory.type_id }"
						method="POST">

						<div class="modal-header">
							<h4 class="modal-title">Thêm ${itemTypeOfCategory.type_name }</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">


							<div class="form-group">
								<label>Tên loại sản phẩm <label> <input
										type="text" class="form-control" id="productCategoryName"
										name="productCategoryName" required="required" value="" />
							</div>

						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="Cancel"> <input type="submit"
								class="btn btn-success" value="Add">
						</div>
					</form>
				</div>
			</div>
		</div>
	</c:forEach>
	
	<div id="addShop" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="/petshop-5/admin/them-shop" method="POST">

					<div class="modal-header">
						<h4 class="modal-title">Thêm shop mới</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">


						<div class="form-group">
							<label>Tên shop <label> <input type="text"
									class="form-control" id="shopName" name="shopName"
									required="required" value="" />
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>

</html>
