package com.kristen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kristen.model.Food;
import com.kristen.repository.FoodDao;

@Controller
@RequestMapping(value = "/enriko")
/*
 * @CrossOrigin(stuff) fixes the CORS issue of angular to Database
 *
 */
@CrossOrigin("stuff")
public class FoodController {

	@Autowired
	private FoodDao fooddao;

	public FoodController() {

	}

	// @GetMapping(value="/getAllFood.app")
	@RequestMapping(value = "/getAllFood.app", method = RequestMethod.GET)
	public @ResponseBody List<Food> getAllFoods() {
		return fooddao.selectAll();
	}
/*http://localhost:9005/HelloSpringMVC/enriko.getFoodById.app?id=2
	@RequestMapping(value = "/getFoodById.app", method = RequestMethod.POST, produces = "application/json", params = {
			"id" })
	public ResponseEntity<Food> getFoodById(int id) {

		return new ResponseEntity<Food>(fooddao.selectById(id), HttpStatus.OK);

	}*/
			
			
}
