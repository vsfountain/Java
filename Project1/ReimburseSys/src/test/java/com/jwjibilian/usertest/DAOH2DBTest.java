package com.jwjibilian.usertest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.jwjibilian.controller.DBDriver;
import com.jwjibilian.daos.ReimbursementDAOImpl;
import com.jwjibilian.services.ReimbursementServiceImpl;

class DAOH2DBTest {
	static DBDriver driver;
	static ReimbursementDAOImpl dao = new ReimbursementDAOImpl();

	@BeforeClass
	static void setUpBeforeClass() throws Exception {

		// final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
		final String DB_URL = "jdbc:h2:./h2thing;MODE=ORACLE";

		// Database credentials
		final String USER = "sa";
		final String PASS = "";

		//Statement stmt = null;
		DBDriver.setItems(DB_URL, USER, PASS);
		driver = new DBDriver();
		dao.h2InitDao();
		dao.addReimbursement(1, 1.22, "Other", "desc");
		

		

	}

	@AfterClass
	static void tearDownAfterClass() throws Exception {
		dao.h2DestroyDao();
	}

	@Before
	void setUp() throws Exception {
	}

	@After
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		ReimbursementDAOImpl testThis = new ReimbursementDAOImpl();
		testThis.addReimbursement(1, 1.22, "Other", "wat");
		try (Connection conn = driver.connect()) {
			PreparedStatement state = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT");
			ResultSet rs = state.executeQuery();
			//System.out.println(rs.getInt("REIMB_ID"));
			System.out.println(rs.getInt("REIMB_AMMOUNT"));
			System.out.println(rs.getDate("REIMB_SUBMITTED"));
			System.out.println(rs.getDate("REIMB_RESOLVED"));
			System.out.println(rs.getString("REIMB_DESCRIPTION"));
			System.out.println(rs.getBlob("REIMB_RECEIPT"));
			System.out.println(rs.getInt("REIMB_AUTHOR"));
			System.out.println(rs.getInt("REIMB_RESOLVER"));
			System.out.println(rs.getInt("REIMB_STATUS_ID"));
			System.out.println(rs.getInt("REIMB_TYPE_ID"));
			//assertEquals(rs.getInt(arg0), actual);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
