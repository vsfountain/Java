package com.dao.transaction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;

import com.profiles.Transaction;

public class TransactionDAOImplementation implements TransactionDAO{
	private static String url = "jdbc:oracle:thin:@usf-revature-sean.ctfo6zflqljh.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "RykerIndustries";
	private static String password = "revature1";
	
	@Override
	public int insertTransaction(Transaction t) {
		int rs = 0;
		try (Connection conn =  DriverManager.getConnection(url, username, password)){
			String sql = "INSERT INTO transactions (amount, accountnum, transdesc, dateof, transaction_id, clientnum) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1,  t.getAmount());
			ps.setInt(2,  t.getAccountNum());
			ps.setString(3,  t.getTransDesc());
			ps.setString(4, t.getDate()+"");
			ps.setInt(5,  t.getTransactionID());	
			ps.setInt(6,  t.getClientNum());
			rs = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ArrayList<Transaction> selectAllTransactions(int accountNum) {
		ArrayList<Transaction> transactions = new ArrayList<>();
		try (Connection conn =  DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM transactions WHERE accountnum = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  accountNum + "");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {				
				transactions.add(new Transaction(rs.getDouble("amount"), rs.getInt("accountnum"), rs.getString("transdesc"), Instant.parse(rs.getString("dateof")), rs.getInt("transaction_id")) );
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}

	@Override
	public void wipeDB(String verify) {
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{call wipedb(?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, verify);
			int status = cs.executeUpdate();
			System.out.println("CallableStatement returns: " + status);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
