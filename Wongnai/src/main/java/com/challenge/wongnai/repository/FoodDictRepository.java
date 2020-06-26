package com.challenge.wongnai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import com.challenge.wongnai.entity.FoodDict;

public interface FoodDictRepository extends JpaRepository<FoodDict, Long> {
	
	@Query(value="select * from food_dictionary d where d.keyword=?1", nativeQuery=true)
	FoodDict getByKeyword(String query);
}
