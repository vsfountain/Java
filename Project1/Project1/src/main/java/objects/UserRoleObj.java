package objects;

public class UserRoleObj {
	private int ersUserRoleID;
	private String userRole;
	
	public UserRoleObj(int ersUserRoleID, String userRole) {
		super();
		this.ersUserRoleID = ersUserRoleID;
		this.userRole = userRole;
	}
	public int getErsUserRoleID() {
		return ersUserRoleID;
	}
	public void setErsUserRoleID(int ersUserRoleID) {
		this.ersUserRoleID = ersUserRoleID;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "UserRoleObj [ersUserRoleID=" + ersUserRoleID + ", userRole=" + userRole + "]";
	}
	
}
