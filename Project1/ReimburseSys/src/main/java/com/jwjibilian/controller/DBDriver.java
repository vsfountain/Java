package com.jwjibilian.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDriver {
	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}
	/** The url. */
	private static String url = 
			"jdbc:oracle:thin:@revy.ctgsqmepdtko.us-east-2.rds.amazonaws.com:1521:orcl";

	/** The username. */
	private static String username = "reimbursesys";

	/** The password. */
	private static String password = "p4ssw0rd";
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	public static void setItems(String url, String username, String password) {
		DBDriver.url = url;
		DBDriver.username = username;
		DBDriver.password = password;
	}
	@Override
	public String toString() {
		return "DBDriver ["+DBDriver.password+", " + DBDriver.url + ", "+ DBDriver.username+"]";
	}
	
}
