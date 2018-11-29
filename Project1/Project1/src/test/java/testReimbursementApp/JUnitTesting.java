package testReimbursementApp;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import pendingAccounts.PendingAccountsManager;
import reimbursement.ReimbursementManager;
import servletController.LoginController;
import servletController.PendingAccountRequestsController;
import servletController.ReimbursementRequestController;
import servletController.RequestHelper;
import servletController.approveDenyPendingAccountsController;
import servletController.approveDenyReimbursementsController;
import servletJSONController.HomeJSONController;
import servletJSONController.HomeJSONNameController;
import servletJSONController.JSONRequestHelper;
import servletJSONController.ManagerHomeJSONController;
import servletJSONController.ManagerReimbRequestsController;

public class JUnitTesting {
	PendingAccountsManager pendingAccountsClass = Mockito.mock(PendingAccountsManager.class);
	ReimbursementManager reimbursementManagerClass = Mockito.mock(ReimbursementManager.class);
	approveDenyPendingAccountsController approveDenyPendingAccountsControllerClass = Mockito.mock(approveDenyPendingAccountsController.class);
	approveDenyReimbursementsController approveDenyReimbursementsControllerClass = Mockito.mock(approveDenyReimbursementsController.class);
	LoginController loginControllerClass = Mockito.mock(LoginController.class);
	PendingAccountRequestsController pendingAccountRequestsControllerClass = Mockito.mock(PendingAccountRequestsController.class);
	ReimbursementRequestController reimbursementRequestControllerClass = Mockito.mock(ReimbursementRequestController.class);
	RequestHelper requestHelperClass = Mockito.mock(RequestHelper.class);
	HomeJSONController homeJSONControllerClass = Mockito.mock(HomeJSONController.class);
	HomeJSONNameController homeJSONNameControllerClass = Mockito.mock(HomeJSONNameController.class);
	JSONRequestHelper JSONRequestHelperClass = Mockito.mock(JSONRequestHelper.class);
	ManagerHomeJSONController managerHomeJSONControllerClass = Mockito.mock(ManagerHomeJSONController.class);
	ManagerReimbRequestsController managerReimbRequestsControllerClass = Mockito.mock(ManagerReimbRequestsController.class);
	
