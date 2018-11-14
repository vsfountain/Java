package com.project1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project1.userinfo.User;

public class UserDaoImpl implements Userdao {
												   //allanimalsaredogs.cm0bal1gan4u.us-east-2.rds.amazonaws.com
	private static String url = "jdbc:oracle:thin:@allanimalsaredogs.cm0bal1gan4u.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Codereese";
	private static String password = "usf12345";
	
	@Override
	public int insertUser(User u) {
		
		return 0;
	}

	@Override
	public ArrayList<User> selectAllUser() {
		ArrayList<User> users = new ArrayList();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT * FROM ers_users";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			}
			System.out.println(users.get(1));
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User selectUserById(int id) {
		ArrayList<User> users = new ArrayList();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT * FROM ers_users WHERE ers_users_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			}
			System.out.println(users.get(0));
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return users.get(0);
	}

	@Override
	public User selectUserByFirstName(String name) {
		ArrayList<User> users = new ArrayList();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT * FROM ers_users WHERE ers_users_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			}
			System.out.println(users.get(0));
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return users.get(0);
	}
	
	@Override
	public User selectUserByLastName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> selectByType(String type) {
		// TODO Auto-generated method stub
		return null;
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
