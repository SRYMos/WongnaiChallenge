package com.challenge.wongnai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
	
	@Id
	@Column(name="ReviewID")
	private int reviewID;
	@Column(name="Review",columnDefinition="TEXT")
	private String review;
	
	public int getReviewID() {
		return reviewID;
	}
	
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	
	public String getReview() {
		return review;
	}
	
	public void setReview(String review) {
		this.review = review;
	}
}
