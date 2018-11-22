package com.ErsReimbursement.dao;

import com.ErsReimbursement.model.User;


public interface UserDao {

	/**
	 * CRUD methods only
	 */
	

	public User selectByusername(String userName);

	public User selectUserByPassWord(String passWord);


 public User selectUserByLoginInfo(String userName, String passWord);

public static String getCurrUserName(String string) {
	// TODO Auto-generated method stub
	return null;
}
 
}


