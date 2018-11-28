package com.ErsReimbursement;
import org.junit.Before;
import org.mockito.Mockito;

import com.ErsReimbursement.dao.ReimbursementDaoImpl;

public class MyTest {
	//NOT using mockito, so this is not a unit test
	//	it is integration testing
	com.ErsReimbursement.dao.ReimbursementDaoImpl reimbServ= new com.ErsReimbursement.dao.ReimbursementDaoImpl();
	
	//Let's use mockito instead
ReimbursementDaoImpl reimbDao= Mockito.mock(ReimbursementDaoImpl.class);

 ReimbursementDaoImpl reimburseme;

	@Before
	public void setUp() throws Exception {
  reimburseme = new ReimbursementDaoImpl();
}
}
//
//	@Test
//	public int test() {
//Mockito.when (reimbServ.InsertReimbursement(reimDao);
//	
//	
////verifying your mock object was used
//Mockito.verify(reimbDao).InsertReimbursement(reimburseme);
//}
//	@After
//	public void tearDown() throws Exception {
//}
//}