package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repository.FoodDao;

@Controller
@RequestMapping(value="/enriko")
public class FoodController {

	@Autowired
	private FoodDao foodDao;
	
	public FoodController() {
	}
	
	
}
