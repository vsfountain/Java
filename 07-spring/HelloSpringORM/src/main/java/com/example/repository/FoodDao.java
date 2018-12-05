package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Food;

@Repository("foodDao")
public class FoodDao {

	@Autowired
	private SessionFactory sesFact;
	
	public void insert(Food food) {
		Session ses = sesFact.openSession();
		Transaction tx = ses.beginTransaction();
		ses.save(food);
		tx.commit();
		ses.close();
	}

	public void update(Food food) {

	}

	public Food selectById(int id) {
		return null;
	}

	public List<Food> selectAll() {
		Session ses = sesFact.openSession();
		List<Food> foodList=ses.createQuery("from Food", Food.class).list();
		ses.close();
		
		return foodList;
	}
}
