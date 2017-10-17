<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/styles.css" />
</head>
<body>
 <a href="index.jsp">Back</a>
	<%@include file="header.jsp" %>
		<div class="main">
 	<center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">User:</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Username:${username}</td>
            </tr>
            <tr>
                <td>Phone:${phone}</td>
            </tr>
           	<tr>
                <td>Emails:${email}</td>
            </tr>
            </tbody>
            
            
        </table>
    </center>
    </div>
    	<%@include file="footer.jsp" %>
</body>
</html>