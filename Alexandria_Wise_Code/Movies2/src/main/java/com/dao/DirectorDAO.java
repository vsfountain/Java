package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Director;
import com.util.HibernateUtil;

public class DirectorDAO {
	
	public DirectorDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert(Director myDirector) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.save(myDirector);
		tx.commit(); // DON'T FORGET TO COMMIT
		// ses.close();
	}

	public void update(Director myDirector) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.update(myDirector);
		tx.commit(); // DON'T FORGET TO COMMIT
		// ses.close();
	}

	public Director selectById(int id) {

		Session ses = HibernateUtil.getSession();
		// no transaction because there is no change to the database

		Director myDirector = ses.get(Director.class, id); // specifically tells it what type of object

		// ses.close();
		return myDirector;
	}

	public List<Director> selectAll() {
		Session ses = HibernateUtil.getSession();

		List<Director> directorList = ses.createQuery("from Director", Director.class).list();

		return directorList;
	}
}
