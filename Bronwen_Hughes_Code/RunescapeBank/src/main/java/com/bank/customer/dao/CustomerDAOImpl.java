package com.bank.customer.dao;

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
import com.bank.employee.model.Employee;
import com.bank.registration.model.Registration;

public class CustomerDAOImpl extends DAOConnection implements CustomerDAO {

	@Override
	public int insertCustomer(Customer c) {
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "INSERT INTO customers(customerid, username, password, firstname, lastname, jointcustomer) VALUES (?, ?, ?, ?, ?, ?)";
			System.out.println("B");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getUsername());
			ps.setString(3, c.getPassword());
			ps.setString(4, c.getFirstName());
			ps.setString(5, c.getLastName());
			ps.setBoolean(6, c.isJointCustomer());

			ps.executeUpdate();

		} catch (SQLException ex) {
			// createAccountDB();
			ex.printStackTrace();
			System.out.println("ohno");
		}
		return 0;
	}
	
	@Override
	public List<Customer> selectAllCustomers() {
		ArrayList<Customer> customerList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "SELECT * FROM customers";

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), new Boolean(rs.getInt(6) == 1 ? true : false));
				// System.out.println(r);
				customerList.add(c);
			}

		} catch (SQLException ex) {
			// createAccountDB();
			ex.printStackTrace();
			System.out.println("ohno");
		}
		// System.out.println(registrationList);
		return customerList;
	}

	@Override
	public Customer selectCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectCustomerByUsername(String username) {
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "SELECT * FROM customers WHERE username = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			// ps.executeQuery();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						new Boolean(rs.getInt(6) == 1? true : false));
				//System.out.println(e);
				return c;
				
			}
		} catch (SQLException ex) {
			System.out.println("nope");
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer selectCustomerByAccount(Account a) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public int createCustomerDB() {
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "CREATE TABLE Customers(" + "CustomerID NUMBER PRIMARY KEY,"
					+ "Username VARCHAR2(30) NOT NULL," + "Password VARCHAR2(50) NOT NULL,"
					+ "FirstName VARCHAR2(50) NOT NULL," + "LastName VARCHAR2(50)," + "JointCustomer NUMBER NOT NULL)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeQuery();
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return 0;
	}

}
