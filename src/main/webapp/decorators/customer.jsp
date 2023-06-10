<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pet Shop</title>
<style>
.dropdown-menu {
  display: none;
}
</style>
	<!-- Google Web Fonts -->
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

	<!-- Font Awesome -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

	<!-- Libraries Stylesheet -->
	<link href="<c:url value="/template/customer/lib/owlcarousel/assets/owl.carousel.min.css"/>" rel="stylesheet">
	<!-- Customized Bootstrap Stylesheet -->
	<link href="<c:url value="/template/customer/css/style.css"/>" rel="stylesheet">
	<link rel = "icon" href = "https://i.imgur.com/9BNxn4W.jpg" 
        type = "image/x-icon">
   <dec:head></dec:head>
</head>
<body>
<%@ include file="/common/customer/header.jsp" %>
<dec:body/>

<%@ include file="/common/customer/footer.jsp" %>

     <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="<c:url value='/template/customer/lib/easing/easing.min.js'/>"> </script>
	<script src="<c:url value='/template/customer/lib/owlcarousel/owl.carousel.min.js'/>"> </script>
	
	<!-- Contact Javascript File -->
	<script src="<c:url value='/template/customer/mail/jqBootstrapValidation.min.js'/>"> </script>
	<script src="<c:url value='/template/customer/mail/contact.js'/>"> </script>

	<!-- Template Javascript -->
	<script src="<c:url value='/template/customer/js/main.js'/>"> </script>
	
	<dec:getProperty property="page.script">
	</dec:getProperty>
</body>
</html>