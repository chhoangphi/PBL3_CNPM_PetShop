package com.petshop.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperReviews implements RowMapper<Reviews>{

	public Reviews mapRow(ResultSet rs, int rowNum) throws SQLException {
		Reviews reviews = new Reviews();
		reviews.setProduct_id(rs.getString("product_id"));
		reviews.setCustomerID(rs.getString("tenDangNhap"));
		reviews.setReviewID(rs.getString("reviewID"));
		reviews.setRating(rs.getDouble("rating"));
		reviews.setReviewText(rs.getString("reviewText"));
		reviews.setReviewDate(rs.getDate("reviewDate"));
		return reviews;
	}
	
}
