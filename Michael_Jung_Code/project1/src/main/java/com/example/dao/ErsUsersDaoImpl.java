package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.ErsUser;

public class ErsUsersDaoImpl implements ErsUsersDao{
	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	private static String url =
					"jdbc:oracle:thin:@revy-chan.cjfdvsamxdlk.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "usfdb";
	private static String password = "usf12345";
	
	
	@Override
	public List<ErsUser> selectAllFinanceManagers() {
		List<ErsUser> allFinanceManagers = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT * FROM ERS_USERS WHERE USER_ROLE_ID = 2";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				allFinanceManagers.add(new ErsUser(rs.getInt("ERS_USERS_ID"),
													rs.getString("ERS_USERNAME"),
													rs.getString("ERS_PASSWORD"),
													rs.getString("USER_FIRST_NAME"),
													rs.getString("USER_LAST_NAME"),
													rs.getString("USER_EMAIL"),
													rs.getInt("USER_ROLE_ID")));
				
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		return allFinanceManagers;
		
		
	}


	@Override
	public ErsUser selectErsUser(String loginUsername) {
		// TODO Auto-generated method stub
		
		ErsUser ersUser = null;
		
		try(Connection conn = DriverManager.getConnection(url, username, password))  {
			
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, loginUsername);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ersUser = new ErsUser(rs.getInt("ERS_USERS_ID"),
										rs.getString("ERS_USERNAME"),
										rs.getString("ERS_PASSWORD"),
										rs.getString("USER_FIRST_NAME"),
										rs.getString("USER_LAST_NAME"),
										rs.getString("USER_EMAIL"),
										rs.getInt("USER_ROLE_ID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ersUser;
		
		
		
		/*return null;*/
	}
	
	@Override
	public ErsUser selectErsUserById(int id) {
		
		ErsUser ersUser = null;
		
		try(Connection conn = DriverManager.getConnection(url, username, password))  {
			
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERS_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ersUser = new ErsUser(rs.getInt("ERS_USERS_ID"),
										rs.getString("ERS_USERNAME"),
										rs.getString("ERS_PASSWORD"),
										rs.getString("USER_FIRST_NAME"),
										rs.getString("USER_LAST_NAME"),
										rs.getString("USER_EMAIL"),
										rs.getInt("USER_ROLE_ID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ersUser;
		
		
		
	}
	
	
	
	
}
