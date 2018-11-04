package accountManagement;

import java.util.ArrayList;

public interface AccountManagementDao {
	public ArrayList<PendingAccounts> getCustomerAccountRequests();
	public void setCustomerAccountRequests(String pw, String username, String usernameJoint, String accountType, String accountID);
	public void removeCustomerAccountRequests(String accountID);
	public void removeApprovedAccount(String accountID);	
	public ArrayList<ApprovedAccounts> getApprovedAccounts();
	public void setApprovedAccounts(String pw, String username, String usernameJoint, String accountType, String accountID);
}
