
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Update Order</title>


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
			action="/petshop-5/admin/cap-nhat-don-hang/${orderId}"
			method="POST" modelAttribute="order">
			<div class="row">

				<div class="col-sm-12">
					<div class="text-center">
						<h3>UPDATE ORDER</h3>
					</div>
					<!-- <div class="mb-3">
						<label for="product_id" class="form-label">Product ID</label> <input
							type="text" class="form-control" id="product_id"
							name="product_id">
					</div> -->

					<div class="mb-3">
						<label for="customerID" class="form-label">CustomerID</label>
						<form:input type="text" value ="${order.customerId}" class="form-control" path="customerId" disabled="true"></form:input>
					</div>
					<div class="mb-3">
						<label for="recipientName" class="form-label">Recipient Name</label>
						<form:input type="text" value ="${order.recipientName}" class="form-control" path="recipientName" disabled="true"></form:input>
					</div>
					<div class="mb-3">
						<label for="phoneNumber" class="form-label">Phone Number</label>
						<form:input type="text" value ="${order.phoneNumber}" class="form-control" path="phoneNumber" disabled="true"></form:input>
					</div>
					<div class="mb-3">
						<label for="address" class="form-label">Address</label>
						<form:input type="text" value ="${order.address}" class="form-control" name="address" path="address"></form:input>
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label>
						<form:input type="text" value ="${order.email}" class="form-control" path="email" disabled="true" ></form:input>
					</div>
					<div class="mb-3">
						<label for="totalPrice" class="form-label">Total Price</label>
						<form:input type="text" value ="${order.totalPrice}" class="form-control" path="totalPrice" disabled="true"></form:input>
					</div>
					
					<hr />
					<div class="mb-3">
						<label for="status" class="form-label">Status</label>
						<select class="form-control" id="status"
							name="status" >
								<option value="PENDING" label="PENDING"/>
								<option value="TO_SHIP" label="TO_SHIP"/>
								<option value="TO_RECEIVE" label="TO_RECEIVE"/>
								<option value="COMPLETED" label="COMPLETED"/>
								<option value="CANCELED" label="CANCELED"/>
					
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