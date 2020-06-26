package com.challenge.wongnai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;

import com.challenge.wongnai.entity.Review;

public interface  ReviewRepository extends JpaRepository<Review, Integer> {
	
	@Query(value="select * from review r where r.ReviewID=?1", nativeQuery=true)
	List<Review> getReviewById(int reviewId);
	
	@Query(value="select * from review r where r.Review like %:query%", nativeQuery=true)
	List<Review> getByKeyword(String query);
}
