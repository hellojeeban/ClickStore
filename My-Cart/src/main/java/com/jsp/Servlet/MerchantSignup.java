package com.jsp.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.MerchantDao;
import com.jsp.entities.Admin;
import com.jsp.entities.Merchant;



/**
 * Servlet implementation class MerchantSignup
 */

@WebServlet("/merchantsignup")
public class MerchantSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MerchantSignup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = null;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	    String phone = request.getParameter("phone");
	    address = request.getParameter("address");
	    
	    try {
	    	
	    // Admin
	    	Admin a = new Admin();
	    	
	    // creating user
	    Merchant m = new Merchant(name, email, password, phone, address, "pending");
	    
	    MerchantDao.addMerchant(m);
	    HttpSession httpSession = request.getSession();
	    httpSession.setAttribute("message", "Register Sucessfull ! "+name+" you Can Login Now");
	    response.sendRedirect("merchantlogin.jsp");
	    }catch (Exception e) {
	    	HttpSession httpSession = request.getSession();
		    httpSession.setAttribute("message", "Email name "+email+" is already Present");
		    response.sendRedirect("merchantsignup.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
