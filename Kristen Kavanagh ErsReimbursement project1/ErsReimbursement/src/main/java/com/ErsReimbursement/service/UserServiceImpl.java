package com.ErsReimbursement.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ErsReimbursement.model.User;

/**
 * @author Kristen Kavanagh
 * @version 11/15/2018
 *
 */
public class UserServiceImpl implements UserService {
	static {
		// This is how we can make sure our tomcat knows what to do when calling DB
		// make sure you add ojdbc to WEB-INF and add to build-path
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//private static UserDao udao = new UserDaoImpl();

	private static String url = "jdbc:oracle:thin:@kristen.cu5uh73jvis1.us-east-2.rds.amazonaws.com:1521:kristen";
	private static String username = "kristenzers";
	private static String password = "krisers1234";

	//User logUser =  udao.selectUserByLoginInfo(username,  password);

	
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
				//String dbName = rs.getString(2);
				//String dbPassword = rs.getString(3);
			}
			return String.valueOf(dbId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
}
//
//	@Override
//	public String getCurrPassword(String currUserName) {
//		try (Connection conn = DriverManager.getConnection(url, username, password)) {
//			String sql = "SELECT ers_password FROM ers_users WHERE ers_username=?";
//
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, currUserName);
//			ResultSet rs = ps.executeQuery();
//			rs.next();
//			String dbPassword = rs.getString(1);
//			return dbPassword;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return "";
//	}
//}
