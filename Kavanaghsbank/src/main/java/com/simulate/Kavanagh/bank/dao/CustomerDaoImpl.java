package com.simulate.Kavanagh.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.simulate.Kavanagh.bank.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	private static String url = "jdbc:oracle:thin:@kristen.cu5uh73jvis1.us-east-2.rds.amazonaws.com:1521:kristen";
	private static String username = "kavanaghsbank";
	private static String password = "kristen1234";
	Scanner scanner = new Scanner(System.in);

	@Override
	public int insertCustomer(Customer client) {

		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			
		
			String sql = "{call insert_Customer_null_id(?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement callState = conn.prepareCall(sql);
			callState.setInt(1, client.getClient_id());
			callState.setString(1, client.getFirstName());
			callState.setString(2, client.getLastName());
			callState.setDouble(3, client.getIncome());
			callState.setInt(4, client.getCreditScore());
			callState.setString(5, client.getAddress());
			callState.setString(6, client.getCity());
			callState.setString(7, client.getState());
			callState.setInt(8, client.getPostalCode());
			callState.setInt(9, client.getTelePhoneNumber());
			callState.setString(10, client.getCustomerEmail());
			callState.setString(11, client.getuserName());
			callState.setString(12, client.getpassWord());
			int status = callState.executeUpdate();

			System.out.println("CallableStatement return:" + status);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Customer> selectAllCustomer() {
		List<Customer> clients = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * From Customer";
			PreparedStatement prepstate = conn.prepareStatement(sql);
			ResultSet reultEt = prepstate.executeQuery();
			while (reultEt.next()) {

				clients.add(new Customer(reultEt.getInt("client_id"), reultEt.getString("firstName"),
						reultEt.getString("lastName"), reultEt.getDouble("income"), reultEt.getInt("creditScore"),
						reultEt.getString("address"), reultEt.getString("city"), reultEt.getString("state"),
						reultEt.getInt("postalCode"), reultEt.getInt("telePhoneNumber"),
						reultEt.getString("customerEmail"), reultEt.getString("userName"),
						reultEt.getString("passWord")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clients;
	}

	@Override
	public Customer selectCustomerById(int client_id) {
		return null;
	}

	@Override
	public Customer selectCustomerByFirstName(String firstName) {
		return null;
	}

	@Override
	public Customer selectCustomerByLastName(String lastName) {
		return null;
	}

	@Override
	public Customer selectCustomerByAddress(String address) {
		return null;
	}

	@Override
	public Customer selectByusername(String userName) {
		Customer client = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			//System.out.println(userName);
			String sql = "SELECT * FROM customer WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				client = new Customer(rs.getInt("client_id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getDouble("income"), rs.getInt("creditScore"), rs.getString("address"), rs.getString("city"),
						rs.getString("state"), rs.getInt("postalCode"), rs.getInt("telePhoneNumber"),
						rs.getString("customerEmail"), rs.getString("userName"), rs.getString("passWord"));
			}
			return client;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public List<Customer> selectCustomerByincome(double income) {
		return null;
	}

	@Override
	public List<Customer> selectCustomerByCreditScore(int creditScore) {
		return null;
	}

	@Override
	public List<Customer> selectCustomerByCity(String city) {
		return null;
	}

	@Override
	public List<Customer> selectCustomerByState(String state) {
		return null;
	}

	@Override
	public Customer selectCustomerByPostalCode(int postalCode) {
		return null;
	}

	@Override
	public Customer selectCustomerByTelePhoneNumber(int telePhoneNumber) {
		return null;
	}

	@Override
	public Customer selectCustomerByCustomerEmail(String customerEmail) {
		return null;
	}

	@Override
	public Customer selectCustomerBypassWord(String passWord) {
		return null;
	}

	@Override
	public int updateCustomer(Customer client) {
		return 0;
	}

	@Override
	public int deleteCustomer(Customer client) {
		return 0;
	}
	
	
}
