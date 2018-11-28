package com.dao;

import java.util.ArrayList;

import com.classes.User;

public interface UsersDAO {

	public ArrayList<User> getUsers();
	
	public User checkLoginCreds(String username, String password);
}
