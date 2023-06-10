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

	public int Add(Reviews reviews) {
		try {
			String sql = "INSERT INTO reviews (reviewID, tendangnhap, product_id, reviewtext, reviewdate, rating) VALUES (?, ?, ?, ?, ?, ?)";
			Object[] param = { reviews.getReviewID(), reviews.getCustomerID(), reviews.getProduct_id(),
					reviews.getReviewText(), reviews.getReviewDate(), reviews.getRating() };

			int insert = _jdbcTemplate.update(sql, param);
			return insert;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	public double AvgRating(String product_id) {
		try {
			String sql = "SELECT rating FROM reviews WHERE product_id ='" + product_id + "'";
			List<Double> data = _jdbcTemplate.queryForList(sql, Double.class);
			double avgRating = 0;
			for (int i = 0; i < data.size(); i++) {

				avgRating += (double) data.get(i);
			}
			return (double) avgRating / data.size();
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	public List<Reviews> GetDataReviewsByProductID(String product_id) {
		List<Reviews> listReviews = new ArrayList<>();
		try {
			String sql = "SELECT * FROM reviews WHERE product_id ='" + product_id + "'";
			listReviews = _JdbcTemplate.query(sql, new MapperReviews());
			return listReviews;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public int GetAmountOfReviews(String product_id) {
		List<Reviews> listReviews = new ArrayList<>();
		try {
			String sql = "SELECT * FROM reviews WHERE product_id='" + product_id + "'";
			listReviews = _JdbcTemplate.query(sql, new MapperReviews());
			return listReviews.size();
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}

	}

	public Reviews EditRatingReviews(Reviews reviews, double ratingValue) {
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
