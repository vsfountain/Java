/*
 * Simple object used to store data for Approved accounts.
 */
package accountManagement;

public class ApprovedAccounts implements ApprovedAccountsDao{
	
	private String userPW = "";
	private String userName = "";
	private String accountType = "";
	private String userNameJoint = "";
	private String accountID = "";
	private Double money = 0.0;
	
	public ApprovedAccounts() {
	}
	
	public ApprovedAccounts(String userPW, String userName, String accountType, String userNameJoint, String accountID) {
		this.userPW = userPW;
		this.userName = userName;
		this.accountType = accountType;
		this.userNameJoint = userNameJoint;
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
	public Double getMoney() {
		return this.money;
	}
	
	@Override
	public void setMoney(double deposit) {
		this.money+=deposit;
	}
	
	@Override
	public double withdraw(double amount) {
		if(amount <= 0.0) {
			return -1.0;
		}
		if(amount <= this.money) {
			this.money-=amount;
			return this.money;
		}
		else if(amount > this.money) {
			return -2.0;
		}
		return -2.0;
	}
	
	@Override
	public String getUserNameJoint() {
		return this.userNameJoint;
	}
	
	@Override
	public void setUserNameJoint(String userNameJoint) {
		this.userNameJoint = userNameJoint;
	}
	
	@Override
	public String getUserPW() {
		return this.userPW;
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
		return "Account List [Account type for created accounts:\t" + this.getUserName() + "\t" + this.getUserNameJoint()+ "\t" + this.getAccountType()+ "\t" + this.getAccountID()+ "\t" + this.getMoney() + "]";
	}
}
