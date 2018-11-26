package com.kers.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kers.models.User;

public class UserDAOImpl implements UserDAO {

	static {
		try {Class.forName("oracle.jdbc.driver.OracleDriver");} 
		catch (ClassNotFoundException e) {e.printStackTrace();}
	}

	private static String url = "jdbc:oracle:thin:@revychan.c75kj45zpjaq.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "ersdb";
	private static String password = "password";

	final static Logger logger = Logger.getLogger(UserDAOImpl.class);

	/*
	 * @Override public int insertUser(User u) { try (Connection con =
	 * DriverManager.getConnection(url, username, password)) { String sql =
	 * "{ call insert_ers_users_id_null(?, ?, ?, ?, ?, ?) }";
	 * 
	 * CallableStatement cs = con.prepareCall(sql); cs.setString(1,
	 * u.getUsername()); cs.setString(2, u.getPassword()); cs.setString(3,
	 * u.getFirstName()); cs.setString(4, u.getLastName()); cs.setString(5,
	 * u.getEmail()); cs.setInt(6, u.getRole_id());
	 * 
	 * return cs.executeUpdate();
	 * 
	 * } catch (SQLException ex) { ex.printStackTrace(); } return 0; }
	 */
	
	public UserDAOImpl() {}
	
	public UserDAOImpl(String url, String username, String password) {
		UserDAOImpl.url = url;
		UserDAOImpl.username = username;
		UserDAOImpl.password = password;
	}
	
	@Override
	public List<User> selectAllUsers() {
		logger.info("Getting all users");
		List<User> uList = new ArrayList<>();
		try(Connection con = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT ERS_USERS.ERS_USERNAME,  ERS_USERS.USER_FIRST_NAME,  ERS_USERS.USER_LAST_NAME, ERS_USERS.USER_EMAIL, ERS_USER_ROLES.USER_ROLE FROM ERS_USERS LEFT OUTER JOIN ERS_USER_ROLES ON  ERS_USERS.USER_ROLE_ID = ERS_USER_ROLES.ERS_USER_ROLE_ID";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				User u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				uList.add(u);
			}
			return uList;
			
		} catch (SQLException ex) {
			logger.fatal(ex);
		}
		return null;
	}

	@Override
	public User selectUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectUserByUsername(String username) {
		logger.info("Getting user from username: " + username );
		try (Connection con = DriverManager.getConnection(url, UserDAOImpl.username, password)) {
			// String sql = "SELECT * FROM users WHERE username = ?";
			String sql = "SELECT ERS_USERS.ERS_USERNAME,  ERS_USERS.USER_FIRST_NAME,  ERS_USERS.USER_LAST_NAME, ERS_USERS.USER_EMAIL, ERS_USER_ROLES.USER_ROLE FROM ERS_USERS LEFT OUTER JOIN ERS_USER_ROLES ON  ERS_USERS.USER_ROLE_ID = ERS_USER_ROLES.ERS_USER_ROLE_ID"
					+ " WHERE ERS_USERS.ERS_USERNAME = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				return u;
			}
		} catch (SQLException ex) {
			logger.fatal(ex);
		}
		return null;
	}

	@Override
	public User selectUserByUsernameAndPassword(String username, String password) {
		logger.info("Getting user from username and password, provided its correct: " + username + " " + password);
		try (Connection con = DriverManager.getConnection(url, UserDAOImpl.username, UserDAOImpl.password)) {
			// String sql = "SELECT * FROM users WHERE username = ?";
			String sql = "SELECT ERS_USERS.ERS_USERNAME,  ERS_USERS.USER_FIRST_NAME,  ERS_USERS.USER_LAST_NAME,  ERS_USERS.USER_EMAIL, ERS_USER_ROLES.USER_ROLE FROM ERS_USERS LEFT OUTER JOIN ERS_USER_ROLES ON  ERS_USERS.USER_ROLE_ID = ERS_USER_ROLES.ERS_USER_ROLE_ID"
					+ " WHERE ERS_USERS.ERS_PASSWORD = CHECK_CRENDENTIALS(?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				return u;
			}
		} catch (SQLException ex) {
			logger.fatal(ex);
		}
		logger.warn("There was no username and password associated with following: " + username + " " + password);
		return null;
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
