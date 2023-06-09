package com.lms.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.dao.BookDao;
import com.lms.dao.CategoryDao;
import com.lms.dao.IssueDao;
import com.lms.dao.RoleDao;
import com.lms.dao.StudentDao;
import com.lms.daoimpl.BookDaoImpl;
import com.lms.daoimpl.CategoryDaoImpl;
import com.lms.daoimpl.IssueDaoImpl;
import com.lms.daoimpl.RoleDaoImpl;
import com.lms.daoimpl.StudentDaoImpl;
import com.lms.models.Book;
import com.lms.models.Category;
import com.lms.models.Issue;
import com.lms.models.Role;
import com.lms.models.Student;
import com.lms.models.User;
import com.lms.util.Database;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/Book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDao categoryDaoImpl = new CategoryDaoImpl(Database.getConnection());
	BookDao bookDaoImpl = new BookDaoImpl(Database.getConnection());
	RoleDao roleDaoImpl = new RoleDaoImpl(Database.getConnection());
	static StudentDao studentDaoImpl = new StudentDaoImpl(Database.getConnection());
	IssueDao issueDaoImpl = new IssueDaoImpl(Database.getConnection());
	
	List<Student> allStudents = studentDaoImpl.getAllStudent();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		String bookcode= request.getParameter("bookcode");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String categoryName = request.getParameter("category");
		
		Category category = categoryDaoImpl.getCategoryById(categoryDaoImpl.getIdByName(categoryName));
		

		
		String action = request.getParameter("action");
		
		System.out.print("Action: "+action);
		System.out.print("No of copies: "+request.getParameter("no_of_copies"));
		
		Book book = null;
		Integer id = null;
		Integer result = null;
		switch (action) {
		
		case "add":
			Integer noOfCopies = Integer.parseInt(request.getParameter("no_of_copies"));
			book = new Book();
                        book.setTitle(title);
			book.setBookCode(generateBookCode());
			book.setAuthor(author);
			book.setCategory(category);
			book.setNoOfCopies(noOfCopies);
			book.setCreatedBy(u.getRole());
			
			result = bookDaoImpl.addBook(book);
			if (result > 0) {
				response.sendRedirect("view-book.jsp");
			}
			break;

		case "update":
			
			noOfCopies = Integer.parseInt(request.getParameter("no_of_copies"));
                        id = Integer.parseInt(request.getParameter("id"));
                        
			book = bookDaoImpl.getBookById(id);
			book.setTitle(title);
			book.setAuthor(author);
			book.setCategory(category);
			book.setNoOfCopies(noOfCopies);
			
			//Role role = new Role();
                        Role updatedBy = roleDaoImpl.getRoleById(u.getRole().getId());
			//role.setId(u.getRole().getId());
			
			book.setUpdatedBy(updatedBy);
			
			result = bookDaoImpl.updateBook(book);
			System.out.print("Result : "+result);
			if (result > 0) {
				response.sendRedirect("view-book.jsp");
			}
			
			break;
		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			result = bookDaoImpl.deleteBook(id);
			
			if (result > 0) {
				response.sendRedirect("view-book.jsp");
			}else {
				response.getWriter().print("Error in deleting book!");
			}
			break;
			
		case "issue":
			String[] selectedStudentIds = request.getParameterValues("selected");
			
			String studentRoll = request.getParameter("student-roll-no");
			
			Integer studentId = studentDaoImpl.getIdByRollNo(studentRoll);
			
			
			Student student = studentDaoImpl.getStudentById(studentId);
			
			for(int i=0; i<selectedStudentIds.length; i++) {
				Integer bookId = Integer.parseInt(selectedStudentIds[i]);
				
				Book book2 = bookDaoImpl.getBookById(bookId);
				Role createdBy = roleDaoImpl.getRoleById(u.getRole().getId());
                            				
				Issue issue = new Issue();
				issue.setBook(book2);
				issue.setStudent(student);
				issue.setCreatedBy(createdBy);
				issue.setIssuedBy(u);
                                
				
				result = issueDaoImpl.addIssue(issue);
	

			}
			if (result > 0) {
				response.sendRedirect("view-issued-book.jsp");
			}else {
				response.getWriter().print("Error in deleting book!");
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
	
	static public String generateBookCode() {

        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        // Using random method 
        Random rndm_method = new Random();

        String code = "";

        for (int i = 0; i < 6; i++) {
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int
            if (i == 2) {
                code += "-";
            }
            if (i == 0 || i == 1) {
            	code += Capital_chars.charAt(rndm_method.nextInt(Capital_chars.length()));
            } else {
            	code += numbers.charAt(rndm_method.nextInt(numbers.length()));
            }
        }
        return code;
    }
	
	
	
}
