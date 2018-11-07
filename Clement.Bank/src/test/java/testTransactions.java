import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bankofdikoko.model.Account;
import com.bankofdikoko.model.User;
import com.bankofdikoko.dao.UserDao;
import com.bankofdikoko.dao.AccountDao;
import com.bankofdikoko.dao.DAOInterface;
public class testTransactions {
	public User user;
	@Before
	public void test() {
		User user = new User();
	}
	
	@Test
	public void testDeposit() {
	int balance = 0;
	Account account = new Account();
	account.deposit(100);
	assertEquals(account.getBalance(), 100);
		
	}
	
	@Test
	public void testWithdrawal() {
	int balance = 100;
	Account account = new Account();
	assertEquals(account.getBalance(), 0);
	}


}
