package com.petshop.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Order {
	private String orderId;
	private String customerId;
	private String recipientName;
	private String phoneNumber;
	private String address;
	private String email;
	private LocalDateTime orderTime;
	private LocalDateTime confirmTime;
	private LocalDateTime shipTime;
	private LocalDateTime receiveTime;
	private LocalDateTime completedTime;
	private LocalDateTime cancleTime;
	private OrderStatus status;
	private static final int shippingFee=20000;
	private long totalPrice;
	private List<OrderDetail> orderDetailList;
	
	public Order() {
		
	}
	public Order(Order order) {
		this.orderId = order.orderId;
		this.customerId = order.customerId;
		this.recipientName = order.recipientName;
		this.phoneNumber = order.phoneNumber;
		this.address = order.address;
		this.orderTime = order.orderTime;
		this.confirmTime = order.confirmTime;
		this.shipTime = order.shipTime;
		this.receiveTime = order.receiveTime;
		this.completedTime = order.completedTime;
		this.cancleTime = order.cancleTime;
		this.status = order.status;
		this.totalPrice=order.totalPrice;
		this.orderDetailList=new ArrayList<>(order.orderDetailList);
	}

	public LocalDateTime getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(LocalDateTime receiveTime) {
		this.receiveTime = receiveTime;
	}
	public LocalDateTime getCancleTime() {
		return cancleTime;
	}
	public void setCancleTime(LocalDateTime cancleTime) {
		this.cancleTime = cancleTime;
	}
	public static int getShippingfee() {
		return shippingFee;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Order(
			String orderId, String customerId, String recipientName, String phoneNumber, String address,
			LocalDateTime orderTime,LocalDateTime confirmTime, LocalDateTime shipTime, LocalDateTime completedTime, OrderStatus status,
			List<OrderDetail> orderDetailList) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.recipientName = recipientName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.orderTime = orderTime;
		this.confirmTime = confirmTime;
		this.shipTime = shipTime;
		this.completedTime = completedTime;
		this.status = status;
		this.orderDetailList = new ArrayList<>(orderDetailList);
		setTotalPrice();
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
	public LocalDateTime getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(LocalDateTime confirmTime) {
		this.confirmTime = confirmTime;
	}
	public LocalDateTime getShipTime() {
		return shipTime;
	}
	public void setShipTime(LocalDateTime shipTime) {
		this.shipTime = shipTime;
	}
	public LocalDateTime getCompletedTime() {
		return completedTime;
	}
	public void setCompletedTime(LocalDateTime completedTime) {
		this.completedTime = completedTime;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public int getShippingFee() {
		return shippingFee;
	}
	
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice() {
		for (OrderDetail order:orderDetailList) {
			this.totalPrice+=order.getPrice()*order.getQuantity();
		}
		this.totalPrice+=shippingFee;
	}
	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}
	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = new ArrayList<>(orderDetailList);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public enum OrderStatus {
		PENDING,
		TO_SHIP,
		TO_RECEIVE,
		COMPLETED,
		CANCELED
	}
}
