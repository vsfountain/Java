package com.reimbsys.dao;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import com.reimbsys.model.Reimbursement;

public class ReimbDaoImpl implements ReimbDao {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String url = "jdbc:oracle:thin:@revy-chan.cxm6xvuq7tje.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String dbUsername = "reimbsysdb";
	private static String dbPassword = "p4ssw0rd";

	@Override
	public Map<String, Reimbursement> selectAllReimbs() {
		Map<String, Reimbursement> reimb = new HashMap<>();

		try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
			String sql = "SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, "
					+ "r.reimb_receipt, r.reimb_author, u1.ers_username AS author_name, r.reimb_resolver, "
					+ "u2.ers_username AS resolver_name, r.reimb_status_id, s.reimb_status, r.reimb_type_id, t.reimb_type "
					+ "FROM ers_reimbursement r JOIN ers_reimbursement_type t ON r.reimb_type_id=t.reimb_type_id "
					+ "JOIN ers_reimbursement_status s ON r.reimb_status_id=s.reimb_status_id "
					+ "JOIN ers_users u1 ON r.reimb_author=u1.ers_users_id "
					+ "LEFT OUTER JOIN ers_users u2 ON r.reimb_resolver=u2.ers_users_id";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// using the full constructor
				Timestamp tmp = null;
				int auth = -1;
				if (rs.getTimestamp("reimb_resolved") != null) {
					tmp = rs.getTimestamp("reimb_resolved");
					auth = Integer.parseInt(rs.getString("reimb_resolver"));
				}
				Reimbursement r = new Reimbursement(Integer.parseInt(rs.getString("reimb_id")),
						rs.getDouble("reimb_amount"), 
						rs.getTimestamp("reimb_submitted"),
						tmp, 
						rs.getString("reimb_description"),
						rs.getBlob("reimb_receipt"), 
						Integer.parseInt(rs.getString("reimb_author")),
						rs.getString("author_name"), 
						auth,
						rs.getString("resolver_name"), 
						Integer.parseInt(rs.getString("reimb_status_id")),
						rs.getString("reimb_status"), 
						Integer.parseInt(rs.getString("reimb_type_id")),
						rs.getString("reimb_type"));
				reimb.put(r.getAuthor()+"|"+rs.getString("reimb_id"), r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public Reimbursement selectReimbById(int reimbid) {
		Reimbursement reimb = new Reimbursement();

		try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
			String sql = "SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, "
					+ "r.reimb_receipt, r.reimb_author, u1.ers_username AS author_name, r.reimb_resolver, "
					+ "u2.ers_username AS resolver_name, r.reimb_status_id, s.reimb_status, r.reimb_type_id, t.reimb_type "
					+ "FROM ers_reimbursement r JOIN ers_reimbursement_type t ON r.reimb_type_id=t.reimb_type_id "
					+ "JOIN ers_reimbursement_status s ON r.reimb_status_id=s.reimb_status_id "
					+ "JOIN ers_users u1 ON r.reimb_author=u1.ers_users_id "
					+ "LEFT OUTER JOIN ers_users u2 ON r.reimb_resolver=u2.ers_users_id WHERE r.reimb_id=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(reimbid));

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// using the full constructor
				Timestamp tmp = null;
				int auth = -1;
				if (rs.getTimestamp("reimb_resolved") != null) {
					tmp = rs.getTimestamp("reimb_resolved");
					auth = Integer.parseInt(rs.getString("reimb_resolver"));
				}
				reimb = new Reimbursement(Integer.parseInt(rs.getString("reimb_id")),
						rs.getDouble("reimb_amount"), 
						rs.getTimestamp("reimb_submitted"),
						tmp, 
						rs.getString("reimb_description"),
						rs.getBlob("reimb_receipt"), 
						Integer.parseInt(rs.getString("reimb_author")),
						rs.getString("author_name"), 
						auth,
						rs.getString("resolver_name"), 
						Integer.parseInt(rs.getString("reimb_status_id")),
						rs.getString("reimb_status"), 
						Integer.parseInt(rs.getString("reimb_type_id")),
						rs.getString("reimb_type"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public Map<String, Reimbursement> selectReimbByUserId(int userid) {
		Map<String, Reimbursement> reimb = new HashMap<>();

		try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
			String sql = "SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, "
					+ "r.reimb_receipt, r.reimb_author, u1.ers_username AS author_name, r.reimb_resolver, "
					+ "u2.ers_username AS resolver_name, r.reimb_status_id, s.reimb_status, r.reimb_type_id, t.reimb_type "
					+ "FROM ers_reimbursement r JOIN ers_reimbursement_type t ON r.reimb_type_id=t.reimb_type_id "
					+ "JOIN ers_reimbursement_status s ON r.reimb_status_id=s.reimb_status_id "
					+ "JOIN ers_users u1 ON r.reimb_author=u1.ers_users_id "
					+ "LEFT OUTER JOIN ers_users u2 ON r.reimb_resolver=u2.ers_users_id WHERE r.reimb_author=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(userid));

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// using the full constructor
				Timestamp tmp = null;
				int auth = -1;
				if (rs.getTimestamp("reimb_resolved") != null) {
					tmp = rs.getTimestamp("reimb_resolved");
					auth = Integer.parseInt(rs.getString("reimb_resolver"));
				}
				Reimbursement r = new Reimbursement(Integer.parseInt(rs.getString("reimb_id")),
						rs.getDouble("reimb_amount"), 
						rs.getTimestamp("reimb_submitted"),
						tmp, 
						rs.getString("reimb_description"),
						rs.getBlob("reimb_receipt"), 
						Integer.parseInt(rs.getString("reimb_author")),
						rs.getString("author_name"), 
						auth,
						rs.getString("resolver_name"), 
						Integer.parseInt(rs.getString("reimb_status_id")),
						rs.getString("reimb_status"), 
						Integer.parseInt(rs.getString("reimb_type_id")),
						rs.getString("reimb_type"));
				reimb.put(r.getAuthor()+"|"+rs.getString("reimb_id"), r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public Map<String, Reimbursement> selectReimbByUserName(String username) {
		Map<String, Reimbursement> reimb = new HashMap<>();

		try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
			String sql = "SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, "
					+ "r.reimb_receipt, r.reimb_author, u1.ers_username AS author_name, r.reimb_resolver, "
					+ "u2.ers_username AS resolver_name, r.reimb_status_id, s.reimb_status, r.reimb_type_id, t.reimb_type "
					+ "FROM ers_reimbursement r JOIN ers_reimbursement_type t ON r.reimb_type_id=t.reimb_type_id "
					+ "JOIN ers_reimbursement_status s ON r.reimb_status_id=s.reimb_status_id "
					+ "JOIN ers_users u1 ON r.reimb_author=u1.ers_users_id "
					+ "LEFT OUTER JOIN ers_users u2 ON r.reimb_resolver=u2.ers_users_id WHERE u1.ers_username=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// using the full constructor
				Timestamp tmp = null;
				int auth = -1;
				if (rs.getTimestamp("reimb_resolved") != null) {
					tmp = rs.getTimestamp("reimb_resolved");
					auth = Integer.parseInt(rs.getString("reimb_resolver"));
				}
				Reimbursement r = new Reimbursement(Integer.parseInt(rs.getString("reimb_id")),
						rs.getDouble("reimb_amount"), 
						rs.getTimestamp("reimb_submitted"),
						tmp, 
						rs.getString("reimb_description"),
						rs.getBlob("reimb_receipt"), 
						Integer.parseInt(rs.getString("reimb_author")),
						rs.getString("author_name"), 
						auth,
						rs.getString("resolver_name"), 
						Integer.parseInt(rs.getString("reimb_status_id")),
						rs.getString("reimb_status"), 
						Integer.parseInt(rs.getString("reimb_type_id")),
						rs.getString("reimb_type"));
				reimb.put(r.getAuthor()+rs.getString("reimb_id"), r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public int insertReimb(Double amount, int userid, int typeid, String description, Blob receipt) {
//		insert_new_reimbursement(ramount IN ers_reimbursement.reimb_amount%TYPE,
//                rauthor IN ers_reimbursement.reimb_author%TYPE,
//                rtype IN ers_reimbursement.reimb_type_id%TYPE,
//                rdesc IN ers_reimbursement.reimb_description%TYPE,
//                rreceipt IN ers_reimbursement.reimb_receipt%TYPE)
		
		// Hard code the status id to 1 for pending by default
		int id = 0;
		try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword))
		{
			//return the account id
			String sql= "{ ? = call insert_new_reimbursement(?, ?, ?, ?, ?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setDouble(2, amount);
			cs.setInt(3, userid);
			cs.setInt(4, typeid);
			cs.setString(5, description);
			cs.setBlob(6, receipt);
			
			id = cs.executeUpdate();
			id = cs.getInt(1);

		}catch(SQLException  e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Map<String, Integer> selectTypes() {
		Map<String, Integer> types = new HashMap<>();

		try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
			String sql = "SELECT * FROM ers_reimbursement_type";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			int id = 0;
			String type = "";
			
			while (rs.next()) {
				id = rs.getInt("reimb_type_id");
				type = rs.getString("reimb_type");
				types.put(type, id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return types;
	}

	@Override
	public Map<String, Integer> selectStatuses() {
		Map<String, Integer> statuses = new HashMap<>();

		try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
			String sql = "SELECT * FROM ers_reimbursement_status";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			int id = 0;
			String status = "";
			
			while (rs.next()) {
				id = rs.getInt("reimb_status_id");
				status = rs.getString("reimb_status");
				statuses.put(status, id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statuses;
	}

	@Override
	public int updateReimb(int reimbid, int statusid, int resolverid, Timestamp resolved) {
		try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword))
		{
			String sql= "UPDATE ers_reimbursement "
					+ "SET reimb_id=?, reimb_status_id=?, reimb_resolver=?, reimb_resolved=? "
					+ "WHERE reimb_id=?";
		
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, reimbid);
			ps.setInt(2, statusid);
			ps.setInt(3, resolverid);
			ps.setTimestamp(4, resolved);
			ps.setInt(5, reimbid);
			
			
			ps.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteReimb(int reimbid) {
		try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
			String sql = "DELETE * FROM ers_reimbursement WHERE reimb_id=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbid);
		
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
