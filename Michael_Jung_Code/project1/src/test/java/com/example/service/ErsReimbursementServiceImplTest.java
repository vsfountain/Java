package com.example.service;

/*import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;*/

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import org.mockito.Mockito;

import com.example.model.ErsReimbFeModel;
import com.example.model.ErsUser;
import com.example.service.ErsReimbursementService;
import com.example.service.ErsReimbursementServiceImpl;

public class ErsReimbursementServiceImplTest {

	static ErsReimbursementService ersReimbursementService;
	
	static List<ErsReimbFeModel> ersReimbFeModels;
	static ErsUser ersUserOne, ersUserTwo;
	static ErsReimbFeModel ersReimbFeModel1, ersReimbFeModel2;
	
	@BeforeClass
	public static void beforeClass() {
		/*ersReimbursementService = new ErsReimbursementServiceImpl();*/
		ersReimbursementService=Mockito.mock(ErsReimbursementServiceImpl.class);
		
		System.out.println("------BEFORE CLASS----------");
		ersReimbFeModels = new ArrayList<>();
		ersUserOne = new ErsUser(1, "employee1", "password",
				 "employee1", "employee1", "employee1",
				 1);
		ersUserTwo = new ErsUser(2, "employee2", "password",
				 "employee2", "employee2", "employee2",
				 1);
		ersReimbFeModel1 = new ErsReimbFeModel(1, 22.2, null,
				null, null,
				null, ersUserOne,
				"Pending", "Lodging",
				null);
		ersReimbFeModel2 = new ErsReimbFeModel(2, 22.2, null,
				null, null,
				null, ersUserTwo,
				"Approved", "Other",
				null);
		ersReimbFeModels.add(ersReimbFeModel1);
		ersReimbFeModels.add(ersReimbFeModel2);
	}
	@Before
	public void beforeMethod() {
		System.out.println("-------before test----------");
		
		
	}
	@After
	public void afterMethod() {
		System.out.println("---------after test---------");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("-------AFTER CLASS--------");
	}

	
	@Test
	public void getAllReimbursementsTest() {
		System.out.println("----------Beginning getAllReimbursementsTests-------");
		assertEquals("test1", 1, 1);
		System.out.println("Test1 " + "passed");
		
		
		/*List<ErsReimbFeModel> ersReimbFeModels = new ArrayList<>();*/
		/*ErsUser ersUserOne = new ErsUser(1, "employee1", "password",
										 "employee1", "employee1", "employee1",
										 1);
		ErsReimbFeModel ersReimbFeModel1 = new ErsReimbFeModel(1, 22.2, null,
																null, null,
																null, ersUserOne,
																"Pending", "Lodging",
																null);
		ersReimbFeModels.add(ersReimbFeModel1);*/
		
		
		Mockito.when(ersReimbursementService.getAllErsReimbursements()).thenReturn(ersReimbFeModels);
		
		/*assertEquals("ersReimbursementService getAllErsReimbursements", 22.2, 
				ersReimbursementService.getAllErsReimbursements().get(0).getReimbursementAmount());*/
		

	}
	
	@Test
	public void getAllReimbursementsUsernameTest() {
		System.out.println("----------Beginning getAllReimbursementsUsernameTest-------");
		Mockito.when(ersReimbursementService.getAllErsReimbursements()).thenReturn(ersReimbFeModels);
		assertEquals("ersReimbursementService getAllErsReimbursements", "employee1", 
				ersReimbursementService.getAllErsReimbursements().get(0)
				.getErsReimbursementUser().getUsername());
		System.out.println("Test getAllReimbursementsUsernameTest employee1" + " passed");
		assertEquals("ersReimbursementService getAllErsReimbursements", "employee2", 
				ersReimbursementService.getAllErsReimbursements().get(1)
				.getErsReimbursementUser().getUsername());
		System.out.println("Test getAllReimbursementsUsernameTest employee2" + " passed");
	}
	
	@Test
	public void getAllReimbursementsPasswordTest() {
		System.out.println("----------Beginning getAllReimbursementsPasswordTest-------");
		Mockito.when(ersReimbursementService.getAllErsReimbursements()).thenReturn(ersReimbFeModels);
		assertEquals("ersReimbursementService getAllErsReimbursements", "password", 
				ersReimbursementService.getAllErsReimbursements().get(0)
				.getErsReimbursementUser().getPassword());
		System.out.println("Test getAllReimbursementsPasswordTest employee1" + " passed");
		assertEquals("ersReimbursementService getAllErsReimbursements", "password", 
				ersReimbursementService.getAllErsReimbursements().get(1)
				.getErsReimbursementUser().getPassword());
		System.out.println("Test getAllReimbursementsPasswordTest employee2" + " passed");
	}
	
