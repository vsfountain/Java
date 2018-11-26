package project1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.project1.service.UserServiceImpl;
import com.project1.objs.User;

public class TestClass {
	UserServiceImpl testUserServ = Mockito.mock(UserServiceImpl.class);
	User testUser = Mockito.mock(User.class);
	
	@Test
    public void userObjTest() {
		Mockito.when(testUser.getUserRoleId()).thenReturn(1);
		assertEquals(1, testUser.getUserRoleId());
		
		Mockito.when(testUser.getUsername()).thenReturn("phillippride");
		assertEquals("phillippride", testUser.getUsername());
	}

}
