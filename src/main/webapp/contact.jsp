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
<title>Add Contact</title>
</head>
<body>
<div class="form">
<h3>CONTACT FORM</h3>
<br>
<form action="AddContact" method="POST">
<label for="name">Name</label><input type="text" name="name" required>
<br>
<label for="email">Email</label><input type="email" name="email" required>
<br>
<label for="phone">Phone</label><input type="number" name="phone" required>
<br>
<label for="message">Message</label><input type="text" name="message" required>
<br>
<div class="wrong">
</div>
<input type="submit" value="SUBMIT" class="submit btn btn-primary">
</form>
<a class="btn btn-primary btn-block submit" href="user-home.jsp">Home</a>
</div>
</body>
</html>