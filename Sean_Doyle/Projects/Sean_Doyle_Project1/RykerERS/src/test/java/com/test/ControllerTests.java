package com.test;

import static org.mockito.ArgumentMatchers.anyString;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.classes.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.servicelayer.ERSService;
import com.servicelayer.ERSServiceImplementation;
import com.servlets.helpers.LoginController;
/*@RunWith(PowerMockRunner.class)
@PrepareForTest(DriverManager.class)*/
public class ControllerTests {
	
	HttpServletRequest req;
	HttpServletResponse resp;
	ERSService eserv;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		req = Mockito.mock(HttpServletRequest.class);
		resp = Mockito.mock(HttpServletResponse.class);
		eserv = Mockito.mock(ERSServiceImplementation.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	/*	private static ERSService eserv = new ERSServiceImplementation();
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	// Part of JSON
	public static String login(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		String JSONjohnny = "{}";
		if (!(req.getMethod().equals("POST"))) {
			logger.info("@login		FAIL: using method GET to access");
		} else {
			String username = (String) req.getParameter("username");
			String password = (String) req.getParameter("password");
			User loggy = eserv.checkLoginCreds(username, password);
			if (loggy == null) {
				logger.info("@login		FAIL: login returned user is null");
			} else {
				JSONjohnny =  new ObjectMapper().writeValueAsString(loggy);
				logger.info("@login		Successful: login returned user is "+ loggy.toString());
				req.getSession().setAttribute("nowUser", loggy);
				req.getSession().setAttribute("JSONjohnny", JSONjohnny);
				req.getSession().setAttribute("username", username);
				req.getSession().setAttribute("password", password);// This may not be a good idea
			}
		}
		return JSONjohnny;
	}
	
	// Part of Action
	public static String logout(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().invalidate();
		logger.info("@logout		Successful: Session invalidated");
		return "Logout Successful";
	} */
	
	@Test
	public void testLogin() throws JsonProcessingException, IOException {
		Mockito.when(req.getParameter("username")).thenReturn("seandoyle").thenReturn("12345");
		User user = new User("seandoyle", "sean", "doyle", "scdoyle316@gmail.com", "Employee");
		Mockito.when(eserv.checkLoginCreds(anyString(), anyString())).thenReturn(user);
		
		//LoginController.login(req, resp);

	}

}
