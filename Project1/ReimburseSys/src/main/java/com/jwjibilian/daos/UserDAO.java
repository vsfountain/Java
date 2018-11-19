package com.jwjibilian.daos;

import java.util.ArrayList;

import com.jwjibilian.model.user.User;

public interface UserDAO {
	public User getUser(int id);
	public User userLogin(String username, String password);
	public ArrayList<User> getAllUserReimbursements();
}
