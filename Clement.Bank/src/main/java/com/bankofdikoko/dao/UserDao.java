 package com.bankofdikoko.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao implements DAOInterface{
//	public boolean userExists =false;
	
	public void registerUser(String uName,  String pass, String fName, String lName, String Email) {

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO users(username, password,firstname,lastname, email) " + "Values(?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uName);
			ps.setString(2, pass);
			ps.setString(3, fName);
			ps.setString(4, lName);
			ps.setString(5, Email);
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Didnt work");
			e.printStackTrace();
		}

	}
	
	public void removeUser(String first_name) {
		try(Connection conn = DriverManager.getConnection(url,username, password)){
			String remove = "Delete from users where username = ?";
			PreparedStatement removeUser = conn.prepareStatement(remove);
			removeUser.setString(1, first_name);
			removeUser.executeUpdate();
		} catch (SQLException e) {
		
		}
	}
	
	public boolean checkUserExists(String firstName){
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			String selectUser = "Select * from USERS where username = ?";
			PreparedStatement select = conn.prepareStatement(selectUser);
			select.setString(1,firstName);
			ResultSet rs = select.executeQuery();
			while(rs.next()) {
				String name = rs.getString(2);
				if(firstName.equals(name)) {
					System.out.println("username already exists my dawg");
					
					return false;
					//TODO call some kind of method return them to the login ( registerUser Menu)
				}
			}
			return true;
			
		} catch (SQLException e) {
		
		}
		return false;
	}
	
	//Checks arguments to see if they match the username and password in the database and returns true
	public boolean checkCredentials(String u, String pass) {try(Connection conn = DriverManager.getConnection(url, username, password)){
		
		String selectUser = "Select * from USERS where username = ?";
		PreparedStatement select = conn.prepareStatement(selectUser);
		select.setString(1,u);
		ResultSet rs = select.executeQuery();
		while(rs.next()) {
			String user = rs.getString(2);
			if(u.equals(user)) {
				System.out.println("Authenticating....");
				String name = rs.getString(3);
				if((pass.equals(name))) {
					return true;
				}else System.out.println("Invalid password! please try again!");
			}System.out.println("Invalid Username or Password! Please try again!");
		}
		return false;
		
	} catch (SQLException e) {
	
	}
	return false;
	
}
}
