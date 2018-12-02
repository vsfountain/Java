package com.ErsReimbursement.dao;

import com.ErsReimbursement.model.User;

public interface UserDao {

	/**
	 * CRUD methods only
	 */


	public User selectUserByLoginInfo(String userName, String passWord);

	public String getCurrUserName(String currUserName);

}
