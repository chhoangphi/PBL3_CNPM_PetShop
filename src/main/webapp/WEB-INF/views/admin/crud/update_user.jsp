
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Update user</title>


<style>
.red {
	color: red;
}
.col-sm-12
{
margin: 70px;
padding-left: 150px;
padding-right:150px;
}
</style>
</head>
<body>

	</hr>
	<div class="container" >
		<form:form class="form"
			action="/petshop-5/admin/cap-nhat-tai-khoan/${username}"
			method="POST" modelAttribute="user">
			<div class="row">

				<div class="col-sm-12">
					<div class="text-center">
						<h3>UPDATE USER</h3>
					</div>
				 	<div class="mb-3">
						<label for="fullName" class="form-label">Full Name</label> <input
							type="text" class="form-control" id="fullName"
							name="fullName">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password</label> <input
							type="password" class="form-control" id="password"
							name="password">
					</div>
					<div class="mb-3">
						<label for="dateofbirth" class="form-label">Date Of Birth</label> <input
							type="date" class="form-control" id="dateofbirth"
							name="dateofbirth">
					</div>
					<div class="mb-3">
						<label for="phonenumber" class="form-label">Phone Number</label> <input
							type="text" class="form-control" id="phonenumber"
							name="phonenumber">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email"
							name="email">
					</div>
					<hr />
					<div class="mb-3">
						<label for="gender" class="form-label">Gender</label>
						<select class="form-control" id="gender"
							name="gender" >
								<option value="Nam" label="Nam"/>
								<option value="Nữ" label="Nữ"/>
								<option value="Khác" label="Khác"/>
					
						</select>
					</div>
					<input class="btn btn-primary form-control" type="submit"
						value="Cập nhật" name="submit" id="submit" />
				</div>



			</div>
		</form:form>
	</div>
</body>

</html>