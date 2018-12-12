package com.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.operation.UserOperation;
import com.utility.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void init() throws ServletException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)	throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			// HttpSession session = request.getSession();
			String uname = request.getParameter("uname");

			String password = request.getParameter("password");
			User user=new User(uname, password, "");
			UserOperation userOperation=new UserOperation();
			boolean status=userOperation.validateUser(user);

			if (status) {
				
				
				String type=userOperation.findUserType(uname, password);
				HttpSession session = request.getSession();
				session.setAttribute("type",type);				
				RequestDispatcher rd = request
						.getRequestDispatcher("/DisplayProductDetailsServlet");
				rd.forward(request, response);
				
			} else {
				response.sendRedirect("InvalidUser.html");
			}
		
	}

	@Override
	public void destroy() {
	}
}
