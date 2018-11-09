package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Customer;

public class CustomerDaoImpl implements CustomerDao{

	private static String url =
			"jdbc:oracle:thin:@revy-chan.cjfdvsamxdlk.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "usfdb";
	private static String password = "usf12345";
	
	
	
	
	@Override
	public int insertCustomer(Customer c) {
		// TODO Auto-generated method stub
		
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			
			String sql = " { call insert_customer_null_id(?,?,?,?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, c.getUsername());
			cs.setString(2, c.getPassword());
			cs.setString(3, c.getFirstName());
			cs.setString(4, c.getLastName());
			
			int status = cs.executeUpdate();
			//System.out.println("CallableStatement returns: " + status);
			
			return status;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return 0;
	}

	@Override
	public List<Customer> selectAllCustomer() {
		List<Customer> customer = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT * FROM customer";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customer.add(new Customer(rs.getInt("customer_id"),
											rs.getString("username"),
											rs.getString("password"),
											rs.getString("first_name"),
											rs.getString("last_name")
											));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return customer;
	}

	@Override
	public Customer selectCustomerById(int id) {
		// TODO Auto-generated method stub
		
		
		Customer customer = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * From CUSTOMER WHERE customer_id=?";
			
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customer = new Customer(rs.getInt("customer_id"),
										rs.getString("username"),
										rs.getString("password"),
										rs.getString("first_name"),
										rs.getString("last_name"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return customer;
	}

	@Override
	public Customer selectCustomerByName(String name) {
		// TODO Auto-generated method stub
		
		Customer customer = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * From CUSTOMER WHERE USERNAME=?";
			
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//System.out.println("a");
				customer = new Customer(rs.getInt("customer_id"),
										rs.getString("username"),
										rs.getString("password"),
										rs.getString("first_name"),
										rs.getString("last_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
		
	}

	@Override
	public int updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		return 0;
	}

}
