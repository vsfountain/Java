import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import revERS.tests.H2service;

public class H2ServiceTest {
	public static H2service serv;
	static String goodResult = "{\"id\":1,\"username\":\"coltossoff\",\"password\":null,\"firstname\":\"Colt\",\"lastname\":\"Ossoff\",\"email\":\"coltossoff@gmail.com\",\"role\":\"Employee\"}";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serv = new H2service();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	@Before
	public void setUp() throws Exception {
		serv.h2Init();
	}
	@After
	public void teardown() throws Exception {
		serv.h2Destroy();
	}
	@Test
	public void testLogin() throws Exception {
		String result = serv.login("coltossoff", "12345");
		
		assertEquals(goodResult, result);
	}
	@Test
	public void testById() throws Exception {
		String result = serv.byId(1);
		
		assertEquals(goodResult, result);
	}
}
