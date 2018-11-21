package com.jwjibilian.services;

import java.util.ArrayList;

import com.jwjibilian.daos.UserDAO;
import com.jwjibilian.daos.UserDAOImpl;
import com.jwjibilian.model.user.User;

public class UserServiceImpl implements UserService {
	
	UserDAO dao = new UserDAOImpl();

	@Override
	public User getUser(int id) {
		return dao.getUser(id);
	}

	@Override
	public User userLogin(String username, String password) {
		return dao.userLogin(username, password);
	}

	@Override
	public ArrayList<User> getAllUserReimbursements() {
		return dao.getAllUserReimbursements();
		}


}
