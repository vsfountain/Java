	package com.bank.connection;


public class DAOConnection {

	private static String url = "jdbc:oracle:thin:@revychan.c75kj45zpjaq.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "dbAdmin";
	private static String password = "adminPassword";
	
	public static String getUrl() {
		return url;
	}
	public static String getUsername() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
	
	
}
