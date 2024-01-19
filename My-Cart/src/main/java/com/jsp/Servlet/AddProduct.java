package com.jsp.Servlet;

import java.io.IOException;

import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.CategoryDao;
import com.jsp.dao.ProductDao;
import com.jsp.entities.Category;
import com.jsp.entities.Product;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/addproduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Fetching Product Data
				String name = request.getParameter("productname");
				String desc = request.getParameter("productdesc");
				double price = Double.parseDouble(request.getParameter("productprice"));
				int discount = Integer.parseInt(request.getParameter("productdiscount"));
				int quantity = Integer.parseInt(request.getParameter("productquantity"));
				int catId = Integer.parseInt(request.getParameter("optCat"));
				
				CategoryDao catDao = new CategoryDao(Persistence.createEntityManagerFactory("jeeban"));
				Category cat = catDao.getCategoryById(catId);
				try {
					Product p = new Product(name, desc, price, discount, quantity, cat);
					ProductDao.addProduct(p); 
					HttpSession httpSession = request.getSession();
				    httpSession.setAttribute("message", "Adding "+name+" sucessful !");
				    response.sendRedirect("merchanthome.jsp");
				}catch (Exception e) {
					HttpSession httpSession = request.getSession();
				    httpSession.setAttribute("message", "Adding "+name+" not sucessful !");
				    response.sendRedirect("merchanthome.jsp");
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
