package com.ErsReimbursement.service;

import com.ErsReimbursement.model.User;

/**
 * @author Kristen Kavanagh
 * @version 11/5/2018
 *
 */
public interface UserService {
public String getCurrUserName(String currUserName);
//	public String getCurrPassword(String currUserName);
	User selectUserByLoginInfo(String userName, String passWord);
	
	
}
