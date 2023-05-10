package com.petshop.entity;

import java.sql.Date;

public class Reviews {
	private String reviewID;
	private String orderID;
	private String customerID;
	private String product_id;
	private String reviewText;
	private double Rating;
	private Date reviewDate;
	
	
	
	public Reviews(String reviewID, String orderID, String customerID, String product_id, String reviewText,
			double rating, Date reviewDate) {
		super();
		this.reviewID = reviewID;
		this.orderID = orderID;
		this.customerID = customerID;
		this.product_id = product_id;
		this.reviewText = reviewText;
		Rating = rating;
		this.reviewDate = reviewDate;
	}


	public String getOrderID() {
		return orderID;
	}


	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}


	public Reviews() {
		
	}


	
	public String getReviewID() {
		return reviewID;
	}


	public void setReviewID(String reviewID) {
		this.reviewID = reviewID;
	}


	public String getCustomerID() {
		return customerID;
	}


	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}


	public String getProduct_id() {
		return product_id;
	}


	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


	public String getReviewText() {
		return reviewText;
	}


	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}


	public double getRating() {
		return Rating;
	}


	public void setRating(double rating) {
		Rating = rating;
	}


	public Date getReviewDate() {
		return reviewDate;
	}


	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	


}
