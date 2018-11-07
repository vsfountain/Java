package bankofalexandria;

public class SoloAccount extends Account{
	
	
	public SoloAccount(String name, String userName, String password, int userID) {
		// TODO Auto-generated constructor stub
		super(name, userName, password, userID);
	}
	public Customer owner1;
	public final Customer owner2 = null;
	@Override
	public String toString() {
		return "SoloAccount: owner: " + owner1 + ", balance="+ this.getBalance();
	}
	


}
