package com.kers.daos;

import java.io.ByteArrayInputStream;
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

	public ReimbursementDAOImpl() {
	}

	public ReimbursementDAOImpl(String url, String username, String password) {
		ReimbursementDAOImpl.url = url;
		ReimbursementDAOImpl.username = username;
		ReimbursementDAOImpl.password = password;
	}

	@Override
	public int insertReimbursement(Reimbursement r) {
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			String sql = "{ call insert_ers_reimb_id_null(?,?,?,?,?,?) }";
			CallableStatement cs = con.prepareCall(sql);
			cs.setDouble(1, r.getAmountDouble());
			cs.setTimestamp(2, Timestamp.valueOf(java.time.LocalDateTime.now()));
			cs.setString(3, r.getDescription());
			cs.setBlob(4, new ByteArrayInputStream(r.getReceiptByteArray()));
			cs.setString(5, r.getAuthor());
			cs.setString(6, r.getType());

			return cs.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
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
					Blob blob = rs.getBlob(6);
					System.out.println("BLOB AFTER: " + blob);
					int blobLength = (int) blob.length();
					byte[] blobAsBytes = blob.getBytes(1, blobLength);
					blob.free();
					System.out.println("Blob As Bytes: " + blobAsBytes);
					r = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getString(5),
							blobAsBytes, rs.getString(7), rs.getString(9), rs.getString(10));

				} else {
					Blob blob = rs.getBlob(6);
					int blobLength = (int) blob.length();
					byte[] blobAsBytes = blob.getBytes(1, blobLength);
					blob.free();

					r = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4),
							rs.getString(5), blobAsBytes, rs.getString(7), rs.getString(8), rs.getString(9),
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
		Reimbursement reimbursement = null;

		try (Connection con = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getTimestamp(3) == null) {
					Blob blob = rs.getBlob(6);
					int blobLength = (int) blob.length();
					byte[] blobAsBytes = blob.getBytes(1, blobLength);
					blob.free();
					reimbursement = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3),
							rs.getString(5), blobAsBytes, rs.getString(7), rs.getString(9), rs.getString(10));

				} else {
					Blob blob = rs.getBlob(6);
					int blobLength = (int) blob.length();
					byte[] blobAsBytes = blob.getBytes(1, blobLength);
					blob.free();
					reimbursement = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3),
							rs.getTimestamp(4), rs.getString(5), blobAsBytes, rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10));
				}
				return reimbursement;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

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
			ps.setInt(1, id);
			ps.setString(2, decision);
			ps.setString(3, resolver);

			return ps.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public void h2InitDao() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("-----------CREATING DB!----------");
			String sql = h2InitSeqs() + h2InitTables();
			Statement state = conn.createStatement();
			state.execute(sql);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void h2DestroyDao() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("------------DESTROYING DB!---------------");
			String sql= "DROP TABLE ERS_REIMBURSEMENT;\r\n" + 
					"DROP TABLE ERS_USERS;\r\n" + 
					"DROP TABLE ERS_USER_ROLES;\r\n" + 
					"DROP TABLE ERS_REIMBURSEMENT_TYPE;\r\n" + 
					"DROP TABLE ERS_REIMBURSEMENT_STATUS;" +
					"DROP SEQUENCE ERS_REIMB_STATUS_ID_SEQ;\r\n" + 
					"DROP SEQUENCE ERS_REIMB_ID_SEQ;\r\n" + 
					"DROP SEQUENCE ERS_REIMB_TYPE_ID_SEQ;  \r\n" + 
					"DROP SEQUENCE ERS_USER_ROLE_ID_SEQ;\r\n" + 
					"DROP SEQUENCE ERS_USERS_ID_SEQ;";
			Statement state = conn.createStatement();	
			state.execute(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public String h2InitTables() {
		// TODO Auto-generated method stub
		return "CREATE TABLE ERS_USER_ROLES(\r\n" + 
				"    ERS_USER_ROLE_ID NUMBER DEFAULT ERS_USER_ROLE_ID_SEQ.nextval PRIMARY KEY,\r\n" + 
				"    USER_ROLE VARCHAR2(10) NOT NULL\r\n" + 
				");\r\n" + 
				"\r\n" + 
				"CREATE TABLE ERS_REIMBURSEMENT_TYPE(\r\n" + 
				"    REIMB_TYPE_ID NUMBER DEFAULT ERS_REIMB_TYPE_ID_SEQ.nextval PRIMARY KEY,\r\n" + 
				"    REIMB_TYPE VARCHAR2(10) NOT NULL\r\n" + 
				");\r\n" + 
				"\r\n" + 
				"CREATE TABLE ERS_REIMBURSEMENT_STATUS(\r\n" + 
				"    REIMB_STATUS_ID NUMBER DEFAULT ERS_REIMB_STATUS_ID_SEQ.nextval PRIMARY KEY,\r\n" + 
				"    REIMB_STATUS VARCHAR2(10) NOT NULL\r\n" + 
				");\r\n" + 
				"\r\n" + 
				"CREATE TABLE ERS_USERS(\r\n" + 
				"    ERS_USERS_ID NUMBER DEFAULT ERS_USERS_ID_SEQ.nextval PRIMARY KEY,\r\n" + 
				"    ERS_USERNAME VARCHAR2(50) UNIQUE,\r\n" + 
				"    ERS_PASSWORD VARCHAR2(50) NOT NULL,\r\n" + 
				"    USER_FIRST_NAME VARCHAR2(100) NOT NULL,\r\n" + 
				"    USER_LAST_NAME VARCHAR2(100) NOT NULL,\r\n" + 
				"    USER_EMAIL VARCHAR2(150) UNIQUE NOT NULL,\r\n" + 
				"    USER_ROLE_ID NUMBER NOT NULL,\r\n" + 
				"    FOREIGN KEY (USER_ROLE_ID) REFERENCES ERS_USER_ROLES(ERS_USER_ROLE_ID)\r\n" + 
				");\r\n" + 
				"\r\n" + 
				"CREATE TABLE ERS_REIMBURSEMENT(\r\n" + 
				"    REIMB_ID NUMBER DEFAULT ERS_REIMB_ID_SEQ.nextval PRIMARY KEY,\r\n" + 
				"    REIMB_AMOUNT NUMBER NOT NULL,\r\n" + 
				"    REIMB_SUBMITTED TIMESTAMP NOT NULL,\r\n" + 
				"    REIMB_RESOLVED TIMESTAMP,\r\n" + 
				"    REIMB_DESCRIPTION VARCHAR2(250),\r\n" + 
				"    REIMB_RECEIPT BLOB,\r\n" + 
				"    REIMB_AUTHOR NUMBER NOT NULL,\r\n" + 
				"    REIMB_RESOLVER NUMBER,\r\n" + 
				"    REIMB_STATUS_ID NUMBER DEFAULT 101 NOT NULL,\r\n" + 
				"    REIMB_TYPE_ID NUMBER NOT NULL,\r\n" + 
				"     FOREIGN KEY (REIMB_AUTHOR) REFERENCES ERS_USERS(ERS_USERS_ID),\r\n" + 
				"     FOREIGN KEY (REIMB_RESOLVER) REFERENCES ERS_USERS(ERS_USERS_ID),\r\n" + 
				"     FOREIGN KEY (REIMB_STATUS_ID) REFERENCES ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID),\r\n" + 
				"     FOREIGN KEY (REIMB_TYPE_ID) REFERENCES ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID)\r\n" + 
				");";
	}

	@Override
	public String h2InitSeqs() {
		return "CREATE SEQUENCE ERS_REIMB_STATUS_ID_SEQ\r\n" + 
				"START WITH 101\r\n" + 
				"INCREMENT BY 1;    \r\n" + 
				"    \r\n" + 
				"CREATE SEQUENCE ERS_REIMB_TYPE_ID_SEQ\r\n" + 
				"START WITH 201\r\n" + 
				"INCREMENT BY 1;\r\n" + 
				"\r\n" + 
				"CREATE SEQUENCE ERS_USER_ROLE_ID_SEQ\r\n" + 
				"START WITH 301\r\n" + 
				"INCREMENT BY 1;\r\n" + 
				"    \r\n" + 
				"CREATE SEQUENCE ERS_USERS_ID_SEQ\r\n" + 
				"START WITH 1001\r\n" + 
				"INCREMENT BY 1;\r\n" + 
				"\r\n" + 
				"CREATE SEQUENCE ERS_REIMB_ID_SEQ\r\n" + 
				"START WITH 2001\r\n" + 
				"INCREMENT BY 1;";
	}

	@Override
	public String h2InitTriggers() {
		return "CREATE OR REPLACE TRIGGER ERS_REIMB_ID_NULL_TRIG\r\n" + 
				"BEFORE INSERT ON ERS_REIMBURSEMENT\r\n" + 
				"FOR EACH ROW\r\n" + 
				"BEGIN\r\n" + 
				"        IF :new.REIMB_ID IS NULL THEN\r\n" + 
				"                SELECT ERS_REIMB_ID_SEQ.nextval INTO :new.REIMB_ID FROM dual;\r\n" + 
				"        END IF;\r\n" + 
				"        IF :new.REIMB_STATUS_ID IS NULL THEN\r\n" + 
				"             SELECT 101 INTO :new.REIMB_STATUS_ID FROM dual;\r\n" + 
				"        END IF;\r\n" + 
				"END;\r\n" + 
				"/\r\n" + 
				"\r\n" + 
				"CREATE OR REPLACE TRIGGER ERS_USERS_ID_NULL_TRIG\r\n" + 
				"BEFORE INSERT ON ERS_USERS\r\n" + 
				"FOR EACH ROW\r\n" + 
				"BEGIN\r\n" + 
				"        IF :new.ERS_USERS_ID IS NULL THEN\r\n" + 
				"                SELECT ERS_USERS_ID_SEQ.nextval INTO :new.ERS_USERS_ID FROM dual;\r\n" + 
				"        END IF;\r\n" + 
				"        \r\n" + 
				"         SELECT GET_CUSTOMER_HASH(:NEW.ERS_USERNAME,:NEW.ERS_PASSWORD) INTO :NEW.ERS_PASSWORD FROM DUAL;\r\n" + 
				"END;\r\n" + 
				"/\r\n" + 
				"CREATE OR REPLACE TRIGGER ERS_REIMB_STATUS_ID_NULL_TRIG\r\n" + 
				"BEFORE INSERT ON ERS_REIMBURSEMENT_STATUS\r\n" + 
				"FOR EACH ROW\r\n" + 
				"BEGIN\r\n" + 
				"        IF :new.REIMB_STATUS_ID IS NULL THEN\r\n" + 
				"                SELECT ERS_REIMB_STATUS_ID_SEQ.nextval INTO :new.REIMB_STATUS_ID FROM dual;\r\n" + 
				"        END IF;\r\n" + 
				"END;\r\n" + 
				"/\r\n" + 
				"\r\n" + 
				"CREATE OR REPLACE TRIGGER ERS_REIMB_TYPE_ID_NULL_TRIG\r\n" + 
				"BEFORE INSERT ON ERS_REIMBURSEMENT_TYPE\r\n" + 
				"FOR EACH ROW\r\n" + 
				"BEGIN\r\n" + 
				"        IF :new.REIMB_TYPE_ID IS NULL THEN\r\n" + 
				"                SELECT ERS_REIMB_TYPE_ID_SEQ.nextval INTO :new.REIMB_TYPE_ID FROM dual;\r\n" + 
				"        END IF;\r\n" + 
				"END;\r\n" + 
				"/\r\n" + 
				"\r\n" + 
				"CREATE OR REPLACE TRIGGER ERS_USER_ROLE_ID_NULL_TRIG\r\n" + 
				"BEFORE INSERT ON ERS_USER_ROLES\r\n" + 
				"FOR EACH ROW\r\n" + 
				"BEGIN\r\n" + 
				"        IF :new.ERS_USER_ROLE_ID IS NULL THEN\r\n" + 
				"                SELECT ERS_USER_ROLE_ID_SEQ.nextval INTO :new.ERS_USER_ROLE_ID FROM dual;\r\n" + 
				"        END IF;\r\n" + 
				"END;\r\n" + 
				"/";
	}

	@Override
	public String h2InitProcedures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String h2InitFunctions() {
		return "CREATE ALIAS GET_CUSTOMER_HASH FOR \"com.test.Functions.getCustomerHash\"; " +
				"CREATE ALIAS CHECK_CRENDENTIALS FOR \"com.test.Functions.checkCredentials\";" +
				"CREATE ALIAS QUERY FOR \"com.test.Functions.query\";" +
				"CREATE ALIAS UPDATE_REIMB_STATUS FOR \"com.test.Functions.updateReimbStatus\";";
	}
	
}