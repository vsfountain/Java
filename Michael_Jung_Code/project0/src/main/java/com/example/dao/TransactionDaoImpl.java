package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.model.Transaction;

public class TransactionDaoImpl implements TransactionDao{

	
	
	
	private static String url =
			"jdbc:oracle:thin:@revy-chan.cjfdvsamxdlk.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "usfdb";
	private static String password = "usf12345";
	
	
	@Override
	public int insertTransaction(Transaction t) {
		
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			
			String sql = " { call insert_transaction_null_id(?,?,?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, t.getAccountId());
			cs.setInt(2,  t.getTransferAccountId());
			cs.setString(3, t.getDescription());
			
			int status = cs.executeUpdate();
			
			return status;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}
}
