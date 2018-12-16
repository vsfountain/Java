package com.example.repo;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.Model.Food;


public interface FoodDao extends CrudRepository<Food,Integer> {
	public Food findByDishName (String dishName);
	public List<Food> findByOrderByDishName();
	public List<Food> findByOrderByDishNameDesc();

	public Food findByCalories(double calories);
	public Food findByDishNameAndCalories(String dishName, double calories);


}
