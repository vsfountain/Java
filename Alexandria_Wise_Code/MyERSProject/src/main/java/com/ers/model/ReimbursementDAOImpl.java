package com.ers.model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ReimbursementDAOImpl implements ReimbursementDAO{

	/*static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}*/
	
	//credentials for database connection
	private static String url = "jdbc:oracle:thin:@revature-instance.crl675iwrq4r.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "reimbursementdb";
	private static String password = "p4ssw0rd";


	//insert new reimbursement <- used by employee
	public void preparedInsertReimbursement(double amount, String description, Timestamp reqTime, int author, int statusId, int typeId) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			String sql= "{ call insert_initial_reimbursement(?,?,?,?,?) }";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1,amount);
			//ps.setTimestamp(2, reqTime);
			ps.setString(2, description);
			ps.setInt(3, author);
			ps.setInt(4, statusId);
			ps.setInt(5, typeId);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	//select all existing reimbursements <- used my finance manager
	public ArrayList<Reimbursement> selectAllReimbursements() {
		ArrayList<Reimbursement> reimbList = new ArrayList();
		Reimbursement myReimbursement = null;
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= "SELECT * FROM ers_reimbursement";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				myReimbursement = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5),
						 rs.getBlob(6),rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
				reimbList.add(myReimbursement);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbList;
		
	}

	//select all pending reimbursements <- used by finance manager
	public ArrayList<Reimbursement> selectReimbursementsByStatus(int statusId) {
		ArrayList<Reimbursement> reimbList = new ArrayList();

		Reimbursement myReimbursement = null;
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= "SELECT * FROM ers_reimbursement WHERE reimb_status_id = ?";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,statusId);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				myReimbursement = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5),
						 rs.getBlob(6),rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
				//System.out.println(myReimbursement);
				reimbList.add(myReimbursement);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbList;
	}

	//select all reimbursements associated with a certain employee <- used by employee and finance manager
	public ArrayList<Reimbursement> selectReimbursementsByID(int userId) {
		ArrayList<Reimbursement> reimbList = new ArrayList();

		Reimbursement myReimbursement = null;
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,userId);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				myReimbursement = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5),
						 rs.getBlob(6),rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
				System.out.println(myReimbursement);
				reimbList.add(myReimbursement);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbList;
	}
	
	//update a reimbursement's status from pending to approved/denied <- used by finance manager
	public void approveOrDeny(int reimbId, int resolver, int statusId) {
		try(Connection conn=DriverManager.getConnection(url,username, password))
		{
			String sql= "{ call update_reimbursement(?,?,?) }";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, reimbId);
			ps.setInt(2, resolver);
			ps.setInt(3, statusId);
			
			System.out.println("inside DAO approve/deny");
			System.out.println("id = "+reimbId+" resolver = "+resolver+" status = "+statusId);
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
	
	

