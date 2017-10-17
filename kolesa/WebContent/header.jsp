<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/kolesa/">Home</a>
	
	 
	 <c:if test="${sessionScope.id == null}">
    <a href='login.jsp'>login</a>
    <a href="reg.jsp">Registration</a>
	</c:if>
	 <c:if test="${sessionScope.id != null}">
    <a href='user?id=${sessionScope.id}'>${sessionScope.name}</a>
    <a href="logout">logout</a>
	</c:if>
	  <a href="about.jsp">About us</a>
	  <form action="search">
	  		<input type="radio" name="order" value="price" checked="checked"> Price
            <input type="radio" name="order" value="views"> Popularity
            <input type="radio" name="order" value="capacity"> Capacity
            <input type="radio" name="order" value="year"> Year
            <input type="radio" name="order" value="date"> Date
            <input type="submit" value="Search">
      </form>
      	<a href="new.jsp">New Post</a>
</body>
</html>