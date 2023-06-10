package com.petshop.service;


import java.util.List;

import org.springframework.stereotype.Service;
import com.petshop.entity.Reviews;

@Service
public interface IReviewsSerVice {
	public int Add(Reviews reviews);
	public double AvgRating(String product_id);
	public List<Reviews> GetDataReviewsByProductID(String product_id);
	public int GetAmountOfReviews(String product_id);
	public Reviews EditRatingReviews(Reviews reviews,double ratingValue);
	public Reviews GetDataReviewsByReviewsID(String reviewsID);
	
}


