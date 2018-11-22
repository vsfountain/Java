package com.ErsReimbursement.dao;

import com.ErsReimbursement.model.User;
import com.ErsReimbursement.service.UserService;
import com.ErsReimbursement.service.UserServiceImpl;

public class UserDaoImpl implements UserDao {
	
	private UserService staff = new UserServiceImpl();

	static {
		// This is how we can make sure our tomcat knows what to do when calling DB
		// make sure you add ojdbc to WEB-INF and add to build-path
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public User selectUserByLoginInfo(String userName, String passWord) {
		return staff.selectUserByLoginInfo(userName, passWord);
	}


	@Override
	public User selectByusername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User selectUserByPassWord(String passWord) {
		// TODO Auto-generated method stub
		return null;
	}
}




	