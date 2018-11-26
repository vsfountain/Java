package com.kers.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.kers.daos.ReimbursementDAO;
import com.kers.daos.ReimbursementDAOImpl;
import com.kers.models.Reimbursement;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet(urlPatterns = { "/image" })
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(ImageServlet.class);
	
    static ReimbursementDAO rdao = new ReimbursementDAOImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Trying to get an image from ImageServlet");
		int id = Integer.parseInt(request.getParameter("id"));
		Reimbursement r = rdao.selectReimbursementById(id);
		System.out.println("R: " + r);
		if(r == null) {
			logger.warn("Tried to get an image that didnt exist.");
			response.sendRedirect(request.getContextPath() + "/image/noimage.jpg");
            return;	
		}
		logger.info("Image for reimbursement " + r.getId() + " was processed.");
		String contentType = "image/gif";
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Length", String.valueOf(r.getReceiptByteArray().length));
		response.setHeader("Content-Disposition", "inline; filename=\"" + r.getId() + "\"");
		response.getOutputStream().write(r.getReceiptByteArray());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
