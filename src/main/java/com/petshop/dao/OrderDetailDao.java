package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.petshop.entity.MapperOrder;
import com.petshop.entity.MapperOrderDetail;
import com.petshop.entity.MapperProducts;
import com.petshop.entity.Order;
import com.petshop.entity.OrderDetail;
import com.petshop.entity.Products;

@Repository
public class OrderDetailDao extends BaseDao {
	@Autowired
	private ProductsDao productsDao;

	public int saveOrderDetail(OrderDetail orderdetail) {
//		String sql = "INSERT INTO order_detail VALUES (?, ?, ?, ?, ?)";
//		Object[] params = { orderdetail.getOrderId(), orderdetail.getProduct().getProduct_id(),
//				orderdetail.getProduct_name(), orderdetail.getQuantity(), orderdetail.getPrice() };
//		try {
//			int rowsInserted = _JdbcTemplate.update(sql, params);
//			return rowsInserted;
//		} catch (Exception e) {
//			System.out.println(e);
//			return 0;
//		}
		try {
			StringBuffer  sql = new StringBuffer();
			sql.append("INSERT INTO ");
			sql.append("order_detail ");
			sql.append("( ");
			sql.append("    orderID, ");
			sql.append("    product_id, ");
			sql.append("    product_name, ");
			sql.append("    quantity, ");
			sql.append("    price ");
			sql.append(") ");
			sql.append("VALUES ");
			sql.append("(");
			sql.append("'"+orderdetail.getOrderId()+"',");
			sql.append("'"+orderdetail.getProduct().getProduct_id()+"',");
			sql.append("'"+orderdetail.getProduct_name()+"',");
			sql.append(""+orderdetail.getQuantity()+",");
			sql.append(""+orderdetail.getPrice()+"");
			sql.append(")");
			int insert = _JdbcTemplate.update(sql.toString());
			System.out.println("sql query:" + sql);
			return insert;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public List<OrderDetail> findAll(String OrderID) {
		List<OrderDetail> detailList = new ArrayList<>();
		try {
			String sql = " SELECT * FROM order_detail WHERE orderID='" + OrderID + "'";
			System.out.println(sql);
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
			System.out.println(sql);
			orderList=_JdbcTemplate.query(sql, new MapperOrderDetail(productsDao));
			return orderList;
			
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	public List<OrderDetail> GetDataOrderDetailPaginate(int start, int end) {
		List<OrderDetail> listproduct = new ArrayList<>();
		try {
			String sql = SqlOrderDetailPaginate(start, end).toString();
			System.out.println("SQL Query: " + sql);
			listproduct = _JdbcTemplate.query(sql, new MapperOrderDetail(productsDao));
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public StringBuffer SqlOrderDetailPaginate(int start, int totalPage) {
		StringBuffer sql = SqlOrderDetail();
		sql.append(" LIMIT ");
		sql.append(start + ", " + totalPage);
		return sql;
	}
	public StringBuffer SqlOrderDetail() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" *");
		sql.append(" FROM"); 
		sql.append(" order_detail");
		System.out.println(sql.toString());
		return sql;
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
			System.out.println(sql);
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
//		sql.append("    product_id = ");
//		sql.append("'"+products.getProduct_id()+"',");
		sql.append("    isreviewed = ");
		sql.append("1");
		sql.append("  WHERE orderID ='" + orderDetail.getOrderId() + "';");
		System.out.println(sql.toString());

		int insert = _JdbcTemplate.update(sql.toString());
		return insert;
	}

}
