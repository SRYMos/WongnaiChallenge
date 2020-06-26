package com.challenge.wongnai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food_dictionary")
public class FoodDict {
	
	@Id
	@Column(name="foodID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodID;
	@Column(name="Keyword")
	private String keyword;
	
	public int getFoodID() {
		return foodID;
	}
	
	public void setFoodID(int reviewID) {
		this.foodID = reviewID;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
