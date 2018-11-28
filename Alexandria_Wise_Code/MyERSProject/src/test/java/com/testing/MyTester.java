package com.testing;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ers.controller.LoginController;
import com.ers.model.User;
import com.ers.model.UserDAO;
import com.ers.model.UserDAOImpl;
import com.ers.model.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

//testing the login method in login controller
class MyTester {

	LoginController myLog = Mockito.mock(LoginController.class);
	
	UserService myServ = Mockito.mock(UserService.class);
	User myUser = new User(2000,
							"awise",
							"ihateshoes",
							"Alexandria",
							"Wise",
							"arw0404@gmail.com",
							0);
	UserDAO mydao = Mockito.mock(UserDAOImpl.class);
	
	HttpServletRequest myReq = Mockito.mock(HttpServletRequest.class);
	HttpServletResponse myRes = Mockito.mock(HttpServletResponse.class);
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws JsonProcessingException, IOException {
		String username = "awise";
		String password = "ihateshoes";
		
		//Mockito.w

	
		Mockito.when(myServ.checkLogin("awise", "ihateshoes")).thenReturn(myUser);
		//Mockito.when(myUser.getRoleId()).thenReturn(0);
		//Mockito.when(mydao.checkLogin(username, password))
		
		//assertEquals("manager.html", myLog.login(myReq, myRes));
		
		//Mockito.verify(myServ).checkLogin("awise", "ihateshoes");
	}

}
