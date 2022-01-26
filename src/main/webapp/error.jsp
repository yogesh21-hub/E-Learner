<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
  <%@include file="css/bootstrap.min.css" %>
  <%@include file="css/login-design.css" %>
  div.form{
  margin-top: 150px;
  height: 350px;
  }
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="form">
<h2>Something went wrong!</h2>
<a href=<%=request.getAttribute("url") %>>Try Again</a>
</div>
</body>
</html>