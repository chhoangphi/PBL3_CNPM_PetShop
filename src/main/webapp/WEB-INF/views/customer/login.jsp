
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng nhập</title>

<style>
.red {
	color: red;
}
.form-check-input {
    position: absolute;
    margin-top: 0.3rem;
    margin-left: 0.3rem;
}
</style>
</head>
<body>
	<%
	String statusLogin = request.getAttribute("statusLogin") + "";
	statusLogin = (statusLogin.equals("null")) ? "" : statusLogin;

	 String username = request.getAttribute("username") + "";
	 username = (username.equals("null")) ? "" : username;
	%>
	
	</hr>
	<div class="container">
		<form class="form" action="dang-nhap" method="post">
			<div class="row">
				<div class="col-sm-6">
					<div class="text-center">
						<h3>Đăng nhập</h3>
					</div>

					
					<div class="mb-3">
						<label for="username" class="form-label">Tên đăng nhập<span
							class="red">*</span></label> <input type="text" class="form-control"
							id="username" name="username" required="required" value="<%=username %>"
							>
					</div>
					<div class="mb-3">
						<label for="matKhau" class="form-label">Mật khẩu<span
							class="red">*</span></label> <input type="password" class="form-control"
							id="password" name="password" required="required">
					</div>
					<hr />
					<div class="red" id="baoLoi">
						<%=statusLogin%>
					</div>
					<hr/>
					<div class="mb-3">
						<label for="rememberme" class="form-label">Remember me </label> <input
							type="checkbox" class="form-check-input" id="rememberme"
							name="rememberme">
					</div>
					<input class="btn btn-primary form-control" type="submit"
						value="Đăng nhập" name="submit" id="submit" />
				</div>
				<div class="col-sm-6">
					<div>
						<iframe class="position-relative w-100"
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3833.838623526906!2d108.14770021465138!3d16.073861888878!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x314218d68e8ccb03%3A0x64dc2cb3e38bbdaf!2zNTQgTmd1eeG7hW4gTMawxqFuZyBC4bqxbmcsIEhvw6AgS2jDoW5oIELhuq9jLCBMacOqbiBDaGnhu4N1LCDEkMOgIE7hurVuZyA1NTAwMDAsIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1677676341320!5m2!1svi!2s"
							frameborder="0" style="height: 205px; border: 0;"
							allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
					</div>
					<hr></hr>
				</div>



			</div>
		</form>
	</div>

</body>

</html>