package com.simulate.Kavanagh.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

	public  class Main {
		private static String url ="jdbc:oracle:thin:@kristen.cu5uh73jvis1.us-east-2.rds.amazonaws.com:1521:kristen";
		private static String username = "kavanaghsbank";
		private static String password = "kristen1234";
	
	public static void main (String []args) {
		//statementExample
		//preparedStatementExample
		//callableStatementExample
		System.out.println("Complete");
	}
 public static void preparedStatementExample(String p_name, String p_type) {
	 try (Connection conn = DriverManager.getConnection(url, username, password))
	 {
		 String sql = "INSERT INTO pokemon (pokemon_name, pokemon_type)" + "VALUES (?,?)";
		 PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setString(1,  p_name);
		 ps.setString(2, p_type);
		 ps.executeUpdate();
	 } catch (SQLException e) {
		 e.printStackTrace();
		 		 
	 }
 }
}
