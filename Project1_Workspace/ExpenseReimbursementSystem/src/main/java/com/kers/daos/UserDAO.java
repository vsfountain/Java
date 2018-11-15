package com.kers.daos;

import java.util.List;

import com.kers.models.User;

public interface UserDAO {
	
//	public int insertUser(User u);
	public List<User> selectAllUsers();
	public User selectUserById(int id);
	public User selectUserByUsername(String username);
	public User selectUserByUsernameAndPassword(String username, String password);
	public User updateUser(User u);
	public User deleteUser(User u);
}
