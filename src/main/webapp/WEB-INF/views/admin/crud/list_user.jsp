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
	href="https://fonts.googleapis.com/icon?family=Material+Icons"><link rel="stylesheet"
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
	margin: 30px;
	border-radius: 3px;
	min-width: 1000px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
	padding-left: 150px;
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

.red {
	color: red;
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
<%
String username = request.getAttribute("username") + "";
username = (username.equals("null")) ? "" : username;
String fullName = request.getAttribute("fullName") + "";
fullName = (fullName.equals("null")) ? "" : fullName;

String gender = request.getAttribute("gender") + "";
gender = (gender.equals("null")) ? "" : gender;

String dateofbirth = request.getAttribute("dateofbirth") + "";
dateofbirth = (dateofbirth.equals("null")) ? "" : dateofbirth;

String phonenumber = request.getAttribute("phonenumber") + "";
phonenumber = (phonenumber.equals("null")) ? "" : phonenumber;

String email = request.getAttribute("email") + "";
email = (email.equals("null")) ? "" : email;
%>
<body>
	<div class="container-xl">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-6">
						<c:if test="${param.code=='user'}">
							<h2>
								Quản lý tài khoản <b>Người dùng</b>
							</h2>
						</c:if>
						<c:if test="${param.code=='admin'}">
							<h2>
								Quản lý tài khoản <b>Admin</b>
							</h2>
						</c:if>
						</div>
						<div class="col-sm-6">
							<a href="#addEmployeeModal" class="btn btn-success"
								data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add
									New User</span></a> 
						</div>
					</div>
				</div>
				<nav class="order-status">
									<ul>
										<li class="${param.stt=='all' ? 'active' : ''}"><a
											href='<c:url value="/admin/quan-ly-tai-khoan?code=${param.code}&currentPage=1&stt=all"/>'
											class="">Tất cả</a></li>
										<li class="${param.stt=='active' ? 'active' : ''}"><a
											href='<c:url value="/admin/quan-ly-tai-khoan?code=${param.code}&currentPage=1&stt=active"/>'
											class="">Hoạt động</a></li>
										<li class="${param.stt=='inactive' ? 'active' : ''}"><a
											href='<c:url value="/admin/quan-ly-tai-khoan?code=${param.code}&currentPage=1&stt=inactive"/>'
											class="">Bị khóa</a></li>
									</ul>
				</nav>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th><span class="custom-checkbox"> <input
									type="checkbox" id="selectAll"> <label for="selectAll"></label>
							</span></th>
							<th>Username</th>
							<th>Fullname</th>
							<th>Gender</th>
							<th>Date Of Birth</th>
							<th>Phone Number</th>
							<th>Action</th>
							
						</tr>
					</thead>
					<c:if test="${abc==1}"> 
  				<span id="notify" style="color: red">Xóa tài khoản thành công</span>
  				 </c:if>
  				 <c:if test="${update==1}"> 
  				<span id="notify" style="color: red">Cập nhật tài khoản thành công</span>
  				 </c:if>
  				 <c:if test="${addaccount!=null}"> 
  				<span id="notify" style="color: red">${addaccount}</span>
  				 </c:if>
					<tbody>
						 <c:forEach var="item" items="${userPaginate}">
							<tr>
								<td><span class="custom-checkbox"> <input
										type="checkbox" id="checkbox1" name="options[]" value="1">
										<label for="checkbox1"></label>
								</span></td>
								<td>${item.username}</td>
								<td>${item.fullName}</td>
								<td>${item.gender}</td>
 								<td>${item.dateOfBirth}</td>
 								<td>${item.phoneNumber}</td>
 								<td> <a
									href="<c:url value="/admin/cap-nhat-tai-khoan/${item.username }"/>"
									class="edit" title="Edit" data-toggle="tooltip"><i
										class="material-icons">&#xE254;</i></a> <a
     									class="delete" title="Delete" data-toggle="tooltip" onclick="confirmCancel('${item.username}')"><i
										class="material-icons">&#xE872;</i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<div class="clearfix">
					<ul class="pagination">
					<c:forEach var="item" begin="1" end="${pageinfo.totalPage}" varStatus ="loop">
					<c:if test="${loop.index==pageinfo.currentPage}">
						<li class="page-item active"><a href="<c:url value="/admin/quan-ly-tai-khoan?code=${param.code}&currentPage=${loop.index}&stt=${param.stt}"/>" class="page-link">${loop.index }</a></li>
						</c:if>
						<c:if test="${loop.index!=pageinfo.currentPage}">
						<li class="page-item"><a href="<c:url value="/admin/quan-ly-tai-khoan?code=${param.code}&currentPage=${loop.index}&stt=${param.stt}"/>" class="page-link">${loop.index }</a></li>
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
				<form:form action="/petshop-5/admin/them-tai-khoan" method="POST"
					modelAttribute="user">
					<div class="modal-header">
						<h4 class="modal-title">Add User</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">


						<div class="form-group">
							<form:label path="username">Username</form:label>
							<form:input type="text" class="form-control" path="username"
								id="username" name="username" required="required"
								value="<%=username%>" />

						</div>
						<div class="mb-3">
							<label for="gender" class="form-label">Role</label> <select class="form-control"
								id="roleId" name="roleId">
									<option value="0" label="Admin &#9660;" ></option>
									<option value="1" label="User &#9660;" />
							</select>
						</div>
						<div class="form-group">
							<form:label path="password">Password</form:label>
							<form:input type="password" class="form-control" path="password" />
						</div>
						<div class="form-group">
							<form:label path="fullName">Fullname</form:label>
							<form:input type="text" class="form-control" path="fullName"
								id="fullName" name="fullName" required="required"
								value="<%=fullName%>" />
						</div>
						<div class="form-group">
							<form:label path="email">Email</form:label>
							<form:input type="text" class="form-control" path="email"
								id="email" name="email" required="required" value="<%=email%>" />
						</div>
						<div class="form-group">
							<form:label path="dateOfBirth">Date Of Birth</form:label>
							<form:input type="date" class="form-control" path="dateOfBirth"
								id="dateOfBirth" name="dateOfBirth" required="required"
								value="<%=dateofbirth%>" />
						</div>
						<div class="form-group">
							<form:label path="phoneNumber">Phone Number</form:label>
							<form:input type="text" class="form-control" path="phoneNumber"
								id="phonenumber" name="phonenumber" required="required"
								value="<%=phonenumber%>" />
						</div>
						<div class="mb-3">
							<label for="gender" class="form-label">Gender</label> <select class="form-control"
								id="gender" name="gender">
									<option value="Nam" label="Nam &#9660;" />
									<option value="Nữ" label="Nữ &#9660;" />
									<option value="Khác" label="Khác &#9660;" />
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
				<form:form action="/petshop-5/admin/chinh-sua-tai-khoan"
					method="POST" modelAttribute="user">
					<div class="modal-header">
						<h4 class="modal-title">Edit User</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<form:label path="username">Username</form:label>
							<form:input type="text" class="form-control" path="username" />
						</div>
						<div class="form-group">
							<form:label path="password">Password</form:label>
							<form:input type="password" class="form-control" path="password" />
						</div>
						<div class="form-group">
							<form:label path="fullName">Fullname</form:label>
							<form:input type="text" class="form-control" path="fullName" />
						</div>
						<div class="form-group">
							<form:label path="email">Email</form:label>
							<form:input type="email" class="form-control" path="email" />
						</div>
						<div class="form-group">
							<form:label path="dateOfBirth">Date Of Birth</form:label>
							<form:input type="text" class="form-control" path="dateOfBirth" />
						</div>
						<div class="form-group">
							<form:label path="phoneNumber">Phone Number</form:label>
							<form:input type="text" class="form-control" path="phoneNumber" />
						</div>
						<div class="mb-3">
							<label for="gender" class="form-label">Gender</label> <select class="form-control"
								id="gender" name="gender">
									<option value="Nam" label="Nam" />
									<option value="Nữ" label="Nữ" />
									<option value="Khác" label="Khác" />
							</select>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-success" value="Update">
					</div>
				</form:form>
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
	   function confirmCancel(username){
		   if (confirm("Xác nhận xóa tài khoản")){
			    window.location.href = "/petshop-5/admin/xoa-tai-khoan/" + username;
				document.getElementById("msg").innerHTML = "Xóa thành công";	 
		   }
	   }
</script>
</body>
</html>