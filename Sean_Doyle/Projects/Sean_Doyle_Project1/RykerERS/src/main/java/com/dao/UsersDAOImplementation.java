package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.classes.User;

public class UsersDAOImplementation implements UsersDAO {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	final static Logger logger = Logger.getLogger(UsersDAOImplementation.class);
	private static String url = "jdbc:oracle:thin:@usf-revature-sean.ctfo6zflqljh.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "RykerIndustries";
	private static String password = "revature1";
	
	public UsersDAOImplementation(){
		url = "jdbc:oracle:thin:@usf-revature-sean.ctfo6zflqljh.us-east-2.rds.amazonaws.com:1521:orcl";
		username = "RykerIndustries";
		password = "revature1";
	}
	
	public UsersDAOImplementation(String _url, String _username, String _password) {
		url = _url;
		username = _username;
		password = _password;
	}
	
	//NEVER USED
	@Override
	public ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT u.ers_users_id, u.ers_username, u.user_first_name, u.user_last_name, u.user_email, "
					+ "r.user_role from (ers_users u LEFT OUTER JOIN ers_user_roles r ON "
					+ "u.user_role_id = r.ers_user_role_id) ORDER BY u.ers_users_id ASC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				users.add(new User(rs.getString("ers_username"), rs.getString("user_first_name"),
						rs.getString("user_last_name"), rs.getString("user_email"), rs.getString("user_role")));
			}
		} catch (SQLException e) {
			logger.error("@getUsers",e);
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User checkLoginCreds(String userName, String pwd) {
		User tempUser = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT u.ers_username, u.user_first_name, u.user_last_name, u.user_email, r.user_role from"
					+ " (ers_users u LEFT OUTER JOIN ers_user_roles r ON u.user_role_id = r.ers_user_role_id) "
					+ " WHERE ers_password = checkLoginCredentials(?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2,  pwd);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tempUser = new User(rs.getString("ers_username"), rs.getString("user_first_name"),
						rs.getString("user_last_name"), rs.getString("user_email"), rs.getString("user_role"));
			}
		} catch (SQLException e) {
			logger.error("@checkLoginCreds",e);
			e.printStackTrace();
		}
		return tempUser;
	}
}
