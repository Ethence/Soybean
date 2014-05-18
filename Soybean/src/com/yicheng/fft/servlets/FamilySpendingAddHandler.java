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
@WebServlet(description = "handler for add new spending items", urlPatterns = { "/AddFamilySpendingItems" })
public class FamilySpendingAddHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FamilySpendingAddHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int peopleId = Integer.parseInt(request.getParameter("newSpendingSpender"));
        String date = request.getParameter("newSpendingDate");
        double amount = Double.parseDouble(request.getParameter("newSpendingAmount"));
        String desc = request.getParameter("newSpendingDescription");
        int catId = Integer.parseInt(request.getParameter("newSpendingCategory"));
        int payId = Integer.parseInt(request.getParameter("newSpendingPayMethod"));
        
        ServletContext context = getServletContext();
        DataService ds = (DataService) context.getAttribute("data");
        ds.addFamilySpendingItem(date, amount, desc, catId, payId, peopleId);
        PrintWriter out = response.getWriter();
        out.println(peopleId);
        out.println(date);
        out.println(amount);
        out.println(desc);
        out.println(catId);
        out.println(payId);
        /*
        response.setContentType("application/json");
        ServletContext context = getServletContext();
        DataService ds = (DataService) context.getAttribute("data");
        PrintWriter out = response.getWriter();
        out.println(ds.getFamilySpendingItems());
        */
    }

}
