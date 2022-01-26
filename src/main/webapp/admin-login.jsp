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
<title>Admin Login</title>
</head>
<body>
<div class="form">
<h3>ADMIN LOGIN</h3>
<br>
<form action="AdminLogin" method="GET">
<label for="admin id">Admin ID</label> <input type="number" name="admin_id" required>
<br>
<label for="password">Password</label> <input type="password" name="password" required>
<br>
<div class="wrong">
<%if(request.getAttribute("wrongCredentials")!=null)
	out.println("Wrong Admin id or password!<br>");
	%>
</div>

<input type="submit" value="LOGIN" class="submit btn btn-primary">
<br><br>
Login as <a href="index.jsp">User</a>
</form>
</div>
</body>
</html>