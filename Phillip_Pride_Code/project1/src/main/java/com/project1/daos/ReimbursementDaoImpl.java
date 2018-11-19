package com.project1.daos;

import java.security.Timestamp;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project1.objs.Reimbursement;
import com.project1.objs.User;

public class ReimbursementDaoImpl implements ReimbursementDao {
	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	private static String url = "jdbc:oracle:thin:@revatur-instance.cyxb24oq9oml.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "ersdb";
	private static String password = "ers1234";

	@Override
	public void creatReimb(int reimbAmount, String reimbDescription, Blob receipt, int reimbAuthor,
			int reimbTypeId) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{ call add_reimbursement(?,?,?,?,?) }";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, reimbAmount);
			cs.setString(2, reimbDescription);
			cs.setBlob(3, receipt);
			cs.setInt(4, reimbAuthor);
			cs.setInt(5, reimbTypeId);

			cs.executeUpdate();
			// logger.info("Account for " + name + " was successfully created.");
		} catch (SQLException e) {
			e.printStackTrace();
			/*
			 * logger.error("There was an error creating an account for " + name + ".", new
			 * SQLException());
			 */
		}
	}

	@Override
	public List<Reimbursement> getUserReimbs(User user) {
		List reimbs = new ArrayList<Reimbursement>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author=" +
							user.getUserId();

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"), rs.getBlob("reimb_receipt"), 
						rs.getInt("reimb_author"), rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id")));
			}
			return reimbs;
		} catch (SQLException e) {
			e.printStackTrace();
			/*
			 * logger.error("There was an error creating an account for " + name + ".", new
			 * SQLException());
			 */
		}
		return reimbs;
	}
	
	@Override
	public List<Reimbursement> getAllReimbs() {
		List reimbs = new ArrayList<Reimbursement>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM ers_reimbursement";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"), rs.getBlob("reimb_receipt"), 
						rs.getInt("reimb_author"), rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id")));
			}
			return reimbs;
		} catch (SQLException e) {
			e.printStackTrace();
			/*
			 * logger.error("There was an error creating an account for " + name + ".", new
			 * SQLException());
			 */
		}
		return reimbs;
	}
	

	@Override
	public void updateReimb(Reimbursement reimb, User resolver, int process) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{ call process_reimbursement(?,?,?) }";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, reimb.getReimbId());
			cs.setInt(2, resolver.getUserId());
			cs.setInt(3, process);

			cs.executeUpdate();
			// logger.info("Account for " + name + " was successfully created.");
		} catch (SQLException e) {
			e.printStackTrace();
			/*
			 * logger.error("There was an error creating an account for " + name + ".", new
			 * SQLException());
			 */
		}

	}

}
