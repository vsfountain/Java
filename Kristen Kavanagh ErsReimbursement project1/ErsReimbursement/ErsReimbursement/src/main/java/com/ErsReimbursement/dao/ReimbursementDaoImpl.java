package com.ErsReimbursement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ErsReimbursement.model.Reimbursement;

/**
 * @author Kristen Kavanagh
 * @version 11/15/2018
 *
 */
public class ReimbursementDaoImpl implements ReimbursementDao {

	 static {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	private static String url = "jdbc:oracle:thin:@kristen.cu5uh73jvis1.us-east-2.rds.amazonaws.com:1521:kristen";
	private static String username = "kristenzers";
	private static String password = "krisers1234";
//	@Override
//	public int InsertReimbursement(Reimbursement reimburse) {
//		int imbur = 0;
//	try (Connection conn = DriverManager.getConnection(url,username,password)){
//		String sql = "{call insert_reimbursement_null_id(?,?,?,?,?,?)}";
//		CallableStatement cs = conn.prepareCall(sql);
//		cs.setDouble(1, reimburse.getRemb_Amount());
//		cs.setString(2, reimburse.getRemb_Description());
//		cs.setInt(3, reimburse.getRemb_Author());
//		cs.setInt(4, reimburse.getRemb_Status_Id());
//		cs.setInt(5, reimburse.getRemb_Type_Id());
//				cs.execute();
//		imbur=1;
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//	return imbur;
//	}

	@Override
	public int InsertReimbursement(Reimbursement reimburse) {
		int imbur = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT,REIMB_DESCRIPTION, REIMB_AUTHOR,REIMB_STATUS_ID, REIMB_TYPE_ID)"
					+ "VALUES(?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, reimburse.getRemb_Amount());
			ps.setString(2, reimburse.getRemb_Description());
			ps.setInt(3, reimburse.getRemb_Author());
			ps.setInt(4, reimburse.getRemb_Status_Id());
			ps.setInt(5, reimburse.getRemb_Type_Id());
			imbur = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return imbur;
	}

	@Override
	public ArrayList<Reimbursement>viewReimburse() {
		ArrayList<Reimbursement> arryreimb = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT";

			Statement statmnt = conn.createStatement();

			ResultSet rs = statmnt.executeQuery(sql);
			while (rs.next()) {
				
				int reimb_id = rs.getInt(1);
				double reimb_amount = rs.getDouble(2);
				String reimb_submitted = rs.getString(3);
				String reimb_resolved = rs.getString(4);
				String reimb_description = rs.getString(5);
				int reimb_author = rs.getInt(6);
				String reimb_resolver = rs.getString(7);
				int reimb_status_id = rs.getInt(8);
				int reimb_type_id = rs.getInt(9);

				Reimbursement newReimb = new Reimbursement(reimb_id, reimb_amount, reimb_submitted, reimb_resolved,
						reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id);

				arryreimb.add(newReimb);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return arryreimb;

	}
	

	public ArrayList<Reimbursement> selectByremb_Status_Id(int remb_Status_Id) {

		ArrayList<Reimbursement> arrystatid = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(8, remb_Status_Id);
			ResultSet rs = ps.executeQuery();
			System.out.println("thank you");
			while (rs.next()) {

				arrystatid.add(new Reimbursement(rs.getInt("Reimb_id"), rs.getDouble("reimb_amount"),
						rs.getString("Reimb_submitted"), rs.getString("reimb_resolved"),
						rs.getString("reimb_description"), rs.getInt("reimb_author"), rs.getString("reimb_resolver"),
						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrystatid;
	}


	public ArrayList<Reimbursement> selectByremb_Author(int remb_Author) {

		ArrayList<Reimbursement> arryremb_Author = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(6, remb_Author);
			ResultSet rs = ps.executeQuery();
			System.out.println("thank you");
			while (rs.next()) {

				arryremb_Author.add(new Reimbursement(rs.getInt("Reimb_id"), rs.getDouble("reimb_amount"),
						rs.getString("Reimb_submitted"), rs.getString("reimb_resolved"),
						rs.getString("reimb_description"), rs.getInt("reimb_author"), rs.getString("reimb_resolver"),
						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arryremb_Author;
	}


public int updateReimbursementByStatusId(Reimbursement reimburse) {
	try (Connection conn = DriverManager.getConnection(url, username, password)){
		String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = ? WHERE REIMB_ID = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, reimburse.getRemb_Status_Id());
		ps.setInt(2, reimburse.getRemb_Id());
		 ps.executeUpdate();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return 0;
}

@Override
public int updateReimbursementByStatusId() {
	return 0;
}
public int updateapprovedReimbursementByStatusId(String reimb_Resolved, String reimb_Resolver, int reimb_status_id) {
	try (Connection conn = DriverManager.getConnection(url, username, password)){
		String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = ?,?,? WHERE REIMB_ID = ?,?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(4, reimb_Resolved);
		ps.setString(7, reimb_Resolver);
		ps.setInt(8, reimb_status_id);
		 ps.executeUpdate();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return 0;
}
}
	

