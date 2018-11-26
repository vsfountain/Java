package com.project1.service;

import com.project1.daos.UserDao;
import com.project1.daos.UserDaoImpl;
import com.project1.objs.User;

public class UserServiceImpl implements UserService{
	
	
	private UserDao user = new UserDaoImpl();

	@Override
	public User loginUser(String u_name, String pass) {
		return user.createUser(u_name, pass);
	}

}
