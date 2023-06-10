<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
<style >
.container {
  display: flex;
  justify-content: center;
  align-items: center;
}
.contain{
padding:50px;
display: flex;
  justify-content: center;
  align-items: center;
}
.btn-primary1 {
  color: #212529;
  background-color: #ffc72c;
  border-color: #ffc72c;
   border-radius: 10px;
  width:250px
}
.btn-primary1:hover {
  color: #fff;
  background-color: #E51F28;
  border-color: #E51F28;
  width:250px
}

</style>
</head>
<body>

  <div class="container">
  <h1 class="fa fa-check-circle">Trang này hiện tại đang bị lỗi!</h1>
</div>
<div class="contain">
 <a href="<c:url value="/trang-chu"/>" ><button class="btn btn-block btn-primary1 my-3 py-3">Quay về trang chủ</button></a>
 
</div>
</body>
</html>