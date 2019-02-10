package com.bankofdikoko.service;


import org.springframework.stereotype.Service;

import com.bankofdikoko.dao.UserDao;
import com.bankofdikoko.model.User;

@Service("userservice")
public class UserService {
	
	UserDao u;
	
	public User getUser(String username) {
		
		User user = u.findByName(username);
		return user;
	}

}
