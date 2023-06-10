package com.petshop.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.petshop.entity.OrderDetail;
@Service
public interface IOrderDetailService {
	public List<OrderDetail> GetDataOrderDetail();
	public List<OrderDetail> GetDataOrderDetailPaginate(int start,int end);
	public List<OrderDetail> GetDataOrderDetailByIsReviewed(String product_id,String username,int isReviewed);
	public int updateOrderDetail(OrderDetail orderDetail);
	public int UpdateSoldQuantity(OrderDetail orderDetail);

}
