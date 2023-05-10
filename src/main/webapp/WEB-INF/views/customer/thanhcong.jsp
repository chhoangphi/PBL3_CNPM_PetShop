<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String tenDangNhap = request.getAttribute("tenDangNhap") + "";
	tenDangNhap = (tenDangNhap.equals("null")) ? "" : tenDangNhap;

	String matKhau = request.getAttribute("matKhau") + "";
	String email = request.getAttribute("email") + "";
	String soDienThoai = request.getAttribute("soDienThoai") + "";
	String status = request.getAttribute("status") + "";
	String statusLogin = request.getAttribute("statusLogin") + "";
	%>
	<h1>Chúc mừng bạn đã đăng ký tài khoản thành công! Vui lòng quay
		lại trang đăng nhập.</h1>
	<h2>
		Xin chào:
		<%=tenDangNhap%></h2>
	<h2>
		Yourtel:
		<%=soDienThoai%></h2>
	<h2>
		Status:
		<%=status%></h2>
	<h2>
		StatusLogin:
		<%=status%></h2>

</body>
</html>