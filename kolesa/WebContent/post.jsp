<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
</head>
<body>
<%@include file="header.jsp" %>
	<center>
		<img  width="189" height="255" src="${image}">
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Post:</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Title:${title}</td>
            </tr>
            <tr>
                <td>City:${city}</td>
            </tr>
            <tr>
                <td>Mileage:${mileage}</td>
            </tr>
            <tr>
                <td>Color:${color}</td>
            </tr>
            <tr>
                <td>Drive:${drive}</td>
            </tr>
            <tr>
                <td>State:${state}</td>
            </tr>
            <tr>
                <td>author:${author}</td>
            </tr>
            <tr>
                <td>views:${views}</td>
            </tr>
            </tbody>
        </table>
    </center>
	
</body>
</html>