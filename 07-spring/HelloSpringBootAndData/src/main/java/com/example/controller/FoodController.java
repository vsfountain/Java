package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Food;
import com.example.repo.FoodDao;

@Controller
public class FoodController {

	@Autowired
	private FoodDao foodDao;
	
	@GetMapping("/allfood.app")
	public @ResponseBody List<Food> findAllFood(){
	  return (List<Food>) foodDao.findAll();
	}

	@GetMapping("/food.app")
	public @ResponseBody List<Food> findFood() {
		Food clement = new Food("pizza", 1000);
		return foodDao.findByOrderByCaloriesDesc();
		//return foodDao.findByOrderByDishName();
		//return foodDao.findByDishName("Spaghetti");
		//return foodDao.findById(2).get();
	}
}
