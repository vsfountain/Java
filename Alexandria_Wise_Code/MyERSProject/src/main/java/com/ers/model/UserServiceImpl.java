package com.ers.model;

import java.sql.Timestamp;

public class UserServiceImpl implements UserService {

	private UserDAO uDAO = new UserDAOImpl();
	
	@Override
	public User checkLogin(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return uDAO.login(userName, userPassword);
	}

	@Override
	public Timestamp getCurrentTime() {
		return null;
	}

	@Override
	public void viewTickets() {
		uDAO.viewTickets();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewTicketsById(int userId) {
		uDAO.viewTicketsById(userId);
		// TODO Auto-generated method stub
		
	}

}
