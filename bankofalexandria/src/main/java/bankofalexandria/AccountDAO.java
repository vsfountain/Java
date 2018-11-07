package bankofalexandria;

import java.util.List;

public interface AccountDAO {
	
	//to insert a new account into the database
	public void preparedInsertAccount(double balance, int userID);
	
	//to access accounts in program
	public List<Account> selectAllAccounts();
	public Account selectAccountByID(int acc_id);
	
	//to change values in the database
	public void updateBalance(int acc_id, double acc_balance);
	

}
