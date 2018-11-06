package com.bank.account.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.account.model.Account;
import com.bank.connection.DAOConnection;
import com.bank.customer.model.Customer;

public class AccountDAOImpl extends DAOConnection implements AccountDAO {

	@Override
	public int insertAccount(Account a) {
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "INSERT INTO accounts(accountid, balance, mainuserid, jointuserid) VALUES (?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a.getId());
			ps.setDouble(2, a.getBalance());
			ps.setInt(3, a.getMainUserId()); //a.getCustomers()
			ps.setInt(4, a.getJointUserId());

			ps.executeUpdate();
		} catch (SQLException e) {
			createAccountDB();
			e.printStackTrace();
			System.out.println("ohno");
		}
		return 0;
	}

	@Override
	public List<Account> selectAllAccount() {

		List<Account> accounts = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "SELECT * FROM accounts";

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts.add(new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			System.out.println("Hey i didnt work!");
			//e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Account selectAccountById(int id) {
		Account accounts = null;
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "SELECT * FROM accounts";

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts = new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
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

	@Override
	public int createAccountDB() {
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "CREATE TABLE Accounts("
					+ "AccountID NUMBER PRIMARY KEY,"
					+ "Balance DECIMAL(18,2),"
					+ "MainUserID NUMBER,"
					+ "JointUserID NUMBER,"
					+ "FOREIGN KEY (MainUserID) REFERENCES Customers(CustomerId))";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Account selectAccountByCustomerId(int customerId) {
		Account accounts = null;
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "SELECT * FROM accounts WHERE mainuserid = ? OR jointuserid = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, customerId);
			ps.setInt(2, customerId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts = new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

}
