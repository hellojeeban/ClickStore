package com.jsp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.AdminDao;
import com.jsp.entities.Admin;


/**
 * Servlet implementation class AdminLogin
 */

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			// Validation

			// Authentication User
			AdminDao dao = new AdminDao(Persistence.createEntityManagerFactory("jeeban"));
			Admin admin = dao.getUserByEmailAndPassword(email, password);
			System.out.println(admin.getUserType());
			//httpsession
			HttpSession httpSession = request.getSession();
		    
			if (admin == null) {
				httpSession.setAttribute("message", "Invalid User details! try with another one");
			    response.sendRedirect("adminlogin.jsp");
			}else {
			    
			    //login
			    httpSession.setAttribute("current-admin", admin);
			    
			    if(admin.getUserType().equals("admin")) {
			    	httpSession.setAttribute("message", "Hello Admin "+admin.getUserName());
			    	response.sendRedirect("admin.jsp");
			    }else if(admin.getUserType().equals("normal_user")){
			    	httpSession.setAttribute("message", "Welcome "+admin.getUserName());
				    response.sendRedirect("index.jsp");
			    }
			    
			}
		} catch (Exception e) {
			e.printStackTrace();
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
