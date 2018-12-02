package com.simulate.Kavanagh.bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import com.simulate.Kavanagh.bank.model.Customer;
import com.simulate.Kavanagh.bank.service.AccountServiceImpl;
import com.simulate.Kavanagh.bank.service.CustomerServiceImpl;

public class Main {
	private static String url = "jdbc:oracle:thin:@kristen.cu5uh73jvis1.us-east-2.rds.amazonaws.com:1521:kristen";
	private static String username = "Kavanaghsbank";
	private static String password = "kristen1234";
	final static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		Customer customer = CustomerServiceImpl.webRegister();
		AccountServiceImpl.applyForanAccount(customer);

		if (logger.isInfoEnabled()) {
			logger.info("This is info: loggers are cool");
			logger.warn("This is a warning....");
			logger.error("This is an error:", new IndexOutOfBoundsException());
			logger.fatal("This is fatal:");
			logger.info("");
		}
	}

	// callableStatement
	public static void callabeStatementExample(int client_id, String firstName, String lastName, double income,
			int creditScore, String address, String city, String state, int postalCode, int telePhoneNumber,
			String customerEmail, String userName, String passWord) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{call insert_Customer_null_id(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement callState = conn.prepareCall(sql);
			callState.setInt(1, client_id);
			callState.setString(2, firstName);
			callState.setString(3, lastName);
			callState.setDouble(4, income);
			callState.setInt(5, creditScore);
			callState.setString(6, address);
			callState.setString(7, city);
			callState.setString(8, state);
			callState.setInt(9, postalCode);
			callState.setInt(10, telePhoneNumber);
			callState.setString(11, customerEmail);
			callState.setString(12, userName);
			callState.setString(13, passWord);
			int status = callState.executeUpdate();

			System.out.println("CallableStatement return:" + status);
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	// preparedStatement
	public static void preparedStatementExample(int client_id, String firstName, String lastName, double income,
			int creditScore, String address, String city, String state, int postalCode, int telePhoneNumber,
			String customerEmail, String userName, String passWord) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO Customer (int client_id, firstName, lastName,  income,  creditScore, address, city, state, postalCode, telePhoneNumber,customerEmail,userName, passWord)"
					+

					"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prepState = conn.prepareStatement(sql);
			prepState.setInt(1, client_id);
			prepState.setString(2, firstName);
			prepState.setString(3, lastName);
			prepState.setDouble(4, income);
			prepState.setInt(5, creditScore);
			prepState.setString(6, address);
			prepState.setString(7, city);
			prepState.setString(8, state);
			prepState.setInt(9, postalCode);
			prepState.setInt(10, telePhoneNumber);
			prepState.setString(11, customerEmail);
			prepState.setString(12, userName);
			prepState.setString(13, passWord);

			prepState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
	// callableStatement

	public static void callabeStatement(int client_id, int accountNumber, double accountBalance, double interestRate,
			double interestEarned, String description, String status) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{call insert_Account_null_id(?,?,?,?,?,?,?)}";
			CallableStatement callState = conn.prepareCall(sql);
			callState.setInt(1, client_id);
			callState.setInt(2, accountNumber);
			callState.setDouble(3, accountBalance);
			callState.setDouble(4, interestRate);
			callState.setDouble(5, interestEarned);
			callState.setString(6, description);
			callState.setString(7, status);
			int s = callState.executeUpdate();
			System.out.println("CallableStatement return:" + status);
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	// preparedStatement
	public static void preparedStatement(int client_id, String firstName, String lastName, double income,
			int creditScore, String address, String city, String state, int postalCode, int telePhoneNumber,
			String customerEmail, String userName, String passWord) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO Customer (int client_id, firstName, lastName,  income,  creditScore, address, city, state, postalCode, telePhoneNumber,customerEmail,userName, passWord)"
					+

					"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prepState = conn.prepareStatement(sql);
			prepState.setInt(1, client_id);
			prepState.setString(2, firstName);
			prepState.setString(3, lastName);
			prepState.setDouble(4, income);
			prepState.setInt(5, creditScore);
			prepState.setString(6, address);
			prepState.setString(7, city);
			prepState.setString(8, state);
			prepState.setInt(9, postalCode);
			prepState.setInt(10, telePhoneNumber);
			prepState.setString(11, customerEmail);
			prepState.setString(12, userName);
			prepState.setString(13, passWord);

			prepState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}