package com.kristen.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kristen.model.Crime;
import com.kristen.util.HibernateUtil;

public class CrimeDao {
	public CrimeDao() {}
	public void insert (Crime myCrime) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(myCrime);
		tx.commit();
	}
public void update (Crime myCrime) {
	Session ses = HibernateUtil.getSession();
	Transaction tx = ses.beginTransaction();
	ses.update(myCrime);
	tx.commit();
}
	public Crime selectById (int id) {
		Session ses = HibernateUtil.getSession();
		Crime myCrime = ses.get(Crime.class, id);
		return myCrime;
}
	public List <Crime>selectAll(){
		Session ses = HibernateUtil.getSession();
		List<Crime>crimeList = ses.createQuery("from Crime", Crime.class).list();
		return crimeList;
		
	}
}
