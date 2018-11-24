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

//	 static {
//			// This is how we can make sure our tomcat knows what to do when calling DB
//			// make sure you add ojdbc to WEB-INF and add to build-path
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		}

	

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