package com.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MAIN {
	// private static String url = "jdbc:oracle:thin:@localhost:1521:xe"; //
	private static String url = "jdbc:oracle:thin:@revy-chan.ciojmd28x67w.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "pokemondb";
	private static String password = "p4ssw0rd";

	public static void main(String[] args) {
		System.out.println("done");
		//statementExample("yx", "Fire");
	//	preparedStatementExample("Jones","Fire");
		CallableStatementExample("Louis", "Psychic");
		

	}
	
	public static void CallableStatementExample(String p_name, String p_type) 
	{
		try(Connection conn = DriverManager.getConnection(url, username,password))
		{
			String sql = "{ call insert_pokemon_null_id(?.?) }";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, p_name);
			cs.setString(2, p_type);
			
			int status = cs.executeUpdate();
			
		}catch(SQLException e) {}
	}
	
	public static void preparedStatementExample(String p_name, String r_type) {
		
		try(Connection conn =	
				DriverManager.getConnection(url, username, password))
		{
			String sql = "INSERT INTO pokemon(pokemon_name, pokemon_type) " + "Values(?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p_name);
			ps.setString(2, r_type);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void statementExample(String p_name, String p_type) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO pokemon(pokemon_name, pokemon_type) " + "Values('" + p_name + "','" + p_type+ "')";
			//pay attention to this
			
			Statement statement = conn.createStatement();
			int numOfRowsChanged = statement.executeUpdate(sql);
			System.out.println("The # of rows changed : "+ numOfRowsChanged);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
