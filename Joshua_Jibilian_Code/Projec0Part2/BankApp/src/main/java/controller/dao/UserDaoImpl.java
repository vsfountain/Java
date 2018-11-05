package controller.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.accounts.Account;
import model.users.ClientUser;
import model.users.Employee;
import model.users.User;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDaoImpl.
 */
public class UserDaoImpl  implements UserDao{
	
	/** The url. */
	private static String url=
			"jdbc:oracle:thin:@revy.ctgsqmepdtko.us-east-2.rds.amazonaws.com:1521:orcl";
	
	/** The username. */
	private static String username="bankuser";
	
	/** The password. */
	private static String password="p4ssw0rd";
	
	/* (non-Javadoc)
	 * @see controller.dao.UserDao#userLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public User userLogin(String email, String testpassword) {
		ArrayList<User> users = new ArrayList<User>();
		try(Connection conn=
				DriverManager.getConnection(url, username, password))
		{
			String sql= "SELECT * FROM (users JOIN usertypes ON "
					+ "usertypes.usertypeid = users.usertype) "
					+ "WHERE email = ? AND userpassword = ?";
			
			CallableStatement cs= conn.prepareCall(sql);
			cs.setString(1, email); //notice how we start at 1
			cs.setString(2, testpassword);
			ResultSet rs = cs.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("usertypename").equals("Admin")) {
					//System.out.println("Admin");

					users.add(new Employee(rs.getString("firstname"),
							rs.getString("lastname"), rs.getString("email"),
							null, rs.getInt("userid")));
				} else {
					//System.out.println("Admin");
					users.add(new ClientUser(rs.getString("firstname"),
							rs.getString("lastname"), rs.getString("email"),
							null, rs.getInt("userid")));
					
				}
				if (users.size() > 1) {
					System.out.println("something is seriosly wrong with the database");
				} else if(users.size() ==1 ) {
					return users.get(0);
				} else {
					return null;
				}
			}
			conn.close();
			
		}catch(SQLException e) {
			System.out.println("Your connection has errored out, "
					+ "try again later.");
			e.printStackTrace();
		}
		
		return null;
		

	}

	/* (non-Javadoc)
	 * @see controller.dao.UserDao#registerUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean registerUser(String firstName, String lastName, String newpassword, String email) {
		String sql= "{ call insert_user(?,?,?,?) }";
		int result = 0;
		try(Connection conn=
				DriverManager.getConnection(url, username, password))
		{
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, firstName);
		ps.setString(3, lastName);
		ps.setString(4, newpassword);
		
		result = ps.executeUpdate();
		//System.out.println("them results 1 : " + result);
		//result = ps.getUpdateCount();
		
		conn.close();
		//System.out.println("THEM RESULTS" + result);
		} catch (SQLException e) {
			//System.out.println(e.getErrorCode());
			//e.printStackTrace();
			return false;
		}
		//System.out.println("THEM RESULTS" + result);
		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean applyForAccount(int userID, int type) {
		String sql = "{ call account_app(?,?,?) }";
		int result = 0;
		try(Connection conn=
				DriverManager.getConnection(url, username, password))
		{
		CallableStatement ps= conn.prepareCall(sql);
		ps.setInt(1, type);
		ps.setInt(2, userID);
		ps.registerOutParameter(3, OracleTypes.NUMBER);
		
		
		
		result = ps.executeUpdate();
		int rs = ps.getInt(3);
		
		//System.out.println("THIS IS A THING MAYBE? " + rs);
		//System.out.println("them results 1 : " + result);
		//result = ps.getUpdateCount();
		
		conn.close();
		//System.out.println("THEM RESULTS" + result);
		} catch (SQLException e) {
			//System.out.println(e.getErrorCode());
			//e.printStackTrace();
			return false;
		}
		//System.out.println("THEM RESULTS" + result);
		if (result == 1) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean approveAccount(int accountId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdraw(int account, int ammount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deposit(int account, int ammount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transfer(int fromAccount, int toAccount, int ammount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Account> getAccounts(int userid) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
