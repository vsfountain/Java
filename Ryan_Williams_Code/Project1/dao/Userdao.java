package com.project1.dao;

import java.util.ArrayList;

import com.project1.userinfo.User;

public interface Userdao {
	//INSERT
	public int insertUser(User u);
	//READ
	public ArrayList<User> selectAllUser();
	public User selectUserById(int id);
	public User selectUserByFirstName(String name);
	public User selectUserByLastName(String name);
	public ArrayList <User> selectByType(String type);
	//UPDATE
	public int updateUser(User u);
	//DELETE
	public int deleteUser(User u);
}
