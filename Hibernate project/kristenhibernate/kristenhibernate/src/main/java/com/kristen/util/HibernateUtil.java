package com.kristen.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Session ses;
	private static SessionFactory sf = 
			new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	public static Session getSession() {
		if (ses==null)
			ses=sf.openSession();
		return ses;
	}
			
public static void closeSession() {
	ses.close();
	sf.close();
}
/*Configuration class job is to gather information from hibernate.cfg.xml and is used to create a session Factory.
//SessionFactory's (interface)job is to create sessions and store information on how to make connections to your database.
//Once it's  configured it's immutable.
//Session(interface) manages the connections to your database and provides create, read, update and delete operations. 
//Transaction (interface) manages  transactions and caache (must be ACID)
*/
}
