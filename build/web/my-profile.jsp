<%@page import="com.lms.models.User"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>



<%
    session = request.getSession();
    User user = (User) session.getAttribute("user");

    //String[] names = user.getName().split(" ");
    if (user != null) {
%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>My Profile</title>
        <%@ include file="links.jsp" %> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">

    </head>

    <body>
        <%@ include file="navbar.jsp" %>  
        <div class="article-clean">
            <div class="container">
                <div class="row">
                    <div class="col-lg-10 col-xl-8 offset-lg-1 offset-xl-2">
                        <div class="intro"></div>
                        <form action="edit-profile.jsp">
                            <div class="form-row profile-row">
                                <div class="col-md-8">
                                    <h1 class="text-center" style="color: rgb(31,40,81);">My Profile</h1>
                                    <hr style="background-color: rgb(31,40,81);">
                                    <div class="form-row">
                                        <div class="col-sm-12 col-md-6">
                                            <div class="form-group"><label style="color: rgb(31,40,81);font-weight: bold;font-size: 16px;">Name </label><input class="form-control" value="<%=user.getName()%>" type="text" name="firstname" style="border-color: rgb(31,40,81);color: rgb(31,40,81);font-size: 14px;"readonly=""></div>
                                        </div>
                                    </div>
                                    <div class="form-group"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Email </label><input class="form-control" value="<%=user.getEmail()%>" type="email" autocomplete="off" required="" name="email" style="border-color: rgb(31,40,81);color: rgb(31,40,81);font-size: 14px;"
                                      autofocus="" readonly=""></div>
                                    <div class="form-group">
                                        <label style="color: rgb(31, 40, 81); font-size: 16px; font-weight: bold;">Password</label>
                                        <input id="passwordInput" class="form-control" value="<%=user.getPassword()%>" type="text" autocomplete="off" required name="password" style="border-color: rgb(31, 40, 81); color: rgb(31, 40, 81); font-size: 14px;" autofocus readonly></div>
                                  

                                    <hr style="background-color: rgb(31,40,81);">
                                    <!--                                <div class="form-row">
                                                                        <div class="col-md-12 content-right"><a class="btn btn-primary form-btn" role="button" href="edit-profile.jsp?id=<%=user.getId()%>" style="background-color: rgb(31,40,81);border-color: rgb(31,40,81);">EDIT</a><button class="btn btn-danger form-btn" type="reset" style="background-color: rgb(31,40,81);border-color: rgb(31,40,81);">CANCEL </button></div>
                                                                    </div>-->
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="scripts.jsp" %> 
        <script>
function myFunction() {
  var x = document.getElementById("passwordInput");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>


    </body>

</html>
<%} else {
        response.sendRedirect("login.jsp");
    }%>