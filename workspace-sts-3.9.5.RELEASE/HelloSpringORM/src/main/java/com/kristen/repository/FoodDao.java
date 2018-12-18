package com.kristen.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kristen.food.Food;

// name our bean
@Repository("foodDao")
@Transactional
public class FoodDao {

	@Autowired
	private SessionFactory sesFact;

	public void insert(Food food) {
//		Session ses = sesFact.openSession();
//		Transaction tx = ses.beginTransaction();
//		ses.save(food);
//		tx.commit();
//		ses.close();
		sesFact.getCurrentSession().save(food);

	}

	public void update(Food food) {
		sesFact.getCurrentSession().update(food);
	}

	public Food selectById(int id) {
		return sesFact.getCurrentSession().get(Food.class, id);
	}

	public List<Food> selectAll() {
//		Session ses= sesFact.openSession();
//				List<Food> foodList= ses.createQuery("from Food",Food.class).list();
//				ses.close();
//		return foodList;
		return sesFact.getCurrentSession().createQuery("from Food",Food.class).list();
	}
}
