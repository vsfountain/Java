package com.example.dao;

/*Session methods
 * 
 * 	save() and persist()		result in a sql insert
 * 	update() and merge()		result in a sql update
 *  delete() 					result in a sql delete
 *  saveOrUpdate()				results in either a sql insert or update (depending)
 *  get() and load()			results in a sql select
 *  
 *  get()	will go to the database immediately
 *  load() will use a placeholder (called a proxy) until you need the value
 *  
 *  update() will not allow duplicate ids inside of your cache
 *  merge() will insert into the cache or overwrite the existing cache value
 * 
 */

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
		//ses.close();
	}

	public void update(SuperVillain myVill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.update(myVill);
		tx.commit();
		//ses.close();
	}

	public SuperVillain selectById(int id) {

		Session ses = HibernateUtil.getSession();

		SuperVillain myVill = ses.get(SuperVillain.class, id);
		//ses.close();

		return myVill;
	}

	public SuperVillain selectByName(String name) {
		
		Session ses = HibernateUtil.getSession();
		
		///////HQL
		//the attribute needs to be in single quotes
		//HQL uses Hibernate class names instead of the table names
		List<SuperVillain> villList = ses.createQuery("from SuperVillain"
				+" where name="+name, SuperVillain.class).list();
		//we can also do things like this:
		/*List<Integer> villList = ses.createQuery("select bounty from SuperVillain"
				+" where name="+name, SuperVillain.class).list();*/
		
		////////////////CRITERIA API
		//////no single quotes on the attribute when using criteria.
		/*List<SuperVillain> villList = ses.createCriteria(SuperVillain.class)
				.add(Restrictions.like("name", name)).list();*/
		
		/////////NATIVE SQL
		///uses db table names
		//single quotes again
		/*List<SuperVillain> villList = ses.createNativeQuery("select * from"+
				" Super_Villain where name="+name, SuperVillain.class).list();*/
		
		SuperVillain myVill = villList.get(0);
		
		return myVill;
	}

	public List<SuperVillain> selectAll() {
		Session ses = HibernateUtil.getSession();

		List<SuperVillain> villList = ses.createQuery("from SuperVillain",
				SuperVillain.class).list();

		//ses.close();
		return villList;
	}
}
