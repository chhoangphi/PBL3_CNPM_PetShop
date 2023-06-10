package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.petshop.entity.MapperOrderDetail;
import com.petshop.entity.OrderDetail;

@Repository
public class OrderDetailDao extends BaseDao {
	@Autowired
	private ProductsDao productsDao;

	public int saveOrderDetail(OrderDetail orderdetail) {
		try {
			String sql = "INSERT INTO order_detail (orderID, product_id, product_name, quantity, price) VALUES (?, ?, ?, ?, ?)";
			Object[] param = {
				orderdetail.getOrderId(),
				orderdetail.getProduct().getProduct_id(),
				orderdetail.getProduct_name(),
				orderdetail.getQuantity(),
				orderdetail.getPrice()
			};
			int insert = _JdbcTemplate.update(sql, param);
			return insert;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<OrderDetail> findAll(String OrderID) {
		List<OrderDetail> detailList = new ArrayList<>();
		try {
			String sql = " SELECT * FROM order_detail WHERE orderID='" + OrderID + "'";
			detailList = _JdbcTemplate.query(sql, new MapperOrderDetail(productsDao));
			return detailList;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public long TotalPriceProducts(List<OrderDetail> orderDetailList) {
		long totalPriceQuantity = 0;
		for (OrderDetail item : orderDetailList) {
			totalPriceQuantity += item.getPrice() * item.getQuantity();
		}
		return totalPriceQuantity;
	}
	public List<OrderDetail> GetDataOrderDetail() {
		List<OrderDetail> orderList=new ArrayList<>();
		try {
			String sql=" SELECT * FROM order_detail ";
			orderList=_JdbcTemplate.query(sql, new MapperOrderDetail(productsDao));
			return orderList;
			
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	public List<OrderDetail> GetDataOrderDetailPaginate(int start, int totalPage) {
		List<OrderDetail> listproduct = new ArrayList<>();
		try {
			String sql ="SELECT * FROM order_detail LIMIT ?,?";
			Object []params={start,totalPage};
			listproduct = _JdbcTemplate.query(sql, new MapperOrderDetail(productsDao),params);
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public List<OrderDetail> GetDataOrderDetailByIsReviewed (String product_id,String username,int isReviewed)
	{
		try {
			List<OrderDetail> listOrderDetail = new ArrayList<>();
			String sql = " SELECT * FROM order_detail AS od INNER JOIN order_customer AS oc ON od.orderID=oc.orderID"
					+ " WHERE od.isreviewed=" + isReviewed
					+ " AND oc.customerID = '"+username + "'"
					+ " AND od.product_id='" + product_id+"'";
			listOrderDetail = _JdbcTemplate.query(sql, new MapperOrderDetail(productsDao));
			return listOrderDetail;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public int updateOrderDetail(OrderDetail orderDetail) {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE ");
		sql.append("order_detail ");
		sql.append("SET ");
		sql.append("    isreviewed = ");
		sql.append("1");
		sql.append("  WHERE orderID ='" + orderDetail.getOrderId() + "';");
		int insert = _JdbcTemplate.update(sql.toString());
		return insert;
	}

}
