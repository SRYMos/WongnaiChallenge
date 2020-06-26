package com.challenge.wongnai.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.wongnai.component.FoodDictService;
import com.challenge.wongnai.entity.FoodDict;
import com.challenge.wongnai.repository.FoodDictRepository;

@Service
public class FoodDictServiceImpl implements FoodDictService {

	@Autowired
	private FoodDictRepository FoodDictRepository;
	
	public void addDataFoodDictToDB() throws FileNotFoundException {
		try {
		      File myObj = new File("src\\main\\resources\\templates\\files\\food_dictionary.txt");
		      Scanner myReader = new Scanner(myObj);
		      int brk = 0;
		      System.out.println("Waiting for add data food dictionary to data base...");
		      while (myReader.hasNextLine()) {
		    	  FoodDict foodDict = new FoodDict();
		    	  foodDict.setKeyword(myReader.nextLine());
		    	  FoodDictRepository.save(foodDict);
		    	  brk++;
		    	  int pc = brk*100/20000;
		    	  if(brk==5000||brk==10000||brk==15000||brk==20000) {
		    		  System.out.println(pc+"%...");
		    	  }
		    	  if(brk==20000) {
		    		  break;
		    	  }
		      }
		      myReader.close();
		      System.out.println("data food dictionary add to data base : Success");
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public FoodDict getByKeyword(String query) throws QueryException{
		FoodDict foodDict = new FoodDict();
		foodDict = FoodDictRepository.getByKeyword(query);
		return foodDict;
	}
}
