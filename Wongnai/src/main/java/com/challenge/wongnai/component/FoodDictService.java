package com.challenge.wongnai.component;

import java.io.FileNotFoundException;

import org.hibernate.QueryException;

import com.challenge.wongnai.entity.FoodDict;

public interface FoodDictService {
	
	public void addDataFoodDictToDB() throws FileNotFoundException;
	public FoodDict getByKeyword(String query) throws QueryException;
}
