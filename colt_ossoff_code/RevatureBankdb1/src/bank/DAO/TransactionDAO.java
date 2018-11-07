package bank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bank.accounts.Transaction;
import bank.main.Main;

public class TransactionDAO {
	private static String url = "jdbc:oracle:thin:@colt-rev-db.cjm6y7b2xpmz.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "revBank";
	private static String password = "p4ssw0rd";

	public static int insert(int oper, String trType, double amount) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "INSERT INTO Transactions (OPER, TRTYPE, AMOUNT) VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, oper);
			ps.setString(2, trType);
			ps.setDouble(3, amount);
			ps.executeUpdate();
			return getTransId();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static Transaction selectById(int id) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT * FROM Transactions WHERE TRANSID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Transaction(rs.getInt("TRANSID"),
									   rs.getDouble("AMOUNT"),
									   RelateTransAcc.selectByTrans(rs.getInt("TRANSID")),
									   rs.getString("TRTYPE"),
									   rs.getInt("OPER"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static int getTransId() {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT MAX(TRANSID) FROM Transactions";
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


