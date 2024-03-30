package com.controller;

import com.businessLogic.CategoryBL;
import com.businessLogic.ProductBL;
import com.javaBean.Category;
import com.javaBean.Product;
import com.javaBean.model.CategoryParent;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DetailServlet
 */
@WebServlet({"/DetailServlet","/detail.html"})
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;
	private CategoryBL categoryBL;
	private ProductBL productBL;


	public void init() throws ServletException {
		// Lấy SessionFactory từ ServletContext
		sessionFactory = (SessionFactory) getServletContext().getAttribute("sessionFactory");
		categoryBL = new CategoryBL(sessionFactory);
		productBL = new ProductBL(sessionFactory);
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		List<Category> categories = categoryBL.findAll();
		List<CategoryParent> categoryParents = categoryBL.getCategoryParent(categories);
		request.setAttribute("categoryParents", categoryParents);
		Product product = productBL.findById(productId);
		request.setAttribute("product", product);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
