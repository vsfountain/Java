package mainServlet;

import servletController.RequestHelper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class MasterServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(MasterServlet.class);
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("Master Servlet GET Request Recieved.");
		req.getRequestDispatcher(RequestHelper.process(req))
		.forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("Master Servlet POST Request Recieved.");
		req.getRequestDispatcher(RequestHelper.process(req))
		.forward(req, resp);
	}
}
