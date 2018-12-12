package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Food;
import com.example.repository.FoodDao;

/*What is a RESTful API?
 * 	An API that follows the REST constrAInts.
 * 
 * What are the REST constraints?
 * 		Uniform Interface-
 * 				In short, each entity's api should follow the same pattern.
 * 			No pattern should have more than one uri.
 * 		Client Server-
 * 				The client and server are separate entities. They exist
 * 			independently. (client should only know URI. API is encapsulated)
 * 		Stateless-
 * 				Servers don't store any data about latest HTTP request. It treats
 * 			each request as though it is a new request. No session, no history.
 * 		Cacheable-
 * 				resources must declare themselves as cacheable.
 * 		Layered System-
 * 				Client cannot tell whether it's connected to the original server
 * 			or some other intermediate server.
 * 		Code on demand (optional)-
 * 				You're able to send functional code if necessary. (like a UI
 * 			widget). Not only static code.
 * 
 * 
 * 	More on uniform Interface-
 * 		how the "uri"s generally look
 * 	GET:	website.net/api/mymodel
 * 		returns full list of objects
 *  GET:	website.net/api/mymodel/{id}
 *  	returns single object with this id
 *  POST:	website.net/api/mymodel
 *  	creates new record, body contains JSON
 *  PUT:	website.net/api/mymodel/{id}  OR   /api/mymodel/update
 *  	updates the record contained in the body (as JSON)
 *  DELETE:	website.net/api/mymodel/{id}  OR   /api/mymodel/delete/{id}
 *  	deletes the record
 *  
 * What is marshalling?
 * 		is the process of transforming an object into its serializable version
 * 		to be transmitted through the network. Unmarshalling is the opposite.
 * 		Marshalling tools:
 * 			Jackson (object -> JSON)
 * 			Jax-B	(object -> XML)
 * 
 * 
 */

@RestController
@RequestMapping("api/food")
public class FoodController {
	@Autowired
	private FoodDao foodDao;
	
	@GetMapping("")
	public List<Food> getAllFood() {
		return foodDao.findAll();
	}
	
	@GetMapping("/{id}")
	public Food findFood(@PathVariable int id) {
		return foodDao.findByFoodId(id);
	}
	
	@PostMapping("")
	public void insertFood(@RequestBody Food food) {
		foodDao.save(food);
	}
	
	@PutMapping("/update")
	public void updateFood(@RequestBody Food food) {
		foodDao.save(food);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteFood(@PathVariable int id) {
		foodDao.deleteById(id);
	}
	
	@GetMapping("/biteme")
	public ResponseEntity<Food> exceptionFood(){
		return new ResponseEntity<Food>(HttpStatus.I_AM_A_TEAPOT);
	}
}








