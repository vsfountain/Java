package project1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.project1.service.ReimbursementServiceImpl;
import com.project1.service.UserServiceImpl;
import com.project1.objs.Reimbursement;
import com.project1.objs.User;

public class TestClass {
	UserServiceImpl testUserServ = Mockito.mock(UserServiceImpl.class);
	User testUser = Mockito.mock(User.class);
	ReimbursementServiceImpl testReimbServ = Mockito.mock(ReimbursementServiceImpl.class);
	Reimbursement testReimb = Mockito.mock(Reimbursement.class);
	
	@Test
    public void userObjTest() {
		Mockito.when(testUser.getUserRoleId()).thenReturn(1);
		assertEquals(1, testUser.getUserRoleId());
		
		Mockito.when(testUser.getUsername()).thenReturn("phillippride");
		assertEquals("phillippride", testUser.getUsername());
	}
	
	@Test
    public void reimbObjTest() {
		Mockito.when(testReimb.getReimbAuthor()).thenReturn(5);
		assertEquals(5, testReimb.getReimbAuthor());
		
		
	}

}
