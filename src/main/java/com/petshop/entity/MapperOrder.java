package com.petshop.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.petshop.dao.OrderDetailDao;


public class MapperOrder implements  RowMapper<Order>{
	
	 private OrderDetailDao orderDetailDao;

	    public MapperOrder(OrderDetailDao orderDetailDao) {
	        this.orderDetailDao = orderDetailDao;
	    }
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order=new Order();
	String orderID=rs.getString("orderID");
		order.setOrderId(orderID);
		order.setCustomerId(rs.getString("customerID"));
		order.setAddress(rs.getString("address"));
		order.setPhoneNumber(rs.getString("phoneNumber"));
		order.setEmail(rs.getString("email"));
		order.setRecipientName(rs.getString("recipientName"));
		Order.OrderStatus status = Order.OrderStatus.valueOf(rs.getString("order_status"));
		order.setStatus(status);
		LocalDateTime orderTime = rs.getTimestamp("orderTime").toLocalDateTime();
		order.setOrderTime(orderTime);
		LocalDateTime confirmTime = rs.getTimestamp("confirmTime") != null ? rs.getTimestamp(
				"confirmTime").toLocalDateTime() : null;
		order.setConfirmTime(confirmTime);
		LocalDateTime shipTime = rs.getTimestamp("shiptime") != null ? rs.getTimestamp(
				"shiptime").toLocalDateTime() : null;
		order.setShipTime(shipTime);
		LocalDateTime receiveTime = rs.getTimestamp("receivetime") != null ? rs.getTimestamp(
				"receivetime").toLocalDateTime() : null;
		order.setCompletedTime(receiveTime);
		LocalDateTime completedTime = rs.getTimestamp("completedtime") != null ? rs.getTimestamp(
				"completedtime").toLocalDateTime() : null;
		order.setCompletedTime(completedTime);
		LocalDateTime cancleTime = rs.getTimestamp("cancletime") != null ? rs.getTimestamp(
				"cancletime").toLocalDateTime() : null;
		order.setCompletedTime(cancleTime);
		
		List<OrderDetail> orderDetailList=orderDetailDao.findAll(orderID);
		order.setOrderDetailList(orderDetailList);
		order.setTotalPrice();
		return order;
	}
	
}
