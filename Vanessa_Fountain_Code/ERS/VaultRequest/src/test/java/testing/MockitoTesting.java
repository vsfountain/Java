package testing;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import Servlets.MasterServlet;

public class MockitoTesting {
	//MOCKITO REQUIRES SETUP NOT USED IN JUNIT TESTING CLASS
	HttpServletRequest request = mock(HttpServletRequest.class);       
    HttpServletResponse response = mock(HttpServletResponse.class);
    MasterServlet testServ = mock(MasterServlet.class);
	private StringWriter response_writer;
	private Map<String, String> parameters;
	
	@Before
	public void setUp() throws IOException {
        System.out.println("Currently testing setup");
		parameters = new HashMap<String, String>();
		response_writer = new StringWriter();

		when(request.getParameter(toString())).thenAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocation) {
				return parameters.get((String) invocation.getArguments()[0]);
			}
		});
		when(response.getWriter()).thenReturn(new PrintWriter(response_writer));
	}
	
	@Test
    public void testServlet() throws Exception {
		System.out.println("Currently testing servlet");
        Mockito.when(request.getParameter("username")).thenReturn("SOME");
        Mockito.when(request.getParameter("password")).thenReturn("THING");
        
        //CANNOT MOCK PRIMITIVE TYPES
        //ANY METHOD CALLED FROM doPost OR doGet of type "void" CANNOT BE MOCKED
        //StringWriter stringWriter = new StringWriter();
        //PrintWriter writer = new PrintWriter(stringWriter);
        
        testServ.doGet(request, response);
        testServ.doPost(request, response);
        
        Mockito.verify(request);
        //Mockito.verify(response);
    }

}
