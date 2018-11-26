package com.example.service;

import java.util.List;

import com.example.model.ErsUser;

public interface ErsUsersService {

	
	public List<ErsUser> getAllFinanceManagers();
	
	public ErsUser getFinanceManager(String username, String password);
	
	public ErsUser getErsUser(String username);
	
}
