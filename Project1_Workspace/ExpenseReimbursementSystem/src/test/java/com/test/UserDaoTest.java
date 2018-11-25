package com.test;

import org.junit.BeforeClass;

import com.kers.daos.UserDAO;
import com.kers.daos.UserDAOImpl;

public class UserDaoTest {
	
	private static UserDAO udao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		udao = new UserDAOImpl("jdbc:h2:./folder1/folder2/theData", "ersdb", "password");
	}
	
	
}
