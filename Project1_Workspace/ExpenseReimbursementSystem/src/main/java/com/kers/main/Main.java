package com.kers.main;

import com.kers.daos.UserDAO;
import com.kers.daos.UserDAOImpl;

public class Main {
	public static void main(String[] args) {
		UserDAO userD = new UserDAOImpl();
		System.out.println(userD.selectUserByUsernameAndPassword("seandoyle", "12345"));
		System.out.println(userD.selectUserByUsername("bronwenhughes"));
	}
}
