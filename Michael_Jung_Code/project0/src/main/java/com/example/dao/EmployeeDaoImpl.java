package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	
	private static String url =
			"jdbc:oracle:thin:@revy-chan.cjfdvsamxdlk.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "usfdb";
	private static String password = "usf12345";
	
	
	
	@Override
	public Employee selectEmployeeByName(String name) {
		// TODO Auto-generated method stub
		
		Employee employee = null;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			
			String sql = "SELECT * From EMPLOYEE WHERE USERNAME=?";
			
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				employee = new Employee(rs.getInt("employee_id"),
										rs.getString("username"),
										rs.getString("password"),
										rs.getInt("admin_ind") == 1 ? true : false);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
		
		
		
		//return null;
	}

}
