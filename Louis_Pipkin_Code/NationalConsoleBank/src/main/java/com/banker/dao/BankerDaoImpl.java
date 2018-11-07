package com.banker.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import com.banker.model.accounts.Account;
import com.banker.model.accounts.Joint;
import com.banker.model.accounts.Personal;
import com.banker.model.users.Admin;
import com.banker.model.users.Associate;
import com.banker.model.users.Client;
import com.banker.model.users.User;
 
public class BankerDaoImpl implements BankerDao {

	private static String url = "jdbc:oracle:thin:@revy-chan.cxm6xvuq7tje.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "bankerdb";
	private static String password = "p4ssw0rd";
	
	@Override
	public int insertUser(User u) {
		// add user to users table
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			String sql= "INSERT INTO users(userid, pass, firstname, lastname, " +
						"email, usertype) "+
						"VALUES(?,?,?,?,?,?)";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			//ps.setString(6, u.);
			if (u instanceof Client) {
				ps.setString(6, "client");
			} else if (u instanceof Associate) {
				ps.setString(6, "associate");
			} else if (u instanceof Admin) {
				ps.setString(6, "admin");
			}
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int insertAccount(Account a, User u) {
		int status = -1;
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			//return the account id
			String sql= "{ ? = call insert_new_account(?,?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, u.getUserName());
			if (a instanceof Personal) {
				cs.setString(3, "personal");
			} else if (a instanceof Joint) {
				cs.setString(3, "joint");
			}
			
			status = cs.executeUpdate();
			status = cs.getInt(1);
			//System.out.("CallableStatement returns: "+status);
		}catch(SQLException  e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
/*	@Override
	public int insertAccount(Account a, User u1, User u2) {
		// add acounts to account table
		// add user1 id and account id to ref table
		// add user2 id and account id to ref table
		return 0;
	}*/
	
	@Override
	public Map<String, User> selectAllUsers() {
		Map<String, User> users = new HashMap<>();
		try(Connection conn = DriverManager.getConnection(url,username, password))
		{
			String sql= "SELECT * FROM users";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			int i = 0;
			while(rs.next())
			{				
				if ("client".equals(rs.getString("usertype"))) {
					User u = new Client(rs.getString("userid"), rs.getString("pass"), 
										rs.getString("firstname"), rs.getString("lastname"));
					users.put(u.getUserName(), u);
				} else if ("associate".equals(rs.getString("usertype"))) {
					User u = new Associate(rs.getString("userid"), rs.getString("pass"), 
							rs.getString("firstname"), rs.getString("lastname"));
					users.put(u.getUserName(), u);
				} else if ("admin".equals(rs.getString("usertype"))) {
					User u = new Admin(rs.getString("userid"), rs.getString("pass"), 
							rs.getString("firstname"), rs.getString("lastname"));
					users.put(u.getUserName(), u);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public ArrayList<Account> selectAllAccounts() {
		// select all personal and add
		// select all joint and add
		ArrayList<Account> accounts = new ArrayList<>();;
		Account a = new Account();
		
		try(Connection conn = DriverManager.getConnection(url,username, password))
		{
			String sql= "SELECT a.accountid, a.balance, a.acctype, u.userid "
					+ "FROM accounts a JOIN account_user_ref r ON a.accountid = r.accountid "
					+ "JOIN users u ON u.userid = r.userid";
			
			PreparedStatement ps= conn.prepareStatement(sql);

			ResultSet rs= ps.executeQuery();

			while(rs.next())
			{
				if ("personal".equals(rs.getString(3))) {
					a = new Personal(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)), rs.getString(4));
					
				} else if ("joint".equals(rs.getString(3))) {
					ArrayList<String> as = new ArrayList<>();
					as.add(rs.getString(4));
					a = new Joint(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)), as);
				}
				accounts.add(a);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//System.out.("in doa, all acounts: "+accounts);
		return accounts;
	}
	
	@Override
	public Account selectAccountById(int id) {
		Account a = new Account();
		try(Connection conn = DriverManager.getConnection(url,username, password))
		{
			String sql= "SELECT a.accountid, a.balance, a.acctype, u.userid "
					+ "FROM accounts a JOIN account_user_ref r ON a.accountid = r.accountid "
					+ "JOIN users u ON u.userid = r.userid "
					+ "WHERE a.accountid = ?";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				if ("personal".equals(rs.getString(3))) {
					a = new Personal(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)), rs.getString(4));
					
				} else if ("joint".equals(rs.getString(3))) {
					ArrayList<String> as = new ArrayList<>();
					as.add(rs.getString(4));
					a = new Joint(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)), as);
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	@Override
	public User selectUserByUsername(String userid) {
		User u = new User();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			String sql= "SELECT * FROM users WHERE userid=?";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, userid);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				if ("client".equals(rs.getString("usertype"))) {
					u = new Client(rs.getString("userid"), rs.getString("pass"), 
										rs.getString("firstname"), rs.getString("lastname"));
				} else if ("associate".equals(rs.getString("usertype"))) {
					u = new Associate(rs.getString("userid"), rs.getString("pass"), 
							rs.getString("firstname"), rs.getString("lastname"));
				} else if ("admin".equals(rs.getString("usertype"))) {
					u = new Admin(rs.getString("userid"), rs.getString("pass"), 
							rs.getString("firstname"), rs.getString("lastname"));
				}
				/*if ("client".equals(rs.getString(9))) {
					u = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				} else if ("associate".equals(rs.getString(9))) {
					u = new Associate(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				} else if ("admin".equals(rs.getString(9))) {
					u = new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				}*/
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
/*	@Override
	public ArrayList<Account> selectAccountsByUsername(String userid) {
		Account a = null;
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			String sql= "SELECT a.accountid, a.balance, a.acctype "
					+ "FROM accounts a LEFT OUTER JOIN "
					+ "account_user_ref r ON a.accountid = r.accountid "
					+ "WHERE r.userid = ?";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, userid);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				if ("personal".equals(rs.getString(3))) {
					a = new Personal(rs.getString(1), rs.getString(2), rs.getString(3));
				} else if ("joint".equals(rs.getString(3))) {
					a = new Joint(rs.getString(1), rs.getString(2), rs.getString(3));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	@Override
	public ArrayList<Account> selectUnapprovedAccounts() {
		Account a = null;
		ArrayList<Account> unAcc = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url,username, password))
		{
			String sql= "SELECT DISTINCT a.accountid, a.balance, a.acctype, r.userid "
					+ "FROM unapproved u INNER JOIN accounts a ON a.accountid=u.accountid "
					+ "JOIN account_user_ref r ON a.accountid=r.accountid";
			 
			PreparedStatement ps= conn.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if ("personal".equals(rs.getString(3))) {
					a = new Personal(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)), rs.getString(4));
					
				} else if ("joint".equals(rs.getString(3))) {
					ArrayList<String> as = new ArrayList<>();
					as.add(rs.getString(4));
					a = new Joint(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)), as);
				}
				unAcc.add(a);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return unAcc;
	}
	
	@Override
	public int updateUser(User u) {
		try(Connection conn = DriverManager.getConnection(url,username, password))
		{
			String sql= "UPDATE users SET pass=?, firstname=?, lastname=? WHERE userid=?";
		
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, u.getPassword());
			ps.setString(2, u.getFirstName());
			ps.setString(3, u.getLastName());
			ps.setString(4, u.getUserName());
		
			ps.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int updateAccount(Account a) {
		try(Connection conn = DriverManager.getConnection(url,username, password))
		{
			String sql= "UPDATE accounts SET balance=?, acctype=? WHERE accountid=?";
		
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(a.getBalance()));
			if (a instanceof Personal) {
				ps.setString(2, "personal");
			} else if (a instanceof Joint) {
				ps.setString(2, "joint");
			}
			ps.setString(3, Integer.toString(a.getAccountid()));
			
			ps.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int deleteUser(User u) {
		try(Connection conn = DriverManager.getConnection(url,username, password))
		{
			String sql= "DELETE FROM users WHERE userid=?";
		
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, u.getUserName());
		
			ps.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int deleteAccount(Account a) {
		try(Connection conn = DriverManager.getConnection(url,username, password))
		{
			String sql= "DELETE FROM accounts WHERE accountid=?";
		
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(a.getAccountid()));
		
			ps.executeUpdate();

		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUnapproved(int aid) {
		try(Connection conn = DriverManager.getConnection(url,username, password))
		{
			String sql= "DELETE FROM unapproved WHERE accountid=?";
			//String sql= "{ call approve_account(?) }";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(aid));
		
			ps.executeUpdate();

		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public ArrayList<User> selectOwners(Account a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertRef(Account a, User u) {
		int status = -1;
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			//return the account id
			String sql= "{ call add_user_to_account(?,?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, Integer.toString(a.getAccountid()));
			cs.setString(2, u.getUserName());
			
			status = cs.executeUpdate();
			//System.out.("CallableStatement returns: "+status);
		}catch(SQLException  e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public int insertUnapproved(Account a) {
		int status = -1;
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			//return the account id
			String sql= "{ call insert_unaproved(?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, Integer.toString(a.getAccountid()));
			
			status = cs.executeUpdate();
			//System.out.("CallableStatement returns: "+status);
		}catch(SQLException  e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public int commit() {
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			conn.commit();
		}catch(SQLException  e) {
			e.printStackTrace();
		}
		return 0;
	}

}