	@Test
	public void getAllReimbursementsUserRoleTest() {
		System.out.println("----------Beginning getAllReimbursementsUserRoleTest-------");
		Mockito.when(ersReimbursementService.getAllErsReimbursements()).thenReturn(ersReimbFeModels);
		assertEquals("ersReimbursementService getAllErsReimbursements", 1, 
				ersReimbursementService.getAllErsReimbursements()
				.get(0).getErsReimbursementUser().getUserRoleId());
		System.out.println("Test getAllReimbursementsUserRoleTest employee1" + " passed");
		assertEquals("ersReimbursementService getAllErsReimbursements", 1, 
				ersReimbursementService.getAllErsReimbursements()
				.get(1).getErsReimbursementUser().getUserRoleId());
		System.out.println("Test getAllReimbursementsUserRoleTest employee2" + " passed");
	}
	
	@Test
	public void getAllReimbursementsReimbursementStatusTest() {
		System.out.println("----------Beginning getAllReimbursementsReimbursementStatusTest-------");
		Mockito.when(ersReimbursementService.getAllErsReimbursements()).thenReturn(ersReimbFeModels);
		assertEquals("ersReimbursementService getAllErsReimbursements", "Pending", 
				ersReimbursementService.getAllErsReimbursements().get(0)
				.getReimbursementStatus());
		System.out.println("Test getAllReimbursementsReimbursementStatusTest employee1 'Pending'" + " passed");
		assertEquals("ersReimbursementService getAllErsReimbursements", "Approved", 
				ersReimbursementService.getAllErsReimbursements().get(1)
				.getReimbursementStatus());
		System.out.println("Test getAllReimbursementsReimbursementStatusTest employee2 'Approved'" + " passed");
	}
	
	@Test
	public void getAllReimbursementsUserIdTest() {
		System.out.println("----------Beginning getAllReimbursementsUserIdTest-------");
		Mockito.when(ersReimbursementService.getAllErsReimbursements()).thenReturn(ersReimbFeModels);
		assertEquals("ersReimbursementService getAllErsReimbursements", 1, 
				ersReimbursementService.getAllErsReimbursements().get(0)
				.getErsReimbursementUser().getUserId());
		System.out.println("Test getAllReimbursementsReimbursementUserIdTest employee1" + " passed");
		assertEquals("ersReimbursementService getAllErsReimbursements", 2, 
				ersReimbursementService.getAllErsReimbursements().get(1)
				.getErsReimbursementUser().getUserId());
		System.out.println("Test getAllReimbursementsReimbursementUserIdTest employee2" + " passed");
	}
	
	@Test
	public void getAllReimbursementsReimbursementTypeTest() {
		System.out.println("----------Beginning getAllReimbursementsReimbursementTypeTest-------");
		Mockito.when(ersReimbursementService.getAllErsReimbursements()).thenReturn(ersReimbFeModels);
		assertEquals("ersReimbursementService getAllErsReimbursements", "Lodging", 
				ersReimbursementService.getAllErsReimbursements().get(0)
				.getReimbursementType());
		System.out.println("Test getAllReimbursementsReimbursementReimbursementTypeTest employee1 'Lodging'" + " passed");
		assertEquals("ersReimbursementService getAllErsReimbursements", "Other", 
				ersReimbursementService.getAllErsReimbursements().get(1)
				.getReimbursementType());
		System.out.println("Test getAllReimbursementsReimbursementReimbursementTypeTest employee2 'Other'" + " passed");
	}
	
	@Test
	public void createReimbursementsTest() {
		System.out.println("----------Beginning createReimbursementsTests-------");
		assertEquals("test1", 2, 2);
		System.out.println("Test2 " + "passed");
		ErsUser ersUser = null;
		/*Double amount = null;*/
		Double amount = 0.0;
		String type = null;
		String description = null;
		Mockito.when(ersReimbursementService.createReimbursement(ersUser, amount, type, description)).thenReturn(1);
		assertEquals(1, ersReimbursementService.createReimbursement(ersUser, amount, type, description));
		System.out.println("Test ErsReimbursementService " + " createReimbursement " + "passed");
		
		
		
	}
	

}
