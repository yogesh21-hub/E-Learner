<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="amdocs.elearner.model.*" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
  <%@include file="css/bootstrap.min.css" %>
  <%@include file="css/login-design.css" %>
  <%@include file="css/view-design.css" %>
</style>
<meta charset="ISO-8859-1">
<title>Feedbacks</title>
</head>
<body>
<div class="form">
<h2>Courses</h2>
<div class="scroll">
<table border="1" class="table">
<tr>
<th>Course ID</th>
<th>Course Name</th>
<th>Course Description</th>
<th>Course Fees</th>
<th>Course Resource</th>
</tr>
<%
ArrayList<Course> courses = (ArrayList<Course>) request.getAttribute("courses");
for(Course temp: courses)
		{
	out.println("<tr>");
	out.println("<td>"+temp.getCourse_id()+"</td>");
	out.println("<td>"+temp.getCourse_name()+"</td>");
	out.println("<td>"+temp.getCourse_desp()+"</td>");
	out.println("<td>"+temp.getCourse_fees()+"</td>");
	out.println("<td>"+temp.getCourse_resource()+"</td>");
	out.println("</tr>");
		}

%>
</table>
</div>
<a class="btn btn-primary btn-lg btn-block exit-button" 
href=<%=request.getAttribute("url") %>>Home</a>
</div>
</body>
</html>