/**
 * 
 */
package com.kristen.mains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kristen.model.Food;
import com.kristen.repository.FoodDao;

/**
 * @author Kristen
 *
 */


public class Main {
	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	public static FoodDao foodDao = appContext.getBean("foodDao", FoodDao.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		insertInitialValues();
		System.out.println("All our foods:" + foodDao.selectAll());
	}

	public static void insertInitialValues() {

		Food food1 = new Food("Spaghetti", 500.1);
		foodDao.insert(food1);
		Food food2 = new Food("mcGriddle", 900.70);
		foodDao.insert(food2);
		Food food3 = new Food("Laab", 400);
		foodDao.insert(food3);
		Food food4 = new Food("Switzers", 100);
		foodDao.insert(food4);

	}
}



