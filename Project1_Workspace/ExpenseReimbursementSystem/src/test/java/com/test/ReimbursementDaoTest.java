package com.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kers.daos.ReimbursementDAO;
import com.kers.daos.ReimbursementDAOImpl;

public class ReimbursementDaoTest {
private static ReimbursementDAO rdao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		rdao = new ReimbursementDAOImpl("jdbc:h2:./Reimbursement/data;MODE=Oracle", "ersdb", "password");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		rdao.h2InitDao();
	}

	@After
	public void tearDown() throws Exception {
		rdao.h2DestroyDao();
	}
	
	@Test
	public void selectByNametest() {
		/*Reimbursement r = new Reimbursement(32.23, "Test description", null, "trevinchester", "lodging");
		rdao.insertReimbursement(r);*/
	}

}
