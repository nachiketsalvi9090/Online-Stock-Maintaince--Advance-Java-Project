package com.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbconnection.DbConnection;
import com.operation.ProductOperations;
import com.utility.Product;

/**
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	Connection conn=DbConnection.getConnection();
	ProductOperations productOperations=new ProductOperations();
	int pid=productOperations.getMaxPid();
	Product product=new Product(pid,request.getParameter("pname"), Float.parseFloat(request.getParameter("pprice")), request.getParameter("pcateory"));
	boolean status=productOperations.productAdd(product);
	if(status)
	{
		//response.sendRedirect("DisplayProductDetailsServlet");

		RequestDispatcher rd = request
				.getRequestDispatcher("/DisplayProductDetailsServlet");
		request.setAttribute("type", "admin");
		rd.forward(request, response);
	}
	}

	
}
