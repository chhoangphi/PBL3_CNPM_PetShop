<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="VI">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title></title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
	color: #566787;
	background: #f5f5f5;
	font-family: 'Varela Round', sans-serif;
	font-size: 13px;
}

.table-responsive {
	margin: 30px 0;
}

.table-wrapper {
	background: #fff;
	padding: 20px 25px;
	margin:30px;
	border-radius: 3px;
	min-width: 1000px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
	padding-left:150px;
}

.table-title {
	padding-bottom: 15px;
	background: #435d7d;
	color: #fff;
	padding: 16px 30px;
	min-width: 100%;
	margin: -20px -25px 10px;
	border-radius: 3px 3px 0 0;
}

.table-title h2 {
	margin: 5px 0 0;
	font-size: 24px;
}

.table-title .btn-group {
	float: right;
}

.table-title .btn {
	color: #fff;
	float: right;
	font-size: 13px;
	border: none;
	min-width: 50px;
	border-radius: 2px;
	border: none;
	outline: none !important;
	margin-left: 10px;
}

.table-title .btn i {
	float: left;
	font-size: 21px;
	margin-right: 5px;
}

.table-title .btn span {
	float: left;
	margin-top: 2px;
}

table.table tr th, table.table tr td {
	border-color: #e9e9e9;
	padding: 12px 15px;
	vertical-align: middle;
}

table.table tr th:first-child {
	width: 60px;
}

table.table tr th:last-child {
	width: 100px;
}

table.table-striped tbody tr:nth-of-type(odd) {
	background-color: #fcfcfc;
}

table.table-striped.table-hover tbody tr:hover {
	background: #f5f5f5;
}

table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

table.table td:last-child i {
	opacity: 0.9;
	font-size: 22px;
	margin: 0 5px;
}

table.table td a {
	font-weight: bold;
	color: #566787;
	display: inline-block;
	text-decoration: none;
	outline: none !important;
}

table.table td a:hover {
	color: #2196F3;
}

table.table td a.edit {
	color: #FFC107;
}

table.table td a.delete {
	color: #F44336;
}

table.table td i {
	font-size: 19px;
}

table.table .avatar {
	border-radius: 50%;
	vertical-align: middle;
	margin-right: 10px;
}

.pagination {
	float: right;
	margin: 0 0 5px;
}

.pagination li a {
	border: none;
	font-size: 13px;
	min-width: 30px;
	min-height: 30px;
	color: #999;
	margin: 0 2px;
	line-height: 30px;
	border-radius: 2px !important;
	text-align: center;
	padding: 0 6px;
}

.pagination li a:hover {
	color: #666;
}

.pagination li.active a, .pagination li.active a.page-link {
	background: #03A9F4;
}

.pagination li.active a:hover {
	background: #0397d6;
}

.pagination li.disabled i {
	color: #ccc;
}

.pagination li i {
	font-size: 16px;
	padding-top: 6px
}

.hint-text {
	float: left;
	margin-top: 10px;
	font-size: 13px;
}
/* Custom checkbox */
.custom-checkbox {
	position: relative;
}

.custom-checkbox input[type="checkbox"] {
	opacity: 0;
	position: absolute;
	margin: 5px 0 0 3px;
	z-index: 9;
}

.custom-checkbox label:before {
	width: 18px;
	height: 18px;
}

.custom-checkbox label:before {
	content: '';
	margin-right: 10px;
	display: inline-block;
	vertical-align: text-top;
	background: white;
	border: 1px solid #bbb;
	border-radius: 2px;
	box-sizing: border-box;
	z-index: 2;
}

.custom-checkbox input[type="checkbox"]:checked+label:after {
	content: '';
	position: absolute;
	left: 6px;
	top: 3px;
	width: 6px;
	height: 11px;
	border: solid #000;
	border-width: 0 3px 3px 0;
	transform: inherit;
	z-index: 3;
	transform: rotateZ(45deg);
}

.custom-checkbox input[type="checkbox"]:checked+label:before {
	border-color: #03A9F4;
	background: #03A9F4;
}

