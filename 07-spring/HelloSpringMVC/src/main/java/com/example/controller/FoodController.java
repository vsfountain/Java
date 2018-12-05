package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Food;
import com.example.repository.FoodDao;

@Controller
@RequestMapping(value="/enriko")
public class FoodController {

	@Autowired
	private FoodDao foodDao;
	
	public FoodController() {
	}
	
	@GetMapping(value="/getAllFood.app")
	public @ResponseBody List<Food> getAllFoods() {
		return foodDao.selectAll();
	}
	
	
}
