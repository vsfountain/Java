package bankofalexandria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO{
	
	private static String url = "jdbc:oracle:thin:@revature-instance.crl675iwrq4r.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "bankdb";
	private static String password = "p4ssw0rd";

	@Override
	public void preparedInsertAccount(double initialBalance, int userId) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			String sql= "{ call insert_account_null_id(?,?) }";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, (long) initialBalance);
			ps.setLong(2, (long) userId );
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Account> selectAllAccounts() {
		
		List<Account> accs = new ArrayList<>();
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= "SELECT * FROM accounts";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				//accs.add(new Account(rs.getString(1), rs.getString(2),
						//rs.getString(3)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accs;
	}

	@Override
	public Account selectAccountByID(int cust_id) {
		Account acc = null;
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= "SELECT * FROM accounts WHERE userid = ?";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,cust_id);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				acc = new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			}
			return acc;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}
	
	@Override
	public void updateBalance(int userID, double acc_balance) {
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= "UPDATE accounts SET balance = ? WHERE userID = ? ";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setLong(1,(long) acc_balance);
			ps.setInt(2, userID);
			
			ResultSet rs= ps.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
