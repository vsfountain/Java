package com.reimbsys.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import com.reimbsys.model.Admin;
import com.reimbsys.model.Employee;
import com.reimbsys.model.User;

public class UserDaoImpl implements UserDao {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * User Mem. Data	| attributes returned by ers_users JOIN ers_user_roles
	 * 
	 * int usersId		| ers_users_id
	 * String username	| ers_username
	 * String password	| ers_password
	 * String firstName	| user_first_name
	 * String lastName	| user_last_name
	 * String email		| user_email
	 * int roleId		| user_role_id
	 * String role 		| user_role
	 */
	
	private static String url = "jdbc:oracle:thin:@revy-chan.cxm6xvuq7tje.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String dbUsername = "reimbsysdb";
	private static String dbPassword = "p4ssw0rd";
	
	@Override
	public int insertUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, User> selectAllUsers() {
		//SELECT * FROM ers_users u JOIN ers_user_roles r ON u.user_role_id=r.ers_user_role_id;
		Map<String, User> users = new HashMap<>();
		try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
			String sql= "SELECT * FROM ers_users u JOIN ers_user_roles r "
					+ "ON u.user_role_id=r.ers_user_role_id";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();

			while(rs.next()) {				
				//using the full constructor
				if ("Employee".equals(rs.getString("user_role"))) {
					User u = new Employee(Integer.parseInt(rs.getString("ers_users_id")), 
								rs.getString("ers_username"), 
								rs.getString("ers_password"), 
								rs.getString("user_first_name"),
								rs.getString("user_last_name"),
								rs.getString("user_email"),
								Integer.parseInt(rs.getString("user_role_id")),
								rs.getString("user_role")
							);
					users.put(u.getUsername(), u);
				} else if ("Admin".equals(rs.getString("user_role"))) {
					User u = new Admin(Integer.parseInt(rs.getString("ers_users_id")), 
								rs.getString("ers_username"), 
								rs.getString("ers_password"), 
								rs.getString("user_first_name"),
								rs.getString("user_last_name"),
								rs.getString("user_email"),
								Integer.parseInt(rs.getString("user_role_id")),
								rs.getString("user_role")
							);
					users.put(u.getUsername(), u);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public User selectUserByUsername(String username) {
		User user = new User();
		try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
			String sql= "SELECT * FROM ers_users u JOIN ers_user_roles r "
					+ "ON u.user_role_id=r.ers_user_role_id WHERE u.ers_username=?";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				//using the full constructor
				if ("Employee".equals(rs.getString("user_role"))) {
					user = new Employee(Integer.parseInt(rs.getString("ers_users_id")), 
								rs.getString("ers_username"), 
								rs.getString("ers_password"), 
								rs.getString("user_first_name"),
								rs.getString("user_last_name"),
								rs.getString("user_email"),
								Integer.parseInt(rs.getString("user_role_id")),
								rs.getString("user_role")
							);
				} else if ("Admin".equals(rs.getString("user_role"))) {
					user = new Admin(Integer.parseInt(rs.getString("ers_users_id")), 
								rs.getString("ers_username"), 
								rs.getString("ers_password"), 
								rs.getString("user_first_name"),
								rs.getString("user_last_name"),
								rs.getString("user_email"),
								Integer.parseInt(rs.getString("user_role_id")),
								rs.getString("user_role")
							);
				}
			} 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String selectHash(String username, String password) {
		String hash = null;
		try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword))
		{
			//return the account id
			String sql= "{ ? = call get_user_hash(?,?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, username);
			cs.setString(3, password);

			
			cs.executeUpdate();
			hash = cs.getString(1);
			//System.out.("CallableStatement returns: "+status);
		}catch(SQLException  e) {
			e.printStackTrace();
		}
		
		return hash;

	}
	
	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

}
