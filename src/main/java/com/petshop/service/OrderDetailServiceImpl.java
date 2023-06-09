package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dao.OrderDao;
import com.petshop.dao.OrderDetailDao;
import com.petshop.entity.OrderDetail;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService{

	@Autowired
	OrderDao orderDao=new OrderDao();
	@Autowired
	OrderDetailDao orderDetailDao=new OrderDetailDao();
	

	@Override
	public List<OrderDetail> GetDataOrderDetail() {
		// TODO Auto-generated method stub
		return orderDetailDao.GetDataOrderDetail();
	}


	@Override
	public List<OrderDetail> GetDataOrderDetailPaginate(int start, int end) {
		// TODO Auto-generated method stub
		return orderDetailDao.GetDataOrderDetailPaginate(start,end);
	}


	@Override
	public List<OrderDetail> GetDataOrderDetailByIsReviewed(String product_id,String username,int isReviewed) {
		// TODO Auto-generated method stub
		return orderDetailDao.GetDataOrderDetailByIsReviewed(product_id, username, isReviewed);
	}


	@Override
	public int updateOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return orderDetailDao.updateOrderDetail(orderDetail);
	}


	@Override
	public int UpdateSoldQuantity(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return orderDao.UpdateSoldQuantity(orderDetail);
	}
	
}
