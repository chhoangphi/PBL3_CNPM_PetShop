package com.petshop.entity;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.petshop.dao.ProductsDao;

public class MapperOrderDetail implements  RowMapper<OrderDetail> {
	
	private ProductsDao productsDao;
	public MapperOrderDetail(ProductsDao productsDao) {
		this.productsDao=productsDao;
	}
	@Override
	public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderDetail orderDetail=new OrderDetail();
		String product_id=rs.getString("product_id");
		Products product=productsDao.GetDataProductByProductID(product_id);
		orderDetail.setProduct(product);
		orderDetail.setOrderId(rs.getString("OrderID"));
		orderDetail.setProduct_name(rs.getString("product_name"));
		orderDetail.setQuantity(rs.getInt("quantity"));
		orderDetail.setPrice(rs.getLong("price"));
		return orderDetail;
	}
}