.custom-checkbox input[type="checkbox"]:checked+label:after {
	border-color: #fff;
}

.custom-checkbox input[type="checkbox"]:disabled+label:before {
	color: #b8b8b8;
	cursor: auto;
	box-shadow: none;
	background: #ddd;
}
/* Modal styles */
.modal .modal-dialog {
	max-width: 400px;
}

.modal .modal-header, .modal .modal-body, .modal .modal-footer {
	padding: 20px 30px;
}

.modal .modal-content {
	border-radius: 3px;
	font-size: 14px;
}

.modal .modal-footer {
	background: #ecf0f1;
	border-radius: 0 0 3px 3px;
}

.modal .modal-title {
	display: inline-block;
}

.modal .form-control {
	border-radius: 2px;
	box-shadow: none;
	border-color: #dddddd;
}

.modal textarea.form-control {
	resize: vertical;
}

.modal .btn {
	border-radius: 2px;
	min-width: 100px;
}

.modal form label {
	font-weight: normal;
}
nav.order-status li.active {
	border-bottom: 2px solid #E51F28;
	border-bottom-color: #E51F28;
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

</style>
</head>
<body>
	<div class="container-xl">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-6">
							  <h2>
								${productCateg.product_categ_name}
							</h2> 
						</div>
						<div class="col-sm-6">
							<a href="#addEmployeeModal" class="btn btn-success"
								data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add
									New Product</span></a> <a href="#deleteEmployeeModal"
								class="btn btn-danger" data-toggle="modal"><i
								class="material-icons">&#xE15C;</i> <span>Delete</span></a>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th><span class="custom-checkbox"> <input
									type="checkbox" id="selectAll"> <label for="selectAll"></label>
							</span></th>
							<th>Product ID</th>
							<th>Product Name</th>
							<th>Product Price</th>
							<th>Product CategoryID</th>
							<th>Actions</th>
						</tr>
					</thead>
					<nav class="order-status">
									<ul>
										<li class="${param.stt=='all' ? 'active' : ''}"><a
											href='<c:url value="/admin/danh-sach-san-pham/${productCateg.product_categ_id}/1?stt=all"/>'
											class="">Tất cả</a></li>
										<li class="${param.stt=='active' ? 'active' : ''}"><a
											href='<c:url value="/admin/danh-sach-san-pham/${productCateg.product_categ_id}/1?stt=active"/>'
											class="">Kích hoạt</a></li>
										<li class="${param.stt=='inactive' ? 'active' : ''}"><a
											href='<c:url value="/admin/danh-sach-san-pham/${productCateg.product_categ_id}/1?stt=inactive"/>'
											class="">Vô hiệu hóa</a></li>
									</ul>
				</nav>
					<c:if test="${abc==1}"> 
  				<span id="notify" style="color: red">Xóa tài sản phẩm thành công</span>
  				 </c:if>
  				 <c:if test="${update==1}"> 
  				<span id="notify" style="color: red">Cập nhật thông tin sản phẩm thành công</span>
  				 </c:if>
  				 <c:if test="${addproduct==1}"> 
  				<span id="notify" style="color: red">Thêm sản phẩm thành công</span>
  				 </c:if>
					<tbody>
						 <c:forEach var="products" items="${ProductPaginate}">
							<tr>
								<td><span class="custom-checkbox"> <input
										type="checkbox" id="checkbox1" name="options[]" value="1">
										<label for="checkbox1"></label>
								</span></td>
								<td>${products.product_id}</td>
								<td>${products.product_name}</td>
								<td>${products.price}</td>
 								<td>${products.product_categ_id}</td>
 								<td><a
									href="<c:url value="/chi-tiet-san-pham/${products.product_id}"/>"
									class="view" title="View" data-toggle="tooltip"><i
										class="material-icons">&#xE417;</i></a> <a
									href="<c:url value="/admin/chinh-sua-thong-tin-san-pham/${products.product_id}"/>"
									class="edit" title="Edit" data-toggle="tooltip"><i
										class="material-icons">&#xE254;</i></a> <a
									onclick="confirmCancel('${products.product_id}')" class="delete" title="Delete" data-toggle="tooltip"><i
										class="material-icons">&#xE872;</i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="clearfix">
					<ul class="pagination">
					<c:forEach var="item"  begin="1" end="${pageinfo.totalPage}" varStatus ="loop">
					<c:if test="${loop.index==pageinfo.currentPage}">
						<li class="page-item active"><a href="<c:url value="/admin/danh-sach-san-pham/${product_categ_id}/${loop.index}?stt=${param.stt}"/>" class="page-link">${loop.index }</a></li>
						</c:if>
						<c:if test="${loop.index!=pageinfo.currentPage}">
						<li class="page-item"><a href="<c:url value="/admin/danh-sach-san-pham/${product_cate_id}/${loop.index}?stt=${param.stt}"/>" class="page-link">${loop.index }</a></li>
						</c:if>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				 <form:form action="/petshop-5/admin/them-san-pham" method="POST"
					modelAttribute="product">
					<div class="modal-header">
						<h4 class="modal-title">Add Product</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
					<div class="form-group">
							<form:label path="product_name">Product Name</form:label>
							<form:input type="text" class="form-control" path="product_name" />
						</div>
						<div class="form-group">
							<label for="status" class="form-label">Status</label>
							<select class="form-control"
								id="status" name="status">
								<option value="1" label="Active &#9660;" />
								<option value="0" label="Inactive &#9660;" />
							</select>
						</div>
						<div class="form-group">
							<form:label path="img">Product Image URL</form:label>
							<form:input type="text" class="form-control" path="img" />
						</div>
						<div class="form-group">
							<form:label path="price">Product Price</form:label>
							<form:input type="text" class="form-control" path="price" />
						</div>
						<div class="form-group">
							<form:label path="description">Product Description</form:label>
							<form:input type="text" class="form-control" path="description" />
						</div>
						<div class="mb-3">
							<label for="product_categ_name" class="form-label">Product
								Category Name</label> <select class="form-control"
								id="product_categ_name" name="product_categ_name">
<%-- 								<c:forEach var="item" items="${productCategory1}">
 --%>									<option value="${categoryName}" label="${categoryName}" />
								<%-- </c:forEach> --%>
							</select>
						</div>
						</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-success" value="Add">
					</div>
				</form:form> 
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="editEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">
						<h4 class="modal-title">Edit Product</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Name</label> <input type="text" class="form-control"
								required>
						</div>
						<div class="form-group">
							<label>Email</label> <input type="email" class="form-control"
								required>
						</div>
						<div class="form-group">
							<label>Address</label>
							<textarea class="form-control" required></textarea>
						</div>
						<div class="form-group">
							<label>Phone</label> <input type="text" class="form-control"
								required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit" class="btn btn-info"
							value="Save">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Delete Modal HTML -->
	<div id="deleteEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">
						<h4 class="modal-title">Delete Product</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<p>Are you sure you want to delete these Records?</p>
						<p class="text-warning">
							<small>This action cannot be undone.</small>
						</p>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-danger" value="Delete">
					</div>
				</form>
			</div>
		</div>
	</div>

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
	<script>
	$(document).ready(function() {
		// Activate tooltip
		$('[data-toggle="tooltip"]').tooltip();

		// Select/Deselect checkboxes
		var checkbox = $('table tbody input[type="checkbox"]');
		$("#selectAll").click(function() {
			if (this.checked) {
				checkbox.each(function() {
					this.checked = true;
				});
			} else {
				checkbox.each(function() {
					this.checked = false;
				});
			}
		});
		checkbox.click(function() {
			if (!this.checked) {
				$("#selectAll").prop("checked", false);
			}
		});
	});
	function confirmCancel(product_id){
		   if (confirm("Xác nhận xóa tài khoản")){
			    window.location.href = "/petshop-5/admin/xoa-san-pham/" + product_id;
				document.getElementById("msg").innerHTML = "Xóa thành công";	 
		   }
	   }
</script>
</body>
</html>