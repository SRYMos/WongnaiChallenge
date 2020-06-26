package com.challenge.wongnai.serviceImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.wongnai.component.ReviewService;
import com.challenge.wongnai.entity.Review;
import com.challenge.wongnai.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	public void addDataReviewFromCSVToDB() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/templates/files/test_file.csv"));
	    String line =  null;
	    HashMap<Integer,String> map = new HashMap<Integer, String>();
	    int index = 0;
	    System.out.println("Waiting for add data review to data base...");
	    while((line=br.readLine())!=null){
	        String str[] = line.split(";");
	        try {
	        	if(str.length>1 && str[0].contains("[a-zA-Z]+") == false) {
	        		int id = Integer.parseInt(str[0]);
		        	index = id;
		        	map.put(index, str[1]);
	        	}else {
	        		map.put(index, map.get(index)+"\n"+str[0]);
	        	}
			} catch (Exception e) {
				if(str.length>1) {
					map.put(index, map.get(index)+str[0]+";"+str[1]);
		        }else {
		        	map.put(index, map.get(index)+"\n"+str[0]);
		        }
			}
	    }
	    Set<Integer> keySet = map.keySet(); 
	    ArrayList<Integer> listOfKeys = new ArrayList<Integer>(keySet);
	    int[] ct = new int[4];
	    ct[0] = 25*listOfKeys.size()/100;
	    ct[1] = 50*listOfKeys.size()/100;
	    ct[2] = 75*listOfKeys.size()/100;
	    ct[3] = listOfKeys.size();
	    for(int i=1;i<=listOfKeys.size();i++) {
	    	Review review = new Review();
	    	review.setReviewID(i);
	    	review.setReview(map.get(i));
	    	reviewRepository.save(review);
	    	int pc = (i+1)*100/listOfKeys.size();
	    	if(i==ct[0]||i==ct[1]||i==ct[2]||i==ct[3]) {
	    		System.out.println(pc+"%...");
	    	}
	    }
	    System.out.println("data review add to data base : Success");
	}
	
	public Review getReviewById(Review review) throws QueryException{
		try {
			List<Review> reviewList = new ArrayList<Review>();
			reviewList = reviewRepository.getReviewById(review.getReviewID());
			if(reviewList != null && reviewList.size() > 0) {
				review = reviewList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return review;
	}
	
	public Review saveReviewById(Review review) throws QueryException{
		try {
			review = reviewRepository.save(review);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return review;
	}
	
	public List<Review> getByKeyword(String query) throws QueryException{
		List<Review> reviewList = new ArrayList<Review>();
		try {
			reviewList = reviewRepository.getByKeyword(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewList;
	}
}
