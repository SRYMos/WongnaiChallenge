package com.challenge.wongnai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String searchById() {
		return "search_by_id";
	}
	
	@RequestMapping(value = "/searchKeyword", method = RequestMethod.GET)
	public String searchByKeyword() {
		return "search_by_keyword";
	}
	
	
}
