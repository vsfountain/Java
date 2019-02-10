 package com.bankofdikoko.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bankofdikoko.model.User;

@Repository("userDao")
@Transactional
public class UserDao {

	@Autowired
	private SessionFactory sesFact;
	
	public void insertUser(User user) {
		sesFact.getCurrentSession().save(user);
	}
	
	public User findByName(User user) {
		return sesFact.getCurrentSession().createQuery("from User where username = '" + user.getUserName() + "'", User.class).getSingleResult();
	}
	public User findByName(String username) {
		return sesFact.getCurrentSession().createQuery("from User where username = '" + username + "'", User.class).getSingleResult();
	}
	
}
