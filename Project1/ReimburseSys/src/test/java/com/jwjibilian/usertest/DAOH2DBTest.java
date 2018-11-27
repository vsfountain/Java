package com.jwjibilian.usertest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.jwjibilian.controller.DBDriver;
import com.jwjibilian.daos.ReimbursementDAOImpl;

public class DAOH2DBTest {
	public static DBDriver driver;
	public static ReimbursementDAOImpl dao = new ReimbursementDAOImpl();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new DBDriver();
		dao.h2InitDao();
		dao.addReimbursement(1, 1.22, "Other", "desc");
		

		

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao.h2DestroyDao();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		ReimbursementDAOImpl testThis = new ReimbursementDAOImpl();
		testThis.addReimbursement(1, 1.22, "Other", "wat");
		try (Connection conn = driver.connect()) {
			System.out.println(driver);
			conn.commit();
			PreparedStatement state = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT;");
			
			ResultSet rs = state.executeQuery();
			rs.next();
			System.out.println(rs.getInt("REIMB_ID"));
			System.out.println(rs.getInt("REIMB_AMMOUNT"));
			System.out.println(rs.getDate("REIMB_SUBMITTED"));
			System.out.println(rs.getDate("REIMB_RESOLVED"));
			System.out.println(rs.getString("REIMB_DESCRIPTION"));
			System.out.println(rs.getBlob("REIMB_RECEIPT"));
			System.out.println(rs.getInt("REIMB_AUTHOR"));
			System.out.println(rs.getInt("REIMB_RESOLVER"));
			System.out.println(rs.getInt("REIMB_STATUS_ID"));
			System.out.println(rs.getInt("REIMB_TYPE_ID"));
			assertEquals(0,rs.getInt("REIMB_ID"));
			assertEquals(1, rs.getInt("REIMB_AMMOUNT"));
			assertNull(rs.getDate("REIMB_RESOLVED"));
			assertTrue(rs.getString("REIMB_DESCRIPTION").equals("desc"));
			assertNull(rs.getBlob("REIMB_RECEIPT"));
			assertEquals(1,rs.getInt("REIMB_AUTHOR"));
			assertEquals(0,rs.getInt("REIMB_RESOLVER"));
			assertEquals(1,rs.getInt("REIMB_STATUS_ID"));
			assertEquals(4,rs.getInt("REIMB_TYPE_ID"));
			
			
			//assertEquals(rs.getInt(arg0), actual);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
