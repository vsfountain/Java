/*
 * Simple object used to store data for Pending accounts.
 */
package accountManagement;

public class PendingAccounts implements PendingAccountsDao{
	
	private String userPW = "";
	private String userName = "";
	private String userNameJoint = "N/A";
	private String accountType = "";
	private String accountID = "";
	
	public PendingAccounts() {
	}
	
	public PendingAccounts(String accountType, String userName, String userNameJoint, String userPW, String accountID) {
		this.accountType = accountType;
		this.userName = userName;
		this.userNameJoint = userNameJoint;
		this.userPW = userPW;
		this.accountID = accountID;
	}
	
	@Override
	public String getAccountID() {
		return this.accountID;
	}
	
	@Override
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	
	@Override
	public String getUserNameJoint() {
		return userNameJoint;
	}
	
	@Override
	public void setUserNameJoint(String name) {
		this.userNameJoint = name;
	}
	
	@Override
	public String getUserPW() {
		return userPW;
	}

	@Override
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String getAccountType() {
		return accountType;
	}

	@Override
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "PendingAccounts [Account type for pending accounts:\t" + this.getUserName() + "\t" + this.getUserNameJoint() + "\t" + this.getAccountType() + "\t" + this.getAccountID() + "]";
	}
}
