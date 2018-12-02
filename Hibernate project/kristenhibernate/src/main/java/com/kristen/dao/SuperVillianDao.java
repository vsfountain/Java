package com.kristen.dao;

import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;

import com.kristen.model.SuperVillain;
import com.kristen.util.HibernateUtil;

/*
 * Session methods
 * save() and persist() result in a sql insert
 * update(0 and merge() result in a sql update
 * delete() result in a sql delete
 * saveOrUpdate() results in either a sql insert or update (depending)
 * get() and load() results in a sql select
 * get ()will go to the database immediately
 * load() will use a placeholer(called a proxy) until you need the value
 * update() will not allow duplicate ids insude of your cache
 * merge will insert into the cache or overwrite the existing cache value
 * 
 */
public class SuperVillianDao {
	public SuperVillianDao() {

	}

	public void insert(SuperVillain myVill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(myVill);
		tx.commit();
		// ses.close(); was demo that it was not a required,
		// we also removed it to fix an exception the problem was that the main never
		// had access to the session because it was being closed
		// within each DAO method.
	}
	public void update (SuperVillain myVill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(myVill);
		tx.commit();
		//ses.close(); demo  for exception error
	}
	public SuperVillain selectByID (int id) {
		Session ses = HibernateUtil.getSession();
		SuperVillain myVill = ses.get(SuperVillain.class, id);
		//ses.close();
		return myVill;
	}
	public SuperVillain selectByName(String name) {
		Session ses = HibernateUtil.getSession();
		/*HQL
		 * the attribute needs to be in single quotes
		 * HQL uses Hibernate class names instead of the able names*/
		
		 List <SuperVillain> villList = ses.createQuery("from SuperVillain" +" whwre name ="+name, SuperVillain.class).list();
		 SuperVillain myVill=villList.get(0);
		 return myVill;
	}
	
	public List<SuperVillain>selectAll(){
		Session ses = HibernateUtil.getSession();
		List<SuperVillain> villList = ses.createQuery("from SuperVillain",SuperVillain.class).list();
		//ses.close();
		return villList;
		
		 
	
	}
}
