package accountManagement;

public interface ApprovedAccountsDao {
	public String getAccountID();
	public void setAccountID(String accountID);
	public Double getMoney();
	public void setMoney(double deposit);
	public double withdraw(double amount);
	public String getUserNameJoint();
	public void setUserNameJoint(String userNameJoint);
	public String getUserPW();
	public void setUserPW(String userPW);
	public String getUserName();
	public void setUserName(String userName);
	public String getAccountType();
	public void setAccountType(String accountType);
}
