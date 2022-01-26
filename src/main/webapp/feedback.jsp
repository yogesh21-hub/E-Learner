<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
  <%@include file="css/bootstrap.min.css" %>
  <%@include file="css/login-design.css" %>
  <%@include file="css/form-design.css" %>
</style>
<meta charset="ISO-8859-1">
<title>Add Feedback</title>
</head>
<body>
<div class="form">
<h3>FEEDBACK FORM</h3>
<br>
<form action="AddFeedback" method="POST">
<label for="name">Name</label><input type="text" name="name" required>
<br>
<label for="email">Email</label><input type="email" name="email" required>
<br>
<label for="feedback">Feedback</label><input type="text" name="feedback" required>
<br>
<div class="wrong">
</div>
<input type="submit" value="SUBMIT" class="submit btn btn-primary">
</form>
<a class="btn btn-primary btn-block submit" href="user-home.jsp">Home</a>
</div>
</body>
</html>