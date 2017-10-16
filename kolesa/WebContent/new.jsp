<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" >
<title>New post</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<a href="/kolesa/">Back</a>
    <center>
        <div style="color: #FF0000;">${error}</div>
        <form action="new" method="post" enctype="multipart/form-data">
                <label>Title:</label>
                <input type="text" name="title">
            <br>
                <label>City:</label>
                <input type="text" name="city">
            <br>
                <label>Year:</label>
                <input type="text" name="year">
            <br>
                <label>Capacity:</label>
                <input type="text" name="capacity">
            <br>
                <label>Mileage:</label>
                <input type="text" name="mileage">
            <br>
                <label>Color:</label>
                <input type="text" name="color">
            <br>
                <label>Drive:</label>
                <input type="radio" name="drive" value="front"> Front
                <input type="radio" name="drive" value="back"> Back
                <input type="radio" name="drive" value="4wd"> 4wd
            <br>
                <label>State:</label>
                 <input type="radio" name="state" value="new"> New
                 <input type="radio" name="state" value="used"> Used
                 <input type="radio" name="state" value="emergency"> Emergency
            <br>
            	<label>Photo:</label>
                <input type="file" name="file" accept="image/jpeg">
            <br>
                <input type="submit" value="submit">
        </form>
    </center>

	<%@include file="footer.jsp" %>
</body>
</html>