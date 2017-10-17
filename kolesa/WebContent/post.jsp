<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
<link type="text/css" rel="stylesheet" href="./css/styles.css" />
<link type="text/css" rel="stylesheet" href="./css/post.css" />
</head>
<body>
<%@include file="header.jsp" %>
<div class="main">
	<center>
	<%-- 	<img  width="189" height="255" src="${image}">
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
     --%>
    <div class="card">
  <div class="thumbnail"><img class="left" src="${image}"></div>
  <div class="right">
    <h1>${title}</h1>
    <div class="author">
      <h2>${author}</h2>
    </div>
    <div class="separator"></div>
    <div>
    <table>
               <tbody>
          
            <tr>
                <td>City: </td>
                <td>${city}</td>
            </tr>
            <tr>
                <td>Mileage: </td>
                <td>${mileage}</td>
            </tr>
            <tr>
                <td>Color: </td>
                <td>${color}</td>
            </tr>
            <tr>
                <td>Drive: </td>
                <td>${drive}</td>
            </tr>
             <tr>
                <td>Price: </td>
                <td>${price}</td>
            </tr>
            <tr>
                <td>State: </td>
                <td>${state}</td>
            </tr>
           
   
     
            </tbody>
        </table>
        <h5 class="desc"> 
	            Description: <br>
	            ${description}
	          </h5>
        <h5>views:${views}</h5>
    </div>
 </div>
</div>
    </center>
 </div>
<%@include file="footer.jsp" %>
</body>
</html>