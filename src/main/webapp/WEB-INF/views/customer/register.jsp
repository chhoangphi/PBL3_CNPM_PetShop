
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng ký</title>
 
<style>
.red {
	color: red;
}
.form-check-input {
    position: absolute;
    margin-top: 0.3rem;
    margin-left: 0.2rem;
}
</style>
</head>
<body>
	<%
	String baoLoi = request.getAttribute("baoLoi") + "";
	baoLoi = (baoLoi.equals("null")) ? "" : baoLoi;

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
	<!-- Topbar Start -->
	</hr>
	<div class="container">
		<form class="form" action="dang-ky" method="post">
			<div class="row">
				<div class="col-sm-6">
					<div class="text-center">
						<h3>ĐĂNG KÝ TÀI KHOẢN</h3>
					</div>

					<div class="red" id="baoLoi">
						<%=baoLoi%>
						
					</div>
					<div class="mb-3">
						<label for="username" class="form-label">Tên đăng nhập<span
							class="red">*</span></label> <input type="text" class="form-control"
							id="username" name="username" required="required"
							value="<%=username%>" >
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Mật khẩu<span
							class="red">*</span></label> <input type="password" class="form-control"
							id="password" name="password" required="required"
							onkeyup="kiemTraMatKhau()">
					</div>
					<div class="mb-3">
						<label for="passwordRetype" class="form-label">Nhập lại
							mật khẩu<span class="red">*</span> <span id="msg" class="red"></span>
						</label> <input type="password" class="form-control" id="passwordRetype"
							name="passwordRetype" required="required"
							onkeyup="kiemTraMatKhau()">
					</div>
					<div class="mb-3">
						<label for="fullName" class="form-label">Tên khách hàng<span
							class="red">*</span></label> <input type="text" class="form-control"
							id="fullName" name="fullName" required="required"
							value="<%=fullName%>" >
					</div>
					<hr />
					<div class="mb-3">
						<label for="gender" class="form-label">Giới tính</label> <select
							class="form-control" id="gender" name="gender">
							<option></option>
							<option value="Nam"
								<%=(gender.equals("Nam")) ? "selected='selected'" : ""%>>Nam</option>
							<option value="Nữ"
								<%=(gender.equals("Nữ")) ? "selected='selected'" : ""%>>Nữ</option>
							<option value="Khác"
								<%=(gender.equals("Khác")) ? "selected='selected'" : ""%>>Khác</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="dateofbirth" class="form-label">Ngày sinh</label> <input
							type="date" class="form-control" id="dateofbirth" name="dateofbirth"
							value="<%=dateofbirth%>">
					</div>
					<div class="mb-3">
						<label for="phonenumber" class="form-label">Số điện thoại<span
							class="red">*</span></label> <input type="tel" class="form-control"
							id="phonenumber" name="phonenumber" required="required" value="<%=phonenumber%>">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email"
							value="<%=email%>">
					</div>
					<hr />
					<div class="mb-3">
						<label for="dongYDieuKhoan" class="form-label">Đồng ý với
							<a>điều khoản của công ty </a><span id="red">*</span>
						</label> <input type="checkbox" class="form-check-input"
							id="dongYDieuKhoan" name="dongYDieuKhoan" required="required">
					</div>
					<input class="btn btn-primary form-control" type="submit"
						value="Đăng ký" name="submit" id="submit" />
				</div>



			</div>
		</form>
	</div>
</body>
<content tag="script">
<script>
	function kiemTraMatKhau() {
		matKhau = document.getElementById("password").value;
		matKhauNhapLai = document.getElementById("passwordRetype").value;
		if (matKhau != matKhauNhapLai) {
			document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
			return false;
		} else {
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}
</script>
</content>

</html>