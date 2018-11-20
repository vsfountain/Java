package ERSModelLayer;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

//MODEL LAYER FOR THE USER OBJECTS
public class ERSUser extends LogEventPatternConverter{
	//ERS_USER 
	//VAULT DOOR ACCESS
	private int userID;
	private String userName;
	private String password;
	private String First;
	private String Last;
	private String email;
	private int userRoleID;
	public ERSUser(String name, String style, int userID, String userName, String password, String first, String last,
			String email, int userRoleID) {
		super(name, style);
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		First = first;
		Last = last;
		this.email = email;
		this.userRoleID = userRoleID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst() {
		return First;
	}
	public void setFirst(String first) {
		First = first;
	}
	public String getLast() {
		return Last;
	}
	public void setLast(String last) {
		Last = last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserRoleID() {
		return userRoleID;
	}
	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}
	@Override
	public String toString() {
		return "ERSUser [userID=" + userID + ", userName=" + userName + ", password=" + password + ", First=" + First
				+ ", Last=" + Last + ", email=" + email + ", userRoleID=" + userRoleID + "]";
	}
	@Override
	public void format(LogEvent event, StringBuilder toAppendTo) {
		// TODO Auto-generated method stub
		
	}
	
}
