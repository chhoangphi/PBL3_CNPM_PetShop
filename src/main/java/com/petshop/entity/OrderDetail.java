package com.petshop.entity;


public class OrderDetail {
	private String orderId;
	private Products product;
	private String product_name;
	private int quantity;
	private long price;
	
	public OrderDetail(OrderDetail orderDetail) {
		this.orderId = orderDetail.orderId;
		this.product = new Products(orderDetail.product);
		this.product_name = orderDetail.product_name;
		this.quantity = orderDetail.quantity;
		this.price = orderDetail.price;
	}

	public OrderDetail(String orderId, Products product, String product_name, int quantity, long price) {
		this.orderId = orderId;
		this.product = new Products(product);
		this.product_name = product_name;
		this.quantity = quantity;
		this.price = price;
	}
	public OrderDetail() {
		
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long l) {
		this.price=l;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
}
