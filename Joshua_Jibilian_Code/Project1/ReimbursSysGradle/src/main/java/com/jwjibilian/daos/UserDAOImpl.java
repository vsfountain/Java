package com.jwjibilian.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jwjibilian.controller.DBDriver;
import com.jwjibilian.model.user.Admin;
import com.jwjibilian.model.user.Client;
import com.jwjibilian.model.user.User;

import oracle.jdbc.OracleTypes;

public class UserDAOImpl implements UserDAO {
	DBDriver theDriver = new DBDriver();
	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User userLogin(String username, String password) {
		
		ResultSet result = null;
		
		User toReturn = null;
		String hashedPassword = null;
		String userType = null;
		
		String sqlHash = " SELECT ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, " + 
				"USER_LAST_NAME, USER_ROLE, USER_EMAIL " + 
				"FROM ERS_USERS use left JOIN ERS_USER_ROLES roles " + 
				"ON use.USER_ROLE_ID = roles.ERS_USER_ROLE_ID " + 
				"WHERE ers_password = ERS_USERS__UNv1(?, ?)";
		
		try(Connection conn = theDriver.connect()){
			PreparedStatement cs = conn.prepareStatement(sqlHash);
			cs.setString(1, username);
			cs.setString(2, password);
			result = cs.executeQuery();
			
			
			result.next();
			
			userType = result.getString("user_role");
			int id = result.getInt("ers_users_id");
			String userName = result.getString("ERS_USERNAME");
			String firstName = result.getString("user_first_name");
			String lastname = result.getString("user_last_name");
			String email = result.getString("user_email");
			
			
			
			if (userType.equals("Admin")) {
				toReturn = new Admin(id, userName, null, firstName, lastname, email, null);
			} else {
				toReturn = new Client(id, userName, null, firstName, lastname, email, null);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toReturn;
	}

}
