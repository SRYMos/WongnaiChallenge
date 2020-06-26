package com.challenge.wongnai.component;

import java.io.IOException;
import java.util.List;

import org.hibernate.QueryException;

import com.challenge.wongnai.entity.Review;

public interface ReviewService {
	
	public void addDataReviewFromCSVToDB() throws IOException;
	public Review getReviewById(Review review) throws QueryException;
	public Review saveReviewById(Review review) throws QueryException;
	public List<Review> getByKeyword(String query) throws QueryException;
}
