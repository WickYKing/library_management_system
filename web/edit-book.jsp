
<%@page import="com.lms.util.Database"%>
<%@page import="com.lms.models.User"%>
<%@page import="com.lms.models.Book"%>
<%@page import="com.lms.models.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.lms.daoimpl.BookDaoImpl"%>
<%@page import="com.lms.dao.BookDao"%>
<%@page import="com.lms.daoimpl.CategoryDaoImpl"%>
<%@page import="com.lms.dao.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <%
    
    CategoryDao categoryDaoImpl = new CategoryDaoImpl(Database.getConnection());
    BookDao bookDaoImpl = new BookDaoImpl(Database.getConnection());
    
    List<Category> allCategories = categoryDaoImpl.getAllCategory();
    
    Integer id = Integer.parseInt(request.getParameter("id"));
    Book book = bookDaoImpl.getBookById(id);
   	
    Category category = categoryDaoImpl.getCategoryById(book.getCategory().getId());
    
 session = request.getSession();
 User user = (User) session.getAttribute("user");
 
 if(user != null){ %>
 
  <% String action = "update"; %> 
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Update Book</title>
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
                    <form method="Post" action="Book?id=<%=book.getId() %>&&action=<%= action%>">
                        <div class="form-row profile-row">
                            <div class="col-md-8">
                                <h1 class="text-center" style="color: rgb(31,40,81);">Update Book</h1>
                                <hr style="background-color: rgb(31,40,81);">
                                <div class="form-row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group"><label style="color: rgb(31,40,81);font-weight: bold;font-size: 16px;">Title</label><input class="form-control" value = <%=book.getTitle() %> type="text" name="title" style="border-color: rgb(31,40,81);color: rgb(31,40,81);font-size: 14px;"></div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group"><label style="color: rgb(31,40,81);font-weight: bold;font-size: 16px;">Author&nbsp;</label><input class="form-control" value=<%=book.getAuthor() %> type="text" name="author" style="border-color: rgb(31,40,81);color: rgb(31,40,81);font-size: 14px;"></div>
                                    </div>
                                </div>
                                <div class="form-group"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Category</label>
                                <select name="category" class="custom-select" style="color: rgb(31,40,81);border-color: rgb(31,40,81);">
                                <optgroup label="Select category">
                   
                                <%for(Category c: allCategories){ 
                                	
                                	if(c.getCategory().equalsIgnoreCase(category.getCategory())){}else{
                                %>
                                	
                                	<option value="<%=c.getCategory() %>" selected=<%=category.getCategory() %>><%=c.getCategory() %></option>
                                	
                                <%}} %>
                                
                                <option value="<%=category.getCategory() %>" selected=<%=category.getCategory() %>><%=category.getCategory() %></option>
                                
                                </optgroup></select></div>
                                <div
                                    class="form-group"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">No of Copies</label><input name="no-of-copies" value=<%=book.getNoOfCopies() %> class="form-control" type="number" style="border-color: rgb(31,40,81);"></div>
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
