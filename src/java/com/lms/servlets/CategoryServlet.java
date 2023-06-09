package com.lms.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.dao.CategoryDao;
import com.lms.dao.RoleDao;
import com.lms.daoimpl.CategoryDaoImpl;
import com.lms.models.Category;
import com.lms.models.User;
import com.lms.util.Database;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/Category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CategoryDao categoryDaoImpl = new CategoryDaoImpl(Database.getConnection());
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		
		String category = null;
		Integer result = null;
		
		String action = request.getParameter("action");
		
		switch (action) {
		case "add":
			category = request.getParameter("category");
			
			Category c = new Category();
			c.setCategory(category);
			c.setCreatedBy(u.getRole());
			
			result = categoryDaoImpl.addCategory(c);
			
			if (result > 0) {
				response.sendRedirect("view-category.jsp");
			}
			
			break;
			
		case "update":
			Integer id = Integer.parseInt(request.getParameter("id"));
			category = request.getParameter("category");
			
			c = categoryDaoImpl.getCategoryById(id);
			
			c.setCategory(category);
			c.setUpdatedBy(u.getRole());
			
			result = categoryDaoImpl.updateCategory(c);
			
			if (result > 0) {
				response.sendRedirect("view-category.jsp");
			}
			
			break;
			
		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			
			
			result = categoryDaoImpl.deleteCategory(id);
			
			if (result > 0) {
				response.sendRedirect("view-category.jsp");
			}
			
			break;

		
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
