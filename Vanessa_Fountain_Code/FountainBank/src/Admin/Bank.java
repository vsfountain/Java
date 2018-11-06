package Admin;


import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Customer.CustomerAccess;
import NewUser.NewUserAccess;

public class Bank implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1704823035222108376L;
	/**
	 * 
	 */
	static String filename;
	private static String url="jdbc:oracle:thin:@revature.cakynjhhcvux.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username= "BankFountain";
	private static String password= "p4ssw0rd";

	
	public static void preparedStatement(String name, Integer pin, Integer ssn,
			Integer accessLevel)
	{
		try(Connection conn=DriverManager.getConnection(url, username, password)){
			String sql= "INSERT INTO NEWUSER(name,pin,ssn,accessLevel) "+"VALUES(?,?,?,?)";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, pin);
			ps.setInt(3, ssn);
			ps.setInt(4, accessLevel);

			ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
				}
		}

	
	public static void Bank(Integer accessLevel, Person person) throws ClassNotFoundException, IOException{
		person.setAccessLevel(accessLevel);
		//change the person's access level to customer access level
		if(accessLevel == 1) {
			CustomerAccess.main(person, accessLevel);

		}
		if(accessLevel == 2) {
			filename = "./EmployeeInformation";
			//readObject(filename, person);
		}
		if(accessLevel == 3) {
			filename = "./AdminInformation";
			//readObject(filename, person);
		}
		else if(accessLevel == 4){
			filename = "./NewUserInformation";
			if (accessLevel == 4) {
				NewUserAccess.main(person);
				
			}
		}
	}
}