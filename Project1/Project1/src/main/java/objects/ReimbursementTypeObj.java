package objects;

public class ReimbursementTypeObj {
	private int reimbStatusID;
	private String reimbStatus;
	
	public ReimbursementTypeObj(int reimbStatusID, String reimbStatus) {
		super();
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
		return "ReimbursementTypeObj [reimbStatusID=" + reimbStatusID + ", reimbStatus=" + reimbStatus + "]";
	}
	
}
