package com.bank.customer.dao;

import java.sql.CallableStatement;
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
			String sql = "{ call insert_customer_null_id(?, ?, ?, ?, ?) }";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, c.getUsername());
			cs.setString(2, c.getPassword());
			cs.setString(3, c.getFirstName());
			cs.setString(4, c.getLastName());
			cs.setInt(5, c.getJointPartner());

			return cs.executeUpdate();

		} catch (SQLException ex) {
			// ex.printStackTrace();
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
						rs.getString(5), rs.getInt(6));
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
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "SELECT * FROM customers WHERE customerid = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6));
				return c;

			}
		} catch (SQLException ex) {
			// ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer selectCustomerByUsername(String username) {
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "SELECT * FROM customers WHERE username = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6));
				return c;

			}
		} catch (SQLException ex) {
			// ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer selectCustomerByAccount(Account a) {
		Customer c = null;
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "SELECT * FROM customers WHERE customerid = ? OR jointpartner = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a.getMainUserId());
			ps.setInt(2, a.getJointUserId());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));
			}
		} catch (SQLException ex) {
			// ex.printStackTrace();
		}
		return c;
	}

	@Override
	public int updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCustomer(Customer c) {
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "DELETE FROM customers WHERE customerid = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, c.getId());
			return ps.executeUpdate();

		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int createCustomerDB() {
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "CREATE TABLE Customers(" + "CustomerID NUMBER PRIMARY KEY,"
					+ "Username VARCHAR2(30) NOT NULL," + "Password VARCHAR2(50) NOT NULL,"
					+ "FirstName VARCHAR2(50) NOT NULL," + "LastName VARCHAR2(50)," + "JointPartner NUMBER NOT NULL)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeQuery();
		} catch (SQLException e) {
		}
		return 0;
	}

}
