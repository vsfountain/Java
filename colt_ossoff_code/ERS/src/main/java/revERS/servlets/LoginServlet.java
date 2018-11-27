package revERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import revERS.servlets.controllers.RequestHelper;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	public static Logger logger = Logger.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        logger.info("In LoginServlet constructor");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("in doGET()");
		String json = "You\'re not supposed to be here"; //WelcomeController.sendUser(request);
		response.setContentType("text/json");
		
		PrintWriter out = response.getWriter();
		out.println(json);
		logger.info(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("In doPost()");
		logger.info(request.getRequestURI());
		response.setContentType("application/json");
		String json = RequestHelper.process(request, response);
		PrintWriter out = response.getWriter();
		out.println(json);
		logger.info(json);
	}

}
