package com.project1.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project1.objs.User;

public class UserDaoImpl implements UserDao{
	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}
	
	private static String url = "jdbc:oracle:thin:@revatur-instance.cyxb24oq9oml.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "ersdb";
	private static String password = "ers1234";
	
	@Override
	public User createUser(String u_name, String pass) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM ers_users WHERE "
					+ "ers_username='"+ u_name
					+ "' AND ers_password='" + pass + "'";
			

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				return new User(rs.getInt("ers_users_id"), 
						rs.getString("ers_username"), rs.getString("ers_password"), 
						rs.getString("user_first_name"), rs.getString("user_last_name"), 
						rs.getString("user_email"), rs.getInt("user_role_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	

}
