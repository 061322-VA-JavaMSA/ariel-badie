package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.UserDTO;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.util.CorsFix;

/**
 * Servlet implementation class AuthServlet
 */
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthService as = new AuthService();  
    private ObjectMapper om = new ObjectMapper();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		//res.addHeader("Content-Type", "application/json");


		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//System.out.println(username +' '+ password );
		try {
			User principal = as.login(username, password);
 			HttpSession session = req.getSession();
			session.setAttribute("userId", principal.getId());
			session.setAttribute("userName", principal.getUsername());
			session.setAttribute("userRole", principal.getRole().getRole());

			// To make Chrome work with our cookie
			String cookie = res.getHeader("Set-Cookie") + "; SameSite=None; Secure";
			res.setHeader("Set-Cookie", cookie);
 
			UserDTO principalDTO = new UserDTO(principal);
			try (PrintWriter pw = res.getWriter()) {
				pw.write(om.writeValueAsString(principalDTO));
				res.setStatus(200);
			}

		} catch (UserNotFoundException | LoginException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		HttpSession session = req.getSession();
		session.invalidate();
	}
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		super.doOptions(req, res);
	}
}
