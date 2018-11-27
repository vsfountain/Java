package revERS.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import revERS.model.Reimbursement;

public class ReImbDAO {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static String url = "jdbc:oracle:thin:@colt-rev-db.cjm6y7b2xpmz.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "revERS";
	private static String password = "p4ssw0rd";
	
	public static Logger logger = Logger.getLogger(ReImbDAO.class);

	public static int insert(double amt, String descr, int auth, String type) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			logger.info("In ReImbDAO.insert()");
			String sql = "{ call INSERT_REIMB(?,?,?,?) }";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1, amt);
			cs.setString(2, descr);
			cs.setInt(3, auth);
			cs.setString(4, type);
			return cs.executeUpdate();
		} catch(SQLException e) {
			logger.error("SQL Exception in insert()", e);
		}
		return 0;
	}
	public static int updateStatus(int rid, int uid, String status) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			logger.info("In ReImbDAO.updateStatus()");
			String sql = "{ call update_reimb(?,?,?) }";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, rid);
			cs.setInt(2, uid);
			cs.setString(3, status);
			return cs.executeUpdate();
		} catch(SQLException e) {
			logger.error("SQL Exception in updateStatus()", e);
		}
		return 0;
	}
	public static ArrayList<Reimbursement> selectAll(){
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			logger.info("In ReImbDAO.selectAll()");
			String sql = "SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, r.reimb_receipt, u.ers_username AS author, res.ers_username AS resolver, s.reimb_status, t.reimb_type " + 
						 "FROM ERS_REIMBURSEMENT r " + 
						 "LEFT OUTER JOIN ERS_USERS U ON r.reimb_author = u.ers_users_id " + 
						 "LEFT OUTER JOIN ERS_USERS res ON r.reimb_resolver = res.ers_users_id " + 
						 "LEFT OUTER JOIN ers_reimbursement_status s ON r.reimb_status_id = s.reimb_status_id " + 
						 "LEFT OUTER JOIN ers_reimbursement_type t ON r.reimb_type_id = t.reimb_type_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Reimbursement> r = new ArrayList<Reimbursement>();
			while(rs.next()) {
				LocalDate d = null;
				if (rs.getDate("reimb_resolved") != null) {
                    d = rs.getDate("reimb_resolved").toLocalDate();
                }
				r.add(new Reimbursement(rs.getInt("reimb_id"), 
										rs.getDouble("reimb_amount"), 
										rs.getDate("reimb_submitted").toLocalDate(), 
										d, 
										rs.getString("reimb_description"), 
										null, 
										rs.getString("author"), 
										rs.getString("resolver"), 
										rs.getString("reimb_status"), 
										rs.getString("reimb_type")));
			}
			return r;
		} catch(SQLException e) {
			logger.error("SQL Exception in selectAll()", e);
		}
		return null;
	}
	public static ArrayList<Reimbursement> selectByUser(int uid){
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			logger.info("In ReImbDAO.selectByUser()");
			String sql = "SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, r.reimb_receipt, u.ers_username AS author, res.ers_username AS resolver, s.reimb_status, t.reimb_type " + 
						 "FROM ERS_REIMBURSEMENT r " + 
						 "LEFT OUTER JOIN ERS_USERS U ON r.reimb_author = u.ers_users_id " + 
						 "LEFT OUTER JOIN ERS_USERS res ON r.reimb_resolver = res.ers_users_id " + 
						 "LEFT OUTER JOIN ers_reimbursement_status s ON r.reimb_status_id = s.reimb_status_id " + 
						 "LEFT OUTER JOIN ers_reimbursement_type t ON r.reimb_type_id = t.reimb_type_id " +
						 "WHERE u.ers_users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			ArrayList<Reimbursement> r = new ArrayList<Reimbursement>();
			while(rs.next()) {
				LocalDate d = null;
				if (rs.getDate("reimb_resolved") != null) {
                    d = rs.getDate("reimb_resolved").toLocalDate();
                }
				r.add(new Reimbursement(rs.getInt("reimb_id"), 
										rs.getDouble("reimb_amount"), 
										rs.getDate("reimb_submitted").toLocalDate(), 
										d, 
										rs.getString("reimb_description"), 
										null, 
										rs.getString("author"), 
										rs.getString("resolver"), 
										rs.getString("reimb_status"), 
										rs.getString("reimb_type")));
			}
			return r;
		} catch(SQLException e) {
			logger.error("SQL Exception in selectByUser()", e);
		}
		return null;
	}
}

/*
try(Connection conn= DriverManager.getConnection(url, username, password))
{
} catch(SQLException e) {
	e.printStackTrace();
}
*/