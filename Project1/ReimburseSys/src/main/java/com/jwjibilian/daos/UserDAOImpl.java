package com.jwjibilian.daos;

import java.awt.Image;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.jwjibilian.controller.DBDriver;
import com.jwjibilian.model.reimbursement.Reimbursement;
import com.jwjibilian.model.user.Admin;
import com.jwjibilian.model.user.Client;
import com.jwjibilian.model.user.User;



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

	@Override
	public ArrayList<User> getAllUserReimbursements() {
		ArrayList<User> toReturn = new ArrayList<User>();
		
		ResultSet rs = null;
		
		String sql = "SELECT REIMB_AUTHOR, REIMB_ID, USER_FIRST_NAME, USER_LAST_NAME, REIMB_RESOLVER, REIMB_SUBMITTED, REIMB_RESOLVED, "+
				"REIMB_AMMOUNT, REIMB_TYPE, REIMB_STATUS, REIMB_RECEIPT, REIMB_DESCRIPTION " + 
				"FROM " + 
				"ERS_REIMBURSEMENT re " + 
				"LEFT JOIN ERS_REIMBURSEMENT_STATUS status on re.REIMB_STATUS_ID = status.REIMB_STATUS_ID " + 
				"LEFT JOIN ERS_REIMBURSEMENT_TYPE reType on re.REIMB_TYPE_ID = reType.REIMB_TYPE_ID " + 
				"LEFT JOIN ERS_USERS theUsers on theUsers.ERS_USERS_ID = REIMB_AUTHOR " + 
				"order by REIMB_AUTHOR, REIMB_SUBMITTED";
		try(Connection conn = theDriver.connect()){
			PreparedStatement cs = conn.prepareStatement(sql);
			rs = cs.executeQuery();
			int previousId = -10000;
			Client currentUser=null;
			while (rs.next()) {
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastname = rs.getString("USER_LAST_NAME");
				int id = rs.getInt("REIMB_AUTHOR");
				int reimbursId = rs.getInt("REIMB_ID");
				Admin resolver = new Admin(rs.getInt("REIMB_RESOLVER"), "", "", "", "", "", null);
				LocalDate timeSubmitted = rs.getObject("REIMB_SUBMITTED", LocalDate.class);
				LocalDate timeResolved = rs.getObject("REIMB_RESOLVED", LocalDate.class);
				double ammount = rs.getDouble("REIMB_AMMOUNT");
				String type = rs.getString("REIMB_TYPE");
				String status = rs.getString("REIMB_STATUS");
				Image recipit = null;
				String desc = rs.getString("REIMB_DESCRIPTION");
				
				if(id != previousId) {
					previousId = id;
					currentUser = new Client(id, null, null, firstName, lastname, null, new ArrayList<Reimbursement>());
					toReturn.add(currentUser);
				}
				Reimbursement toAdd =  new Reimbursement(
						reimbursId, ammount, timeSubmitted, timeResolved, 
						desc, recipit, null, resolver, 
						status, type);
				currentUser.addReimbursment(toAdd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toReturn;
	}

}
