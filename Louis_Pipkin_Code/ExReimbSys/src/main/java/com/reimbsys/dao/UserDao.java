package com.reimbsys.dao;

import java.util.Map;

import com.reimbsys.model.User;

public interface UserDao {

	//CREATE
	public int insertUser(User u);
	
	//READ
	public Map<String, User> selectAllUsers();
	public User selectUserByUsername(String username);
	public String selectHash(String username, String password);
	
	//UPDATE
	public int updateUser(User u);
	
	//DELETE
	public int deleteUser(User u);
	
}
