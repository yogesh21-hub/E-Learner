<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
  <%@include file="css/bootstrap.min.css" %>
  <%@include file="css/login-design.css" %>
  <%@include file="css/home-design.css" %>
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="form">
<h3>Hello, <%=session.getAttribute("admin_name") %></h3>
<a class="btn btn-primary btn-lg btn-block normal-button" href="course.jsp">Add Course</a>
<br>
<a class="btn btn-primary btn-lg btn-block normal-button" href="ViewCourse">View Courses</a>
<br>
<a class="btn btn-primary btn-lg btn-block normal-button" href="ViewUser">View Users</a>
<br>
<a class="btn btn-primary btn-lg btn-block normal-button" href="ViewContact">View Contacts</a>
<br>
<a class="btn btn-primary btn-lg btn-block normal-button" href="ViewFeedback">View Feedbacks</a>
<br>
<a class="btn btn-danger btn-lg btn-block exit-button" href="admin-login.jsp">Logout</a>
</div>
</body>
</html>