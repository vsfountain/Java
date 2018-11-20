package testing;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ServiceLayer.VaultServiceImplementation;

public class JunitTesting {
	//JUNIT TESTING CLASS REQUIRES SETUP NOT USED IN MOCKITO TESTING CLASS
	
	@Test
	public void getUsername() {
		System.out.print("Currently testing username set");
		VaultServiceImplementation tester = new VaultServiceImplementation();
		String username = "vsfount";
		String password = "password";
		assertThat("No UserID is 0", tester.getUserInfo(username, password), is(not(0)));
		assertThat("Should be 1",tester.getUserInfo(username, password), is(1));
	}

}
