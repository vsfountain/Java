package com.ers.model;

public interface UserDAO {
	
	User login(String userName, String userPassword);
	void viewTickets();
	void viewTicketsById(int userId);
	
}
