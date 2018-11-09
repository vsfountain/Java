package com.simulate.Kavanagh.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simulate.Kavanagh.bank.model.Account;

public class AccountDaoImpl implements AccountDao {
	
	@Override
	public int insertAccount(Account accountBank) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{call insert_account_null_id(?,?,?,?,?,?,?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, accountBank.getClient_id());
			cs.setDouble(2, accountBank.getAccountBalance());
			cs.setDouble(3, accountBank.getInterestEarned());
			cs.setString(4, accountBank.getStatus());
			cs.setString(5, accountBank.getDescription());
			cs.setInt(6, accountBank.getisJointAccount());
			cs.setInt(7, accountBank.getjointAccountClientId());
			int status = cs.executeUpdate();
			System.out.println("CallableStatement return:" + status);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public List<Account> selectAllAccount() {
		List<Account> accts = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * From ACCOUNT";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accts.add(new Account(rs.getInt("accountNumber"), rs.getInt("client_id"),
						rs.getDouble("accountBalance"), rs.getDouble("interestEarned"), rs.getString("status"),
						rs.getString("description"), rs.getInt("isJointAccount"), rs.getInt("jointAccountClientId")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accts;

	}

	@Override
	public List<Account> selectAccountByAccountNumber(int accountNumber) {
		return null;
	}

	@Override
	public Account selectAccountBystatus(String status) {
		return null;
	}

	@Override
	public List<Account> selectAccountByclient_id(int client_id) {
		// System.out.println("done");

		List<Account> accountList = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "SELECT * From Account where client_id= ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, client_id);

			ResultSet rs = ps.executeQuery();
			System.out.println("thank you");
			while (rs.next())

			{

				accountList.add(new Account(rs.getInt("client_id"), rs.getInt("account_number"),
						rs.getDouble("account_Balance"), rs.getDouble("interestEarned"), rs.getString("status"),
						rs.getString("description"), rs.getInt("isJointAccount"), rs.getInt("jointAccountClientId")));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountList;

	}

	@Override
	public Account selectAccountByAccountBalance(double accountBalance) {
		return null;
	}

	@Override
	public Account selectAccountByInterestEarned(double interestEarned) {
		return null;
	}

	@Override
	public Account selectAccountByDescription(String description) {
		return null;
	}

	@Override
	public int updateAccount(Account accountBank) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "UPDATE  Account set Account_Balance = ? where Account_Number = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, accountBank.getAccountBalance());
			ps.setInt(2, accountBank.getAccountNumber());

			int status = ps.executeUpdate();
			System.out.println("thankyou");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAccount(Account accountBank) {

		return 0;
	}

	@Override
	public Account selectAllAccountByClient_id(int client_id) {

		return null;
	}

}
