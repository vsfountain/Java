package com.project1.main;

import com.project1.dao.UserDaoImpl;
import com.project1.dao.Userdao;

public class Main {
	public static void main(String[] args) {
		Userdao name = new UserDaoImpl();
		name.selectUserById(1);
	}
}
