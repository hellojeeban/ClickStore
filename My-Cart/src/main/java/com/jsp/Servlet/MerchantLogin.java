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

import com.jsp.dao.MerchantDao;
import com.jsp.entities.Merchant;


/**
 * Servlet implementation class MerchantLogin
 */
@WebServlet("/merchantlogin")
public class MerchantLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MerchantLogin() {
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
			MerchantDao dao = new MerchantDao(Persistence.createEntityManagerFactory("jeeban"));
			Merchant merchant = dao.getUserByEmailAndPassword(email, password);

			// httpsession
			HttpSession httpSession = request.getSession();

			if (merchant == null) {
				httpSession.setAttribute("message", "Invalid User details! try with another one");
				response.sendRedirect("merchnatlogin.jsp");
			} else {

				// login
				httpSession.setAttribute("current-merchant", merchant);

				if (merchant.getStatus().equals("merchant")) {
					httpSession.setAttribute("message", "Hello Merchant " + merchant.getMname());
					response.sendRedirect("merchanthome.jsp");
				} else if (merchant.getStatus().equals("pending")) {
					httpSession.setAttribute("message", "Welcome " + merchant.getMname()+" Status is pending!");
					response.sendRedirect("merchantwaiting.jsp");
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
