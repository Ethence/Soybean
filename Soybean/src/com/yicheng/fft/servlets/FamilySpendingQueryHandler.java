package com.yicheng.fft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yicheng.fft.data.DataService;

/**
 * Servlet implementation class FamilySpendingQueryHandler
 */
@WebServlet(description = "handling requests for the family spending items", urlPatterns = { "/GetFamilySpendingItems" })
public class FamilySpendingQueryHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FamilySpendingQueryHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    response.setContentType("application/json");
	    ServletContext context = getServletContext();
	    DataService ds = (DataService) context.getAttribute("data");
	    PrintWriter out = response.getWriter();
	    out.println(ds.getFamilySpendingItems());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
