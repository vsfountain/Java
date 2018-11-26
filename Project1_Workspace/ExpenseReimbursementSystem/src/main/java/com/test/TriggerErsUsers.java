package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.h2.api.Trigger;

public class TriggerErsUsers implements Trigger{

	@Override
	public void init(Connection conn, String schemaName, String triggerName, String tableName, boolean before, int type)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void fire(Connection conn, Object[] oldRow, Object[] newRow) throws SQLException {
		String sql = "INSERT INTO ers_users (ers_users_id, ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)" 
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setObject(1, newRow[0]);
			ps.setObject(2, newRow[1]);
			ps.setObject(3, Functions.getCustomerHash(conn, (String)newRow[1], (String)newRow[2]));
			ps.setObject(4, newRow[3]);
			ps.setObject(5, newRow[4]);
			ps.setObject(6, newRow[5]);
			ps.setObject(7, newRow[6]);
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}*/
	
	@Override
	public void fire(Connection conn, Object[] oldRow, Object[] newRow) throws SQLException {
		String sql = "UPDATE ers_users SET ers_password = ? WHERE ers_username = ?";
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setObject(1, Functions.getCustomerHash(conn, (String)newRow[1], (String)newRow[2]));
			ps.setObject(2, newRow[1]);
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
