package com.petshop.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.petshop.dao.OrderDao;
import com.petshop.dao.OrderDetailDao;
import com.petshop.service.HomeServiceImpl;
import com.petshop.service.OrderServiceImpl;

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
				"confirm_time").toLocalDateTime() : null;
		order.setConfirmTime(confirmTime);
		LocalDateTime shipTime = rs.getTimestamp("shipTime") != null ? rs.getTimestamp(
				"ship_time").toLocalDateTime() : null;
		order.setShipTime(shipTime);
		LocalDateTime completedTime = rs.getTimestamp("completedTime") != null ? rs.getTimestamp(
				"completed_time").toLocalDateTime() : null;
		order.setCompletedTime(completedTime);
		
		List<OrderDetail> orderDetailList=orderDetailDao.findAll(orderID);
		order.setOrderDetailList(orderDetailList);
		order.setTotalPrice();
		return order;
	}
	
}
