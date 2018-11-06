package com.bank.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.connection.DAOConnection;
import com.bank.employee.model.Employee;
import com.bank.registration.model.Registration;

public class EmployeeDAOImpl extends DAOConnection implements EmployeeDAO {

	@Override
	public int insertEmployee(Employee e) {
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "INSERT INTO employees(employeeid, username, password, firstname, lastname, admin) VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, e.getId());
			ps.setString(2, e.getUsername());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getFirstName());
			ps.setString(5, e.getLastName());
			ps.setBoolean(6, e.isAdmin());

			return ps.executeUpdate();
			
		} catch (SQLException ex) {
			// createAccountDB();
			ex.printStackTrace();
			System.out.println("ohno");
		}
		return 0;
	}

	@Override
	public List<Employee> selectAllEmployees() {
		ArrayList<Employee> employeeList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "SELECT * FROM employees";

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), new Boolean(rs.getInt(6) == 1 ? true : false));
				// System.out.println(r);
				employeeList.add(e);
			}

		} catch (SQLException ex) {
			// createAccountDB();
			ex.printStackTrace();
			System.out.println("ohno");
		}
		// System.out.println(registrationList);
		return employeeList;
	}

	@Override
	public Employee selectEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee selectEmployeeByUsername(String username) {
		//Employee e = null;
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "SELECT * FROM employees WHERE username = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			// ps.executeQuery();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						new Boolean(rs.getInt(6) == 1? true : false));
				//System.out.println(e);
				return e;
				
			}
		} catch (SQLException ex) {
			System.out.println("nope");
			ex.printStackTrace();
		}
		return null;
		//return e;
	}

	@Override
	public int updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	// employeeid, username, password, first_name, last_name, admin
	@Override
	public int createEmployeeDB() {
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "CREATE TABLE Employees(" 
					+ "EmployeeID NUMBER PRIMARY KEY,"
					+ "Username VARCHAR2(30) NOT NULL," 
					+ "Password VARCHAR2(50) NOT NULL,"
					+ "FirstName VARCHAR2(50) NOT NULL," 
					+ "LastName VARCHAR2(50)," 
					+ "Admin NUMBER NOT NULL)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
