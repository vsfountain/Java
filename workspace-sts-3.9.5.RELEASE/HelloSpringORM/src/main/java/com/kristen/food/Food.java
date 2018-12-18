package com.kristen.food;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Food")
public class Food {

	@Id
	@Column(name= "food_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodId;
	@Column(name= "dish_name", unique = true, nullable = false)
	private String dishName;
	@Column(name= "calories", nullable = false)
	private double calories;

	public Food() {

	}

	/**
	 * @param foodId
	 * @param dishName
	 * @param calories
	 */
	public Food(int foodId, String dishName, double calories) {
		super();
		this.foodId = foodId;
		this.dishName = dishName;
		this.calories = calories;

	}


	/**
	 * @param dishName
	 * @param calories
	 */
	public Food(String dishName, double calories) {
		super();
		this.dishName = dishName;
		this.calories = calories;
	}

	/**
	 * @return the foodId
	 */
	public int getFoodId() {
		return foodId;
	}

	/**
	 * @param foodId the foodId to set
	 */
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	/**
	 * @return the dishName
	 */
	public String getDishName() {
		return dishName;
	}

	/**
	 * @param dishName the dishName to set
	 */
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	/**
	 * @return the calories
	 */
	public double getCalories() {
		return calories;
	}

	/**
	 * @param calories the calories to set
	 */
	public void setCalories(double calories) {
		this.calories = calories;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", dishName=" + dishName + ", calories=" + calories + "]\n";
	}

}
