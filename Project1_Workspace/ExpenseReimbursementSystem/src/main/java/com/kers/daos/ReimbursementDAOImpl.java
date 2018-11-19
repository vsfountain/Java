package com.kers.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kers.models.Reimbursement;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String url = "jdbc:oracle:thin:@revychan.c75kj45zpjaq.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "ersdb";
	private static String password = "password";

	@Override
	public int insertReimbursement(Reimbursement r) {
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			String sql = "{ call insert_ers_reimb_id_null(?,?,?,?,?,?) }";

			CallableStatement cs = con.prepareCall(sql);
			cs.setDouble(1, r.getAmountDouble());
			cs.setTimestamp(2, Timestamp.valueOf(java.time.LocalDateTime.now()));
			cs.setString(3, r.getDescription());
			cs.setBlob(4, r.getReceipt());
			cs.setString(5, r.getAuthor());
			cs.setString(6, r.getType());

			return cs.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Reimbursement> selectAllReimbursements() {
		ArrayList<Reimbursement> rList = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, r.reimb_receipt, u1.ers_username, u2.ers_username, rs.reimb_status, rt.reimb_type FROM ERS_REIMBURSEMENT r  LEFT OUTER JOIN ERS_USERS u1   ON r.reimb_author = u1.ers_users_id"
					+ "    LEFT OUTER JOIN ERS_USERS u2 ON r.reimb_resolver = u2.ers_users_id"
					+ "    LEFT OUTER JOIN ERS_REIMBURSEMENT_STATUS rs ON r.reimb_status_id = rs.reimb_status_id"
					+ "    LEFT OUTER JOIN ERS_REIMBURSEMENT_TYPE rt ON r.reimb_type_id = rt.reimb_type_id";

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimbursement r;
				if (rs.getTimestamp(3) == null) {
					r = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getString(5),
							rs.getBlob(6), rs.getString(7), rs.getString(9), rs.getString(10));
				} else {
					r = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4),
							rs.getString(5), rs.getBlob(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10));
				}
				rList.add(r);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rList;
	}

	@Override
	public Reimbursement selectReimbursementById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement selectReimbursementByStatusId(int status_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement deleteReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateReimbursementById(int id, String decision, String resolver) {
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			String sql = "{ call update_reimb_status(?,?,?) }";

			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("DECISION: " + decision);
			/*
			 * if (decision.equals("approve")) { ps.setInt(1, 102); } else { ps.setInt(1,
			 * 103); }
			 */
			ps.setInt(1, id);
			if (decision.equals("approve")) {
				ps.setString(2, "Approved");
			} else {
				ps.setString(2, "Denied");
			}
			ps.setString(3, resolver);

			return ps.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}
}
