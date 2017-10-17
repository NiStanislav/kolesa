<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" >
<title>New post</title>
<link type="text/css" rel="stylesheet" href="./css/styles.css" />
<link type="text/css" rel="stylesheet" href="./css/reg.css" />
</head>
<body>
	<%@include file="header.jsp" %>
	<a href="/kolesa/" class="back-link">Back</a>
    <center>
    <div class="main new-post">
        <div style="color: #FF0000;">${error}</div>
      <!--   <form action="new" method="post" enctype="multipart/form-data">
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
                <label>Color:</label>
                <input type="text" name="price">
            <br>
            	<label>Photo:</label>
                <input type="file" name="file" accept="image/jpeg">
            <br>
                <input type="submit" value="submit">
        </form> -->
        
        
               
       <div class='container'>
  <div class='window'>
    <div class='overlay'></div>
    <div class='content'>
      <div class='welcome'>New Post</div>
      <div class='subtitle'>Please tell us more about your car</div>
      <div class='input-fields'>
	           <form action="new" method="post" enctype="multipart/form-data">
	                <input type="text" name="title" placeholder="Title" class='input-line full-width'>
	            <br>
	                <input type="text" name="city" placeholder="City" class='input-line full-width'>
	            <br>
	               <input type="text" name="year" placeholder="Year" class='input-line full-width'>
	            <br>
	             <input type="text" name="capacity" placeholder="Capacity" class='input-line full-width'>
	             <br>
	              <input type="text" name="mileage" placeholder="Mileage" class='input-line full-width'>
	             <br>
	               <input type="text" name="color" placeholder="Color" class='input-line full-width'>
	             <br>
	              <input type="text" name="price" placeholder="Price" class='input-line full-width'>
	             <br>
	              <input type="text" name="description" placeholder="Description" class='input-line full-width'>
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
       
	                <input type="submit" value="submit" class='ghost-round full-width'>
	        </form>
	
    </div>
  </div>
</div>
       </div>
       
       
    </center>

	<%@include file="footer.jsp" %>
</body>
</html>