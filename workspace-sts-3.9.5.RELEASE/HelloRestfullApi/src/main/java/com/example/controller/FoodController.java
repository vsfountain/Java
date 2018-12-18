package com.example.controller;


import java.util.List;

import com.example.model.Food;
/*What is a RESTful API?
		An API that follows the REST constraints.
		What are the REST constraints?
		Uniform Interface-
				In short, each entity's API should follow the same pattern. 
			No pattern should have more than one URI.
		Client Server-
		The client and server are separate entities. They exist independently.(client should only know URI.API IS ENCAPSULATED)
		Stateless-
		Servers dont; store any data about latest HTTP
		
		More on uniform Interface-
			how the "uri"s generally look
			GET: website.net/api/mymodel
				returns full list of objects
			GET:  website.net/api/mymodel/{id}
				returns single object with this id
			POST: website.net
			
		*/

@RestController
@RequestMapping("api/food")
public class FoodController {

	@Autowired
	private FoodDao foodDao;
	
	@GetMapping("/food.app")
	public @ResponseBody Food findFood() {
		return foodDao.findByDishName("Spaghetti");
	}
	
	@GetMapping(""")
	public @ResponseBody List<Food> findAllFood() {
		//return (List<Food>) foodDao.findAll();
		return foodDao.findByOrderByDishName();
	}
}
