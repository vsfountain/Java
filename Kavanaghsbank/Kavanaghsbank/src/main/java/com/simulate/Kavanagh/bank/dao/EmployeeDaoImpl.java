package com.simulate.Kavanagh.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simulate.Kavanagh.bank.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private static String url = "";
	private static String username = "";
	private static String password = "";

	@Override
	public int insertEmployeeDao(Employee employee) {
		return 0;

	}

	@Override
	public List<Employee> selectAllEmployee() {
		List<Employee> empees = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * From Employee";
			PreparedStatement prepState = conn.prepareStatement(sql);
			ResultSet reultEt = prepState.executeQuery();
			while (reultEt.next()) {
				// empees.add(new Employee(reultEt.getInt(i), rs.getString("status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empees;
	}

	@Override
	public Employee selectEmployeebyId(int employee_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> selectAllEmployeebyEmpFirstName(String empFristName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> selectAllEmployeebyEmpLastName(String empLastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> selectAllEmployeebyJobtitle(String jobtitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee selectEmployeebyJobTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee selectEmployeebyFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee selectEmployeebyLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

}
