/*
 * Simple object used to store data for Pending accounts.
 */
package accountManagement;

public class PendingAccounts{
	
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
	
	public String getAccountID() {
		return this.accountID;
	}
	
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	
	public String getUserNameJoint() {
		return userNameJoint;
	}
	
	public void setUserNameJoint(String name) {
		this.userNameJoint = name;
	}
	
	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "PendingAccounts [Account type for pending accounts:\t" + this.getUserName() + "\t" + this.getUserNameJoint() + "\t" + this.getAccountType() + "\t" + this.getAccountID() + "]";
	}
}
