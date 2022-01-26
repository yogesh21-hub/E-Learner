<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
  <%@include file="css/bootstrap.min.css" %>
  <%@include file="css/login-design.css" %>
</style>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
<div class="form">
<h3>USER LOGIN</h3>
<br>
<form action="UserLogin" method="GET">
<label for="user id">User ID</label> <input type="number" name="user_id" required>
<br>
<label for="password">Password</label> <input type="password" name="password" required>
<br>
<div class="wrong">
<%if(request.getAttribute("wrongCredentials")!=null)
	out.println("Wrong User id or password!<br>");
	%>
</div>
<input type="submit" value="LOGIN" class="submit btn btn-primary ">
<br><br>
New User? <a href="user-registration.jsp">Register here</a>
<br>
or
<br>
Login as <a href="admin-login.jsp">Admin</a>
</form>
</div>
</body>
</html>