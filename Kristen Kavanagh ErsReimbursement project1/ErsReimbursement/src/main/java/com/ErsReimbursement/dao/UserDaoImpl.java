package com.ErsReimbursement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ErsReimbursement.model.Reimbursement;
import com.ErsReimbursement.model.User;

public class UserDaoImpl implements UserDao {
	static {
		// This is how we can make sure our tomcat knows what to do when calling DB
		// make sure you add ojdbc to WEB-INF and add to build-path
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// private static UserDao udao = new UserDaoImpl();

	private static String url = "jdbc:oracle:thin:@kristen.cu5uh73jvis1.us-east-2.rds.amazonaws.com:1521:kristen";
	private static String username = "kristenzers";
	private static String password = "krisers1234";

	// User logUser = udao.selectUserByLoginInfo(username, password);

	@Override
	public User selectUserByLoginInfo(String userName, String passWord) {
		 User staff = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM Ers_users WHERE ERS_username = ? and ERS_password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				staff = new User(rs.getInt("ERS_users_Id"), rs.getString("Ers_userName"), rs.getString("Ers_password"),
						rs.getString("User_first_name"), rs.getString("User_last_name"), rs.getString("User_email"),
						rs.getInt("user_role_Id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staff;
	}
	public  ArrayList<Reimbursement>selectUserByuserRoleId(int userRoleId) {
	ArrayList<Reimbursement> arryuserRoleId = new ArrayList<>();
	try (Connection conn = DriverManager.getConnection(url, username, password)) {
		String sql = "SELECT * FROM ERS_USERS WHERE USER_ROLE_ID = 2";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(7, userRoleId);
		ResultSet rs = ps.executeQuery();
		System.out.println("thank you");
		while (rs.next()) {

			arryuserRoleId.add(new Reimbursement(rs.getInt("Reimb_id"), rs.getDouble("reimb_amount"),
					rs.getString("Reimb_submitted"), rs.getString("reimb_resolved"),
					rs.getString("reimb_description"), rs.getInt("reimb_author"), rs.getString("reimb_resolver"),
					rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id")));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return arryuserRoleId;
	}
	@Override
	public String getCurrUserName(String currUserName) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM ers_users WHERE ers_username=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, currUserName);

			ResultSet rs = ps.executeQuery();
			int dbId = 0;
			while (rs.next()) {
				dbId = rs.getInt(1);
				  currUserName = rs.getString(2);
			 password = rs.getString(3);
			}
			return String.valueOf(dbId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	}

	
	

	 