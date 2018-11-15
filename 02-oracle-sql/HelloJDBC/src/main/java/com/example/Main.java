package com.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * JDBC API. IMPORTANT INTERFACES:
 * 		CONNECTION
 * 		STATEMENT
 * 			PREPARED STATEMENT- precompiles the SQL string
 * 						without parameters.
 * 			CALLABLE STATEMENT- used with stored procedures
 * 
 * statement    vs   prepared statement
 * 		1. PS has better readability
 * 		2. PS more secure than statement
 * 
 * 
 * To connect to our database, 4 things are needed:
 * 		1. username
 * 		2. password
 * 		3. url (endpoint + port + DBname)
 * 		4. driver
 * 
 * 
 */
public class Main {

	//private static String url= "jdbc:oracle:thin:@localhost:1521:xe";
	private static String url=
			"jdbc:oracle:thin:@rainforest-closet.c4wt8faaxlgp.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username= "pokemondb";
	private static String password= "p4ssw0rd";
	
	
	public static void main(String[] args) {
		//statementExample("Alex","fire");
		//preparedStatementExample("John", "fighting");
		callableStatementExample("Louis","Psychic");
		System.out.println("done");
	}
	
	public static void callableStatementExample(String p_name,
											String p_type)
	{
		try(Connection conn=
				DriverManager.getConnection(url, username, password))
		{
			String sql= "{ call insert_pokemon_null_id(?,?) }";
			
			CallableStatement cs= conn.prepareCall(sql);
			cs.setString(1, p_name); //notice how we start at 1
			cs.setString(2, p_type);
			
			int status = cs.executeUpdate();
			System.out.println("CallableStatement returns: "+status);
		}catch(SQLException  e) {
			e.printStackTrace();
		}
	}
	
	public static void preparedStatementExample(String p_name,
											String p_type)
	{
		try(Connection conn=
				DriverManager.getConnection(url, username, password))
		{
			String sql= "INSERT INTO pokemon(pokemon_name, pokemon_type) "+
						"VALUES(?,?)";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, p_name);
			ps.setString(2, p_type);
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void statementExample(String p_name, String p_type) {
		try(Connection conn = 
				DriverManager.getConnection(url, username, password))
		{
			//this is sql injection
			//p_name=" pokemon2','other'); DROP TABLE important table;-- ";
			
			String sql = "INSERT INTO pokemon(pokemon_name, pokemon_type) "+
					"VALUES('" + p_name+"', '" + p_type+"' )";
			
			Statement statement =conn.createStatement();
			
			int numOfRowsChanged = statement.executeUpdate(sql);
			System.out.println("The # of rows changed: "+numOfRowsChanged);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
















