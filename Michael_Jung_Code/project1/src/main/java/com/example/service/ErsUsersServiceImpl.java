package com.example.service;

import java.util.List;

import com.example.dao.ErsUsersDao;
import com.example.dao.ErsUsersDaoImpl;
import com.example.model.ErsUser;

public class ErsUsersServiceImpl implements ErsUsersService{

	private ErsUsersDao ersUsers = new ErsUsersDaoImpl();
	
	
	@Override
	public List<ErsUser> getAllFinanceManagers() {
		// TODO Auto-generated method stub
		return ersUsers.selectAllFinanceManagers();
	}
	
	
	public ErsUser getFinanceManager(String username, String password) {
		ErsUser ersUserReturn = null;
		List<ErsUser> ersUsersList = ersUsers.selectAllFinanceManagers();
		for(ErsUser ersUser: ersUsersList) {
			if(ersUser.getUsername().equals(username)) {
				if(ersUser.getPassword().equals(password)) {
					ersUserReturn = ersUser;
				}
			}
		}
		return ersUserReturn;
		
		
	}
	
	
	public ErsUser getErsUser(String username) {
		return ersUsers.selectErsUser(username);
	}

}
