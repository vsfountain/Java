package com.kers.services;

import com.kers.models.User;

public interface UserService {
	public User getUserByUsername(String username);
	public User getUserbyUsernameAndPassword(String username, String password);
}
