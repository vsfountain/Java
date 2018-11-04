package accountManagement;

public interface PendingAccountsDao {
	
	public String getAccountID();
	public void setAccountID(String accountID);
	public String getUserNameJoint();
	public void setUserNameJoint(String name);
	public String getUserPW();
	public void setUserPW(String userPW);
	public String getUserName();
	public void setUserName(String userName);
	public String getAccountType();
	public void setAccountType(String accountType);
}
