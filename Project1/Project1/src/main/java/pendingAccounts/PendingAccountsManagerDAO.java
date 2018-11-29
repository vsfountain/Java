package pendingAccounts;

import java.util.ArrayList;

import objects.UserObj;

public interface PendingAccountsManagerDAO {
	public void addPendingAccount(String currUsername, String currPassword, String currFirstname, String currLastname, String currEmail, int role);
	public ArrayList<UserObj> getPendingAccounts();
	public void removePendingAccount(String currUserId);
	public void insertNewActualAccount(String currUsername, String currPassword, String currFirstname, String currLastname, String currEmail, String currRole);
}
