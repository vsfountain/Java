package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.classes.Reimbursement;
import com.classes.User;
import com.dao.H2DAO;
import com.dao.H2DAOImplementation;
import com.dao.ReimbDAO;
import com.dao.ReimbDAOImplementation;
import com.dao.UsersDAO;
import com.dao.UsersDAOImplementation;

public class DaoTests {
	private static H2DAO h2dao;
	private static ReimbDAO rdao;
	private static UsersDAO udao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Using H2 database, instead of your actual live environment data, allows you heavily modify
		//	the database to extensively test your DAO functionality without threat of destroying
		//	your live environment.
		//pokeDao = new PokeDaoImpl("jdbc:h2:./Starmie/is/thebest/pokemon/testData", "sa", "sa");
		h2dao = new H2DAOImplementation("jdbc:h2:./ryker/ers/test/db", "ryker", "ryker");
		rdao = new ReimbDAOImplementation("jdbc:h2:./ryker/ers/test/db", "ryker", "ryker");
		udao = new UsersDAOImplementation("jdbc:h2:./ryker/ers/test/db", "ryker", "ryker");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		h2dao.h2InitDaoSeq();
		h2dao.h2InitDao();
		h2dao.h2InitDaoFunProc();
		h2dao.h2InitDaoTriggers();
		h2dao.h2InitDaoInserts(); // This initializes the database with 3 reimbursements (one pending, one approved, one denied all for the same person and for the same amount)
	}

	@After
	public void tearDown() throws Exception {
		h2dao.h2DestroyDao();
	}

	@Test
	public void testGetReimbForUserByUsername() {
		ArrayList<Reimbursement> array = rdao.getReimbursementForUser("seandoyle");
		assertEquals(3, array.size());
		Reimbursement r = array.get(0);
		assertEquals(21.27, r.getReimb_amount(), 0.005);
		assertEquals("seandoyle", r.getReimb_author());
		assertEquals("pending", r.getReimb_status());
		assertEquals("Lodging", r.getReimb_type());
		Reimbursement r2 = array.get(1);
		assertEquals(21.27, r2.getReimb_amount(), 0.005);
		assertEquals("seandoyle", r2.getReimb_author());
		assertEquals("approved", r2.getReimb_status());
		assertEquals("Lodging", r2.getReimb_type());
		Reimbursement r3 = array.get(2);
		assertEquals(21.27, r3.getReimb_amount(), 0.005);
		assertEquals("seandoyle", r3.getReimb_author());
		assertEquals("deny", r3.getReimb_status());
		assertEquals("Lodging", r3.getReimb_type());
		
		// We have no reimbursements for trevinchester at this time
		ArrayList<Reimbursement> array2 = rdao.getReimbursementForUser("trevinchester");
		assertEquals(0, array2.size());
		
		// seandoyle has misspelled his username and dropped the final e; no records should be found
		ArrayList<Reimbursement> array3 = rdao.getReimbursementForUser("seandoyl");
		assertEquals(0, array3.size());
		
		// There is no user jamesbartik at this time
		ArrayList<Reimbursement> array4 = rdao.getReimbursementForUser("jamesbartik");
		assertEquals(0, array4.size());
		
		// There is no user by the username ""+1
		ArrayList<Reimbursement> array5 = rdao.getReimbursementForUser(""+1);
		assertEquals(0, array5.size());
	}
	
	@Test
	public void testGetReimbForAll() {
		ArrayList<Reimbursement> array = rdao.getReimbursements();
		// we should only have 3 
		assertEquals(3, array.size());
		Reimbursement r = array.get(0);
		assertEquals(21.27, r.getReimb_amount(), 0.005);
		assertEquals("seandoyle", r.getReimb_author());
		assertEquals("pending", r.getReimb_status());
		assertEquals("Lodging", r.getReimb_type());
		Reimbursement r2 = array.get(1);
		assertEquals(21.27, r2.getReimb_amount(), 0.005);
		assertEquals("seandoyle", r2.getReimb_author());
		assertEquals("approved", r2.getReimb_status());
		assertEquals("Lodging", r2.getReimb_type());
		Reimbursement r3 = array.get(2);
		assertEquals(21.27, r3.getReimb_amount(), 0.005);
		assertEquals("seandoyle", r3.getReimb_author());
		assertEquals("deny", r3.getReimb_status());
		assertEquals("Lodging", r3.getReimb_type());
	}
	
	@Test
	public void testCheckLoginCreds() {
		User u = udao.checkLoginCreds("seandoyle", "12345");
		//System.out.println(u);
		assertNotNull(u);
		assertEquals("seandoyle", u.getUsername());
		assertEquals("sean", u.getFirstName().toLowerCase());
		assertEquals("doyle", u.getLastName().toLowerCase());
		assertEquals("scdoyle316@gmail.com", u.getEmail().toLowerCase());
		assertEquals("employee", u.getRole().toLowerCase());
		
		
		User u2 = udao.checkLoginCreds("trevinchester", "help");
		//System.out.println(u2);
		assertNotNull(u2);
		assertEquals("trevinchester", u2.getUsername());
		assertEquals("trevin", u2.getFirstName().toLowerCase());
		assertEquals("chester", u2.getLastName().toLowerCase());
		assertEquals("trevin.chester@revature.com", u2.getEmail().toLowerCase());
		assertEquals("admin", u2.getRole().toLowerCase());
		
		// Invalid Login Creds
		User u3 = udao.checkLoginCreds("trevinchester", "12345");
		//System.out.println(u3);
		assertNull(u3);
		
		// Invalid Login Creds dropped the r in the end of the username
		User u4 = udao.checkLoginCreds("trevincheste", "help");
		//System.out.println(u4);
		assertNull(u4);
		
		// Invalid Login Creds dropped the r in the end of the username
		User u5 = udao.checkLoginCreds("sea", "$$");
		//System.out.println(u5);
		assertNull(u5);
	}

	@Test
	public void testUpdateReimb() {
		int test1 = rdao.updateReimbursement(101, "trevinchester", "approved");
		//System.out.println(test1);
		assertEquals(500, test1);// Failure because 101 has already been updated
		
		int test2 = rdao.updateReimbursement(101, "seandoyle", "approved");
		//System.out.println(test2);
		assertEquals(400, test2);// Failure because seandoyle is not an admin
		
		int test3 = rdao.updateReimbursement(100, "trevinchester", "approveadsf");
		//System.out.println(test3);
		assertEquals(-1, test3);// Failure because newStatus Approvedadsf is not a valid status value
		
		int test4 = rdao.updateReimbursement(100, "seandoyle", "approved");
		//System.out.println(test4);
		assertEquals(400, test4);// Failure because seandoyle is not an admin
		
		int test5 = rdao.updateReimbursement(100, "trevinchester", "approved");
		//System.out.println(test5);
		assertEquals(200, test5);// Success
		
		int test6 = rdao.updateReimbursement(100, "trevinchester", "approved");
		//System.out.println(test6);
		assertEquals(500, test6);// Failure because 100 should have been updated for test5
		
		int test7 = rdao.updateReimbursement(98, "trevinchester", "approved");
		//System.out.println(test7);
		assertEquals(0, test7);// Failure because there shouldnt be a reimb_id that is 99
	}

	
	@Test
	public void testAddReimb() {
		int test1 = rdao.addReimbursement(10.00, "test1", "bronwenhughes", "Food");
		assertEquals(1, test1); // This should be a valid add and should return 1 for 1 row added
		
		int test2 = rdao.addReimbursement(10.00, null,  "bronwenhughes", "Food");
		assertEquals(1, test2); // This should be a valid add since we don't need a description
		
		int test3 = rdao.addReimbursement(0, "test1", "bronwenhughes", "Food");
		assertEquals(1, test3); // This should be a valid add
		
		int test4 = rdao.addReimbursement(10.00, "test1", "bronwenhughes", "Lodging");
		assertEquals(1, test4); // This should be a valid add and should return 1 for 1 row added
		
		int test5 = rdao.addReimbursement(10.00, "test1", "bronwenhughes", "Other");
		assertEquals(1, test5); // This should be a valid add and should return 1 for 1 row added
		
		int test6 = rdao.addReimbursement(10.00, "test1", "bronwenhughes", "Travel");
		assertEquals(1, test6); // This should be a valid add and should return 1 for 1 row added
		
		int test7 = rdao.addReimbursement(10.00, "test1", "bronwenhughe", "Travel");
		assertEquals(400, test7); // Fail no user found 
		
		int test8 = rdao.addReimbursement(10.00, "test1", "bronwenhughes", "Travelg");
		assertEquals(450, test8); // Fail no status Travelg found
	}
	
	@Test
	public void testGetAllUsers() {
		ArrayList<User> users = udao.getUsers();
		assertEquals(15, users.size()); //We should have 15 users stored
		assertEquals("trevinchester", users.get(0).getUsername());// the user with the first id is trevin
		assertEquals("Admin", users.get(0).getRole()); //trevin should show up as an admin (shows bad join)
		assertEquals("Employee", users.get(1).getRole()); //all other users should be employees (shows bad join)
	}
}
