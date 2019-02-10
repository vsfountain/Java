package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Food;

public interface FoodDao extends CrudRepository<Food, Integer> {
	public List<Food> findAll();
	public Food findByFoodId(int id);
}
