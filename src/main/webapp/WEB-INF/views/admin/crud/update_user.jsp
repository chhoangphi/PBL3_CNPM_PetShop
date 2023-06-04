
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
						<h3 style="display: inline-block;">UPDATE USER</h3>
 						<a href="<c:url value="/admin/quan-ly-tai-khoan"/>"> <button style="display: inline-block;float:right;">Cancel</button></a>
					</div>
					<div class="mb-3">
						<label for="username" class="form-label">User Name</label>
						<form:input type="text" class="form-control" path="username" readonly="true"></form:input>
					</div>
				 	<div class="mb-3">
						<label for="fullName" class="form-label">Full Name</label>
						<form:input type="text" class="form-control" path="fullName"></form:input>
					</div>
					<div class="mb-3">
						<label for="status" class="form-label">Status</label>
						<select class="form-control"
								id="status" name="status">
									<option value="1" label="Hoạt động &#9660" ${user.status=='1' ? 'selected' : ''} />
									<option value="0" label="Khóa &#9660" ${user.status=='0' ? 'selected' : ''}/>
						</select>
					</div>
					<div class="mb-3">
						<label for="dateofbirth" class="form-label">Date Of Birth</label>
							<form:input type="date" class="form-control" path="dateOfBirth" readonly="true"/>
					</div>
					<div class="mb-3">
						<label for="phonenumber" class="form-label">Phone Number</label>
							<form:input type="text" class="form-control" path="phoneNumber"/>
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label>
							<form:input type="text" class="form-control" path="email"/>
					</div>
					<hr />
					<div class="mb-3">
						<label for="gender" class="form-label">Gender</label>
						<form:input type="text" class="form-control" path="gender" readonly="true"/>
					</div>
					<input class="btn btn-primary form-control" type="submit"
						value="Cập nhật" name="submit" id="submit" />
				</div>



			</div>
		</form:form>
	</div>
</body>

</html>