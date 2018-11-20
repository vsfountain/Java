package VaultLogin;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.HashMap;
import ERSModelLayer.ERSUser;

public class LoginImplementation implements Login{
	private static String url="jdbc:oracle:thin:@revature.cakynjhhcvux.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String user= "reimburse_admin";
	private static String pass = "MyPassword";
	
	
	public void addNewDweller(ERSUser newDweller) {
		
	}

	public int checkInfo(String username, String password) {
		//HashMap<Object, Object> map = new HashMap<>();
		int userID = 0;
		//FOR HASHMAP IMPLEMENTATION USE GET ALL SQL STATEMENT
		//SELECT * FROM ERS_USERS WHERE ERS_USERNAME = 'vsfount' and ERS_PASSWORD = 'password';
		try(
				Connection connect = DriverManager.getConnection(url, user, pass);
				PreparedStatement ps = connect.prepareStatement("SELECT ERS_USERS_ID FROM ERS_USERS WHERE ERS_USERNAME = ? and ERS_PASSWORD = ?");
				ResultSet rs = ps.executeQuery();
				){
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			while(rs.next()) {
				userID = rs.getInt("ERS_USERS_ID");
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userID;
	}

	public void changeInfo(ERSUser ersUsersID) {
		
	}

	public void deleteDwellerAccess(ERSUser dwellerRelease) {
		// DONT FORGET TO COMMIT
		
	}

	
}
