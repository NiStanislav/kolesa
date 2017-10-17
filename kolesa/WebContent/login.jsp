<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link type="text/css" rel="stylesheet" href="./css/styles.css" />
<link type="text/css" rel="stylesheet" href="./css/reg.css" />
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="main">
	    <center>
	    
	        <div style="color: #FF0000;">${error}</div>
	        	
	<div class='bold-line'></div>
<div class='container'>
  <div class='window'>
    <div class='overlay'></div>
    <div class='content'>
      <div class='welcome'>Login</div>
      <div class='subtitle'>Please sign up</div>
      <div class='input-fields'>
	        <form action="login" method="post">
	                <input type="text" placeholder="Username" name="username" class='input-line full-width'>
	            <br>
	                <input type="password" placeholder="Password" name="password" class='input-line full-width'>
	            <br>
	                <input type="submit" value="submit" class='ghost-round full-width'>
	        </form>
	
    </div>
  </div>
</div>
	    </center>
     
</div>
    	<%@include file="footer.jsp" %>
</body>
</html>