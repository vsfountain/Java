package com.jwjibilian.services;

import com.jwjibilian.model.user.User;

public interface UserService {
	public User getUser(int id);
	public User userLogin(String username, String password);
}
