package reimbursement;

import java.sql.Blob;
import java.util.ArrayList;

import objects.ReimbursementObj;

public interface ReimbursementManagerDAO {
	public String getCurrFullName(String currUserName);
	public String getUsersId(String currUserName);
	public ArrayList<ReimbursementObj> getReimbursement();
	public ArrayList<ReimbursementObj> getReimbursement(String ersUsersId);
	public String getUserName(String currUserName);
	public String getUserPassword(String currUserName);
	public String validateUser(String currUserName, String currUserPassword);
	public String getCurrUsernamee(int userId);
	public String getStatus(int status_id);
	public String getType(int type_id);
	public void addReimbursementRequest(double currAmount, String currDescription, String currType, int currAuthor);
	public String getRoleID(String currUsername);
	public void approveDenyReimbursement(String approveOrDeny, String adminID, String reimbID);
}
