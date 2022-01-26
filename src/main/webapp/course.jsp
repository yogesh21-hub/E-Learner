<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
  <%@include file="css/bootstrap.min.css" %>
  <%@include file="css/login-design.css" %>
  <%@include file="css/form-design.css" %>
  div.form{
  	width: 530px;
	margin-left: calc(50% - 265px);
  }
  label{
	width: 180px;
	}
</style>
<meta charset="ISO-8859-1">
<title>Add Course</title>
</head>
<body>
<div class="form">
<h3>COURSE FORM</h3>
<br>
<form action="AddCourse" method="POST">
<label for="course id">Course ID</label> <input type="number" name="course_id" required>
<br>
<label for="course name">Course Name</label><input type="text" name="course_name" required>
<br>
<label for="course description">Course Description</label>
<input type="text" name="course_description" required>
<br>
<label for="course resources">Course Resources</label>
<input type="text" name="course_resources" required>
<br>
<label for="course fees">Course Fees</label>
<input type="number" name="course_fees" required>
<br>
<div class="wrong">
<%if(request.getAttribute("courseExist")!=null)
	out.println("Course Id already exist! Use different course id");
%>
</div>
<input type="submit" value="SUBMIT" class="submit btn btn-primary">
</form>
<a class="btn btn-primary btn-block submit" href="admin-home.jsp">Home</a>
</div>
</body>
</html>