/*
 * Handle's the objects, ApprovedAccounts and PendingAccounts; returns the information pertaining to them and allows admins to drop accounts.
 */
package accountManagement;

import java.util.ArrayList;

public class AccountManagement implements AccountManagementDao{
	private static ArrayList<PendingAccounts> customerAccountRequests = new ArrayList<>();
	private static ArrayList<ApprovedAccounts> approvedAccounts = new ArrayList<>();
	
	public AccountManagement() {
		super();
	}
	
	@Override
	public ArrayList<PendingAccounts> getCustomerAccountRequests() {
		return customerAccountRequests;
	}
	
	@Override
	public void setCustomerAccountRequests(String pw, String username, String usernameJoint, String accountType, String accountID) {
		PendingAccounts currPending = new PendingAccounts(accountType, username, usernameJoint, pw, accountID);
		customerAccountRequests.add(currPending);
	}
	
	@Override
	public void removeCustomerAccountRequests(String accountID) {
		for(int i = 0; i < customerAccountRequests.size(); i++) {
			String curr = "" + customerAccountRequests.get(i).getAccountID();
			if(curr.equals(accountID)){
				customerAccountRequests.remove(i);
				break;
			}
		}
	}
	
	@Override
	public void removeApprovedAccount(String accountID) {
		for(int i = 0; i < approvedAccounts.size(); i++) {
			String curr = "" + approvedAccounts.get(i).getAccountID();
			if(curr.equals(accountID)){
				approvedAccounts.remove(i);
				break;
			}
		}
	}
	
	@Override
	public ArrayList<ApprovedAccounts> getApprovedAccounts() {
		return approvedAccounts;
	}
	
	@Override
	public void setApprovedAccounts(String pw, String username, String usernameJoint, String accountType, String accountID) {
		ApprovedAccounts currApproved = new ApprovedAccounts(pw, username, accountType, usernameJoint, accountID);
		approvedAccounts.add(currApproved);
	}
}
