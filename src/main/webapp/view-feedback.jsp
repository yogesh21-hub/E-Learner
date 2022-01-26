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
<h2>Feedbacks</h2>
<div class="scroll">
<table border="1" class="table">
<tr>
<th>User ID</th>
<th>Name</th>
<th>Email</th>
<th>Feedback</th>
</tr>
<%
ArrayList<Feedback> feedbacks = (ArrayList<Feedback>) request.getAttribute("feedbacks");
for(Feedback temp: feedbacks)
		{
	out.println("<tr>");
	out.println("<td>"+temp.getUser_id()+"</td>");
	out.println("<td>"+temp.getName()+"</td>");
	out.println("<td>"+temp.getEmail()+"</td>");
	out.println("<td>"+temp.getFeedback()+"</td>");
	out.println("</tr>");
		}

%>
</table>
</div>
<a class="btn btn-primary btn-lg btn-block exit-button" href="admin-home.jsp">Home</a>
</div>
</body>
</html>