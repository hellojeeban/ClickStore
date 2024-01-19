package com.jsp.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.AdminDao;
import com.jsp.entities.Admin;
import com.jsp.entities.Merchant;

/**
 * Servlet implementation class AddAdmin
 */
@WebServlet("/addAdmin")
public class AddAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAdmin() {
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
			// creating user
			Admin a = new Admin("admin", "admin@gmail.com", "admin", null, "admin", null);

			AdminDao.addAdmin(a);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("message", "Register Sucessfull ! you Can Login Now");
			response.sendRedirect("adminlogin.jsp");
		} catch (Exception e) {

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
