package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	//@GetMapping(value="/getAllFood.app")
	@RequestMapping(value="/getAllFood.app", method=RequestMethod.GET)
	public @ResponseBody List<Food> getAllFoods() {
		return foodDao.selectAll();
	}
	
	//http://localhost:9005/HelloSpringMVC/enriko/getFoodById.app?id=2
	@RequestMapping(value="/getFoodById.app", method=RequestMethod.POST,
			produces="application/json", params= {"id"})
	public ResponseEntity<Food> getFoodById(int id) {
		return new ResponseEntity<Food>(foodDao.selectById(id), HttpStatus.OK);
	}
	
	
}
