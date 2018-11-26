package com.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.h2.api.Trigger;

public class TriggerErsUsers implements Trigger{

	@Override
	public void init(Connection conn, String schemaName, String triggerName, String tableName, boolean before, int type)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fire(Connection conn, Object[] oldRow, Object[] newRow) throws SQLException {
		oldRow[2] = Functions.getCustomerHash(conn, (String)oldRow[1], (String)oldRow[2]);
		
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
