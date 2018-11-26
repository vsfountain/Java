package ModelLayer;

public class PastDisplay {
	int id;
	int amount;
	int author;
	String first;
	String last;
	String status;
	String type;
	String role;
	public PastDisplay(int id, int amount, int author, String first, String last, String status, String type,
			String role) {
		super();
		this.id = id;
		this.amount = amount;
		this.author = author;
		this.first = first;
		this.last = last;
		this.status = status;
		this.type = type;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
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
		return "PastDisplay [id=" + id + ", amount=" + amount + ", author=" + author + ", first=" + first + ", last="
				+ last + ", status=" + status + ", type=" + type + ", role=" + role + "]";
	}
	
	

}
