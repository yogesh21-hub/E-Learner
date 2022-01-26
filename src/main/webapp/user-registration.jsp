<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="h-100">
<head>
<style type="text/css">
  <%@include file="css/bootstrap.min.css" %>
  <%@include file="css/login-design.css" %>
  <%@include file="css/form-design.css" %>
  div.form{
	margin-top: 20px;
	padding-top: 30px;
	height: 680px;
	}
</style>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body class="h-100">
<div class="form">
<h3>REGISTRATION FORM</h3>
<br>
<form action="UserRegistration" method="POST">
<label for="user id">User ID</label> <input type="number" name="user_id" required>
<br>
<label for="name">Name</label><input type="text" name="name" required>
<br>
<label for="email">Email</label><input type="email" name="email" required>
<br>
<label for="password">Password</label><input type="password" name="password" required>
<br>
<label for="phone">Phone</label><input type="number" name="phone" required>
<br>
<label for="address" class="paragraph">Address</label>
<textarea rows="3" cols="10" name="address" required></textarea>
<br>
<label for="upload photo">Upload Photo</label><input type="file" 
accept="image/*" name="photo" required>
<br>
<div class="wrong">
<%if(request.getAttribute("userExist")!=null)
	out.println("User already exist! Use different user id<br>");
%>
</div>
<input type="submit" value="REGISTER" class="submit btn btn-primary">
</form>

</div>

</body>
</html>