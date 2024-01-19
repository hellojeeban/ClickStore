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

import org.hibernate.SessionFactory;

import com.jsp.dao.UserDao;
import com.jsp.entities.UserEntity;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			// Validation

			// Authentication User
			UserDao dao = new UserDao(Persistence.createEntityManagerFactory("jeeban"));
			UserEntity user = dao.getUserByEmailAndPassword(email, password);
			
			//httpsession
			HttpSession httpSession = request.getSession();
		    
			if (user == null) {
				httpSession.setAttribute("message", "Invalid User details! try with another one");
			    response.sendRedirect("login.jsp");
			}else {
			    
			    //login
			    httpSession.setAttribute("current-user", user);
			    
			    if(user.getUserType().equals("admin")) {
			    	httpSession.setAttribute("message", "Hello Admin "+user.getUserName());
			    	response.sendRedirect("admin.jsp");
			    }else if(user.getUserType().equals("normal_user")){
			    	httpSession.setAttribute("message", "Welcome "+user.getUserName());
				    response.sendRedirect("index.jsp");
			    }
			    
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
