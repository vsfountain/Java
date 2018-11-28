package com.reimbsys.service;

import java.util.Map;

import org.apache.log4j.Logger;

import com.reimbsys.dao.UserDao;
import com.reimbsys.dao.UserDaoImpl;
import com.reimbsys.model.User;

public class UserServiceImpl implements UserService {

	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	private UserDao udao = new UserDaoImpl();

	@Override
	public User getUser(String username) {
		logger.info("UserServiceImpl, calling getUser: "+username);
		
		return udao.selectUserByUsername(username);

	}

	@Override
	public Map<String, User> getAllUsers() {
		logger.info("UserServiceImpl, calling getAllUsers: ");
		
		return udao.selectAllUsers();
	}

	@Override
	public String getHash(String username, String password) {
		logger.info("UserServiceImpl, calling gethash: "+username+", "+password);
		
		return udao.selectHash(username, password);
	}

	@Override
	public boolean authenticate(String username, String password) {
		logger.info("UserServiceImpl, calling authenticate: "+username);
		
		User us = this.getUser(username);
		String hash = this.getHash(username, password);

		System.out.println("username: "+username+" password: "+password);
		System.out.println(us);
		System.out.println("gotten hash: "+hash);
		
		if (hash.equals(us.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getRole(String username) {
		logger.info("UserServiceImpl, calling getRole: "+username);
		
		return this.getUser(username).getRole();
	}

}
