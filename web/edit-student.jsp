<%@page import="com.lms.models.User"%>
<%@page import="com.lms.models.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.lms.daoimpl.StudentDaoImpl"%>
<%@page import="com.lms.dao.StudentDao"%>
<%@page import="com.lms.util.Database"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
    StudentDao studentDaoImpl = new StudentDaoImpl(Database.getConnection());
    List<Student> allStudents = studentDaoImpl.getAllStudent();

    Integer id = Integer.parseInt(request.getParameter("id"));
    Student student = studentDaoImpl.getStudentById(id);

    session = request.getSession();
    User user = (User) session.getAttribute("user");
    
    // String[] names = student.getName().split(" ");


    if (user != null) {
        String action = "update";
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Update Student</title>
   <%@ include file="links.jsp" %>
</head>

<body style="font-family: Lora, serif;background-color: #fff;">
    <%@ include file="navbar.jsp" %>  
    <div class="article-clean">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-8 offset-lg-1 offset-xl-2">
                    <div class="intro"></div>
                    <% %>
                    <form method="Post" action="Student?id=<%=student.getId() %>&&action=<%= action%>">
                        <div class="form-row profile-row">
                            <div class="col-md-8">
                                <h1 class="text-center" style="color: rgb(31,40,81);">Update Student</h1>
                                <hr style="background-color: rgb(31,40,81);">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group"><label style="color: rgb(31,40,81);font-weight: bold;font-size: 16px;">First Name </label><input class="form-control" type="text" name="firstname" style="border-color: rgb(31,40,81);color: rgb(31,40,81);font-size: 14px;"></div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group"><label style="color: rgb(31,40,81);font-weight: bold;font-size: 16px;">Last Name </label><input class="form-control" type="text" name="lastname" style="border-color: rgb(31,40,81);color: rgb(31,40,81);font-size: 14px;"></div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group"><label style="color: rgb(31,40,81);font-weight: bold;font-size: 16px;">Roll No </label><input class="form-control" type="text" name="roll_no" style="border-color: rgb(31,40,81);color: rgb(31,40,81);font-size: 14px;"></div>
                                    </div>
                                 <div class="col-sm-12 col-md-6">
                                <div class="form-group"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Email </label><input class="form-control" type="email" autocomplete="off" required="" name="email" style="border-color: rgb(31,40,81);color: rgb(31,40,81);font-size: 14px;"></div>
                                </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Contact</label><input name="contact" class="form-control" type="tel" style="border-color: rgb(31,40,81);color: rgb(31,40,81);font-size: 14px;"></div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Date of Birth</label><input name="date-of-birth" class="form-control" type="date" style="border-color: rgb(31,40,81);font-size: 14px;color: rgb(31,40,81);"></div>
                                    </div>
                          
                            <hr style="background-color: #fff;">
                            <div class="form-row">
                                <div class="col-md-12 content-right"><button class="btn btn-primary form-btn" type="submit" style="background-color: rgb(31,40,81);border-color: rgb(31,40,81);">Update</button><button class="btn btn-danger form-btn" type="reset" style="background-color: rgb(31,40,81);border-color: rgb(31,40,81);">CANCEL </button></div>
                            </div>
                        </div>
                </div>
                </form>
            </div>
        </div>
    </div>
    </div>
    <%@ include file="scripts.jsp" %>
</body>

</html>

<%}else{
	response.sendRedirect("login.jsp");
} %>
