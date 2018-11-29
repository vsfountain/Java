package objects;

public class ReimbursementStatusObj {
	private int reimbStatusID;
	private String reimbStatus;
	
	public ReimbursementStatusObj(int reimbStatusID, String reimbStatus) {
		this.reimbStatusID = reimbStatusID;
		this.reimbStatus = reimbStatus;
	}
	
	public int getReimbStatusID() {
		return reimbStatusID;
	}
	
	public void setReimbStatusID(int reimbStatusID) {
		this.reimbStatusID = reimbStatusID;
	}
	
	public String getReimbStatus() {
		return reimbStatus;
	}
	
	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	
	@Override
	public String toString() {
		return "ReimbursementStatusObj [reimbStatusID=" + reimbStatusID + ", reimbStatus=" + reimbStatus + "]";
	}
	
	
}
