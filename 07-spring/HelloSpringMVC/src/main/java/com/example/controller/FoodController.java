package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Food;
import com.example.repository.FoodDao;

@Controller
@RequestMapping(value="/enriko")
//@CrossOrigin(stuff)
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
	/*@RequestMapping(value="/getFoodById.app", method=RequestMethod.POST,
			produces="application/json", params= {"num"})
	public ResponseEntity<Food> getFoodById(int num) {
		return new ResponseEntity<Food>(foodDao.selectById(num), HttpStatus.OK);
	}*/
	
	@PostMapping(value="/getFoodById.app")
	public @ResponseBody Food getFoodById(@RequestParam int num) {
		return foodDao.selectById(num);
	}
	
	//http://localhost:9005/HelloSpringMVC/enriko/4/getFoodByUri.app
	@PostMapping(value="{num}/getFoodByUri.app")
	public @ResponseBody Food getFoodByUri(@PathVariable("num") int num) {
		return foodDao.selectById(num);
	}
	
}
