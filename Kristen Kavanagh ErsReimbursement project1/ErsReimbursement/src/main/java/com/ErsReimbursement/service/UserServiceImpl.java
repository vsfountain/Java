package com.ErsReimbursement.service;

import com.ErsReimbursement.dao.UserDao;
import com.ErsReimbursement.dao.UserDaoImpl;
import com.ErsReimbursement.model.User;

/**
 * @author Kristen Kavanagh
 * @version 11/15/2018
 *
 */
public class UserServiceImpl implements UserService {
	private UserDao staff = new UserDaoImpl();


	@Override
	public User selectUserByLoginInfo(String userName, String passWord) {
		return staff.selectUserByLoginInfo(userName, passWord);
	}

	@Override
	public String getCurrUserName(String currUserName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}