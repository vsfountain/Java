package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.HibernateUtil;
import com.model.Character;

public class CharacterDAO {
	
	public CharacterDAO() {
	}

	public void insert(Character myChar) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(myChar);
		tx.commit();       //DON'T FORGET TO COMMIT
	}
	
	public void update(Character myChar) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(myChar);
		tx.commit();       //DON'T FORGET TO COMMIT
	}
	
	public Character selectById(int id) {
		
		Session ses = HibernateUtil.getSession();
		//no transaction because there is no change to the database
		
		Character myChar = ses.get(Character.class, id); //specifically tells it what type of object 
	
		return myChar;
	}
	
	public Character selectByName(String name) {
		Session ses = HibernateUtil.getSession();
		
				List<Character> charList = ses.createNativeQuery("select * from"+ 
										" Character where name="+name, Character.class).list();
		
		Character myChar = charList.get(0);
		
		return myChar;
	}
	
	public List<Character> selectAll() {
		Session ses = HibernateUtil.getSession();
		
		List<Character> charList = ses.createQuery("from Character", Character.class).list();
		
		return charList;
	}

}
