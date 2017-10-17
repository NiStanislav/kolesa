<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<header>
	<div>

<nav class="skew-menu">
  <ul>
    <li><a href="/kolesa/">Home</a></li>
       <c:if test="${sessionScope.id == null}">
  <li>
    <a href="login.jsp">
     Login
      
    </a>
  </li>
  
  <li>
    <a href="reg.jsp" >
      Registration
      
    </a>
  </li>
  	</c:if>
    <li><a href="about.jsp">About us</a></li>
  </ul>
</nav>
<ul class="header-list">

	<c:if test= "${sessionScope.id  != null}">
	   <li> <a href='user?id=${sessionScope.id}'>${sessionScope.name}</a></li>
	   <li> <a href="logout">Logout</a></li>
		</c:if>
	   <li> 	<a href="new.jsp" class="new-post">New Post</a></li>	
    </ul>	    
     	  <form action="search">
     <div class="modal_dropdown-content">
     	<div class="dropdown-content">
     		<ul class="header-registration_sub-menu list-inline">
     	
				<li><input type="radio" name="order" value="price" checked="checked"> Price</li>
				<li><input type="radio" name="order" value="views"> Popularity</li>
				<li><input type="radio" name="order" value="capacity"> Capacity</li>
				<!-- <li><input type="radio" name="order" value="year"> Year</li> -->
				<li><input type="radio" name="order" value="date"> Date</li>
				<li><input type="radio" name="order" value="year"> Year</li>
				<li><input type="submit" value="Search"></li>
			
     		</ul>
     	</div>
     </div>
     </form>
	
</header>