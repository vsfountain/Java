package bank.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bank.accounts.Account;

public class AccountDAO {
	private static String url = "jdbc:oracle:thin:@colt-rev-db.cjm6y7b2xpmz.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "revBank";
	private static String password = "p4ssw0rd";

	public static void insert(double balance, String approved, String cancelled) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "INSERT INTO Accounts (BALANCE, APPROVED, CANCELLED) VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setString(2, approved);
			ps.setString(3, cancelled);
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static Account selectById(int id) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT * FROM Accounts WHERE ACCID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				boolean app = (rs.getString("APPROVED").equals("t"))? true:false;
				boolean can = (rs.getString("CANCELLED").equals("t"))? true:false;
				return new Account(rs.getDouble("BALANCE"),
								   rs.getInt("ACCID"),
								   RelateAccCust.selectByAcc(id),
								   app,
								   can,
								   RelateTransAcc.selectByAcc(id));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void update(double balance, boolean approved, boolean cancelled, int id) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "UPDATE Accounts SET BALANCE = ?, APPROVED = ?, CANCELLED = ? WHERE ACCID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			String tf = (approved == true)? "t":"f";
			ps.setString(2, tf);
			tf = (cancelled == true)? "t":"f";
			ps.setString(3, tf);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static int withdraw(int id, double amount) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "{ CALL withdraw (?,?) }";
			CallableStatement ps = conn.prepareCall(sql);
			ps.setInt(1, id);
			ps.setDouble(2, amount);
			return ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static int getId() {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT MAX(ACCID) FROM Accounts";
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
