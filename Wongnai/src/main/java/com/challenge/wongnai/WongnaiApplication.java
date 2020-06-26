package com.challenge.wongnai;

//import java.io.IOException;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

//import com.challenge.wongnai.component.FoodDictService;
//import com.challenge.wongnai.component.ReviewService;

@SpringBootApplication
public class WongnaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WongnaiApplication.class, args);
	}
	
//	@Autowired
//	private ReviewService reviewService;
//	@Autowired
//	private FoodDictService foodDictService;
//	
//	@Bean
//	public void initialDB() throws IOException {
//		try {
//			reviewService.addDataReviewFromCSVToDB();
//			foodDictService.addDataFoodDictToDB();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
