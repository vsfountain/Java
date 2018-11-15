package com.dao.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.transaction.TransactionDAO;
import com.dao.transaction.TransactionDAOImplementation;
import com.profiles.Account;
import com.profiles.Transaction;

public class AccountDAOImplementation implements AccountDAO{
	private static String url = "jdbc:oracle:thin:@usf-revature-sean.ctfo6zflqljh.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "RykerIndustries";
	private static String password = "revature1";
	@Override
	public int insertAccount(Account a) {
		int rs = 0;
		try (Connection conn =  DriverManager.getConnection(url, username, password)){
			String sql = "INSERT INTO accounts (balance, myperson, accountnumber, jointly, isfrozen) VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1,  a.getAccountBalance());
			ps.setInt(2,  a.getClientID());//This is not correct
			ps.setInt(3,  a.getAccountNumber());
			if (a.checkJoint()) {
				ps.setString(4,  1 + "");
			} else {
				ps.setString(4,  0 + "");
			}
			if (a.getAccountStatus()) {
				ps.setString(5,  1 + "");
			} else {
				ps.setString(5,  0 + "");
			}
			rs = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public ArrayList<Account> selectAllAccounts() {
		ArrayList<Account> accounts = new ArrayList<>();
		try (Connection conn =  DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM accounts";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			TransactionDAO tsc = new TransactionDAOImplementation();
			ArrayList<Transaction> transactionList = new ArrayList<>();
			while(rs.next()) {
				transactionList = null;
				transactionList = tsc.selectAllTransactions(rs.getInt("accountnumber"));
				
				
				//need to get the account holders
				//ArrayList<Integer> holders = null;//need to build a getter
				int holders = rs.getInt("myperson");
				accounts.add(new Account(rs.getDouble("balance"), holders, rs.getInt("accountnumber"), rs.getInt("jointly")==1, transactionList, rs.getInt("isFrozen")==1) );
			}
			Account.accountCount = accounts.size()+666;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	@Override
	public Account getAccount(int accNum) {
		Account temp = null;
		try (Connection conn =  DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM accounts WHERE accountnumber = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  accNum);
			ResultSet rs = ps.executeQuery();
			TransactionDAO tsc = new TransactionDAOImplementation();
			ArrayList<Transaction> transactionList = new ArrayList<>();
			while(rs.next()) {
				transactionList = null;
				transactionList = tsc.selectAllTransactions(rs.getInt("accountnumber"));
				int holders = rs.getInt("myperson");
				temp = new Account(rs.getDouble("balance"), holders, rs.getInt("accountnumber"), rs.getInt("jointly")==1, transactionList, rs.getInt("isFrozen")==1);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	@Override
	public int updateAccount(Account a) {
		int rs = 0;
		try (Connection conn =  DriverManager.getConnection(url, username, password)){
			String sql = "UPDATE accounts SET balance = ?, myperson = ?, isfrozen = ? WHERE accountnumber = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1,  a.getAccountBalance());
			ps.setInt(2,  a.getClientID());//This is not correct
			if (a.getAccountStatus()) {
				ps.setString(3,  1 + "");
			} else {
				ps.setString(3,  0 + "");
			}
			ps.setInt(4,  a.getAccountNumber());
			rs = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public int deleteAccount(Account a) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deposit(Account a) {
		int rs = 0;
		try (Connection conn =  DriverManager.getConnection(url, username, password)){
			String sql = "UPDATE accounts SET balance = ? WHERE accountnumber = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  a.getAccountBalance() + "");
			ps.setString(2,  a.getAccountNumber() + "");
			rs = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public int withdraw(Account a) {
		int rs = 0;
		try (Connection conn =  DriverManager.getConnection(url, username, password)){
			String sql = "UPDATE accounts SET balance = ? WHERE accountnumber = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  a.getAccountBalance() + "");
			ps.setString(2,  a.getAccountNumber() + "");
			rs = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public Account lookUpAccount(int accountNumber) {
		Account account = null;
		try (Connection conn =  DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM accounts WHERE accountnumber = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			TransactionDAO tsc = new TransactionDAOImplementation();
			ArrayList<Transaction> transactionList = new ArrayList<>();
			while(rs.next()) {
				transactionList = null;
				transactionList = tsc.selectAllTransactions(rs.getInt("accountnumber"));				
				
				//need to get the account holders
				//ArrayList<Integer> holders = null;//need to build a getter
				int holders = rs.getInt("myperson");
				account = new Account(rs.getDouble("balance"), holders, rs.getInt("accountnumber"), rs.getInt("jointly")==1, transactionList, rs.getInt("isFrozen")==1);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	@Override
	public ArrayList<Integer> getAccountNums() {
		ArrayList<Integer> anums = new ArrayList<>();
		try (Connection conn =  DriverManager.getConnection(url, username, password)){
			String sql = "SELECT accountnumber FROM accounts";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				anums.add(rs.getInt("accountnumber"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return anums;
	}
	
}
