package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.classes.Reimbursement;
import com.classes.User;
import com.dao.ReimbDAO;
import com.dao.ReimbDAOImplementation;
import com.dao.UsersDAO;
import com.dao.UsersDAOImplementation;
import com.servicelayer.ERSService;
import com.servicelayer.ERSServiceImplementation;

public class ServiceTests {

	//private static H2DAO h2dao;
	private static ReimbDAO rdao;
	private static UsersDAO udao;

	private static ERSService eserv;
	private static ERSService eservMock;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		rdao =  Mockito.mock(ReimbDAOImplementation.class);
		udao =  Mockito.mock(UsersDAOImplementation.class);
		eservMock = Mockito.mock(ERSServiceImplementation.class);
		eserv = new ERSServiceImplementation(udao, rdao, eservMock);
	}

	@After
	public void tearDown() throws Exception {
		rdao = null;
		udao = null;
	}

	
	@Test
	public void testGetUsers() {
		ArrayList<User> users = new ArrayList<>();
		users.add(new User("seandoyle", "sean", "doyle", "scdoyle316@gmail.com", "Employee"));
		users.add(new User("bronwenhughes", "kat", "hughes", "bronwen@hughesnet.org", "Employee"));
		users.add(new User("trevinchester", "trevin", "chester", "trevin.chester@revature.com", "Admin"));
		Mockito.when(udao.getUsers()).thenReturn(users);
		
		ArrayList<User> usersNew =eserv.getAllUsers();
		assertEquals(3, usersNew.size());
		
		Mockito.verify(udao, times(1)).getUsers();
	}
	
	@Test
	public void testGetAllReimbs() {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		reimbs.add(new Reimbursement(1, 12.98, null, null, "test1", "billybob", 0, "Pending", "Food"));
		reimbs.add(new Reimbursement(2, 12.98, null, null, "test1", "billybob", 0, "Pending", "Food"));
		reimbs.add(new Reimbursement(3, 12.98, null, null, "test1", "billybob", 0, "Pending", "Food"));
		reimbs.add(new Reimbursement(4, 12.98, null, null, "test1", "billybob", 0, "Pending", "Food"));
		Mockito.when(rdao.getReimbursements()).thenReturn(reimbs);
		Mockito.when(udao.getUsers()).thenReturn(null);

		ArrayList<Reimbursement> reimbsNew = eserv.getAllReimbs();
		assertEquals(4, reimbsNew.size()); // The database should have 3 and all for seandoyle, there is no billybob username in DB
		assertEquals("billybob", reimbsNew.get(0).getReimb_author());
		
		verify(rdao, times(1)).getReimbursements();
		verify(udao, times(0)).getUsers();
	}
	
	@Test
	public void testCheckAdmin() {
		User loggyA = Mockito.mock(User.class);
		User loggyE = Mockito.mock(User.class);
		User loggyO = Mockito.mock(User.class);
		
		Mockito.when(loggyA.getRole()).thenReturn("Admin");
		Mockito.when(loggyE.getRole()).thenReturn("Employee");
		Mockito.when(loggyO.getRole()).thenReturn("0th3r").thenReturn(""+1);
		
		boolean test1 = eserv.checkAdmin(loggyA);
		assertTrue(test1);
		boolean test2 = eserv.checkAdmin(loggyE);
		assertFalse(test2);
		boolean test3 = eserv.checkAdmin(loggyO);
		assertFalse(test3);
		boolean test4 = eserv.checkAdmin(loggyO);
		assertFalse(test4);
		boolean test5 = eserv.checkAdmin(loggyO);
		assertFalse(test5);
		
		verify(loggyA, times(1)).getRole();
		verify(loggyE, times(1)).getRole();
		verify(loggyO, times(3)).getRole();
	}
	
	@Test
	public void testCheckLoginCreds() {
		User mock1 = new User("seandoyle", "sean", "doyle", "scdoyle316@gmail.com", "Employee");
		User mock2 = new User("bronwenhughes", "kat", "hughes", "bronwen@hughesnet.org", "Employee");
		User mock3 = new User("trevinchester", "trevin", "chester", "trevin.chester@revature.com", "Admin");
		User mock4 = null;
		User mock5 = new User("jamesbartik", "jj", "bartik", "jjb@comcast.net", "Non-User");
		Mockito.when(udao.checkLoginCreds((String)notNull(), (String)notNull())).thenReturn(mock1, mock2, mock3, mock4, mock5);

		User test1 = udao.checkLoginCreds("seandoyle", "12345");
		assertEquals("sean", test1.getFirstName());
		
		User test2 = udao.checkLoginCreds("bronwenhughes", "12345");
		assertEquals("kat", test2.getFirstName());
		
		User test3 = udao.checkLoginCreds("trevinchester", "help");
		assertEquals("trevin", test3.getFirstName());
		
		User test4 = udao.checkLoginCreds("billybob", "12345");
		assertNull(test4);
		
		User test5 = udao.checkLoginCreds("jamesbartik", "cafebabe");
		assertEquals("jj", test5.getFirstName());// This shows that we are mocking rather than just calling DB
		
		verify(udao, times(5)).checkLoginCreds((String)notNull(), (String)notNull());
	}
	
	
	@Test
	public void testGetAllUserReimbsString() {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		reimbs.add(new Reimbursement(1, 12.98, null, null, "test1", "billybob", 0, "Pending", "Food"));
		reimbs.add(new Reimbursement(2, 12.98, null, null, "test1", "billybob", 0, "Pending", "Food"));
		reimbs.add(new Reimbursement(3, 12.98, null, null, "test1", "billybob", 0, "Pending", "Food"));
		reimbs.add(new Reimbursement(4, 12.98, null, null, "test1", "billybob", 0, "Pending", "Food"));
		// (String)notNull() allows us to use the method for a general non null string
		Mockito.when(rdao.getReimbursementForUser(anyString())).thenReturn(reimbs).thenReturn(new ArrayList<>());

		ArrayList<Reimbursement> reimbsNew = eserv.getAllUserReimbs("billybob");
		assertEquals(4, reimbsNew.size());
		assertEquals("billybob", reimbsNew.get(0).getReimb_author());
		
		
		ArrayList<Reimbursement> reimbsNew2 = eserv.getAllUserReimbs("ashbdj");
		assertEquals(0, reimbsNew2.size());
		
		
		verify(rdao, times(2)).getReimbursementForUser(anyString());
	}
	
	@Test
	public void testGetAllUserReimbsInt() {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		reimbs.add(new Reimbursement(1, 12.98, null, null, "test1", "billybob", 0, "Pending", "Food"));
		reimbs.add(new Reimbursement(2, 12.98, null, null, "test1", "billybob", 0, "Pending", "Food"));
		reimbs.add(new Reimbursement(3, 12.98, null, null, "test1", "billybob", 0, "Pending", "Food"));
		reimbs.add(new Reimbursement(4, 12.98, null, null, "test1", "billybob", 0, "Pending", "Food"));

		Mockito.when(rdao.getReimbursementForUser(anyInt())).thenReturn(reimbs).thenReturn(new ArrayList<>());

		ArrayList<Reimbursement> reimbsNew = eserv.getAllUserReimbs(1);
		assertEquals(4, reimbsNew.size());
		assertEquals("billybob", reimbsNew.get(0).getReimb_author());
		
		ArrayList<Reimbursement> reimbsNew2 = eserv.getAllUserReimbs(3);
		assertEquals(0, reimbsNew2.size());
		
		verify(rdao, times(2)).getReimbursementForUser(anyInt());
	}
	
	@Test
	public void testAddReimbursement() {
		Mockito.when(rdao.addReimbursement(anyDouble(), anyString(), anyString(), anyString())).thenReturn(1, 400, 450, 500, 1, 0, -1);
		
		boolean test1 = eserv.addReimbursement(10.00, "test1", "bronwenhughes", "Food");
		assertTrue(test1);
		boolean test2 = eserv.addReimbursement(10.00, "test1", "billybob", "Food");//NO user billybob
		assertFalse(test2);
		boolean test3 = eserv.addReimbursement(10.00, "test1", "bronwenhughes", "Ukraine");
		assertFalse(test3);
		boolean test4 = eserv.addReimbursement(10.00, "test1", "bronwenhughes", "Food");
		assertFalse(test4);// no test this will only happen if the DB is not set-up correctly
		
		boolean test5 = eserv.addReimbursement(10.00, "test1...aijdf (such that it is over 250 char)", "bronwenhughes", "Food");
		assertTrue(test5);// This should work fine but truncate the description
		
		boolean test6 = eserv.addReimbursement(10.00, "test1", "bronwenhughes; DROP TBALE ERS_USERS; DO", "Food");
		//bad attempt at sql injection (wont work bc of prepared statement) but can sim
		assertFalse(test6);
		
		boolean test7 = eserv.addReimbursement(10.00, "test1", "bronwenhughes", "Food");
		assertFalse(test7);//simulates a bad connection
		
		verify(rdao, times(7)).addReimbursement(anyDouble(), anyString(), anyString(), anyString());
	}
	
	
	@Test
	public void testUpdateReimbursement() {
		User admin = new User("trevinchester", "trevin", "chester", "trevin.chester@revature.com", "Admin");
		User employee = new User("seandoyle", "sean", "doyle", "scdoyle316@gmail.com", "Employee");
		User other = new User("jamesbartik", "jj", "bartik", "jjb@comcast.net", "Non-User");
		User adminBad = new User("trevincheeter", "trevin", "chester", "trevin.chester@revature.com", "Admin");
		
		Mockito.when(rdao.updateReimbursement(anyInt(), anyString(), anyString())).thenReturn(200, -1, 400, 500, 0, 200);
		Mockito.when(eservMock.checkAdmin(admin)).thenReturn(true);
		Mockito.when(eservMock.checkAdmin(employee)).thenReturn(false);
		Mockito.when(eservMock.checkAdmin(other)).thenReturn(false);
		Mockito.when(eservMock.checkAdmin(adminBad)).thenReturn(true);
		//find out how to spy
		
		boolean test1 = eserv.updateReimbursement(admin, 100, "approve");//admin is an admin
		assertTrue(test1);
		boolean test2 = eserv.updateReimbursement(employee, 100, "approve");//employee is not an admin
		assertFalse(test2);
		boolean test3 = eserv.updateReimbursement(other, 100, "approve");//other is not an admin
		assertFalse(test3);
		
		boolean test4 = eserv.updateReimbursement(admin, 23532564, "approve");// no valid reimb_id
		assertFalse(test4);
		
		boolean test5 = eserv.updateReimbursement(adminBad, 100, "approve");//adminBad is an admin but the username is bad
		assertFalse(test5);
		
		boolean test6 = eserv.updateReimbursement(admin, 102, "approve");//reimb 102 has already been approved therefore we cannot update its status
		assertFalse(test6);
		
		boolean test7 = eserv.updateReimbursement(admin, 102, "approve");
		assertFalse(test7);//simulates a bad sql insert probably due to a bad driver
		
		boolean test8 = eserv.updateReimbursement(admin, 102, "SpringBreak"); //SpringBreak is an invalid status 
		assertFalse(test8);
		
		boolean test9 = eserv.updateReimbursement(admin, 100, "deny");//admin is an admin and deny is valid
		assertTrue(test9);
		
		verify(rdao, times(6)).updateReimbursement(anyInt(), anyString(), anyString());// 9 tests but only 6 get past the checkAdmin
		verify(eservMock, times(9)).checkAdmin((User)any());//9 tests all hit it
	}
	
	
}