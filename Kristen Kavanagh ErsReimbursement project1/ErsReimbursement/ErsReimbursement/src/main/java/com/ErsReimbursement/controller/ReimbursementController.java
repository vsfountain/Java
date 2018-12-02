package com.ErsReimbursement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ErsReimbursement.model.Reimbursement;
import com.ErsReimbursement.model.User;
import com.ErsReimbursement.service.ReimbursementService;
import com.ErsReimbursement.service.ReimbursementServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimbursementController {
	final static Logger logger = Logger.getLogger(ReimbursementController.class);



	private static ReimbursementService imbur = new ReimbursementServiceImpl();

	public static String InsertReimbursement(HttpServletRequest req, HttpServletResponse resp) {

		double reimb_amount = Double.parseDouble(req.getParameter("reimb_amount"));
		String reimb_description = req.getParameter("reimb_description");
		User logUser = (User) req.getSession().getAttribute("logUser");
		int reimb_author = logUser.getUserId();
		int reimb_status_id = 3;
		int reimb_type_id = Integer.parseInt(req.getParameter("reimb_type_id"));

		Reimbursement newReimb = new Reimbursement(reimb_amount, reimb_description, reimb_author, reimb_status_id,
				reimb_type_id);
		System.out.println("in HC at IR " + newReimb);
		imbur.InsertReimbursement(newReimb);

		if (newReimb != null) {

			req.getSession().setAttribute("loggedamount", reimb_amount);
			req.getSession().setAttribute("loggeddescription", reimb_description);
			req.getSession().setAttribute("loggedauthor", reimb_author);
			req.getSession().setAttribute("loggedstatusid", reimb_status_id);
			req.getSession().setAttribute("loggedtypeid", reimb_type_id);
		}
		return "pendingrequest.html";

	}

	public static String viewReimbursement(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		User logUser = (User) req.getSession().getAttribute("logUser");
		ArrayList<Reimbursement> arryreimb = imbur.selectAllReimburse();
		System.out.println("ReimburseLIST: " + arryreimb);
		//change to if user id = author id display
		// sort table to order by date
		System.out.println("value of userId: " +logUser.getUserId());
		if (logUser.getUserId() == 4) {
			resp.getWriter().write(new ObjectMapper().writeValueAsString(arryreimb));
		} else {
			
			List<Reimbursement> individualReimb = new ArrayList<Reimbursement>();
			for (Reimbursement rem : arryreimb) {
				if ((rem.getRemb_Author()) == (logUser.getUserId())) {
					individualReimb.add(rem);
				}
			}
			resp.getWriter().write(new ObjectMapper().writeValueAsString(individualReimb));

		}
		return "ViewReimbursement.html";
	}
/**
 * employye can view peding reimbursement
 * @param req
 * @param resp
 * @return
 * @throws JsonProcessingException
 * @throws IOException
 */
	public static String updateReimbursementByStatusId(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		User logUser = (User) req.getSession().getAttribute("logUser");
		Reimbursement loggedUser = (Reimbursement) req.getSession().getAttribute("loggeduser");
		ArrayList<Reimbursement> checkedVal = imbur.selectAllReimburse();
		if ( logUser.getUserId()== loggedUser.getRemb_Author() & loggedUser.getRemb_Status_Id() == 3) {
			resp.getWriter().write(new ObjectMapper().writeValueAsString(checkedVal));
		}
			return "pendingEmployeeReimbursement.html";
		
	}
	/**
	 * employee can view approved reimbursement
	 * @param req
	 * @param resp
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static String updateapprovedReimbursementByStatusId(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		User logUser = (User) req.getSession().getAttribute("logUser");
		Reimbursement loggedUser = (Reimbursement) req.getSession().getAttribute("loggeduser");
		ArrayList<Reimbursement> checkedVal = imbur.selectAllReimburse();
		if ( logUser.getUserId()== loggedUser.getRemb_Author() & loggedUser.getRemb_Status_Id() == 1) {
			resp.getWriter().write(new ObjectMapper().writeValueAsString(checkedVal));
		}
			return "ApprovedEmployeeReimbursement.html";
		
	}
	/**
	 *  Manger can approve  reimbursement based on current status
	 * @param req
	 * @param resp
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	
	
	public static String updateapprovedReimbursementByStatusIdForManager(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		User logUser = (User) req.getSession().getAttribute("logUser");
		Reimbursement loggedUser = (Reimbursement) req.getSession().getAttribute("loggeduser");
		ArrayList<Reimbursement> checkedVal = imbur.selectAllReimburse();
		int reimburseId = Integer.parseInt(req.getParameter("reimburseId"));
		
		imbur.updateapprovedReimbursementByStatusId(logUser.getUserName(), logUser.getUserName(), reimburseId);
			return "ViewReimbursement.html";
		
	}
	
	public static String updatedeclinedReimbursementByStatusIdForManager(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		User logUser = (User) req.getSession().getAttribute("logUser");
		Reimbursement loggedUser = (Reimbursement) req.getSession().getAttribute("loggeduser");
		ArrayList<Reimbursement> checkedVal = imbur.selectAllReimburse();
		int reimburseId = Integer.parseInt(req.getParameter("reimburseId"));
	
		imbur.updatedeclinedReimbursementByStatusId(logUser.getUserName(), logUser.getUserName(), reimburseId);
			return "ViewReimbursement.html";
		
	}

	public static String updateDeniedReimbursementByStatusId(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		User logUser = (User) req.getSession().getAttribute("logUser");
		Reimbursement loggedUser = (Reimbursement) req.getSession().getAttribute("loggeduser");
		ArrayList<Reimbursement> checkedVal = imbur.selectAllReimburse();
		if ( logUser.getUserId()== loggedUser.getRemb_Author() & loggedUser.getRemb_Status_Id() == 2) {
			resp.getWriter().write(new ObjectMapper().writeValueAsString(checkedVal));
		}
			return "DeniedEmployeeReimbursement.html";
		
	}
}


