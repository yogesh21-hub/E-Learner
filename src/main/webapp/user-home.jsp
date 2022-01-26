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
<h3>Hello, <%=session.getAttribute("user_name") %></h3>
<br>
<a class="btn btn-primary btn-lg btn-block normal-button" href="contact.jsp">Add Contact</a>
<br>
<a class="btn btn-primary btn-lg btn-block normal-button"href="feedback.jsp">Add Feedback</a>
<br>
<a class="btn btn-primary btn-lg btn-block normal-button"href="ViewUserCourse">View Courses</a>
<br>
<a class="btn btn-primary btn-lg btn-block normal-button"href="ViewNewCourse">Enroll Course</a>
<br>
<a class="btn btn-danger btn-lg btn-block exit-button"href="index.jsp">Logout</a>
</div>
</body>
</html>