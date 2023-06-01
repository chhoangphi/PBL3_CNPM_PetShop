package com.petshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.entity.Order;
import com.petshop.entity.OrderDetail;

@Service
public interface IOrderService {
	public int AddOrder(Order order);
	public int create(Order order);
	public int saveOrderDetail(OrderDetail orderdetail);
	public List<OrderDetail> findAll(String OrderID);
	public Order findOrder(String OrderID);
	public List<Order> findAllOrder(String customerID);
	public long TotalPriceProducts(List<OrderDetail> orderDetailList);
	public int DeleteOrder(String orderID);
	public List<Order> findOrderByStatus(String status,String customerID);
	public List<Order> GetDataOrder();
	public List<Order> GetDataOrderByUsername(String username);
	public List<Order> GetDataOrderPaginate(int start, int end,String status);
	public int UpdateOrder(String status, String address,String orderID);
	public List<Order> GetDataOrderByStatus(String status);
}
