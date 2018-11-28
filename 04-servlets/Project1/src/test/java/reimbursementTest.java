
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.dikokosolutions.model.Reimbursement;
import com.dikokosolutions.model.User;

@RunWith(MockitoJUnitRunner.class)
class reimbursementTest {

	@Mock
	private DataSource ds;

	@Mock
	private Connection c;

	@Mock
	private PreparedStatement stmt;

	@Mock
	private ResultSet rs;

	@Mock
	private User u;

	@Mock
	private Reimbursement r;

	@Test
	public void setUp() throws Exception {
		assertNotNull(ds);
		when(c.prepareStatement(any(String.class))).thenReturn(stmt);
		when(ds.getConnection()).thenReturn(c);

		u = new User();
		u.setUserId(1);
		u.setUserName(u.getUserFirstName() + u.getUserLastName());
		u.setUserPassword("mockpassword");
		u.setUserFirstName("clement");
		u.setUserLastName("dikoko");
		u.setUserEmail("clementdikoko94@gmail.com");
		u.setUserRoleId(1);

		when(rs.first()).thenReturn(true);
		when(rs.getInt(1)).thenReturn(u.getUserId());
		when(rs.getString(2)).thenReturn(u.getUserPassword());
		when(rs.getString(3)).thenReturn(u.getUserFirstName());
		when(rs.getString(4)).thenReturn(u.getUserLastName());
		when(rs.getString(5)).thenReturn(u.getUserEmail());
		when(rs.getInt(6)).thenReturn(u.getUserRoleId());
		when(stmt.executeQuery()).thenReturn(rs);

	}

}
