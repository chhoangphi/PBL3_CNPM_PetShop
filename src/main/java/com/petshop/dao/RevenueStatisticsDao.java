package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.petshop.dto.RevenueStatisticsDto;

@Repository
public class RevenueStatisticsDao extends BaseDao {
	public long GetDataTotalPriceInMonthAndYear(int month,int year) {
		try {
			String sql="SELECT SUM(totalPrice) FROM order_customer WHERE MONTH(orderTime)=? AND YEAR(orderTime) = ?";
			Object []param= {month,year};
			List<Long> results = _JdbcTemplate.queryForList(sql, param, Long.class);
	        if (!results.isEmpty()) {
	            Long totalPrice = results.get(0);
	            if (totalPrice != null) {
	                return totalPrice;
	            }
	        }
	        return 0;
			}catch(Exception e){
				System.out.println(e);
				return 0;
			}
	}
	public long GetDataTotalOrderInMonthAndYear(int month,int year) {
		try {
			String sql="SELECT count(orderID) FROM order_customer WHERE MONTH(orderTime)=? AND YEAR(orderTime) = ?";
			Object []param= {month,year};
			List<Long> results = _JdbcTemplate.queryForList(sql, param, Long.class);
	        if (!results.isEmpty()) {
	            Long totalOrder = results.get(0);
	            if (totalOrder != null) {
	                return totalOrder;
	            }
	        }
	        return 0;
			}catch(Exception e){
				System.out.println(e);
				return 0;
			}
	}
	public List<RevenueStatisticsDto> FindDataOrderInMonthAndYear(){
		List<RevenueStatisticsDto> list=new ArrayList<>();
		try {
			String sql="SELECT  DISTINCT(MONTH(orderTime)) AS monthOfOrder,SUM(totalPrice) AS totalPriceOfMonth ,count(orderID) AS totalOrderOfMonth FROM order_customer WHERE  YEAR(OrderTime)=2023\r\n"
					+ "	 GROUP BY MONTH(orderTime)\r\n"
					+ "	 ORDER BY MONTH(orderTime) ASC";
			 list = _JdbcTemplate.query(sql, new BeanPropertyRowMapper<>(RevenueStatisticsDto.class));
	        return list;
			}catch(Exception e){
				System.out.println(e);
				return null;
			}
	}
}
