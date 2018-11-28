package com.dao;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.classes.Reimbursement;

public class ReimbDAOImplementation implements ReimbDAO {
	static {
		// This is how we can make sure our tomcat knows what to do when calling DB
		// make sure you add ojdbc to WEB-INF and add to build-path
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	final static Logger logger = Logger.getLogger(ReimbDAOImplementation.class);

	private static String url;
	private static String username;
	private static String password;
	
	public ReimbDAOImplementation(){
		url = "jdbc:oracle:thin:@usf-revature-sean.ctfo6zflqljh.us-east-2.rds.amazonaws.com:1521:orcl";
		username = "RykerIndustries";
		password = "revature1";
	}
	public ReimbDAOImplementation(String _url, String _username, String _password){
		url = _url;
		username = _username;
		password = _password;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursements() {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, r.reimb_receipt, u.ers_username AS eauthor, u2.ers_users_id AS eresolver, s.reimb_status, t.reimb_type "
					+ "FROM ers_reimbursement r " 
					+ "LEFT JOIN ers_users u ON r.reimb_author = u.ers_users_id "
					+ "LEFT JOIN ers_users u2 ON r.reimb_resolver = u2.ers_users_id "
					+ "LEFT JOIN ers_reimbursement_status s ON r.reimb_status_id = s.reimb_status_id "
					+ "LEFT JOIN ers_reimbursement_type t ON r.reimb_type_id = t.reimb_type_id WHERE r.reimb_id IS NOT NULL ORDER BY r.reimb_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Timestamp tempResDate = null;
				if (rs.getDate("reimb_resolved") != null) {
					tempResDate = rs.getTimestamp("reimb_resolved");
				}
				int tempResolver = rs.getInt("eresolver");
				reimbs.add(new Reimbursement(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), tempResDate, rs.getString("reimb_description"),
						rs.getString("eauthor"), tempResolver, rs.getString("reimb_status"),
						rs.getString("reimb_type")));
			}
		} catch (SQLException e) {
			logger.error("@getReimbursements",e);
			e.printStackTrace();
		}
		if (reimbs.size() >= 1) {
			logger.info("@getReimbursements		Success:"+ reimbs.size() +" reimbursements obtained");
		} else {
			logger.info("@getReimbursements		FAIL: No Reimbursements found");
		}
		return reimbs;
	}

	// NEVER USED
	@Override
	public ArrayList<Reimbursement> getReimbursementForUser(int ers_user_id) {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, r.reimb_receipt, u.ers_username AS eauthor, u2.ers_users_id AS eresolver, s.reimb_status, t.reimb_type "
					+ "FROM ers_reimbursement r " 
					+ "LEFT JOIN ers_users u ON r.reimb_author = u.ers_users_id "
					+ "LEFT JOIN ers_users u2 ON r.reimb_resolver = u2.ers_users_id "
					+ "LEFT JOIN ers_reimbursement_status s ON r.reimb_status_id = s.reimb_status_id "
					+ "LEFT JOIN ers_reimbursement_type t ON r.reimb_type_id = t.reimb_type_id WHERE r.reimb_id IS NOT NULL AND r.reimb_author = ? ORDER BY r.reimb_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ers_user_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Timestamp tempResDate = null;
				if (rs.getDate("reimb_resolved") != null) {
					tempResDate = rs.getTimestamp("reimb_resolved");
				}
				int tempResolver = rs.getInt("eresolver");
				reimbs.add(new Reimbursement(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), tempResDate, rs.getString("reimb_description"),
						rs.getString("eauthor"), tempResolver, rs.getString("reimb_status"),
						rs.getString("reimb_type")));
			}
		} catch (SQLException e) {
			logger.error("@getReimbursementsForUser(int)",e);
			e.printStackTrace();
		}
		if (reimbs.size() >= 1) {
			logger.info("@getReimbursementsForUser(int)		Success:"+ reimbs.size() +" reimbursements for "+ers_user_id+" obtained");
		} else {
			logger.info("@getReimbursementsForUser(int)		FAIL: No Reimbursements for "+ers_user_id+" found");
		}
		return reimbs;
	}
	
	@Override
	public ArrayList<Reimbursement> getReimbursementForUser(int ers_user_id, boolean getBlob) {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, r.reimb_receipt, u.ers_username AS eauthor, u2.ers_users_id AS eresolver, s.reimb_status, t.reimb_type "
					+ "FROM ers_reimbursement r " 
					+ "LEFT JOIN ers_users u ON r.reimb_author = u.ers_users_id "
					+ "LEFT JOIN ers_users u2 ON r.reimb_resolver = u2.ers_users_id "
					+ "LEFT JOIN ers_reimbursement_status s ON r.reimb_status_id = s.reimb_status_id "
					+ "LEFT JOIN ers_reimbursement_type t ON r.reimb_type_id = t.reimb_type_id WHERE r.reimb_id IS NOT NULL AND r.reimb_author = ? ORDER BY r.reimb_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ers_user_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Timestamp tempResDate = null;
				if (rs.getDate("reimb_resolved") != null) {
					tempResDate = rs.getTimestamp("reimb_resolved");
				}
				
				int tempResolver = rs.getInt("eresolver");
				if (getBlob) {
					Blob bb = rs.getBlob("reimb_receipt");
				}
				reimbs.add(new Reimbursement(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), tempResDate, rs.getString("reimb_description"),
						rs.getString("eauthor"), tempResolver, rs.getString("reimb_status"),
						rs.getString("reimb_type")));
			}
		} catch (SQLException e) {
			logger.error("@getReimbursementsForUser(int)",e);
			e.printStackTrace();
		}
		if (reimbs.size() >= 1) {
			logger.info("@getReimbursementsForUser(int)		Success:"+ reimbs.size() +" reimbursements for "+ers_user_id+" obtained");
		} else {
			logger.info("@getReimbursementsForUser(int)		FAIL: No Reimbursements for "+ers_user_id+" found");
		}
		return reimbs;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementForUser(String ers_username) {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, r.reimb_receipt, u.ers_username AS eauthor, u2.ers_users_id AS eresolver, s.reimb_status, t.reimb_type "
					+ "FROM ers_reimbursement r " 
					+ "LEFT JOIN ers_users u ON r.reimb_author = u.ers_users_id "
					+ "LEFT JOIN ers_users u2 ON r.reimb_resolver = u2.ers_users_id "
					+ "LEFT JOIN ers_reimbursement_status s ON r.reimb_status_id = s.reimb_status_id "
					+ "LEFT JOIN ers_reimbursement_type t ON r.reimb_type_id = t.reimb_type_id WHERE r.reimb_id IS NOT NULL AND u.ers_username = ? ORDER BY r.reimb_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ers_username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Timestamp tempResDate = null;
				if (rs.getDate("reimb_resolved") != null) {
					tempResDate = rs.getTimestamp("reimb_resolved");
				}
				int tempResolver = rs.getInt("eresolver");
				reimbs.add(new Reimbursement(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), tempResDate, rs.getString("reimb_description"),
						rs.getString("eauthor"), tempResolver, rs.getString("reimb_status"),
						rs.getString("reimb_type")));
			}
		} catch (SQLException e) {
			logger.error("@getReimbursementsForUser(String)",e);
			e.printStackTrace();
		}
		if (reimbs.size() >= 1) {
			logger.info("@getReimbursementsForUser(String)		Success:"+ reimbs.size() +" reimbursements for "+ers_username+" obtained");
		} else {
			logger.info("@getReimbursementsForUser(String)		FAIL: No Reimbursements for "+ers_username+" found");
		}
		return reimbs;
	}
	
	
	
	public static byte[] convertFileContentToBlob(String filePath) throws IOException {
		byte[] fileContent = null;
		try {
			fileContent = FileUtils.readFileToByteArray(new File(filePath));
		} catch (IOException e) {
			throw new IOException("Unable to convert file to byte array. " + e.getMessage());
		}
		return fileContent;
	}
	
	@Override
	public int addReimbursementReceipt(double amount, String description, String username, String type, String filePath) {
		int rs = 0;
		try (Connection conn = DriverManager.getConnection(url, this.username, password)){
			//byte[] bb = convertFileContentToBlob(filePath);
			String sql = "{ ? = call reimb_insert_manager_blob(?, ?, ?, ?, ?) }";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setDouble(2, amount);
			cs.setString(3, description);
			cs.setString(4, username);
			cs.setString(5, type);
			InputStream inputStream = new FileInputStream(new File(filePath));
			cs.setBlob(6, inputStream);
			cs.execute();
			rs = cs.getInt(1);
		} catch (IOException e) {
			logger.error("@addReimbursementReceipt",e);
			e.printStackTrace();
		} catch (SerialException e) {
			logger.error("@addReimbursementReceipt",e);
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error("@addReimbursementReceipt",e);
			e.printStackTrace();
		}
		return rs;
	}
	
	public int addReimbursement(double amount, String description, String userName, String type) {
		int rs = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{ ? = call reimb_insert_manager(?, ?, ?, ?) }";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setDouble(2, amount);
			cs.setString(3, description);
			cs.setString(4, userName);
			cs.setString(5, type);
			cs.execute();
			rs = cs.getInt(1);
			System.out.println("asifjkfnsdjgfnw      "+rs);
		} catch (SQLException e) {
			logger.error("@addReimbursement",e);
			e.printStackTrace();
		}
		return rs;
	}
	
	@Override
	public int updateReimbursement(int reimb_id, String admin_name, String newStatus) {
		int rs = -1;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{ ? = call update_reimb_status(?, ?, ?) }";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, reimb_id);
			cs.setString(3, admin_name);
			cs.setString(4, newStatus);
			cs.execute();
			rs = cs.getInt(1);
		} catch (SQLException e) {
			logger.error("@updateReimbursement", e);
			e.printStackTrace();
		}
		return rs;
	}

}
