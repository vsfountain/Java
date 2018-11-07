package bank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bank.people.Employee;

public class EmployeeDAO {
	private static String url = "jdbc:oracle:thin:@colt-rev-db.cjm6y7b2xpmz.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "revBank";
	private static String password = "p4ssw0rd";

	public static void insert(String name, String uName, String pwd, String admin) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "INSERT INTO Employees (NAME, USERNAME, PWD, ADMIN) VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, uName);
			ps.setString(3, pwd);
			ps.setString(4, admin);
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static Employee selectLogin(String uName, String pwd) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT * FROM Employees WHERE USERNAME = ? AND PWD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uName);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				boolean admin = (rs.getString("ADMIN").equals("t"))? true: false;
				return new Employee(admin, rs.getString("NAME"), rs.getInt("EMPLID"), rs.getString("USERNAME"), rs.getString("PWD"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static int getId() {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT MAX(EMPLID) FROM Employees";
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
