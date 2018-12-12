package com.servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.operation.ProductOperations;
import com.operation.UserOperation;
import com.dbconnection.DbConnection;


import com.utility.Product;

/**
 * Servlet implementation class DisplayProductDetailsServlet
 */
public class DisplayProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayProductDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	Connection conn = null;

	@Override
	public void init() throws ServletException {
		conn = DbConnection.getConnection();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		
		ProductOperations product1 = new ProductOperations();

		ArrayList<Product> list = product1.getProductDetails();
		HttpSession session = req.getSession();
		
		session.setAttribute("productlistList", list);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/DisplayProductDetails.jsp");
		
		rd.forward(req, resp);
		
	}

	@Override
	public void destroy() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
