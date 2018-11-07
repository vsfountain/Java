package com.project0;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;

import org.apache.log4j.Logger;

public class ProfileDaoImpl implements ProfileDao {
	final static Logger logger = Logger.getLogger(ProfileDaoImpl.class);
	private static String url = "jdbc:oracle:thin:@allanimalsaredogs.cm0bal1gan4u.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Codereese";
	private static String password = "usf12345";
	
	@Override
	public ArrayList<Profile> selectAllProfile() {//retrieves all of the data from the banking table in SQL
		ArrayList<Profile> allProfiles = new ArrayList<>();
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= "SELECT * FROM banking";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();			
			while(rs.next()) {
				allProfiles.add(new Profile( rs.getString("name"), rs.getString("password"), rs.getInt("id"), rs.getInt("joinedId"), rs.getBoolean("isApproved"), rs.getBoolean("isActive"), rs.getBoolean("isJoined"), rs.getDouble("funds")));
			}
		}catch(SQLException e) {
			logger.error("Select * from banking table has caused an error:", new SQLException());
		}
		return allProfiles;
	}
	
	public void insertProfile(String name, String pw) {
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{call insert_profile_null_id(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);			
			cs.setString(1, name);
			cs.setString(2, pw);
			int status = cs.executeUpdate();
		}
		catch(SQLException e) {
			logger.error("Stored Procedure insert_profile_null_id has caused an error:", new SQLException());
		}
	}
		
	public void insertProfile(String name, String pw, int idNumber, int joinedId, double funds) {
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO banking(name, password, id, joinedId, isApproved, isActive, isJoined, funds) " + "VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);		
			ps.setString(1, name);
			ps.setString(2, pw);
			ps.setInt(3, idNumber);
			ps.setInt(4, joinedId);
			ps.setBoolean(5, false);
			ps.setBoolean(6, false);
			ps.setBoolean(7, true);
			ps.setDouble(8, funds);
			ps.executeUpdate();
		}
		catch(SQLException e) {
			logger.error("INSERT INTO banking has caused an error:", new SQLException());
		}
	}
	public void updateJoinedAccount(int id, int joinedId) {
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE banking SET joinedId = ? , isJoined = 1 WHERE id = ?";			
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setInt(1, id + 1 );//accounts for the index starting at 1 instead of 0
			ps.setInt(2, joinedId);
			ps.executeUpdate();			
		}
		catch(SQLException e) {
			logger.error("UPDATE banking, updateJoinedAccount method has caused an error:", new SQLException());
		}	
	}
	
	@Override
	public void updateFunds(double funds, int id) {
		try(Connection conn = DriverManager.getConnection(url, username, password)) {	
			String sql = "UPDATE banking SET funds = ? WHERE id = ?";			
			PreparedStatement ps = conn.prepareStatement(sql);			
			ps.setDouble(1, funds);
			ps.setInt(2, id);
			ps.executeUpdate();			
		}
		catch(SQLException e) {
			logger.error("updateFunds method has caused an error:", new SQLException());
		}		
	}
	
	@Override
	public void updateApprove( int val, int id) {//this is getting the index, NOT THE ID
		try(Connection conn = DriverManager.getConnection(url, username, password)) {		
			String sql = "UPDATE banking SET isApproved = ? WHERE id = ?";			
			PreparedStatement ps = conn.prepareStatement(sql);				
			ps.setInt(1, val);
			ps.setInt(2, id);
			ps.executeUpdate();			
		}
		catch(SQLException e) {
			logger.error("updateAPprove method has caused an error:", new SQLException());
		}	
	}	
	@Override
	public void updateActive( int val, int id) {
		try(Connection conn = DriverManager.getConnection(url, username, password)) {	
			String sql = "UPDATE banking SET isActive = ? WHERE id = ?";			
			PreparedStatement ps = conn.prepareStatement(sql);				
			ps.setInt(1, val);
			ps.setInt(2, id);
			ps.executeUpdate();			
		}
		catch(SQLException e) {
			logger.error("updateActive method has caused an error:", new SQLException());
		}	
	}	
	@Override
	public void updateJoined( int val, int id) {
		try(Connection conn = DriverManager.getConnection(url, username, password)) {	
			String sql = "UPDATE banking SET isJoined = ? WHERE id = ?";			
			PreparedStatement ps = conn.prepareStatement(sql);				
			ps.setInt(1, val);
			ps.setInt(2, id);
			ps.executeUpdate();			
		}
		catch(SQLException e) {
			logger.error("updateJoined method has caused an error:", new SQLException());
		}	
	}
	public void superSecretRobbery() {
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= "DROP TABLE banking";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();	//don't think this is necessary		
			
		}catch(SQLException e) {
			logger.error("Drop table method has caused an error:", new SQLException());
		}
	}
	
	
}

