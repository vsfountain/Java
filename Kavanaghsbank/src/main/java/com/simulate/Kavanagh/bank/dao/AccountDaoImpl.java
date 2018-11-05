package com.simulate.Kavanagh.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simulate.Kavanagh.bank.model.Account;

public class AccountDaoImpl implements AccountDao {
	private static String url = "";
	private static String username = "";
	private  static String password = "";

	@Override
	public int insertAccount(Account a) {
		
		return 0;
	}

	@Override
	public List<Account>selectAllAccount() {
		List<Account>accts = new ArrayList<>();
		try (Connection conn= 
				DriverManager.getConnection(url,username,password))
				{
			String sql = "SELECT * From ACCOUNT";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
			accts.add(new Account(rs.getInt(1), rs.getString("status")));
			}

				} catch (SQLException e) {
					e.printStackTrace();
				}
				return accts;
				}
			
		
	@Override
	public Account selectAccountByAccountNumber(int accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account selectAccountBystatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAccount(Account a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAccount(Account a) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
