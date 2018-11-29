package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.SuperVillain;
import com.example.util.HibernateUtil;

public class SuperVillainDao {

	public SuperVillainDao() {
	}

	public void insert(SuperVillain myVill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.save(myVill);
		tx.commit();
		ses.close();
	}

	public void update(SuperVillain myVill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.update(myVill);
		tx.commit();
		ses.close();
	}

	public SuperVillain selectById(int id) {

		Session ses = HibernateUtil.getSession();

		SuperVillain myVill = ses.get(SuperVillain.class, id);
		ses.close();

		return myVill;
	}

	public SuperVillain selectByName(String name) {
		return null;
	}

	public List<SuperVillain> selectAll() {
		Session ses = HibernateUtil.getSession();

		List<SuperVillain> villList = ses.createQuery("from SuperVillain",
				SuperVillain.class).list();

		ses.close();
		return villList;
	}
}
