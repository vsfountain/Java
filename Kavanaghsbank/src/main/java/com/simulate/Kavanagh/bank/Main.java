package com.simulate.Kavanagh.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import org.apache.log4j.Logger;



	public  class Main {
		private static String url ="jdbc:oracle:thin:@kristen.cu5uh73jvis1.us-east-2.rds.amazonaws.com:1521:kristen";
		private static String username = "";
		private static String password = "";
		final static Logger logger = Logger.getLogger(Main.class);
	
	public static void main (String []args) {
		if(logger.isInfoEnabled()) {
			logger.info("This is info: loggers are cool");
		}
		
		logger.warn("This is a warning....");
		logger.error("This is an error:",
				new IndexOutOfBoundsException());
		logger.fatal("This is fatal:");
		logger.info("");



		//statementExample
		//preparedStatementExample
		//callableStatementExample
		System.out.println("Complete");
	}
 public static void preparedStatementExample( int client_id, String firstName, String lastName, double income, int creditScore, 
		 char address, String city,String state, char postalCode, char telePhoneNumber, char customerEmail, char userName, char passWord) {
	 try (Connection conn = DriverManager.getConnection(url, username, password))
	 {
		 String sql = "INSERT INTO Customer (int client_id, String firstName,String lastName, double income, int creditScore, char address,"
		 		+ "String state,char postalCode,char telePhoneNumber, char customerEmail, char userName, char passWord pokemon_type)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setString(1,  p_name);
		 ps.setString(2, p_type);
		 ps.executeUpdate();
	 } catch (SQLException e) {
		 e.printStackTrace();
		 		 
	 }
 }
}
