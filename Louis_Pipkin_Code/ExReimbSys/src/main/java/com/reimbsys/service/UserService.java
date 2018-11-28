package com.reimbsys.service;

import java.util.Map;

import com.reimbsys.model.User;

public interface UserService {

	//GETTERS
	public User getUser(String username);
	public Map<String, User> getAllUsers();
	public String getHash(String username, String password);
	public String getRole(String username);
	
	public boolean authenticate(String username, String password);
	
}
