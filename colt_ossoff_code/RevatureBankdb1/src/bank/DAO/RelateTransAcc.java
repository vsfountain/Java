package bank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RelateTransAcc {
	private static String url = "jdbc:oracle:thin:@colt-rev-db.cjm6y7b2xpmz.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "revBank";
	private static String password = "p4ssw0rd";

	public static void insert(int transId, int accId) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "INSERT INTO RelateTransAcc (TRANS, ACC) VALUES (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, transId);
			ps.setInt(2, accId);
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<Integer> selectByTrans(int id) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT * FROM RelateTransAcc WHERE TRANS = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> ar = new ArrayList<>();
			while(rs.next()) {
				ar.add(rs.getInt("ACC"));
			}
			return ar;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<Integer> selectByAcc(int id) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT * FROM RelateTransAcc WHERE ACC = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> ar = new ArrayList<>();
			while(rs.next()) {
				ar.add(rs.getInt("TRANS"));
			}
			return ar;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
