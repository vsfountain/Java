package com.test;

import java.sql.Connection;
import java.sql.SQLException;

public class Functions {

	public static String getCustomerHash(Connection con, String username, String password) throws SQLException {
		String extra = "SALT";
		return MD5.crypt(username+password+extra);
	}

}