	@Test
	public void test() {
		//Mockito.when(pendingAccountsClass.addPendingAccount("michaelgrammens", "12345", "Michael", "Grammens", "MLGrammens@gmail.com",  1)).then(1);
		//Mockito.when(pendingAccountsClass.getPendingAccounts()).thenReturn(pendingAccountsClass.getPendingAccounts());
		//Mockito.when(pendingAccountsClass.selectApprovedDataBase()).thenReturn(-1);
		//Mockito.when(pendingAccountsClass.getPasswordOfAccountHolder("1")).thenReturn("ge");
		
		Mockito.when(reimbursementManagerClass.getCurrFullName("michaelgrammens")).thenReturn("Michael Grammens");
		Mockito.when(reimbursementManagerClass.getUserName("michaelgrammens")).thenReturn("michaelgrammens");
		Mockito.when(reimbursementManagerClass.getUserPassword("michaelgrammens")).thenReturn("706323D5EEAE09C759193B3C7C024367");
		Mockito.when(reimbursementManagerClass.validateUser("michaelgrammens", "12345")).thenReturn("706323D5EEAE09C759193B3C7C024367");
		Mockito.when(reimbursementManagerClass.getUsersId("michaelgrammens")).thenReturn("13");
		//Mockito.when(reimbursementManagerClass.getReimbursement()).thenReturn(reimbursementManagerClass.getReimbursement());
		//Mockito.when(reimbursementManagerClass.getReimbursement("13")).thenReturn(reimbursementManagerClass.getReimbursement("13"));
		Mockito.when(reimbursementManagerClass.getCurrUsernamee(13)).thenReturn("michaelgrammens");
		Mockito.when(reimbursementManagerClass.getStatus(1)).thenReturn("Pending");
		Mockito.when(reimbursementManagerClass.getStatus(2)).thenReturn("Approved");
		Mockito.when(reimbursementManagerClass.getStatus(3)).thenReturn("Denied");
		Mockito.when(reimbursementManagerClass.getType(1)).thenReturn("LODGING");
		Mockito.when(reimbursementManagerClass.getType(2)).thenReturn("TRAVEL");
		Mockito.when(reimbursementManagerClass.getType(3)).thenReturn("FOOD");
		Mockito.when(reimbursementManagerClass.getType(4)).thenReturn("OTHER");
		//Mockito.when(reimbursementManagerClass.addReimbursementRequest(50.0, "howdy do", "2", 13)).thenReturn("mike");
		Mockito.when(reimbursementManagerClass.getRoleID("michaelgrammens")).thenReturn("1");
		//Mockito.when(reimbursementManagerClass.approveDenyReimbursement("1", "15", "1")).thenReturn("mike");
		//Mockito.when(approveDenyPendingAccountsControllerClass.approveAccount(req, currAccount)).thenReturn("mike");
		//Mockito.when(approveDenyPendingAccountsControllerClass.denyAccount(req, currAccount)).thenReturn("mike");
		//Mockito.when(approveDenyReimbursementsControllerClass.getNameOfJointAccountHolder("1")).thenReturn("mike");
		//Mockito.when(approveDenyReimbursementsControllerClass.getNameOfJointAccountHolder("1")).thenReturn("mike");
		//Mockito.when(loginControllerClass.getNameOfJointAccountHolder("1")).thenReturn("mike");
		//Mockito.when(pendingAccountRequestsControllerClass.getNameOfJointAccountHolder("1")).thenReturn("mike");
		//Mockito.when(reimbursementRequestControllerClass.getNameOfJointAccountHolder("1")).thenReturn("mike");
		//Mockito.when(requestHelperClass.getNameOfJointAccountHolder("1")).thenReturn("mike");
		//Mockito.when(homeJSONControllerClass.getNameOfJointAccountHolder("1")).thenReturn("mike");
		//Mockito.when(homeJSONNameControllerClass.getNameOfJointAccountHolder("1")).thenReturn("mike");
		//Mockito.when(JSONRequestHelperClass.getNameOfJointAccountHolder("1")).thenReturn("mike");
		//Mockito.when(managerHomeJSONControllerClass.getNameOfJointAccountHolder("1")).thenReturn("mike");
		//Mockito.when(managerReimbRequestsControllerClass.getNameOfJointAccountHolder("1")).thenReturn("mike");
		//assertEquals(pendingAccountsClass.getPendingAccounts(), pendingAccountsClass.getPendingAccounts());
		
		
		
		
		
		
		
		assertEquals("Michael Grammens", reimbursementManagerClass.getCurrFullName("michaelgrammens"));
		assertEquals("michaelgrammens", reimbursementManagerClass.getUserName("michaelgrammens"));
		assertEquals("706323D5EEAE09C759193B3C7C024367", reimbursementManagerClass.getUserPassword("michaelgrammens"));
		assertEquals("706323D5EEAE09C759193B3C7C024367", reimbursementManagerClass.validateUser("michaelgrammens", "12345"));
		assertEquals("13", reimbursementManagerClass.getUsersId("michaelgrammens"));
		assertEquals("michaelgrammens", reimbursementManagerClass.getCurrUsernamee(13));
		assertEquals("Pending", reimbursementManagerClass.getStatus(1));
		assertEquals("Approved", reimbursementManagerClass.getStatus(2));
		assertEquals("Denied", reimbursementManagerClass.getStatus(3));
		assertEquals("LODGING", reimbursementManagerClass.getType(1));
		assertEquals("TRAVEL", reimbursementManagerClass.getType(2));
		assertEquals("FOOD", reimbursementManagerClass.getType(3));
		assertEquals("OTHER", reimbursementManagerClass.getType(4));
		assertEquals("1", reimbursementManagerClass.getRoleID("michaelgrammens"));
	
	}
}
