<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<%@include file="header.jsp" %>
<center>
	<form action="reg" method="post">
    	<div style="color: #FF0000;">${error}</div>
    	<label>Name</label>
    	<input type="text" name="username">
    	<br>
    	<label>Email</label>
    	<input type="text" name="email">
    	<br>
    	<label>Phone</label>
    	<input type="text" name="phone">
    	<br>
    	<label>Password</label>
    	<input type="password" name="password">
    	<br>
    	<label>Confirm password</label>
		<input type="password" name="password1">
   		<br>
    	<input type="submit" value="submit">
	</form>
</center>
</body>
</html>