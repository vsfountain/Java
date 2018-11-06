/*
 * Handle's the objects, ApprovedAccounts and PendingAccounts; returns the information pertaining to them and allows admins to drop accounts.
 */
package accountManagement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountManagement implements AccountManagementDao{
	private static ArrayList<PendingAccounts> customerAccountRequests = new ArrayList<>();
	private static ArrayList<ApprovedAccounts> approvedAccounts = new ArrayList<>();
	private final static String url="jdbc:oracle:thin:@revy-chan.cvi5jgypuakx.us-east-2.rds.amazonaws.com:1521:orcl";
	private final static String adminUserName="bankAdmin";
	private final static String adminPassWord="adminadmin";
	private static int transactionID = 1;
	
	public AccountManagement() {
		super();
	}
	
	@Override
	public void insertDataBase(int id, String currUserName, String currUserNameJoint, String currPassword, String currAccountType, Double currBalance, String currPending){
		try(Connection conn=DriverManager.getConnection(url, adminUserName, adminPassWord)){
			String sql= "INSERT INTO allAccounts (AccountID, UserName, UserNameJoint, Password, AccountType, Balance, Pending) "+
						"VALUES(?,?,?,?,?,?,?)";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.setString(2, currUserName);
			ps.setString(3, currUserNameJoint);
			ps.setString(4, currPassword);
			ps.setString(5, currAccountType);
			ps.setDouble(6, currBalance);
			ps.setString(7, currPending);
			
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteDataBase(int id){
		try(Connection conn=DriverManager.getConnection(url, adminUserName, adminPassWord)){
			String sql= "DELETE FROM allAccounts WHERE AccountID= ?";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateDataBase(int id){
		try(Connection conn=DriverManager.getConnection(url, adminUserName, adminPassWord)){
			String sql= "UPDATE allAccounts SET Pending=? WHERE AccountID=?";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, "No");
			ps.setInt(2, id);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public double dataBaseMoney(String accountID) {
		try(Connection conn=DriverManager.getConnection(url, adminUserName, adminPassWord)){
			String sql = "SELECT * FROM allAccounts WHERE AccountID=?";
			PreparedStatement money= conn.prepareStatement(sql);
			int currID = 0;
			try {
				currID = Integer.parseInt(accountID);
			}
			catch(Exception e) {
				return 0.0;
			}
			money.setInt(1, currID);
			ResultSet currMoney = money.executeQuery();
			double currMoneyy = 0.0;
			while(currMoney.next()) {
				currMoneyy = currMoney.getDouble(6);
			}
			return currMoneyy;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0.0;
	}
	@Override
	public void dataBaseDepositMoney(double deposit, String accountID) {
		try(Connection conn=DriverManager.getConnection(url, adminUserName, adminPassWord)){
			String sql = "SELECT * FROM allAccounts WHERE AccountID=?";
			PreparedStatement money= conn.prepareStatement(sql);
			int currID = 0;
			try {
				currID = Integer.parseInt(accountID);
			}
			catch(Exception e) {
				return;
			}
			money.setInt(1, currID);
			ResultSet currMoney = money.executeQuery();
			double currMoneyy = 0.0;
			while(currMoney.next()) {
				currMoneyy = currMoney.getDouble(6);
				currMoneyy = currMoneyy+deposit;
			}
			sql= "UPDATE allAccounts SET Balance=? WHERE AccountID=?";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setDouble(1, currMoneyy);
			ps.setInt(2, currID);
			ps.executeUpdate();
			
			//TransactionID, AccountID, Amount, TransactionType, 
			sql = "INSERT INTO allTransactions VALUES(?,?,?,?)";
			PreparedStatement pss = conn.prepareStatement(sql);
			pss.setInt(1, transactionID);
			transactionID++;
			pss.setInt(2, currID);
			pss.setDouble(3, deposit);
			pss.setString(4, "Deposit");
			pss.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override 
	public String getNameOfAccountHolder(String accountID) {
		try(Connection conn=DriverManager.getConnection(url, adminUserName, adminPassWord)){
			String sql = "{call customerName(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			
			int currID = 0;
			try {
				currID = Integer.parseInt(accountID);
			}
			catch(Exception e) {
				return "";
			}
			String returnedName = "";
			cs.setInt(1,  currID);
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			cs.execute();
			returnedName = cs.getString(2);
			return returnedName;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@Override 
	public String getNameOfJointAccountHolder(String accountID) {
		try(Connection conn=DriverManager.getConnection(url, adminUserName, adminPassWord)){
			String sql = "SELECT * FROM allAccounts WHERE AccountID=?";
			PreparedStatement name= conn.prepareStatement(sql);
			int currID = 0;
			try {
				currID = Integer.parseInt(accountID);
			}
			catch(Exception e) {
				return "";
			}
			name.setInt(1, currID);
			ResultSet currName = name.executeQuery();
			String getName = "";
			while(currName.next()) {
				getName = currName.getString(3);
			}
			return getName;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	@Override 
	public String getPasswordOfAccountHolder(String accountID) {
		try(Connection conn=DriverManager.getConnection(url, adminUserName, adminPassWord)){
			String sql = "SELECT * FROM allAccounts WHERE AccountID=?";
			PreparedStatement name= conn.prepareStatement(sql);
			int currID = 0;
			try {
				currID = Integer.parseInt(accountID);
			}
			catch(Exception e) {
				return "";
			}
			name.setInt(1, currID);
			ResultSet currName = name.executeQuery();
			String getPassword = "";
			while(currName.next()) {
				getPassword = currName.getString(4);
			}
			return getPassword;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@Override
	public double dataBaseWithdrawMoney(double amount, String accountID) {
		try(Connection conn=DriverManager.getConnection(url, adminUserName, adminPassWord)){
			String sql = "SELECT * FROM allAccounts WHERE AccountID=?";
			PreparedStatement money= conn.prepareStatement(sql);
			int currID = 0;
			try {
				currID = Integer.parseInt(accountID);
			}
			catch(Exception e) {
				return -1.0;
			}
			money.setInt(1, currID);
			ResultSet currMoney = money.executeQuery();
			double currMoneyy = 0.0;
			while(currMoney.next()) {
				currMoneyy = currMoney.getDouble(6);
			}
			if(amount <= 0.0) {
				return -1.0;
			}
			if(amount <= currMoneyy) {
				currMoneyy-=amount;
				sql= "UPDATE allAccounts SET Balance=? WHERE AccountID=?";
				
				PreparedStatement ps= conn.prepareStatement(sql);
				ps.setDouble(1, currMoneyy);
				ps.setInt(2, currID);
				ps.executeUpdate();
				//TransactionID, AccountID, Amount, TransactionType, 
				sql = "INSERT INTO allTransactions VALUES(?,?,?,?)";
				PreparedStatement pss = conn.prepareStatement(sql);
				pss.setInt(1, transactionID);
				transactionID++;
				pss.setInt(2, currID);
				pss.setDouble(3, amount);
				pss.setString(4, "Withdraw");
				pss.executeQuery();
				return currMoneyy;
			}
			else if(amount > currMoneyy) {
				return -2.0;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0.0;
	}
	
	@Override
	public void freshTable() {
		try(Connection conn=DriverManager.getConnection(url, adminUserName, adminPassWord)){
			String sql = "DROP TABLE allAccounts";
			PreparedStatement count= conn.prepareStatement(sql);
			count.execute(sql);
			sql= "CREATE TABLE allAccounts(" + 
					"AccountID NUMBER NOT NULL," + 
					"UserName VARCHAR2(100) NOT NULL," + 
					"UserNameJoint VARCHAR2(100) NOT NULL," + 
					"Password VARCHAR2(100) NOT NULL," + 
					"AccountType VARCHAR2(100) NOT NULL," + 
					"Balance NUMBER NOT NULL," + 
					"Pending VARCHAR2(5) NOT NULL," + 
					"CONSTRAINT PK_allAccounts PRIMARY KEY (AccountID)" + 
					")";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.executeQuery();
			
			sql = "DROP TABLE allTransactions";
			PreparedStatement trans = conn.prepareStatement(sql);
			trans.execute(sql);
			sql = "CREATE TABLE allTransactions(" + 
					"TransactionID NUMBER NOT NULL," +
					"AccountID NUMBER NOT NULL," + 
					"Amount NUMBER NOT NULL," + 
					"TransactionType VARCHAR2(100) NOT NULL," + 
					"CONSTRAINT PK_allTransactions PRIMARY KEY (TransactionID)" + 
					")";
			PreparedStatement pss = conn.prepareStatement(sql);
			pss.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int selectPendingDataBase(){
		try(Connection conn=DriverManager.getConnection(url, adminUserName, adminPassWord)){
			String sql = "SELECT * FROM allAccounts";
			PreparedStatement count= conn.prepareStatement(sql);
			ResultSet getCount = count.executeQuery();
			int checker = 0;
			while(getCount.next()) {
				if(getCount.getString(7).toLowerCase().equals("yes")) {
					checker = 1;
				}
			}
			if(checker==0) {
				return -1;
			}
			
			sql= "SELECT * FROM allAccounts";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			
			System.out.print("Current pending accounts: ");
			while(rs.next()) {
				if(rs.getString(7).toLowerCase().equals("yes")) {
					System.out.print("Account information: " + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(5) + "\t" + rs.getInt(1));
					System.out.print(" ");
				}
			}		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int selectApprovedDataBase() {
		try(Connection conn=DriverManager.getConnection(url, adminUserName, adminPassWord)){
			String sql = "SELECT * FROM allAccounts";
			PreparedStatement count= conn.prepareStatement(sql);
			ResultSet getCount = count.executeQuery();
			int checker = 0;
			while(getCount.next()) {
				if(getCount.getString(7).toLowerCase().equals("no")) {
					checker = 1;
				}
			}
			if(checker==0) {
				return -1;
			}
			sql= "SELECT * FROM allAccounts";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				if(rs.getString(7).toLowerCase().equals("no")) {
					System.out.print("Account information: " + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(5) + "\t" + rs.getInt(1));
					System.out.print(" ");
				}
			}		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public ArrayList<PendingAccounts> getCustomerAccountRequests() {
		ArrayList<PendingAccounts> sqlPending = new ArrayList<>();
		try(Connection conn=DriverManager.getConnection(url, adminUserName, adminPassWord)){
			String sql = "SELECT * FROM allAccounts";
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(7).toLowerCase().equals("yes")) {
					String currID = "" + rs.getInt(1);
					sqlPending.add(new PendingAccounts(rs.getString(5), rs.getString(2), rs.getString(3), rs.getString(4), currID));
				}
			}		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return sqlPending;
	}
	
	@Override
	public void setCustomerAccountRequests(String pw, String username, String usernameJoint, String accountType, String accountID) {
		PendingAccounts currPending = new PendingAccounts(accountType, username, usernameJoint, pw, accountID);
		customerAccountRequests.add(currPending);
		int id = Integer.parseInt(accountID);
		insertDataBase(id, username, usernameJoint, pw, accountType, 0.0, "Yes");
	}
	
	@Override
	public void removeCustomerAccountRequests(String accountID) {
		for(int i = 0; i < customerAccountRequests.size(); i++) {
			String curr = "" + customerAccountRequests.get(i).getAccountID();
			if(curr.equals(accountID)){
				customerAccountRequests.remove(i);
				break;
			}
		}
		int id = Integer.parseInt(accountID);
		deleteDataBase(id);
	}
	
	@Override
	public void removeApprovedAccount(String accountID) {
		for(int i = 0; i < approvedAccounts.size(); i++) {
			String curr = "" + approvedAccounts.get(i).getAccountID();
			if(curr.equals(accountID)){
				approvedAccounts.remove(i);
				break;
			}
		}
		int id = Integer.parseInt(accountID);
		deleteDataBase(id);
	}
	
	@Override
	public ArrayList<ApprovedAccounts> getApprovedAccounts() {
		ArrayList<ApprovedAccounts> sqlApproved = new ArrayList<>();
		try(Connection conn=DriverManager.getConnection(url, adminUserName, adminPassWord)){
			String sql = "SELECT * FROM allAccounts";
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(7).toLowerCase().equals("no")) {
					String currID = "" + rs.getInt(1);
					sqlApproved.add(new ApprovedAccounts(rs.getString(4), rs.getString(2), rs.getString(5), rs.getString(3), currID, rs.getDouble(6)));
				}
			}		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return sqlApproved;
		//return approvedAccounts;
	}
	
	@Override
	public void setApprovedAccounts(String pw, String username, String usernameJoint, String accountType, String accountID) {
		ApprovedAccounts currApproved = new ApprovedAccounts(pw, username, accountType, usernameJoint, accountID);
		approvedAccounts.add(currApproved);
		int id = Integer.parseInt(accountID);
		updateDataBase(id);
	}
}
