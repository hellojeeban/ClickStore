package com.jsp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.CategoryDao;
import com.jsp.entities.Category;

/**
 * Servlet implementation class AddCategory
 */
@WebServlet("/addcategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Fetching category Data
		String titel = request.getParameter("categoryTitel");
		String desc = request.getParameter("categoryDesc");
		try {
			Category cat = new Category(titel, desc, null);
			CategoryDao.addCategory(cat);
			
			HttpSession httpSession = request.getSession();
		    httpSession.setAttribute("message", "Adding "+titel+" sucessful !");
		    response.sendRedirect("merchanthome.jsp");
		}catch (Exception e) {
			HttpSession httpSession = request.getSession();
		    httpSession.setAttribute("message", "Adding "+titel+" not sucessful !");
		    response.sendRedirect("merchanthome.jsp");
		}
	}

}
