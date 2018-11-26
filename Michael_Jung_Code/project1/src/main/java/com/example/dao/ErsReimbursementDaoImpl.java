package com.example.dao;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.model.ErsReimbursement;

public class ErsReimbursementDaoImpl implements ErsReimbursementDao{

	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}
	
	private static String url =
			"jdbc:oracle:thin:@revy-chan.cjfdvsamxdlk.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "usfdb";
	private static String password = "usf12345";
	
	@Override
	public List<ErsReimbursement> /*void*/ selectAllErsReimbursements() {
		
		List<ErsReimbursement> allErsReimbursements = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "Select * from ers_reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			/*System.out.println("dlskfjldk");*/
			while(rs.next()) {
				
				/*Timestamp ts = rs.getTimestamp("REIMB_SUBMITTED");
				System.out.println(ts);
				Date date = ts;
				System.out.println(date);
				
				
				System.out.println(rs.getTimestamp("REIMB_SUBMITTED"));*/
				/*String a = rs.getBlob("REIMB_RECEIPT") == null? rs.getBlob("REIMB_RECEIPT").toString() : null;*/
				
				allErsReimbursements.add(new ErsReimbursement(rs.getInt("REIMB_ID"),
																rs.getDouble("REIMB_AMOUNT"),
																(Date) rs.getTimestamp("REIMB_SUBMITTED"),
																(Date) rs.getTimestamp("REIMB_RESOLVED"),
																rs.getString("REIMB_DESCRIPTION"),
																rs.getBlob("REIMB_RECEIPT") == null ? null : rs.getBlob("REIMB_RECEIPT").toString(),
																rs.getInt("REIMB_AUTHOR"),
																rs.getInt("REIMB_STATUS_ID"),
																rs.getInt("REIMB_TYPE_ID"),
																rs.getInt("REIMB_RESOLVER")));
			}
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allErsReimbursements;
		/*System.out.println(allErsReimbursements);*/
		
		
	}
	
	
	@Override
	public int approveReimbursement(int reimbursementId, int adminUserId) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED=CURRENT_TIMESTAMP, "
							+ "REIMB_STATUS_ID=1, REIMB_RESOLVER=" + adminUserId
							+ " WHERE REIMB_ID=" + reimbursementId;
			/*System.out.println(sql);*/
			Statement statement = conn.createStatement();
			/*System.out.println("ldskfjsdlkj");*/
			int numberOfRowsChanged = statement.executeUpdate(sql);
			/*System.out.println("sdofijsdoaijfoi");*/
			return numberOfRowsChanged;
			
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
	
	
	public int disapproveReimbursement(int reimbursementId, int adminUserId) {
		
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED=CURRENT_TIMESTAMP, "
							+ "REIMB_STATUS_ID=2, REIMB_RESOLVER=" + adminUserId
							+ " WHERE REIMB_ID=" + reimbursementId;
			Statement statement = conn.createStatement();
			int numberOfRowsChanged = statement.executeUpdate(sql);
			return numberOfRowsChanged;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	public int insertReimbursement(ErsReimbursement ersReimbursement) {
		
		int status = 0;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{ call insert_reimbursement(?,?,?,?) }";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1, ersReimbursement.getReimbursementAmount());
			cs.setString(2, ersReimbursement.getReimbursementDescription());
			cs.setInt(3, ersReimbursement.getReimbursementErsUserId());
			cs.setInt(4, ersReimbursement.getReimbursementTypeId());
			status = cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	
	
	
	
}
