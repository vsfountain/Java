package bank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bank.people.Customer;

public class CustomerDAO {
	private static String url = "jdbc:oracle:thin:@colt-rev-db.cjm6y7b2xpmz.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "revBank";
	private static String password = "p4ssw0rd";

	public static void insert(String name, String uName, String pwd) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "INSERT INTO Customers (NAME, USERNAME, PWD) VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, uName);
			ps.setString(3, pwd);
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static Customer selectLogin(String uName, String pwd) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT * FROM Customers WHERE USERNAME = ? AND PWD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uName);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Customer(rs.getString("NAME"), rs.getInt("CUSTID"), rs.getString("USERNAME"), rs.getString("PWD"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Customer selectById(int id) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT * FROM Customers WHERE CUSTID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Customer c = null;
			while(rs.next()) {
				c = new Customer(rs.getString("NAME"), rs.getInt("CUSTID"), rs.getString("USERNAME"), rs.getString("PWD"));
			}
			return c;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static int getCustId() {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT MAX(CUSTID) FROM Customers";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
