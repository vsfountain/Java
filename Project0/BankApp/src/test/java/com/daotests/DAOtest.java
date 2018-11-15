package com.daotests;

import static org.junit.Assert.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import org.mockito.InjectMocks;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import controller.dao.UserDaoImpl;
import controller.dataio.DriverManagerFacade;
import model.users.User;



public class DAOtest {
	

	Connection conn = Mockito.mock(Connection.class);
	 CallableStatement stmt = Mockito.mock(CallableStatement.class);
	 PreparedStatement ps = Mockito.mock( PreparedStatement.class);
	DriverManagerFacade driver = Mockito.mock(DriverManagerFacade.class);
	
	User use;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//MockitoAnnotations.initMocks(this);
		use = new User("d", "d", "dc@", null, 0);

		

	}


	@Test
	public void testLoginUser() throws SQLException {
		ResultSet mrs= Mockito.mock(ResultSet.class);
		
		when(conn.prepareCall(any(String.class))).thenReturn(stmt);
		when(driver.getConn(any(String.class),any(String.class),any(String.class))).thenReturn(conn);
		
		when(mrs.next()).thenReturn(true).thenReturn(false);
		when(mrs.getString("firstname")).thenReturn("d");
		when(mrs.getString("lastname")).thenReturn("d");
		when(mrs.getString("email")).thenReturn("d@");
		when(mrs.getInt("userid")).thenReturn(0);
		when(stmt.executeQuery()).thenReturn(mrs);
		
		
		when(mrs.getString("usertypename")).thenReturn("User");
		
		
		
		UserDaoImpl dao = new UserDaoImpl();
		User testThis = dao.userLogin("dc@", "d");
		
		assertEquals(use, testThis);
		Mockito.verify(conn.createStatement(), Mockito.times(1));
		Mockito.verify(mrs.getString("firstname"), Mockito.times(1));
		Mockito.verify(mrs.getString("lastname"), Mockito.times(1));
		Mockito.verify(mrs.getString("email"), Mockito.times(1));
		Mockito.verify(mrs.getString("userid"), Mockito.times(1));


	}
	@Before
	public void setUp2() throws Exception {
		//MockitoAnnotations.initMocks(this);
		use = new User("d", "d", "d@", null, 0);

		

	}


	@Test
	public void testRegisterUser() throws SQLException {

		when(driver.getConn(any(String.class),any(String.class),any(String.class))).thenReturn(conn);
		when(conn.prepareStatement(any(String.class))).thenReturn(ps);
		
		when(ps.executeUpdate()).thenReturn(1);

		
		
		UserDaoImpl dao = new UserDaoImpl();
		boolean testThis = dao.registerUser("", "", "", "");
		//System.out.println(testThis);
		assertTrue(testThis);
		
		Mockito.verify(conn.createStatement(), Mockito.times(1));
		

	}


}
