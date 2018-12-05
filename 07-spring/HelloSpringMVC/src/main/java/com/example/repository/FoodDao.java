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
@Transactional
public class FoodDao {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Autowired
	private SessionFactory sesFact;

	public FoodDao() {
	}

	public void insert(Food food) {
		sesFact.getCurrentSession().save(food);
	}

	public void update(Food food) {
		sesFact.getCurrentSession().update(food);
	}

	public Food selectById(int id) {
		return sesFact.getCurrentSession().get(Food.class, id);
	}

	public List<Food> selectAll() {
		return sesFact.getCurrentSession().createQuery("from Food", Food.class).list();
	}
}
