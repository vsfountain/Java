package com.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.h2.api.Trigger;

import com.functions.MD5;

public class H2DAOImplementation implements H2DAO {
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
	
	public H2DAOImplementation(){
		url = "jdbc:oracle:thin:@usf-revature-sean.ctfo6zflqljh.us-east-2.rds.amazonaws.com:1521:orcl";
		username = "RykerIndustries";
		password = "revature1";
	}
	public H2DAOImplementation(String _url, String _username, String _password){
		url = _url;
		username = _username;
		password = _password;
	}
	
	@Override
	public void h2InitDaoSeq() {
		try(Connection conn = DriverManager.getConnection(url,username, password)) {	
			String sql = "CREATE SEQUENCE users_id_seq "
					+ "	START WITH 1"
					+ "	INCREMENT BY 1;"
					+ ""
					+ "CREATE SEQUENCE reimb_id_seq"
					+ "	START WITH 100"
					+ "	INCREMENT BY 1;"
					+ ""
					+ "CREATE SEQUENCE role_id_seq"
					+ "	START WITH 500"
					+ "	INCREMENT BY 1;"
					+ ""
					+ "CREATE SEQUENCE status_id_seq"
					+ "	START WITH 1000"
					+ "	INCREMENT BY 1;"
					+ ""
					+ "CREATE SEQUENCE type_id_seq"
					+ "	START WITH 1500"
					+ "	INCREMENT BY 1;";

			Statement state = conn.createStatement();
			state.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void h2InitDao() {
		try(Connection conn = DriverManager.getConnection(url,username, password)) {	
			String sql = "CREATE TABLE ers_reimbursement_status "
				+ "( reimb_status_id NUMBER DEFAULT status_id_seq.nextval, "
				+ "reimb_status VARCHAR2(10) NOT NULL, "
				+ "CONSTRAINT reimb_status_PK PRIMARY KEY (reimb_status_id)); "
				+ ""
				+ "CREATE TABLE ers_reimbursement_type "
				+ "( reimb_type_id NUMBER DEFAULT type_id_seq.nextval, "
				+ "reimb_type VARCHAR2(10) NOT NULL, "
				+ "CONSTRAINT reimb_type_PK PRIMARY KEY (reimb_type_id)); "
				+ ""
				+ "CREATE TABLE ers_user_roles "
				+ "( ers_user_role_id NUMBER DEFAULT role_id_seq.nextval, "
				+ "user_role VARCHAR2(10) NOT NULL, "
				+ "CONSTRAINT ers_user_roles_PK PRIMARY KEY (ers_user_role_id)); "
				+ ""
				+ "CREATE TABLE ers_users "
				+ "( ers_users_id NUMBER DEFAULT users_id_seq.nextval, "
				+ "ers_username VARCHAR2(50) NOT NULL UNIQUE, "
				+ "ers_password VARCHAR2(50) NOT NULL, "
				+ "user_first_name VARCHAR2(100) NOT NULL, "
				+ "user_last_name VARCHAR2(100) NOT NULL, "
				+ "user_email VARCHAR2(150) NOT NULL UNIQUE, "
				+ "user_role_id NUMBER NOT NULL, "
				+ "CONSTRAINT ers_users_PK PRIMARY KEY (ers_users_id), "
				+ "CONSTRAINT user_roles_FK FOREIGN KEY (user_role_id) REFERENCES ers_user_roles (ers_user_role_id) ON DELETE CASCADE); "
				+ ""
				+ "CREATE TABLE ers_reimbursement "
				+ "(reimb_id NUMBER DEFAULT reimb_id_seq.nextval, "
				+ "reimb_amount NUMBER NOT NULL, "
				+ "reimb_submitted TIMESTAMP DEFAULT current_timestamp NOT NULL, "
				+ "reimb_resolved TIMESTAMP, "
				+ "reimb_description VARCHAR2(250), "
				+ "reimb_receipt BLOB, "
				+ "reimb_author NUMBER NOT NULL, "
				+ "reimb_resolver NUMBER, "
				+ "reimb_status_id NUMBER NOT NULL, "
				+ "reimb_type_id NUMBER NOT NULL, "
				+ "CONSTRAINT ers_reimbursement_PK PRIMARY KEY (reimb_id), "
				+ "CONSTRAINT ers_users_FK_auth FOREIGN KEY (reimb_author) REFERENCES ers_users (ers_users_id) ON DELETE CASCADE, "
				+ "CONSTRAINT ers_users_FK_resolvr FOREIGN KEY (reimb_resolver) REFERENCES ers_users (ers_users_id) ON DELETE CASCADE, "
				+ "CONSTRAINT ers_reimbursement_status_FK FOREIGN KEY(reimb_status_id) REFERENCES ers_reimbursement_status (reimb_status_id) ON DELETE CASCADE, "
				+ "CONSTRAINT ers_reimbursement_type_FK FOREIGN KEY (reimb_type_id) REFERENCES ers_reimbursement_type (reimb_type_id) ON DELETE CASCADE) ";

			Statement state = conn.createStatement();
			state.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int reimb_insert_manager(Double amt, String descrip, String auth, String typ) {
		int returnCode = -1;
		int user_id = -1;
		int type_id = -1;
		int status_id = -1;
		boolean userFound = false;
		boolean typeFound = false;
		boolean statusFound = false;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			java.sql.ResultSet rs;
			rs = conn.createStatement().executeQuery("SELECT ers_users_id FROM ers_users WHERE ers_username = '" + auth+"'");
			while (rs.next()) {
				userFound = true;
				user_id = rs.getInt("ers_users_id");
			}
			if (!userFound) {
				returnCode = 400;
				return returnCode;
			}
			rs = conn.createStatement()
					.executeQuery("SELECT reimb_type_id FROM ers_reimbursement_type WHERE reimb_type = '" + typ+"'");
			while (rs.next()) {
				typeFound = true;
				type_id = rs.getInt("reimb_type_id");
			}

			if (!typeFound) {
				returnCode = 450;
				return returnCode;
			}
			rs = conn.createStatement()
					.executeQuery("SELECT  ers_reimbursement_status.reimb_status_id FROM ers_reimbursement_status WHERE reimb_status = 'pending'");
			while (rs.next()) {
				statusFound = true;
				status_id = rs.getInt("reimb_status_id");
			}
			if (!statusFound) {
				returnCode = 500;
				return returnCode;
			}
			
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO ERS_REIMBURSEMENT (reimb_amount, reimb_description, reimb_author, reimb_status_id, reimb_type_id) VALUES (?, ?, ?, ?, ?)");
			ps.setDouble(1, amt);
			ps.setString(2, descrip);
			ps.setInt(3, user_id);
			ps.setInt(4, status_id);
			ps.setInt(5, type_id);
			returnCode = ps.executeUpdate();
			return returnCode;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnCode;
	}

	
	public static String get_user_hash(String username, String passwordc) {
		String extra = "SALTrYkEr";
		String encr = MD5.crypt(username+passwordc+extra);
		//System.out.println("IN HASHING FUNC "+ encr);
        return encr;
	}
	
	public static String checkLoginCredentials(String usernameunchecked, String passwordunchecked) {
		String myhash = get_user_hash(usernameunchecked, passwordunchecked);
		return myhash;
	}

	public static int UPDATE_REIMB_STATUS(int reimburse_id, String admin_name, String newStatus) {
		int temp_status_id = -11;
		Timestamp temp_status_check = null;
		int temp_employee_id = -11;
		int temp_role_id = -11;
		String temp_role = "";
		int returnCode = 0;
		boolean empFound = false;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			java.sql.ResultSet rs;
			rs = conn.createStatement()
					.executeQuery("SELECT ers_users_id FROM ers_users WHERE ers_username = '" + admin_name + "'");
			while (rs.next()) {
				empFound = true;
				temp_employee_id = rs.getInt("ers_users_id");
			}
			rs = conn.createStatement()
					.executeQuery("SELECT user_role_id FROM ers_users WHERE ers_username = '" + admin_name + "'");
			while (rs.next()) {
				temp_role_id = rs.getInt("user_role_id");
			}
			rs = conn.createStatement().executeQuery(
					"SELECT user_role FROM ers_user_roles WHERE ers_user_role_id = '" + temp_role_id + "'");
			while (rs.next()) {
				temp_role = rs.getString("user_role");
			}
			rs = conn.createStatement()
					.executeQuery("SELECT reimb_resolved FROM ers_reimbursement  WHERE ers_reimbursement.reimb_id = '"
							+ reimburse_id + "'");
			while (rs.next()) {
				temp_status_check = rs.getTimestamp("reimb_resolved");
			}
			if (!temp_role.equals("Admin") || !empFound) {
				returnCode = 400;
			} else if (temp_status_check == null) {
				rs = conn.createStatement()
						.executeQuery("SELECT reimb_status_id FROM ers_reimbursement_status WHERE reimb_status = '"
								+ newStatus + "'");
				boolean inWhile = false;
				while (rs.next()) {
					inWhile = true;
					temp_status_id = rs.getInt("reimb_status_id");
				}
				if (!inWhile) {
					returnCode = -1;
				} else {
					String sql = "UPDATE ers_reimbursement SET reimb_resolved=CURRENT_TIMESTAMP, reimb_resolver=?, reimb_status_id=? WHERE reimb_id = ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, temp_employee_id);
					ps.setInt(2, temp_status_id);
					ps.setInt(3, reimburse_id);
					int didItWork = ps.executeUpdate();
					if (didItWork == 1) {
						returnCode = 200;
					} else {
						returnCode = 0;
					}
				}

			} else {
				returnCode = 500;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnCode;
	}

	@Override
	public void h2InitDaoFunProc() {
		try(Connection conn = DriverManager.getConnection(url,username, password)) {	
			 conn.createStatement().execute("DROP ALIAS IF EXISTS get_user_hash; CREATE ALIAS get_user_hash FOR \"com.dao.H2DAOImplementation.get_user_hash\"");
			 conn.createStatement().execute("DROP ALIAS IF EXISTS reimb_insert_manager; CREATE ALIAS reimb_insert_manager FOR \"com.dao.H2DAOImplementation.reimb_insert_manager\"");
			 conn.createStatement().execute("DROP ALIAS IF EXISTS checkLoginCredentials; CREATE ALIAS checkLoginCredentials FOR \"com.dao.H2DAOImplementation.checkLoginCredentials\"");
			 conn.createStatement().execute("DROP ALIAS IF EXISTS UPDATE_REIMB_STATUS; CREATE ALIAS UPDATE_REIMB_STATUS FOR \"com.dao.H2DAOImplementation.UPDATE_REIMB_STATUS\"");
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}

	public static class user_insert implements Trigger {

	    @Override
	    public void init(Connection conn, String schemaName, 
	                     String triggerName, String tableName, boolean before, int type)
	    throws SQLException {}

	    @Override
	    public void fire(Connection conn, Object[] oldRow, Object[] newRow)
	    throws SQLException {
	    	// oldRow will be null bc we are doing insert
	    	String sql = "UPDATE ERS_USERS SET ERS_PASSWORD = ? WHERE ERS_USERS_ID = ?";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        	System.out.println(newRow[0] + " " + newRow[1]+ " "+ newRow[2] + " " + newRow[3] + " " + newRow[4]+ " "+ newRow[5] + " " + newRow[6]);
	        	String encr = H2DAOImplementation.get_user_hash((String) newRow[1], (String) newRow[2]);
	        	//System.out.println(encr);
	        	stmt.setString(1, encr);
	        	stmt.setInt(2, ((BigDecimal)newRow[0]).intValue());
	        	stmt.executeUpdate();
	        }
	    }

	    @Override
	    public void close() throws SQLException {}

	    @Override
	    public void remove() throws SQLException {}
	}
	
	@Override
	public void h2InitDaoTriggers() {
		try(Connection conn = DriverManager.getConnection(url,username, password)) {	
			String sql = "CREATE TRIGGER user_insert "
					+ "AFTER INSERT ON ers_users "
					+ "FOR EACH ROW "
					+ "CALL \"com.dao.H2DAOImplementation$user_insert\"";
			Statement state = conn.createStatement();
			state.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void h2InitDaoInserts() {
		try(Connection conn = DriverManager.getConnection(url,username, password)) {	
			String sql = "INSERT INTO ERS_REIMBURSEMENT_STATUS (reimb_status) VALUES ('pending'); "
					+ "INSERT INTO ERS_REIMBURSEMENT_STATUS (reimb_status) VALUES ('approved'); "
					+ "INSERT INTO ERS_REIMBURSEMENT_STATUS (reimb_status) VALUES ('deny'); "
					+ ""
					+ "INSERT INTO ERS_REIMBURSEMENT_TYPE(reimb_type) VALUES ('Lodging'); "
					+ "INSERT INTO ERS_REIMBURSEMENT_TYPE (reimb_type) VALUES ('Travel'); "
					+ "INSERT INTO ERS_REIMBURSEMENT_TYPE (reimb_type) VALUES ('Food'); "
					+ "INSERT INTO ERS_REIMBURSEMENT_TYPE (reimb_type) VALUES ('Other'); "
					+ ""
					+ "INSERT INTO ERS_USER_ROLES (user_role) VALUES ('Employee'); "
					+ "INSERT INTO ERS_USER_ROLES (user_role) VALUES ('Admin'); "
					+ ""
					+ "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES('trevinchester','help','Trevin','Chester','Trevin.Chester@revature.com', 501); "
					+ "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES('coltossoff','12345','Colt','Ossoff','coltossoff@gmail.com', 500); "
					+ "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES('seandoyle','12345','Sean','Doyle','SCDoyle316@gmail.com', 500); "
					+ "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES('phillippride','12345','Phillip','Pride','phillipjpride@gmail.com', 500); "
					+ "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES('kristenkavanagh','12345','Kristen','Kavanagh','Kristen.kavanagh.wright@gmail.com', 500); "
					+ "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES('alexandriawise','12345','Alexandria','Wise','alexandriarwise@gmail.com', 500); "
					+ "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES('michaeljung','12345','Michael','Jung','michael.jungrevature@gmail.com', 500); "
					+ "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES('bronwenhughes','12345','Bronwen','Hughes','bronwen@hughesnet.org', 500); "
					+ "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES('ryanwilliams','12345','Ryan','Williams','rrwilliams1600@gmail.com', 500); "
					+ "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES('vanessafountain','12345','Vanessa','Fountain','vanessa.s.fountain@gmail.com', 500); "
					+ "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES('louispipkin','12345','Louis','Pipkin','ldpipkin@gmail.com', 500);"
					+ "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES('joshuajibilian','12345','Joshua','Jibilian','jwjibilian@gmail.com', 500); "
					+ "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES('johnjosephsavath','12345','John','Savath','Johnsavath@gmail.com', 500); "
					+ "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES('michaelgrammens','12345','Michael','Grammens','MLGrammens@gmail.com', 500); "
					+ "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES('clementdikoko','12345','Clement','Dikoko','clementdikoko94@gmail.com', 500); "
					+ "commit;";
			Statement state = conn.createStatement();
			state.execute(sql);
			conn.prepareCall("{call reimb_insert_manager(21.27, 'For pending', 'seandoyle', 'Lodging')}").execute();
			conn.prepareCall("{call reimb_insert_manager(21.27, 'For approved', 'seandoyle', 'Lodging')}").execute();
			conn.prepareCall("{call reimb_insert_manager(21.27, 'For deny', 'seandoyle', 'Lodging')}").execute();
			conn.prepareCall("{call UPDATE_REIMB_STATUS(101, 'trevinchester', 'approved')}").execute();
			conn.prepareCall("{call UPDATE_REIMB_STATUS(102, 'trevinchester', 'deny')}").execute();
			//sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE reimb_author = 1005";
		/*
			sql = "SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, r.reimb_receipt, u1.ers_username, u2.ers_username, rs.reimb_status, rt.reimb_type FROM ERS_REIMBURSEMENT r  " + 
					"    LEFT OUTER JOIN ERS_USERS u1   ON r.reimb_author = u1.ers_users_id " + 
					"    LEFT OUTER JOIN ERS_USERS u2 ON r.reimb_resolver = u2.ers_users_id " + 
					"    LEFT OUTER JOIN ERS_REIMBURSEMENT_STATUS rs ON r.reimb_status_id = rs.reimb_status_id " + 
					"    LEFT OUTER JOIN ERS_REIMBURSEMENT_TYPE rt ON r.reimb_type_id = rt.reimb_type_id";
			
			sql = "SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, r.reimb_receipt, u.ers_username AS eauthor, u2.ers_users_id AS eresolver, s.reimb_status, t.reimb_type "
					+ "FROM ers_reimbursement r " 
					+ "LEFT JOIN ers_users u ON r.reimb_author = u.ers_users_id "
					+ "LEFT JOIN ers_users u2 ON r.reimb_resolver = u2.ers_users_id "
					+ "LEFT JOIN ers_reimbursement_status s ON r.reimb_status_id = s.reimb_status_id "
					+ "LEFT JOIN ers_reimbursement_type t ON r.reimb_type_id = t.reimb_type_id WHERE r.reimb_id IS NOT NULL AND u.ers_username = 'seandoyle' ORDER BY r.reimb_id";
			
			
			
			sql = "SELECT * FROM ERS_REIMBURSEMENT";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				//System.out.println(rs.getString(1) +" "+ rs.getString(2)+" "+  rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+ rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+ rs.getString(9)+" "+ rs.getString(10));
				System.out.println(rs.getString(1) +" "+ rs.getString(2)+" "+  rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+ rs.getString(6)+" "+rs.getString(7));
			}*/
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void h2DestroyDao() {
		try(Connection conn=
				DriverManager.getConnection(url,username, password)) {
			String sql= "DROP TABLE ers_reimbursement; "
					+ "DROP TABLE ers_users; "
					+ "DROP TABLE ers_user_roles; "
					+ "DROP TABLE ers_reimbursement_type; "
					+ "DROP TABLE ers_reimbursement_status; "
					+ "DROP SEQUENCE users_id_seq; "
					+ "DROP SEQUENCE reimb_id_seq; "
					+ "DROP SEQUENCE role_id_seq; "
					+ "DROP SEQUENCE status_id_seq; "
					+ "DROP SEQUENCE type_id_seq; "
					+ "DROP ALIAS get_user_hash;"
					+ "DROP ALIAS checkLoginCredentials; "
					+ "DROP ALIAS UPDATE_REIMB_STATUS; ";
			
			Statement state = conn.createStatement();
			state.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
}
