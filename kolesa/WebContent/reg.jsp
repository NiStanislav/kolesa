<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link type="text/css" rel="stylesheet" href="./css/styles.css" />
<link type="text/css" rel="stylesheet" href="./css/reg.css" />
</head>
<body>
<%@include file="header.jsp" %>
<div class="main">
<center>

	
	
	
	<div class='bold-line'></div>
<div class='container'>
  <div class='window'>
    <div class='overlay'></div>
    <div class='content'>
      <div class='welcome'>Hello There!</div>
      <div class='subtitle'>Register to get full access to all functions of the website</div>
      <div class='input-fields'>
      	<form action="reg" method="post">
    	
    		<div style="color: #FF0000;">${error}</div>

	    	<input type="text" required="true" name="username" placeholder="Username" class='input-line full-width'>
	    	<br>
	    	<input type="email" required="true" name="email" placeholder="Email" class='input-line full-width'>
	    	<br>
	    	<input type="text" required="true" name="phone" placeholder="Phone" class='input-line full-width'>
	    	<br>
	    	<input type="password" required="true" name="password" placeholder="Password" class='input-line full-width'>
	    	<br>
		<input type="password" required="true" name="password1" placeholder="Confirm password" class='input-line full-width'>
   		<br>
    	<input type="submit" value="submit" class='ghost-round full-width'>
	</form>
  
      </div>
    </div>
  </div>
</div>
	
</center>
</div>
<%@include file="footer.jsp" %>
</body>
</html>