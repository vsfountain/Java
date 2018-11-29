package com.example.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * (class)
 * Configuration's job is to gather information from hibernate.cfg.xml
 *  and is used to create a session Factory.
 *  
 *  (interface)
 *  SessionFactory's job is to create sessions and store information on
 *   how to make connections to your database. Once it's configured it's
 *   immutable.
 *   
 *  (interface)
 *  Session manages the connection to your database and provides
 *  	create, read, update, and delete operations.
 *  
 *  (interface)
 *  Transaction manages...well....your transactions and cache (must be ACID)
 */

public class HibernateUtil {

	private static Session ses;
	
	private static SessionFactory sf =
			new Configuration().configure("hibernate.cfg.xml")
			.buildSessionFactory();
	
	public static Session getSession() {
		if(ses==null)
			ses=sf.openSession();
		
		return ses;
	}
	
	public static void closeSession() {
		ses.close();
		sf.close();
	}
}
/* Connection pool is a 
 * 
 * 
*/