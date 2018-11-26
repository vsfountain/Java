package com.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kers.daos.ReimbursementDAO;
import com.kers.daos.ReimbursementDAOImpl;
import com.kers.daos.UserDAO;
import com.kers.daos.UserDAOImpl;
import com.kers.models.Reimbursement;
import com.kers.models.User;

public class ReimbursementDaoTest {
private static ReimbursementDAO rdao;
private static UserDAO udao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		rdao = new ReimbursementDAOImpl("jdbc:h2:./Reimbursement/data;MODE=Oracle", "ersdb", "password");
		udao = new UserDAOImpl("jdbc:h2:./Reimbursement/data;MODE=Oracle", "ersdb", "password");
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
	public void checkValues() {
		/*System.out.println(udao.selectUserByUsername("bronwenhughes"));*/
		Reimbursement r = new Reimbursement(32.23, "Test description", "bronwenhughes", "Food");
		rdao.insertReimbursementSansBlob(r);
		List<Reimbursement> rList = rdao.selectAllReimbursementsSansBlob();
		Reimbursement r2 = rList.get(0);
		assertEquals(r.getAmount(), r2.getAmount());
		assertEquals(r.getAuthor(), r2.getAuthor());
		assertEquals(r.getDescription(), r2.getDescription());
		assertEquals(r.getType(), r2.getType());
	}
	
	@Test
	public void checkApprovingReimbursements() {
		Reimbursement r = new Reimbursement(32.23, "Test description", "bronwenhughes", "Food");
		rdao.insertReimbursementSansBlob(r);
		List<Reimbursement> rList = rdao.selectAllReimbursementsSansBlob();
		Reimbursement r2 = rList.get(0);
		rdao.updateReimbursementById(r2.getId(), "Approved", "trevinchester");
		rList = rdao.selectAllReimbursementsSansBlob();
		Reimbursement r3 = rList.get(0);
		assertEquals("Approved", r3.getStatus());
	}
	
	@Test
	public void checkDenyingReimbursements() {
		Reimbursement r = new Reimbursement(32.23, "Test description", "bronwenhughes", "Food");
		rdao.insertReimbursementSansBlob(r);
		List<Reimbursement> rList = rdao.selectAllReimbursementsSansBlob();
		Reimbursement r2 = rList.get(0);
		rdao.updateReimbursementById(r2.getId(), "Denied", "trevinchester");
		rList = rdao.selectAllReimbursementsSansBlob();
		Reimbursement r3 = rList.get(0);
		assertEquals("Denied", r3.getStatus());
	}
	
	@Test
	public void checkUsersByUsername() {
		User u = udao.selectUserByUsername("seandoyle");
		assertEquals("Employee", u.getRole());
	}
	
	@Test
	public void checkCredentials() {
		System.out.println(udao.selectAllUsers());
		User u = udao.selectUserByUsernameAndPassword("trevinchester", "help");
		System.out.println(u);
		assertEquals("Trevin", u.getFirstName());
	}

}
