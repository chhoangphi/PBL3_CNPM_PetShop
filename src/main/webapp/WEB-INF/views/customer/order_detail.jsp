<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.card {
    box-shadow: 0 20px 27px 0 rgb(0 0 0 / 5%);
}
.card {
    position: relative;
    display: flex;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 0 solid rgba(0,0,0,.125);
    border-radius: 1rem;
}
.text-reset {
    --bs-text-opacity: 1;
    color: inherit!important;
}
a {
    color: #5465ff;
    text-decoration: none;
}

</style>
</head>
<body>
<div class="container-fluid">

<div class="container">
  <!-- Title -->
  <span id="msg" style="color: red"></span>
   <c:if test="${abc==1}"> 
  <span id="notify" style="color: green">Hủy đơn hàng thành công</span>
   </c:if>  
  <div class="d-flex justify-content-between align-items-center py-3">
    <h2 class="h5 mb-0"><a href="#" class="text-muted"></a> Đơn hàng #${Order.orderId}</h2>
     <c:if test="${Order.status!='CANCELED'}">
     <button id="cancel-order" type="button" class="btn btn-primary" onclick="confirmCancel('${Order.status}')" >Hủy đơn hàng</button>
      </c:if> 
  </div>

  <!-- Main content -->
  <div class="row">
    <div class="col-lg-8">
      <!-- Details -->
      <div class="card mb-4">
        <div class="card-body">
          <div class="mb-3 d-flex justify-content-between">
            <div>
              <span class="me-3">Trạng thái</span>
               <span class="badge rounded-pill bg-info">${Order.status=='PENDING' ? 'Chờ xác nhận' : ((Order.status=='TO_SHIP') ? 'Chờ lấy hàng ' : (Order.status=='TO_RECEIVE')  ?  'Đang giao hàng' : (Order.status=='COMPLETED') ? 'Đã giao' : 'Đã hủy')}</span> 
            </div>
            <div class="d-flex">
              <button class="btn btn-link p-0 me-3 d-none d-lg-block btn-icon-text"><i class="bi bi-download"></i> <span class="text">Hóa đơn</span></button>
              <div class="dropdown">
                <button class="btn btn-link p-0 text-muted" type="button" data-bs-toggle="dropdown">
                  <i class="bi bi-three-dots-vertical"></i>
                </button>
                <ul class="dropdown-menu dropdown-menu-end">
                  <li><a class="dropdown-item" href="#"><i class="bi bi-pencil"></i> Edit</a></li>
                  <li><a class="dropdown-item" href="#"><i class="bi bi-printer"></i> Print</a></li>
                </ul>
              </div>
            </div>
          </div>
          <table class="table table-borderless">
            <tbody>
              <c:forEach var="item" items="${Order.orderDetailList}">
              <tr>
                <td>
                  <div class="d-flex mb-2">
                    <div class="flex-shrink-0">
                      <img src="${item.product.img}" alt="" width="35" class="img-fluid">
                    </div>
                    <div class="flex-lg-grow-1 ms-3">
                      <h6 class="small mb-0"><a href="#" class="text-reset">${item.product_name}</a></h6>
                      <span class="small">Số lượng: ${item.quantity}</span>
                    </div>
                  </div>
                </td>
                <td></td>
                <td class="text-end">${item.price}đ</td>
              </tr>
              </c:forEach>
            </tbody>
            <tfoot>
              <tr>
                <td colspan="2">Tổng tiền hàng</td>
                <td class="text-end">${totalPriceProducts}đ</td>
              </tr>
              <tr>
                <td colspan="2">Phí vận chuyển</td>
                <td class="text-end">${Order.shippingFee}đ</td>
              </tr>
     
              <tr class="fw-bold">
                <td colspan="2">Thành tiền</td>
                <td class="text-end">${Order.totalPrice}đ</td>
              </tr>
            </tfoot>
          </table>
        </div>
      </div>
      <!-- Payment -->
      <div class="card mb-4">
        <div class="card-body">
          <div class="row">
            <div class="col-lg-6">
             <h3 class="h6">Đặt ngày</h3>
              <p>${Order.orderTime} <br>
              <h3 class="h6">Phương thức thanh toán</h3>
              <p>Thanh toán khi nhận hàng <br>
             </p>
            </div>
            <div class="col-lg-6">
              <h3 class="h6">Địa chỉ nhận hàng</h3>
              <address>
                <strong>${Order.recipientName}</strong><br>
                ${Order.address}<br>

                <abbr title="Phone">Phone:</abbr> ${Order.phoneNumber}
              </address>
            </div>
           
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
  </div>
  <content tag="script">
   <script>
   function confirmCancel(status){
	   if (confirm("Xác nhận hủy đơn hàng")){
		   if (status === "PENDING" || status === "TO_SHIP")
			{
			   var currentUrl=window.location.href;
	  			 window.location.href=currentUrl.replace("chi-tiet-don-hang","huy-don-hang");
			}
		   else
				{
			       document.getElementById("msg").innerHTML = "Không thể hủy đơn hàng với trạng thái hiện tại";	 
				}
	   }
	   else{
		   
	   }  
   }
   </script>
  </content>
</body>
</html>