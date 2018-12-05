package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Crime;
import com.example.util.HibernateUtil;

public class CrimeDao {

	public CrimeDao() {
	}
	
	public void insert(Crime myCrime) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.save(myCrime);
		tx.commit();
		//ses.close();
	}

	public void update(Crime myCrime) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.update(myCrime);
		tx.commit();
		//ses.close();
	}

	public Crime selectById(int id) {

		Session ses = HibernateUtil.getSession();

		Crime myCrime = ses.get(Crime.class, id);
		//ses.close();

		return myCrime;
	}

	public List<Crime> selectAll() {
		Session ses = HibernateUtil.getSession();

		List<Crime> crimeList = ses.createQuery("from Crime",
				Crime.class).list();

		//ses.close();
		return crimeList;
	}
}
