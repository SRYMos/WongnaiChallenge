package com.challenge.wongnai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.wongnai.component.FoodDictService;
import com.challenge.wongnai.component.ReviewService;
import com.challenge.wongnai.entity.FoodDict;
import com.challenge.wongnai.entity.Review;

@RestController
public class ReviewsController {
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private FoodDictService foodDictService;
	
	@RequestMapping(value = "/reviews/{id}", method = RequestMethod.GET)
	public Review getReviewsByIdd(@PathVariable("id") String id) {
		Review review = new Review();
		if(id != null && !id.isEmpty()) {
			try {
				review.setReviewID(Integer.parseInt(id));
				review = reviewService.getReviewById(review);
			} catch (Exception e) {
				
			}
		}
		return review;
	}
	
	@RequestMapping(value = "/reviews/{id}", method = RequestMethod.PUT)
	public Review saveReviewsById(@PathVariable("id") String id,@RequestBody Review review) {
		if(id != null && !id.isEmpty()) {
			try {
				review.setReviewID(Integer.parseInt(id));
				review = reviewService.saveReviewById(review);
			} catch (Exception e) {
				
			}
		}
		return review;
	}
	
	@RequestMapping(value = "/reviews", method = RequestMethod.GET)
	public List<Review> searchByKeywords(@RequestParam("query") String query) {
		List<Review> reviewList = new ArrayList<Review>();
		FoodDict foodDict = foodDictService.getByKeyword(query);
		if(foodDict != null) {
			reviewList = reviewService.getByKeyword(foodDict.getKeyword());
			if(reviewList != null && reviewList.size() > 0) {
				for(Review review:reviewList) {
					review.setReview(review.getReview().replace(query, "<mark>"+query+"</mark>"));
				}
			}else {
				Review review = new Review();
				review.setReviewID(0);
				review.setReview("No reviews that contain \""+query+"\"");
				reviewList.add(review);
			}
		}else {
			Review review = new Review();
			review.setReviewID(0);
			review.setReview("no keyword \""+query+"\" in keyword dictionary");
			reviewList.add(review);
		}
		return reviewList;
	}
}
