package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.operation.ProductOperations;


public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Product product=new Product(Integer.parseInt(request.getParameter("pid")), request.getParameter("pname"), Float.parseFloat(request.getParameter("pprice")), request.getParameter("pcatagory"));
		
		ProductOperations productOperations=new ProductOperations();
		boolean status=productOperations.productDetele(Integer.parseInt(request.getParameter("pid"))) ;
		if(status)
		{

			RequestDispatcher rd = request
					.getRequestDispatcher("/DisplayProductDetailsServlet");
			request.setAttribute("type", "admin");
			rd.forward(request, response);
		
		}
	}

}
