package accountManagement;

import java.util.ArrayList;

public interface AccountManagementDao {
	public void freshTable();
	public String getNameOfAccountHolder(String accountID);
	public String getPasswordOfAccountHolder(String accountID);
	public String getNameOfJointAccountHolder(String accountID);
	public double dataBaseMoney(String accountID);
	public void dataBaseDepositMoney(double deposit, String accountID);
	public double dataBaseWithdrawMoney(double amount, String accountID);
	public void insertDataBase(int id, String currUserName, String CurrUserNameJoint, String currPassword, String currAccountType, Double currBalance, String currPending) throws Exception;
	public void deleteDataBase(int id);
	public void updateDataBase(int id);
	public int selectPendingDataBase();
	public int selectApprovedDataBase();
	public ArrayList<PendingAccounts> getCustomerAccountRequests();
	public void setCustomerAccountRequests(String pw, String username, String usernameJoint, String accountType, String accountID);
	public void removeCustomerAccountRequests(String accountID);
	public void removeApprovedAccount(String accountID);
	public ArrayList<ApprovedAccounts> getApprovedAccounts();
	public void setApprovedAccounts(String pw, String username, String usernameJoint, String accountType, String accountID);
}
