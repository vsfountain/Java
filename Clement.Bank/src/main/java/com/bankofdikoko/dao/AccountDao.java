package com.bankofdikoko.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountDao implements DAOInterface {

	public void viewAccounts() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String view = "select * from account join users on users.username = account.accountname";
			PreparedStatement ps = conn.prepareStatement(view);
			ResultSet b = ps.executeQuery();
			while (b.next()) {
				System.out.print(b.getString(1) + "|");
				System.out.print(b.getString(2) + "|");
				System.out.print(b.getString(3) + "|");
				System.out.print(b.getString(4) + "|");
				System.out.print(b.getString(5) + "|");
				System.out.print(b.getString(6) + "|");
				System.out.print(b.getString(7) + "|");
				System.out.println(b.getString(8));
			}
		} catch (SQLException e) {
		
		}
	}

	public void registerAccount(String name, int balance) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String updateAccount = "insert into ACCOUNT(ACCOUNTNAME, BALANCE) values (?,?)";
			PreparedStatement upAcc = conn.prepareStatement(updateAccount);
			upAcc.setString(1, name);
			upAcc.setInt(2, balance);
			upAcc.executeUpdate();
		} catch (SQLException e) {
			
		}
	}

	public int checkBalance(String name) {

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String view = "select balance from account where accountname = ?";
			PreparedStatement ps = conn.prepareStatement(view);
			ps.setString(1, name);
			ResultSet b = ps.executeQuery();
			while (b.next()) {
				int balance = b.getInt(1);
				return balance;
			}
		} catch (SQLException e) {
			
		}
		return 0;
	}

	public void updateBalance(int transaction, String accountName) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String s = "update account set balance = ? where accountname = ?";
			PreparedStatement ps = conn.prepareStatement(s);
			ps.setInt(1, transaction);
			ps.setString(2, accountName);
			ps.executeQuery();
		} catch (SQLException s) {
			System.out.println("Something went wrong....");
		}
	}

	public void removeAccount(String edit) {
		// TODO Auto-generated method stub

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String remove = "Delete from account where accountname = ?";
			PreparedStatement removeUser = conn.prepareStatement(remove);
			removeUser.setString(1, edit);
			removeUser.executeUpdate();
		} catch (SQLException e) {
			
		}
	}

}
