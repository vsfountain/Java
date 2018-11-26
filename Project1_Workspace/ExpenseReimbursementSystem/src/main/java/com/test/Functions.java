package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Functions {

	public static String getCustomerHash(Connection con, String username, String password) throws SQLException {
		String extra = "SALT";
		return MD5.crypt(username + password + extra);
	}

	public static String checkCredentials(Connection con, String username, String password) throws SQLException {
		String hash = null;
		hash = getCustomerHash(con, username, password);
		return hash;
	}

	public static void updateReimbStatus(Connection con, int id, String status, String resolver) throws SQLException {
		int t_reimb_status_id = 0;
		int t_resolver_id = 0;
		Timestamp t_resolved = null;

		ResultSet rs = query(con, ("SELECT ers_users_id FROM ers_users WHERE ers_username = '" + resolver + "'"));
		while (rs.next()) {
			t_resolver_id = rs.getInt(1);
		}

		rs = query(con, ("SELECT reimb_status_id FROM ers_reimbursement_status WHERE reimb_status = '" + status + "'"));
		while (rs.next()) {
			t_reimb_status_id = rs.getInt(1);
		}

		rs = query(con, ("SELECT CURRENT_TIMESTAMP FROM DUAL"));

		while (rs.next()) {
			t_resolved = rs.getTimestamp(1);
		}

		String sql = "UPDATE ers_reimbursement SET reimb_resolved = ? , reimb_resolver = ?, reimb_status_id = ? WHERE reimb_id = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setTimestamp(1, t_resolved);
		ps.setInt(2, t_resolver_id);
		ps.setInt(3, t_reimb_status_id);
		ps.setInt(4, id);
		ps.executeUpdate();
	}

	public static ResultSet query(Connection con, String sql) throws SQLException {
		return con.createStatement().executeQuery(sql);
	}

	public static void insertUsersId(Connection con, String username, String password, String firstname,
			String lastname, String email, int user_role_id) throws SQLException {
		/*ResultSet rs = query(con, "INSERT INTO ers_users VALUES(ers_users_id_seq.nextval, '" + username + "', '"
				+ password + "', '" + firstname + "', '" + lastname + "', '" + email + "', " + user_role_id);*/
		
		String sql = "INSERT INTO ers_users VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, firstname);
		ps.setString(4, lastname);
		ps.setString(5, email);
		ps.setInt(6, user_role_id);
		ps.executeUpdate();
	}

	public static void insertReimbId(Connection con, double amount, Timestamp submitted, String description,
			String author, String type) throws SQLException {
		int reimb_author_id = 0;
		int reimb_status_id = 101;
		int reimb_typeid = 0;

		ResultSet rs = query(con, ("SELECT ers_users_id FROM ers_users WHERE ers_username = '" + author + "'"));
		while (rs.next()) {
			reimb_author_id = rs.getInt(1);
		}

		rs = query(con, ("SELECT reimb_type_id FROM ers_reimbursement_type WHERE reimb_type = '" + type + "'"));
		while (rs.next()) {
			reimb_typeid = rs.getInt(1);
		}

		String sql = "INSERT INTO ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDouble(1, amount);
		ps.setTimestamp(2, submitted);
		ps.setString(3, description);
		ps.setInt(4, reimb_author_id);
		ps.setInt(5, reimb_status_id);
		ps.setInt(6, reimb_typeid);
		ps.executeUpdate();
	}

}
