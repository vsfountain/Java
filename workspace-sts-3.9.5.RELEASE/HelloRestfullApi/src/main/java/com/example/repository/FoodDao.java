package com.example.repository;

import java.util.List;

public  interface FoodDao extends CrudRepository<Food,Integer>{
public List<Food>findAll();
public Food findByFoodId(int id);


}
