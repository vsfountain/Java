package com.kers.services;

import com.kers.daos.UserDAO;
import com.kers.daos.UserDAOImpl;
import com.kers.models.User;

public class UserServiceImpl implements UserService{
	
	UserDAO udao = new UserDAOImpl();

	@Override
	public User getUserByUsername(String username) {
		return udao.selectUserByUsername(username);
	}

	@Override
	public User getUserbyUsernameAndPassword(String username, String password) {
		return udao.selectUserByUsernameAndPassword(username, password);
	}
	
}
