package com.minifullstack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.minifullstack.model.Users;
import com.minifullstack.util.HibernateUtil;

public class UserDao {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public UserDao() {
	}

	public void insert(Users users) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(users);
		tx.commit();

	}

	public Users selectByUserName(String UserName) {
		Session ses = HibernateUtil.getSession();
		Users users = ses.get(Users.class, UserName);
		return users;
	}

public List<Users> selectAll() {
Session ses = HibernateUtil.getSession();
List<Users> usersList = ses.createQuery("from Users", Users.class).list();

return usersList;
}
}
