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

    session = request.getSession();
    User user = (User) session.getAttribute("user");

    if (user != null) {
        String action = "update";
%>

<!DOCTYPE html>

