<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.ml-auto, .mx-auto{
margin-left:0;
}
.btn-primary {
  color: #212529;
  background-color: #ffc72c;
  border-color: #ffc72c;
   border-radius: 10px;
}

.btn-primary:hover {
   color: #fff;
  background-color: #E51F28;
  border-color: #E51F28;
}

.container {
  display: flex;
  justify-content: center;
  align-items: center;
}
.contain{
padding:50px;
text-align: center;
}
.btn-primary1 {
  color: #212529;
  background-color: #ffc72c;
  border-color: #ffc72c;
   border-radius: 10px;
  width:250px;
   display: inline-block;
}
.btn-primary1:hover {
  color: #fff;
  background-color: #E51F28;
  border-color: #E51F28;
  width:250px
}
.col-lg-4 {
flex: 00 33.33333%;
max-width: 30%;
}
</style>
</head>
<body>

<div id="editcart">
<c:if test="${empty cart}">
<div class="container">
  <h1 class="fa">Không có sản phẩm nào trong giỏ hàng </h1>
</div>
<div class="contain">
 <a href="<c:url value="/trang-chu"/>" ><button class="btn btn-block btn-primary1 my-3 py-3">Tiếp tục mua sắm</button></a>
</div>
</c:if>
<c:if test="${not empty cart}">
<!-- Cart Start -->
    <div  class="container-fluid pt-5">
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>Sản Phẩm</th>
                            <th>Giá tiền</th>
                            <th>Số lượng </th>
                            <th>Tổng tiền</th>
                           <th>Xóa </th>
                            
                        </tr>
                    </thead>
                    <tbody  class="align-middle">
                    <c:forEach var="item" items="${cart}">
                        <tr>
                            <td class="align-middle"><img src="${item.value.product.img}" alt="" style="width: 50px;">${item.value.product.product_name}</td>
                            <td class="align-middle">${item.value.product.price}đ</td>
                            <td class="align-middle">
                            
                                <div class="input-group quantity mx-auto" style="width: 100px;">
                                    <div class="input-group-btn">
                                    </div>
                                    <input id="quantity-cart-${item.key}" onblur="editquantity('${item.key}')"  type="text" class="form-control form-control-sm bg-secondary text-center" value="${item.value.quantity}"> 
                                </div>
                            </td>
                            <td class="align-middle">${item.value.totalPrice}đ</td>
                           <td  class="align-middle"> <a onclick="deleteCart('${item.key}')"><button class="btn btn-sm btn-primary"> <i class="fa fa-times"></i> 
                          </button></a></td> 
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-lg-4">
      
                <div class="card border-secondary mb-5">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Giỏ hàng</h4>
                    </div>
                    <div class="card-body">
                        <div class="d-flex justify-content-between mb-3 pt-1">
                            <h6 class="font-weight-medium">Tổng giỏ hàng</h6>
                            <h6 class="font-weight-medium">${totalPrice}đ</h6>
                        </div>
                        <div class="d-flex justify-content-between">
                            <h6 class="font-weight-medium">Phí vận chuyển</h6>
                            <h6 class="font-weight-medium">${Shippingfee}đ</h6>
                        </div>
                    </div>
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h5 class="font-weight-bold">Tổng tiền</h5>
                            <h5 class="font-weight-bold">${totalPrice+Shippingfee}đ</h5>
                        </div>
                      <a href='<c:url value="/thanh-toan"/>'> <button class="btn btn-block btn-primary my-3 py-3">Tiến hành đặt hàng</button> </a> 
                    </div>
                </div>
            </div>
        </div>
    </div>
     </c:if>
     </div>
    <content tag="script">
     <script>
     function deleteCart(product_id) {
    	 if (confirm("Bạn muốn xóa sản phẩm này trong giỏ hàng!"))
    		 {
         $.ajax({
             url: "xoa-san-pham/" + product_id,
             type: "get",
             success: function () {
                 $("#editcart").load(location.href + " #editcart>*","");
             }
         });
    		 }
    	 else{
    		 
    	 }
     }
     function editquantity(product_id) {
    	 var quantity=$("#quantity-cart-"+product_id).val();
    	 if (quantity<1) quantity=1;
         $.ajax({
         	
             url: "thay-doi-so-luong/" + product_id +"/"+quantity,
             type: "get",
             success: function () {
                 $("#editcart").load(location.href + " #editcart>*","");
             }
         });
     }
 
    </script>
    </content>

</body>
</html>