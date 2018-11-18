package ServiceLayer;

import java.util.ArrayList;

public interface VaultService {
	
	public int getUserInfo(String username, String password);
	public ArrayList<Object> displayAllRequests();
}
