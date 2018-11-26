package com.example.dao;

import java.util.List;

import com.example.model.ErsUser;

public interface ErsUsersDao {

	
	//READ
	public List<ErsUser> selectAllFinanceManagers();
	public ErsUser selectErsUser(String username);
	public ErsUser selectErsUserById(int id);
	
	
	
}
