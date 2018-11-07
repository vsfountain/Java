package testBankingApp;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import accountManagement.AccountManagement;

public class JUnitTesting {
 	AccountManagement cserv= Mockito.mock(AccountManagement.class);

	@Test
	public void test() {
		Mockito.when(cserv.selectPendingDataBase()).thenReturn(-1);
		Mockito.when(cserv.getNameOfAccountHolder("1")).thenReturn("mike");
		Mockito.when(cserv.selectApprovedDataBase()).thenReturn(-1);
		Mockito.when(cserv.getPasswordOfAccountHolder("1")).thenReturn("ge");
		Mockito.when(cserv.getNameOfJointAccountHolder("1")).thenReturn("mike");
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		assertEquals(-1, cserv.selectPendingDataBase());
		assertEquals(-1, cserv.selectApprovedDataBase());
		assertEquals("ge", cserv.getPasswordOfAccountHolder("1"));
		assertEquals("mike", cserv.getNameOfJointAccountHolder("1"));
		assertEquals("mike", cserv.getNameOfAccountHolder("1"));
	}
	
}
