package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.ReimbursementDTO;
import com.revature.dtos.ReqReimStatusDTO;
import com.revature.dtos.ReqReimbursementDTO;
import com.revature.exceptions.ReimbursementNotCreatedException;
import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.exceptions.ReimbursementStatusNotFoundException;
import com.revature.exceptions.ReimbursementStatusNotUpdatedException;
import com.revature.exceptions.ReimbursementTypeNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.services.AuthService;
import com.revature.services.ReimbursementService;
import com.revature.services.ReimbursementStatusService;
import com.revature.services.ReimbursementTypeService;
import com.revature.services.UserService;
import com.revature.services.ValidateService;
import com.revature.util.CorsFix;

/**
 * Servlet implementation class ReimbursementServlet
 */
public class ReimbursementServlet extends HttpServlet {
	private ReimbursementService rs = new ReimbursementService();
	private ReimbursementStatusService rss = new ReimbursementStatusService();
	private ReimbursementTypeService rt = new ReimbursementTypeService();
	private UserService us = new UserService();
	private AuthService as = new AuthService();
	private ObjectMapper om = new ObjectMapper();
	private ValidateService vs = new ValidateService();
	
//	@Override
//	protected void doOptions(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
//		super.doOptions(req, res);
//		CorsFix.addCorsHeader(req.getRequestURI(),res);
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
		String pathInfo = req.getPathInfo();
		
 			if (pathInfo == null) {

				List<Reimbursement> reimburse = rs.getReimburse();

				PrintWriter pw = resp.getWriter();
				List<ReimbursementDTO> reimDTO = new ArrayList<>();
				reimburse.forEach(r -> reimDTO.add(new ReimbursementDTO(r)));
				pw.write(om.writeValueAsString(reimDTO));
				pw.close();
				resp.setStatus(200);

			} else {
				
				int id = Integer.parseInt(pathInfo.substring(1));
				try {
					ReimbursementDTO reimDTO = new ReimbursementDTO(rs.getByID(id));
					PrintWriter pw = resp.getWriter();
					pw.write(om.writeValueAsString(reimDTO));
					pw.close();
				} catch (ReimbursementNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		

	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
		super.doOptions(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CorsFix.addCorsHeader(req.getRequestURI(), resp);

		InputStream reqBody = req.getInputStream();

		ReqReimbursementDTO newReimbursementDTO = om.readValue(reqBody, ReqReimbursementDTO.class);
		Reimbursement newReimbursement = new Reimbursement();
		Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
			
		try {
			newReimbursement.setAmount(newReimbursementDTO.getAmount());
			newReimbursement.setDescription(newReimbursementDTO.getDescription());
			newReimbursement.setAuthor(us.getUserById(newReimbursementDTO.getAuthor_id()));
			newReimbursement.setReim_status(rss.getReimbursementStatusById(1));
			newReimbursement.setReim_type(rt.getReimbursementTypeById(newReimbursementDTO.getReimb_type_id()));
			newReimbursement.setSubmitted(timestamp1);
			
			Reimbursement newR = rs.insertReimbursement(newReimbursement);
			try (PrintWriter pw = resp.getWriter()) {
				pw.write(1);
				resp.setStatus(200);
			}
		} catch (ReimbursementNotCreatedException | UserNotFoundException | ReimbursementStatusNotFoundException
				| ReimbursementTypeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPut(req, resp);
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
		String pathInfo = req.getPathInfo();
		InputStream reqBody = req.getInputStream();

		if (vs.checkManager(req, resp) == true) {
			ReqReimStatusDTO statusDTO = om.readValue(reqBody, ReqReimStatusDTO.class);

 			int id = Integer.parseInt(pathInfo.substring(1));
 			if (vs.checkManager(req, resp) == true) {
				statusDTO.setId(id);
					

				try {
					ReimbursementDTO reimDTO = new ReimbursementDTO(rs.getByID(id));
						
   					if(reimDTO.getReim_status().getStatus().equals("pending")) {
 						rs.setStatusByID(statusDTO.getId(), statusDTO.getUser_id(), statusDTO.getStatus());
 						try (PrintWriter pw = resp.getWriter()) {
 							reimDTO = new ReimbursementDTO(rs.getByID(id));
 							pw.write(om.writeValueAsString(reimDTO));
 							resp.setStatus(200);
 							pw.close();
 						}
 					} else {
 						vs.messageWrite(req, resp, 409);
 					}					
				} catch (ReimbursementNotFoundException | ReimbursementStatusNotUpdatedException e) {
					// TODO Auto-generated catch block
					vs.messageWrite(req, resp, 404);

					e.printStackTrace();
				}
			}

		}

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}
