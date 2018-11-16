package com.jwjibilian.daos;

import com.jwjibilian.model.user.User;

public interface UserDAO {
	public User getUser(int id);
	public User userLogin(String username, String password);
}
