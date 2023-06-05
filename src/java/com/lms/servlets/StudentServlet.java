package com.lms.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.dao.RoleDao;
import com.lms.dao.StudentDao;
import com.lms.daoimpl.RoleDaoImpl;
import com.lms.daoimpl.StudentDaoImpl;
import com.lms.models.Role;
import com.lms.models.Student;
import com.lms.models.User;
import com.lms.util.Database;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/Student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RoleDao roleDaoImpl = new RoleDaoImpl(Database.getConnection());
	StudentDao studentDaoImpl = new StudentDaoImpl(Database.getConnection());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
                String roll_no = request.getParameter("roll_no");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String sDate1= request.getParameter("date-of-birht");
		
		 Date date = null;
		try {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = dateFormat.parse(sDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		String action = request.getParameter("action");
		
		Student student = null;
		Integer result = null;
		
		System.out.print("Action is: "+action);
		
		switch (action) {
		case "add":
			student = new Student();
			student.setName(firstname+" "+lastname);
                        student.setRollNo(roll_no);
			student.setEmail(email);
			student.setDateOfBirth(date);
			student.setContact(contact);
			
			Role createdBy = roleDaoImpl.getRoleById(u.getRole().getId());
			student.setCreatedBy(createdBy);
			
			result = studentDaoImpl.addStudent(student);
			
			if (result > 0) {
				response.sendRedirect("view-student.jsp");
			}
			break;
                        
                case "update":
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			student = studentDaoImpl.getStudentById(id);
			
			student.setName(firstname+" "+lastname);
                        student.setRollNo(roll_no);
			student.setEmail(email);
			student.setDateOfBirth(date);
			student.setContact(contact);		

//                  Role  createdBy = roleDaoImpl.getRoleById(u.getRole().getId());
//			student.setCreatedBy(createdBy);
			
			
			result = studentDaoImpl.updateStudent(student);
			
			if (result > 0) {
				response.sendRedirect("view-student.jsp");
			}
			break;
		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			
			
			result = studentDaoImpl.deleteStudent(id);
			
			if (result > 0) {
				response.sendRedirect("view-student.jsp");
			}
			break;
			
		default:
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
