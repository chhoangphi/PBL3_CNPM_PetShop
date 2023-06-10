<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
@media (min-width: 992px)
.col-lg-4 {
    flex: 0 0 33.33333%;
    max-width: 30;
}
</style>
<body>
<!-- Checkout Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            
             <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>Sản Phẩm</th>
                            <th>Giá tiền</th>
                            <th>Số lượng </th>
                            <th>Tổng tiền</th>
                            
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                    <c:forEach var="item" items="${cart}">
                        <tr>
                            <td class="align-middle"><img src="${item.value.product.img}" alt="" style="width: 50px;">${item.value.product.product_name}</td>
                            <td class="align-middle">${item.value.product.price}đ</td>
                            <td class="align-middle">${item.value.quantity}</td>
                            <td class="align-middle">${item.value.totalPrice}đ</td>
                           
              
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>  
                  
            </div>
             <div class="col-lg-4">
                <div class="card border-secondary mb-5">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Thông tin mua hàng</h4>
                    </div>
                    <div class="card-body">
                      
                        <hr class="mt-0">
                        <div class="d-flex justify-content-between mb-3 pt-1">
                            <h6 class="font-weight-medium">Tổng sản phẩm</h6>
                            <h6 class="font-weight-medium">${totalPrice}đ</h6>
                        </div>
                        <div class="d-flex justify-content-between">
                            <h6 class="font-weight-medium">Phí vận chuyển</h6>
                            <h6 class="font-weight-medium">${order.shippingFee}đ</h6>
                        </div>
                    </div>
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h5 class="font-weight-bold">Tổng tiền</h5>
                            <h5 class="font-weight-bold">${totalPrice+order.shippingFee}đ</h5>
                        </div>
                    </div>
                </div>
                
                <div class="card border-secondary mb-5">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Hình thức thanh toán</h4>
                    </div>
                        <div class="form-group">        
                                <label class="custom-label" for="paypal">COD thanh toán khi nhận hàng</label>
                        </div>
                    <div class="card-footer border-secondary bg-transparent">
                       
                    </div>
                </div>
          	
            </div> 
            <div class="col-lg-8">
            <form:form action="thanh-toan" method="post" modelAttribute="order">
                <div class="mb-4">
                    <h4 class="font-weight-semi-bold mb-4">Thông tin đặt hàng</h4>
                    <div class="row">
                        <div class="col-md-6 form-group">
                            <label>Tên người nhận*</label>
                            <form:input id="recipientName" class="form-control" type="text"  path="recipientName" required="required"></form:input>
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Địa chỉ E-mail*</label>
                            <form:input id="email" class="form-control" type="text"  path="email" required="required"></form:input>
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Số điện thoại*</label>
                            <form:input id="phoneNumber" class="form-control" type="text"  path="phoneNumber" required="required"></form:input>
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Địa chỉ(số nhà,đường,tỉnh)*</label>
                            <form:input id="address" class="form-control" type="text" path="address" required="required"></form:input>
                        </div>
                    </div>
                </div>
                <a href='<c:url value="/thong-bao"></c:url>'> <input class="btn btn-primary form-control" type="submit"
						value="Hoàn tất đặt hàng" name="submit" id="submit" /> </a> 
                </form:form>
             </div>
        </div>
    </div>

    <!-- Checkout End -->
</body>
</html>