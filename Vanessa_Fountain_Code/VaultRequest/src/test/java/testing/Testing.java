package testing;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;

import ServiceLayer.VaultServiceImplementation;

public class Testing {

	@Test
	public void getUsername() {
		System.out.print("Currently testing username set");
		VaultServiceImplementation tester = new VaultServiceImplementation();
		String username = "vsfount";
		String password = "password";
		//assertNull(null, tester.getUserInfo());
		//assertNotNull("Should return from the Database",tester.getUserInfo());
		//assertThat(tester.getUserInfo(), is(notNullValue()));
		assertThat("No UserID is 0", tester.getUserInfo(username, password), is(not(0)));
	}

}
