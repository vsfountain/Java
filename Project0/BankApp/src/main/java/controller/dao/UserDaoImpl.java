package controller.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.dataio.DriverManagerFacade;
import model.accounts.Account;
import model.accounts.JointAccount;
import model.users.ClientUser;
import model.users.Employee;
import model.users.User;
import oracle.jdbc.OracleTypes;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDaoImpl.
 */
public class UserDaoImpl implements UserDao
{
	
	/** The url. */
	private static String url = "jdbc:oracle:thin:@revy.ctgsqmepdtko.us-east-2.rds.amazonaws.com:1521:orcl";

	/** The username. */
	private static String username = "bankuser";

	/** The password. */
	private static String password = "p4ssw0rd";
	
	private static DriverManagerFacade driverManager = new DriverManagerFacade();

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.dao.UserDao#userLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public User userLogin(String email, String testpassword) {
		ArrayList<User> users = new ArrayList<User>();
		ResultSet rs;
		//System.out.println("test");
		try (Connection conn = driverManager.getConn(url, username, password)) {
			String sql = "SELECT * FROM (users JOIN usertypes ON " + "usertypes.usertypeid = users.usertype) "
					+ "WHERE email = ? AND userpassword = ?";
			//System.out.println("test");
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, email); // notice how we start at 1
			cs.setString(2, testpassword);
			rs = cs.executeQuery();
			//System.out.println("test" + rs);
			while (rs.next()) {
				//System.out.println("testwhile");
				if (rs.getString("usertypename").equals("Admin")) {
					// System.out.println("Admin");

					users.add(new Employee(rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"),
							null, rs.getInt("userid")));
				} else {
					// System.out.println("Admin");
					users.add(new ClientUser(rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"),
							null, rs.getInt("userid")));

				}
				if (users.size() > 1) {
					System.out.println("something is seriosly wrong with the database");
				} else if (users.size() == 1) {
					return users.get(0);
				} else {
					return null;
				}
			}
			conn.close();

		} catch (SQLException e) {
			System.out.println("Your connection has errored out, " + "try again later.");
			e.printStackTrace();
		}

		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.dao.UserDao#registerUser(java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean registerUser(String firstName, String lastName, String newpassword, String email) {
		String sql = "{ call insert_user(?,?,?,?) }";
		int result = 0;
		try (Connection conn = driverManager.getConn(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println(ps + " " + conn);
			ps.setString(1, email);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, newpassword);

			result = ps.executeUpdate();
			//System.out.println(result);
			// System.out.println("them results 1 : " + result);
			// result = ps.getUpdateCount();

			conn.close();
			// System.out.println("THEM RESULTS" + result);
		} catch (SQLException e) {
			// System.out.println(e.getErrorCode());
			// e.printStackTrace();
			//e.printStackTrace();
			return false;
		}
		// System.out.println("THEM RESULTS" + result);
		if (result == 1) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.dao.UserDao#applyForAccount(int, int)
	 */
	@Override
	public boolean applyForAccount(int userID, int type) {
		String sql = "{ call account_app(?,?,?) }";
		int result = 0;
		try (Connection conn = driverManager.getConn(url, username, password)) {
			CallableStatement ps = conn.prepareCall(sql);
			ps.setInt(1, type);
			ps.setInt(2, userID);
			ps.registerOutParameter(3, OracleTypes.NUMBER);

			result = ps.executeUpdate();
			// int rs = ps.getInt(3);

			// System.out.println("THIS IS A THING MAYBE? " + rs);
			// System.out.println("them results 1 : " + result);
			// result = ps.getUpdateCount();

			conn.close();
			// System.out.println("THEM RESULTS" + result);
		} catch (SQLException e) {
			// System.out.println(e.getErrorCode());
			// e.printStackTrace();
			return false;
		}
		// System.out.println("THEM RESULTS" + result);
		if (result == 1) {
			return true;
		}
		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.dao.UserDao#approveAccount(model.users.User,
	 * model.accounts.Account)
	 */
	@Override
	public boolean approveAccount(User user, Account account) {
		int rs3 = 0;
		try (Connection conn = driverManager.getConn(url, username, password)) {
			String sql1 = "DELETE FROM accountapps WHERE userid = ? AND accountid = ?";
			String sql2 = "INSERT INTO ACCOUNTS VALUES (?,0,?)";
			String sql3 = "INSERT INTO userstoaccounts VALUES (?,?)";

			PreparedStatement cs1 = conn.prepareStatement(sql1);
			cs1.setInt(1, user.getAccountId());
			cs1.setInt(2, account.getId());
			PreparedStatement cs2 = conn.prepareCall(sql2);
			cs2.setInt(1, account.getId());
			if (account.getType().equals("Savings")) {
				cs2.setInt(2, 1);
			} else {
				cs2.setInt(2, 2);
			}

			PreparedStatement cs3 = conn.prepareCall(sql3);
			cs3.setInt(1, user.getAccountId());
			cs3.setInt(2, account.getId());
			int rs1 = cs1.executeUpdate();
			cs1.close();
			int rs2 = 0;
			rs3 = 0;
			if (rs1 == 1) {
				rs2 = cs2.executeUpdate();
				cs2.close();

			}
			if (rs1 == 1 && rs2 == 1) {
				rs3 = cs3.executeUpdate();
				// +
				//System.out.println(rs3);

				cs3.close();

			}
			conn.close();
			// System.out.println(rs1 + " " + rs2 + " " + rs3 + "!!!!!!!!!!!!");

		} catch (SQLException e) {
			System.out.println("Your connection has errored out, " + "try again later.");
			e.printStackTrace();
		}
		if (rs3 == 1) {

			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.dao.UserDao#withdraw(int, int)
	 */
	@Override
	public boolean withdraw(int account, int ammount) {
		String sql1 = "SELECT * FROM accounts WHERE accountid = ?";
		String sql2 = "UPDATE ACCOUNTS SET balance = ? WHERE accountid = ?";

		try (Connection conn = driverManager.getConn(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setInt(1, account);

			ResultSet rs = ps.executeQuery();
			int curVal = 0;
			if (rs.next()) {
				curVal = rs.getInt("balance");
			}
			rs.close();
			if (curVal - ammount < 0) {
				return false;
			}
			int newVal = curVal - ammount;
			PreparedStatement ps2 = conn.prepareStatement(sql2);

			ps2.setInt(1, newVal);
			ps2.setInt(2, account);
			int status = ps2.executeUpdate();
			if (status == 1) {
				
				return true;

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.dao.UserDao#deposit(int, int)
	 */
	@Override
	public boolean deposit(int account, int ammount) {
		String sql1 = "SELECT * FROM accounts WHERE accountid = ?";
		String sql2 = "UPDATE ACCOUNTS SET balance = ? WHERE accountid = ?";

		try (Connection conn = driverManager.getConn(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setInt(1, account);

			ResultSet rs = ps.executeQuery();
			int curVal = 0;
			if (rs.next()) {
				curVal = rs.getInt("balance");
			}
			rs.close();
			if (ammount < 0) {
				return false;
			}
			int newVal = curVal + ammount;
			PreparedStatement ps2 = conn.prepareStatement(sql2);

			ps2.setInt(1, newVal);
			ps2.setInt(2, account);
			int status = ps2.executeUpdate();
			if (status == 1) {
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.dao.UserDao#transfer(int, int, int)
	 */
	@Override
	public boolean transfer(int fromAccount, int toAccount, int ammount) {
		if (!withdraw(fromAccount, ammount)) {
			return false;
		}
		if (!deposit(toAccount, ammount)) {
			return false;
		}
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.dao.UserDao#getAccounts(int)
	 */
	@Override
	public ArrayList<Account> getAccounts(int userid) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		String sql = " SELECT * FROM accounts "
				+ " RIGHT JOIN accounttypes ON accounttypes.accounttypeid = accounts.accounttypeid "
				+ " RIGHT JOIN userstoaccounts UTA ON UTA.accountid = accounts.accountid " + " WHERE UTA.userid = ?";
		try (Connection conn = driverManager.getConn(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int accountid = rs.getInt("accountid");
				// int curUserid = rs.getInt("userid");
				int balance = rs.getInt("balance");
				String type = rs.getString("accounttypename");

				accounts.add(new Account(type, accountid, balance));
			}

			rs.close();

			return accounts;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return accounts;
	}

	private Account createAccountObj(String accountType, int accountId) {
		//System.out.println("TYPE!!!!! " + accountType);
		if (accountType.equals("Joint")) {
			return new JointAccount(accountType, accountId);
		} else {
			return new Account(accountType, accountId);
		}
	}

	private Account jointAccountListAdd(ArrayList<Account> accounts, Account account, User u) {
		Account toReturn = account;
		int index = -1;
		if (accounts.size() > 0) {
			if (account instanceof JointAccount) {
				if (accounts.contains(account)) {
					index = accounts.indexOf(account);
					toReturn = accounts.get(index);
					((JointAccount) toReturn).addUser(u);
				} else {
					((JointAccount) account).addUser(u);
					accounts.add((JointAccount) account);
				}
			}
		} else if (account instanceof JointAccount) {
			((JointAccount) account).addUser(u);
			accounts.add((JointAccount) account);
		}
		return toReturn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.dao.UserDao#getAccountsForAproval()
	 */
	@Override
	public ArrayList<User> getAccountsForAproval() {

		ArrayList<User> usersAndApps = new ArrayList<User>();
		String sql = " SELECT users.userid, accountapps.accountid, "
				+ "accounttypes.accounttypename, users.firstname, users.lastname" + ", users.email\r\n"
				+ " FROM users JOIN accountapps ON accountapps.userid = users.userid\r\n"
				+ " JOIN accounttypes on accounttypes.accounttypeid = accountapps.accounttypeid "
				+ "ORDER BY users.userid";
		try (Connection conn = driverManager.getConn(url, username, password)) {
			CallableStatement cs = conn.prepareCall(sql);

			cs.executeUpdate();
			ResultSet rs = cs.getResultSet();

			int preveous = -1;
			User u = null;
			Account toWorkWith = null;
			ArrayList<Account> jointAccountsRequested = new ArrayList<Account>();
			while (rs.next()) {

				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				int userId = rs.getInt("userid");
				int accountId = rs.getInt("accountid");
				String accountType = rs.getString("accounttypename");
				toWorkWith = createAccountObj(accountType, accountId);
				if (preveous != userId) {
					u = new User(firstName, lastName, email, null, userId);
					usersAndApps.add(u);
					u.addAccount(jointAccountListAdd(jointAccountsRequested, toWorkWith, u));

				} else {
					u.addAccount(jointAccountListAdd(jointAccountsRequested, toWorkWith, u));
				}
				preveous = userId;

			}
			//System.out.println("joint acc: " + jointAccountsRequested);
			// System.out.println("THIS IS A THING MAYBE? " + rs);
			// System.out.println("them results 1 : " + result);
			// result = ps.getUpdateCount();

			conn.close();
			// System.out.println("THEM RESULTS" + result);
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + "!!!!!!!!!!!!!");
			e.printStackTrace();
			return null;
		}
		return usersAndApps;
	}

	public ArrayList<User> getAccountsForAll() {

		ArrayList<User> usersAndApps = new ArrayList<User>();
		String sql = "SELECT users.userid, accounts.accountid, accounttypes.accounttypename, "
				+ "users.firstname, users.lastname, users.email, accounts.balance " + "FROM users "
				+ "JOIN userstoaccounts uta ON uta.userid = users.userid "
				+ "RIGHT JOIN accounts ON accounts.accountid = uta.accountid "
				+ "LEFT JOIN accounttypes on accounttypes.accounttypeid = accounts.accounttypeid "
				+ "ORDER BY users.userid";
		try (Connection conn = driverManager.getConn(url, username, password)) {
			CallableStatement cs = conn.prepareCall(sql);

			cs.executeUpdate();
			ResultSet rs = cs.getResultSet();

			int preveous = -1;
			User u = null;
			while (rs.next()) {

				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				int userId = rs.getInt("userid");
				int accountId = rs.getInt("accountid");
				String accountType = rs.getString("accounttypename");
				int balance = rs.getInt("balance");
				if (preveous != userId) {
					u = new User(firstName, lastName, email, null, userId);
					usersAndApps.add(u);
					u.addAccount(new Account(accountType, accountId, balance));
				} else {
					u.addAccount(new Account(accountType, accountId, balance));
				}
				preveous = userId;

			}

			// System.out.println("THIS IS A THING MAYBE? " + rs);
			// System.out.println("them results 1 : " + result);
			// result = ps.getUpdateCount();

			conn.close();
			// System.out.println("THEM RESULTS" + result);
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + "!!!!!!!!!!!!!");
			e.printStackTrace();
			return null;
		}
		return usersAndApps;
	}

	@Override
	public boolean cancelAccount(int accountid) {
		String sql = "DELETE FROM userstoaccounts WHERE accountid = ?";
		String sql2 = "DELETE FROM accounts WHERE accountid = ?";
		int result1 = -1;
		int result2 = -1;
		try (Connection conn = driverManager.getConn(url, username, password)) {


			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountid);

			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, accountid);

			result1 = ps.executeUpdate();
			ps.close();

			result2 = ps2.executeUpdate();
			ps.close();

			if (result1 >= 1 && result2 >= 1) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users JOIN usertypes ON users.usertype = usertypes.usertypeid";
		try (Connection conn = driverManager.getConn(url, username, password)) {
			CallableStatement cs = conn.prepareCall(sql);

			ResultSet rs = cs.executeQuery();

			User u = null;
			while (rs.next()) {

				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				String usertype = rs.getString("usertypename");
				int userId = rs.getInt("userid");
				if (!usertype.equals("Admin")) {
					u = new ClientUser(firstName, lastName, email, null, userId);
					users.add(u);
				}

			}

			// System.out.println("THIS IS A THING MAYBE? " + rs);
			// System.out.println("them results 1 : " + result);
			// result = ps.getUpdateCount();

			conn.close();
			// System.out.println("THEM RESULTS" + result);
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + "!!!!!!!!!!!!!");
			e.printStackTrace();
			return null;
		}
		return users;
	}

	@Override
	public boolean batchApplyForAccount(ArrayList<User> users) {
		String sql = "{ call account_app(?,?,?) }";
		String sql2 = "INSERT INTO accountapps VALUES( ?, ?, ?)";
		int result = 0;
		int[] x = new int[users.size() - 1];
		try (Connection conn = driverManager.getConn(url, username, password)) {
			CallableStatement ps = conn.prepareCall(sql);
			ps.setInt(1, 3);
			ps.setInt(2, users.get(0).getAccountId());
			ps.registerOutParameter(3, OracleTypes.NUMBER);
			users.remove(0);
			result = ps.executeUpdate();
			int rs = ps.getInt(3);
			ps.close();
			CallableStatement ps2 = conn.prepareCall(sql2);
			for (User items : users) {
				ps2.setInt(1, rs);
				ps2.setInt(2, 3);
				ps2.setInt(3, items.getAccountId());
				ps2.addBatch();
				//System.out.println("  RS IS " + rs);
			}
			x = ps2.executeBatch();
			// System.out.println("THIS IS A THING MAYBE? " + rs);
			// System.out.println("them results 1 : " + result);
			// result = ps.getUpdateCount();

			conn.close();
			// System.out.println("THEM RESULTS" + result);
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
			System.out.println("an error has ocured try again later");
			return false;
		}
		// System.out.println("THEM RESULTS" + result);
		if (result == 1) {
			for (int y : x) {
				if (y != 1) {
					System.out.println("Some accounts have encounter an error");
					return false;

				}
			}
			System.out.println("Applied for accounts");
			return true;
		}
		return false;
	}

	@Override
	public boolean approveJointAccount(JointAccount account) {
		String sql1 = "DELETE FROM accountapps WHERE accountid = ?";
		String sql2 = "INSERT INTO ACCOUNTS VALUES (?,0,?)";
		String sql3 = "INSERT INTO userstoaccounts VALUES (?,?)";
		int accountid = account.getId();
		int result1 = -1;
		int result2 = -1;
		ArrayList<User> users = account.getUsersWith();
		int[] checker = new int[users.size()];
		try (Connection conn = driverManager.getConn(url, username, password)) {
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setInt(1, accountid);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, accountid);
			ps2.setInt(2, 3);
			PreparedStatement ps3 = conn.prepareStatement(sql3);

			for (User user : users) {
				ps3.setInt(1, user.getAccountId());
				ps3.setInt(2, account.getId());
				ps3.addBatch();
			}
			result1 = ps1.executeUpdate();
			ps1.close();
			result2 = ps2.executeUpdate();
			ps2.close();

			checker = ps3.executeBatch();
			ps3.close();
			boolean allUpdated = true;
			for (int x : checker) {
				if (x != 1) {
					allUpdated = false;
				}
			}
			//System.out.println(result1 + " " + result2 + " " + allUpdated);
			if (result1 >= 1 && result2 == 1 && allUpdated) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
		return false;
	}

}
