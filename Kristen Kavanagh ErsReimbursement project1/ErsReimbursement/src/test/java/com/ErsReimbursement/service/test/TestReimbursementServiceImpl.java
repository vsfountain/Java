package com.ErsReimbursement.service.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ErsReimbursement.model.Reimbursement;
import com.ErsReimbursement.service.ReimbursementService;
import com.ErsReimbursement.service.ReimbursementServiceImpl;

public class TestReimbursementServiceImpl {
	public void TestInsertReimbursement(Reimbursement reimburse) {
	 
	 }
	
	@Before
	public void setUp() {
		System.out.println("testing");
	}

	
	@Test
	public void TestselectAllReimburse() {
		givenThatReimbursementServiceIsPopulatedwithReimbursementDAOImpl();
		
	}

	@Test
	public void givenThatReimbursementServiceIsPopulatedwithReimbursementDAOImpl() {
		ReimbursementService rserv= Mockito.mock(ReimbursementServiceImpl.class);
		
		
		/*ReimbursementDao mock = Mockito.mock(ReimbursementDao.class);*/
		MyTestclass testClass = new MyTestclass();
		
		ArrayList<Reimbursement>ReimbursementList = testClass.constructReimbursementList();/*constructReimbursementList();*/
		Mockito.when(rserv.selectAllReimburse()).thenReturn(ReimbursementList);
		/*Mockito.when (ReimbursementDao.fetchReimbursements()).thenReturn(ReimbursementList);*/
		List<Reimbursement> valueFromReimbursementList = rserv.selectAllReimburse();
		assertEquals("Most Expensive", valueFromReimbursementList.get(0).getRemb_Description());
		System.out.println("the 87.00 test passed");
		
	}}
