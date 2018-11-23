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
		// This is how we can make sure our tomcat knows what to do when calling DB
		// make sure you add ojdbc to WEB-INF and add to build-path
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static String url = "jdbc:oracle:thin:@kristen.cu5uh73jvis1.us-east-2.rds.amazonaws.com:1521:kristen";
	private static String username = "kristenzers";
	private static String password = "krisers1234";

	@Override
	public int InsertReimbursement(Reimbursement reimburse) {
		int imbur = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT,REIMB_DESCRIPTION, REIMB_AUTHOR,REIMB_STATUS_ID, REIMB_TYPE_ID)"
					+ "VALUES(?,?,?,3,?)";

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
	public ArrayList<Reimbursement> viewReimburse() {
		ArrayList<Reimbursement> arryreimb = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT";

			Statement statmnt = conn.createStatement();

			ResultSet rs = statmnt.executeQuery(sql);
				while(rs.next())
			{
					int reimb_id = rs.getInt(0);
					double reimb_amount = rs.getDouble(1);
					String reimb_submitted = rs.getString(3);
					String reimb_resolved = rs.getString(4);
					String reimb_description = rs.getString(5);
					int reimb_author = rs.getInt(6);
					String reimb_resolver = rs.getString(7);
					int reimb_status_id = rs.getInt(8);
					int reimb_type_id =rs.getInt(9);
					
					Reimbursement newReimb = new Reimbursement(reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id);
				
				arryreimb.add(newReimb);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return arryreimb;

	}

}
