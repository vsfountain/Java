package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Account;
public class AccountDaoImpl implements AccountDao {

	private static String url =
			"jdbc:oracle:thin:@revy-chan.cjfdvsamxdlk.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "usfdb";
	private static String password = "usf12345";
	
	
	
	
	
	
	@Override
	public int insertJointAccount(Account a) {
		// TODO Auto-generated method stub
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			
			String sql = " { call insert_account_null_id(?,?,?,?,?,?,?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, a.getCustomerNumber());
			cs.setInt(2, 1);
			cs.setInt(3, a.getJointCustomerNumber());
			cs.setInt(4, 0);
			cs.setInt(5, 0);
			cs.setInt(6, 1);
			cs.setInt(7, 0);
			
			int status = cs.executeUpdate();
			
			return status;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	@Override
	public int insertAccount(Account a) {
		// TODO Auto-generated method stub
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			
			String sql = " { call insert_account_null_id(?,?,?,?,?,?,?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, a.getCustomerNumber());
			cs.setInt(2, 0);
			cs.setInt(3, 0);
			cs.setDouble(4, 0);
			cs.setInt(5, 0);
			cs.setInt(6, 1);
			cs.setInt(7, 0);
			
			int status = cs.executeUpdate();
			
			return status;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return 0;
	}

	@Override
	public List<Account> selectAllAccount() {
		// TODO Auto-generated method stub
		List<Account> account = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			
			
			String sql = "SELECT * from Account";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			int accountNumber;
			int customerNumber;
			boolean isJointAccount;
			int jointCustomerNumber;
			double amount;
			boolean isApproved;
			boolean isWaitingForApproved;
			boolean isCancelled;
			
			while(rs.next()) {
				
				
				accountNumber = rs.getInt("account_id");
				customerNumber = rs.getInt("customer_number");
				isJointAccount = rs.getInt("joint_account_ind") == 1 ? true : false;
				if(isJointAccount) {
					jointCustomerNumber = rs.getInt("joint_customer_number");
					amount = rs.getDouble("amount");
					isApproved = rs.getInt("approved_ind") == 1 ? true : false;
					isWaitingForApproved = rs.getInt("waiting_for_approved_ind") == 1 ? true : false;
					isCancelled = rs.getInt("cancelled_ind") == 1 ? true : false;
					account.add(new Account(accountNumber, customerNumber, isJointAccount,
											jointCustomerNumber, amount, isApproved,
											isWaitingForApproved, isCancelled));
				} else {
					amount = rs.getDouble("amount");
					isApproved = rs.getInt("approved_ind") == 1 ? true : false;
					isWaitingForApproved = rs.getInt("waiting_for_approved_ind") == 1 ? true : false;
					isCancelled = rs.getInt("cancelled_ind") == 1 ? true : false;
					account.add(new Account(accountNumber, customerNumber, isJointAccount,
											amount, isApproved, isWaitingForApproved, isCancelled));
					
				}
				
				
				
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return account;
		//return null;
	}

	@Override
	public Account selectAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account selectAccountByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAccount(Account a) {
		// TODO Auto-generated method stub
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE account set customer_number=?, joint_account_ind=?, "
						+ "joint_customer_number=?, amount=?, approved_ind=?, "
						+ "waiting_for_approved_ind=?, cancelled_ind=? where "
						+ "account_id=?";
			
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, a.getCustomerNumber());
			ps.setInt(2, a.isJointAccount() == true ? 1 : 0);
			ps.setInt(3, a.getJointCustomerNumber());
			ps.setDouble(4, a.getAmount());
			ps.setInt(5, a.isApproved() == true ? 1 : 0);
			ps.setInt(6, a.isWaitingForApproved() == true ? 1 : 0);
			ps.setInt(7, a.isCancelled() == true ? 1 : 0);
			ps.setInt(8, a.getAccountNumber());
			
			int status = ps.executeUpdate();
			
			return status;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return 0;
	}

	@Override
	public int deleteAccount(Account a) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
