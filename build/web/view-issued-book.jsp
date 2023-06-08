
<%@page import="com.lms.models.User"%>
<%@page import="com.lms.models.Student"%>
<%@page import="com.lms.models.Book"%>
<%@page import="com.lms.models.Issue"%>
<%@page import="java.util.List"%>
<%@page import="com.lms.daoimpl.UserDaoImpl"%>
<%@page import="com.lms.dao.UserDAO"%>
<%@page import="com.lms.daoimpl.StudentDaoImpl"%>
<%@page import="com.lms.dao.StudentDao"%>
<%@page import="com.lms.daoimpl.BookDaoImpl"%>
<%@page import="com.lms.dao.BookDao"%>
<%@page import="com.lms.daoimpl.CategoryDaoImpl"%>
<%@page import="com.lms.dao.CategoryDao"%>
<%@page import="com.lms.util.Database"%>
<%@page import="com.lms.daoimpl.IssueDaoImpl"%>
<%@page import="com.lms.dao.IssueDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>



<%

    IssueDao issueDaoImpl = new IssueDaoImpl(Database.getConnection());
    CategoryDao categoryDaoImpl = new CategoryDaoImpl(Database.getConnection());
    BookDao bookDaoImpl = new BookDaoImpl(Database.getConnection());
    StudentDao studentDaoImpl = new StudentDaoImpl(Database.getConnection());
    UserDAO userDaoImpl = new UserDaoImpl(Database.getConnection());

    List<Issue> allIssuedBooks = issueDaoImpl.getAllIssue();

    session = request.getSession();
    User user = (User) session.getAttribute("user");

    String action = "return";

    if (user != null) {
%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Books</title>
        <%@ include file="links.jsp" %> 
    </head>

    <body style="margin: -20px 0px;background-color: #fff;">
        <%@ include file="navbar.jsp" %>  
        <div class="article-clean" style="background-color: #fff;">
            <div class="container" style="background-color: #fff;">
                <div class="intro">
                    <h1 class="text-center" style="color: rgb(31,40,81);font-weight: bold;">Issued Books</h1>
                    <p class="text-center"> </p>
                </div>
                <% if (allIssuedBooks.size() > 0) {%>
                <div class="table-responsive shadow" style="background-color: #fff;">
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <!--<th style="color: rgb(31,40,81);font-size: 18px;">Issue</th>-->
                                <th style="color: rgb(31,40,81);font-size: 18px;font-family: Lora, serif;">ID</th>
                                <th style="color: rgb(31,40,81);font-size: 18px;">Book Id</th>
                                <th style="color: rgb(31,40,81);font-size: 18px;">Student</th>
                                <th style="color: rgb(31,40,81);font-size: 18px;">Issue Date</th>
                                <th style="color: rgb(31,40,81);font-size: 18px;">Issue By</th>
                                <th style="color: rgb(31,40,81);font-size: 18px;">Status</th>
                                
                                <!--<th>Action</th>-->
                                <!--                                <th style="color: rgb(31,40,81);font-size: 18px;font-family: Lora, serif;">ID</th>
                                                                <th style="color: rgb(31,40,81);font-size: 18px;">Book</th>
                                                                <th style="color: rgb(31,40,81);font-size: 18px;">Student</th>
                                                                <th style="color: rgb(31,40,81);font-size: 18px;">Issue Date</th>
                                                                <th style="color: rgb(31,40,81);font-size: 18px;">Issued By</th>-->
                                <th class="text-center" colspan="2" style="color: rgb(31,40,81);font-size: 18px;">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (Issue issue : allIssuedBooks) {
                                    Book book = bookDaoImpl.getBookById(issue.getBook().getId());
                                    Student student = studentDaoImpl.getStudentById(issue.getStudent().getId());

                                    User u = userDaoImpl.getUserById(issue.getIssuedBy().getId());

                            %>

                            <tr>
                                <td><%= issue.getId() %></td>
                                <td><%= issue.getBook().getId() %></td>
                                <td><%= issue.getStudent().getId() %></td>
                                <td><%= issue.getIssueDate() %></td>
                                <td><%= user.getName() %></td>
                                <td><%= issue.getStatus() %></td>
                                
                                <td style="width: 36px;"><a href="Issue?id=<%=issue.getId()%>&&action=<%=action %>" style="text-decoration: none;font-weight: bold;"><button>RETURN</button></a></td>

                            </tr>
                            <%} %>
                        </tbody>
                    </table>
                </div>
                <%} else { %>

                <center><h1>No Books</h1></center>
                    <%} %>
            </div>
        </div>
        <%@ include file="scripts.jsp" %> 
    </body>

</html>
<%} else {
        response.sendRedirect("login.jsp");
    }%>