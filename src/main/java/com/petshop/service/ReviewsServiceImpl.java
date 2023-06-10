package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.petshop.dao.ReviewsDao;
import com.petshop.entity.Reviews;

@Service
public class ReviewsServiceImpl implements IReviewsSerVice{
	@Autowired
    private ReviewsDao reviewsDao;
	@Override
	public int Add(Reviews reviews) {
		// TODO Auto-generated method stub
		return reviewsDao.Add(reviews);
	}
	@Override
	public double AvgRating(String product_id) {
		// TODO Auto-generated method stub
		return reviewsDao.AvgRating(product_id);
	}
	@Override
	public List<Reviews> GetDataReviewsByProductID(String product_id) {
		// TODO Auto-generated method stub
		return reviewsDao.GetDataReviewsByProductID(product_id);
	}
	@Override
	public int GetAmountOfReviews(String product_id) {
		// TODO Auto-generated method stub
		return reviewsDao.GetAmountOfReviews(product_id);
	}
	@Override
	public Reviews EditRatingReviews(Reviews reviews,double ratingValue) {
		// TODO Auto-generated method stub
		return reviewsDao.EditRatingReviews( reviews,ratingValue);
	}
	@Override
	public Reviews GetDataReviewsByReviewsID(String reviewsID) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
