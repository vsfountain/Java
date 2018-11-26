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
		assertThat("Fails if 0, No UserID is 0", tester.getUserInfo(username, password), is(not(0)));
		assertThat("Should be 2",tester.getUserInfo(username, password), is(2));
	}
	
	@Test
	public void displayAllRequests(){
		//SMALLER TESTS DONE IN ONE TO ONE METHODS CALLS
		System.out.println("Currently testing view all requests");
		VaultServiceImplementation tester = new VaultServiceImplementation();
		System.out.println(tester.displayAllRequests());
		assertThat("Fails if empty", tester.displayAllRequests(), is(not(0)));
	}
	
	@Test
	public void displayUsers() {
		System.out.println("Currently in user display");
		VaultServiceImplementation tester = new VaultServiceImplementation();
		System.out.println(tester.displayAllUsers());
		assertThat("Fails if empty", tester.displayAllRequests(), is(not(0)));
	}

}
