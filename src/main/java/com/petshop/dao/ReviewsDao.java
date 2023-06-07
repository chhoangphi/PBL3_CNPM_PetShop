package com.petshop.dao;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.petshop.entity.*;

@Repository
public class ReviewsDao extends BaseDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	public int Add(Reviews reviews)
	{
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO ");
		sql.append("reviews ");
		sql.append("( ");
		sql.append("    reviewID, ");
		sql.append("    tendangnhap, ");
		sql.append("    product_id, ");
		sql.append("    reviewtext, ");
		sql.append("    reviewdate, ");
		sql.append("    rating ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("(");
		sql.append("'"+reviews.getReviewID()+"',");
		sql.append("'"+reviews.getCustomerID()+"',");
		sql.append("'"+reviews.getProduct_id()+"',");
		sql.append("'"+reviews.getReviewText()+"',");
		sql.append("'"+reviews.getReviewDate()+"',");
		sql.append("'"+reviews.getRating()+"'");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		System.out.println("sql query:" + sql);
		return insert;
	}
	public double  AvgRating(String product_id) {
		try {
			String sql = "SELECT rating FROM reviews WHERE product_id ='" + product_id+"'";			
			List <Double>data = _jdbcTemplate.queryForList(sql, Double.class);
			double avgRating = 0;
			for(int i = 0 ; i < data.size(); i++)
			{
				
				avgRating += (double)data.get(i);
			}
			System.out.println("SQL Query: " + sql);
			return (double)avgRating/data.size();
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	public List<Reviews> GetDataReviewsByProductID(String product_id) {
		List<Reviews> listReviews = new ArrayList<>();
		try {
			String sql = "SELECT * FROM reviews WHERE product_id ='"+product_id+"'";
			listReviews = _JdbcTemplate.query(sql, new MapperReviews());
			System.out.println("SQL Query: " + sql);
			return listReviews;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public int GetAmountOfReviews(String product_id)
	{
		List<Reviews> listReviews = new ArrayList<>();
		try {
			String sql = "SELECT * FROM reviews WHERE product_id='" + product_id+"'";
			listReviews = _JdbcTemplate.query(sql, new MapperReviews());
			System.out.println("SQL Query: " + sql);

			return listReviews.size();
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
		
	}
	public Reviews EditRatingReviews(Reviews reviews, double ratingValue)
	{
		reviews.setRating(ratingValue);
		return reviews;
		
	}
	public Reviews GetDataReviewsByReviewsID(String reviewsID) {
		Reviews reviews = new Reviews();
		try {
			String sql = "SELECT * FROM reviews WHERE reviewsID=" + "'" + reviewsID + "'";
			reviews = _JdbcTemplate.queryForObject(sql, new MapperReviews());

			return reviews;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
