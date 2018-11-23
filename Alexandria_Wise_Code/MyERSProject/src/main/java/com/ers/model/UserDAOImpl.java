package com.ers.model;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO{
	
	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}
	
	//credentials for database connection
	private static String url = "jdbc:oracle:thin:@revature-instance.crl675iwrq4r.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "reimbursementdb";
	private static String password = "p4ssw0rd";
	

	public User login(String userName, String userPassword) {
			System.out.println(userName+ " "+userPassword);
			User myUser = null;
			//User myUserTyped = new User();
		
			try(Connection conn=DriverManager.getConnection(url,username, password))
			{
				String sql= "SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?";
				
				PreparedStatement ps= conn.prepareStatement(sql);
				ps.setString(1, userName);
				ps.setString(2, userPassword);

				ResultSet rs= ps.executeQuery();
				System.out.println("entering dao while");
				while(rs.next())
				{
					System.out.println("in while loop" +rs.getInt(1));
					myUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getInt(7));
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println(myUser);
			/*
			if(myUser.roleId == 0) {
				//Employee myUserTyped = new Employee();
				myUserTyped = (Employee) myUser;
			} else {
				//FinanceManager myUserTyped = new FinanceManager();
				myUserTyped = (FinanceManager) myUser; 
			}*/
			
			return myUser;
	}
	
	/*Timestamp getCurrentTime() {
		Date date = new Date();
		long time = date.getTime();
		
		Timestamp ts = new Timestamp(time);
		
		return ts;
	}
*/	
	
	public void viewTickets() {
		ReimbursementDAOImpl myReimbursement = new ReimbursementDAOImpl();
		myReimbursement.selectAllReimbursements();
	}
	
	public void viewTicketsById(int userId) {
		ReimbursementDAOImpl myReimbursement = new ReimbursementDAOImpl();
		myReimbursement.selectReimbursementsByID(userId);
	}
}
