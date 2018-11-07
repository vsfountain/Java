package bank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RelateAccCust {
	private static String url = "jdbc:oracle:thin:@colt-rev-db.cjm6y7b2xpmz.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "revBank";
	private static String password = "p4ssw0rd";

	public static void insert(int accId, int custId) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "INSERT INTO RelateAccCust (ACC, CUST) VALUES (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accId);
			ps.setInt(2, custId);
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Integer> selectByAcc(int id) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT * FROM RelateAccCust WHERE ACC = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> ar = new ArrayList<>();
			while(rs.next()) {
				ar.add(rs.getInt("CUST"));
			}
			return ar;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<Integer> selectByCust(int id) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT DISTINCT * FROM RelateAccCust WHERE CUST = ?";
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
}
