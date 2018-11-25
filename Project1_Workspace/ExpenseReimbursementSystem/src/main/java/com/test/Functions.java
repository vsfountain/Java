package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Functions {

	public static String getCustomerHash(Connection con, String username, String password) throws SQLException {
		String extra = "SALT";
		return MD5.crypt(username+password+extra);
	}
	
	public static String checkCredentials(Connection con, String username, String password) throws SQLException{
		String hash = null;
		hash = getCustomerHash(con, username, password);
		return hash;
	}
	
	public static void updateReimbStatus(Connection con, int id, String status, String resolver) throws SQLException {
		int t_reimb_status_id;
		int t_resolver_id;
		Timestamp t_resolved;
		
		ResultSet rs = query(con, ("SELECT ers_users_id FROM ers_users WHERE ers_username = " + resolver));
		t_resolver_id = rs.getInt(0);
		
		rs = query(con, ("SELECT reimb_status_id FROM ers_reimbursement_status WHERE reimb_status = " + status));
		t_reimb_status_id = rs.getInt(0);
		
		rs = query(con, ("SELECT CURRENT_TIMESTAMP FROM DUAL"));
		t_resolved = rs.getTimestamp(0);
		
		rs = query(con, ("UPDATE ers_reimbursement SET reimb_resolved = " + t_resolved + ", reimb_resolver = " + t_resolver_id + ", reimb_status_id = " + t_reimb_status_id + " WHERE reimb_id = " + id));
				
	}
	
	public static ResultSet query(Connection con, String sql) throws SQLException {
	    return con.createStatement().executeQuery(sql);
	}

}
