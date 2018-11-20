package ModelLayer;

public class RequestDisplay {
	int amount;
	String first;
	String last;
	String status;
	String type;
	String role;
	public RequestDisplay(int amount, String first, String last, String status, String type, String role) {
		super();
		this.amount = amount;
		this.first = first;
		this.last = last;
		this.status = status;
		this.type = type;
		this.role = role;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "RequestDisplay [amount=" + amount + ", first=" + first + ", last=" + last + ", status=" + status
				+ ", type=" + type + ", role=" + role + "]";
	}
	

}
