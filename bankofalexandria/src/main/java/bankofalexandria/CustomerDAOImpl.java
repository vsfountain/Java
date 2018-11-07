package bankofalexandria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{
	
	private static String url = "jdbc:oracle:thin:@revature-instance.crl675iwrq4r.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "bankdb";
	private static String password = "p4ssw0rd";

	@Override
	public void preparedInsertCustomer(String name, String u_name, String p_word) {
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql= "{ call insert_customer_null_id(?,?,?) }";
			//String sql = "INSERT INTO customers(name, username, password, userid)" + "VALUES(?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, u_name);
			ps.setString(3, p_word);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Customer> selectAllCustomers() {
		
		List<Customer> cust = new ArrayList<>();
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= "SELECT * FROM customers";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				//System.out.println(rs.getInt(4));
				cust.add(new Customer(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getInt(4)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("cust = "+cust);
		return cust;
	}

	@Override
	public Customer selectCustomerByCredentials(String u_name, String p_word) {
		Customer cust = null;
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= "SELECT * FROM customers WHERE username = ?";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, u_name);

			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				cust = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}

}
