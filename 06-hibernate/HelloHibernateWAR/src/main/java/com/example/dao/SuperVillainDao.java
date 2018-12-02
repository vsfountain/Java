package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.SuperVillain;
import com.example.util.HibernateUtil;

public class SuperVillainDao {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public SuperVillainDao() {
	}

	public void insert(SuperVillain myVill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.save(myVill);
		tx.commit();
	}

	public void update(SuperVillain myVill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.update(myVill);
		tx.commit();
	}

	public SuperVillain selectById(int id) {

		Session ses = HibernateUtil.getSession();

		SuperVillain myVill = ses.get(SuperVillain.class, id);

		return myVill;
	}

	public List<SuperVillain> selectAll() {
		Session ses = HibernateUtil.getSession();

		List<SuperVillain> villList = ses.createQuery("from SuperVillain",
				SuperVillain.class).list();
				
		return villList;
	}
}
