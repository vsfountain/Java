package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Food;

@Repository("foodDao")
//@Transactional
public class FoodDao {

	@Autowired
	private SessionFactory sesFact;
	@Transactional
	public void insert(Food food) {
		/*Session ses = sesFact.openSession();
		Transaction tx = ses.beginTransaction();
		ses.save(food);
		tx.commit();
		ses.close();*/
		
		sesFact.getCurrentSession().save(food);
	}

	@Transactional
	public void update(Food food) {
		sesFact.getCurrentSession().update(food);
	}

	public Food selectById(int id) {
		return sesFact.getCurrentSession().get(Food.class, id);
	}
	
	@Transactional
	public List<Food> selectAll() {
		/*Session ses = sesFact.openSession();
		List<Food> foodList=ses.createQuery("from Food", Food.class).list();
		ses.close();*/
		
		return sesFact.getCurrentSession()
				.createQuery("from Food", Food.class).list();
		
		//return foodList;
	}
}
