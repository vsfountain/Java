package com.ers.model;

import java.sql.Timestamp;

public interface UserService {
	
	//user methods
	
	public User checkLogin(String userName,  String password);
	
	public Timestamp getCurrentTime();
	
	public void viewTickets();
	
	public void viewTicketsById(int userId);
	
	
	
	
}
