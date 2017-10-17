<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
<link type="text/css" rel="stylesheet" href="./css/styles.css" />
</head>
<body>
 <a class="back-link" href="/kolesa/">Back</a>
	<%@include file="header.jsp" %>
		<div class="main">
 	<center>
 	<div class="card-user">
  <img src="https://www.w3schools.com/howto/img_avatar.png"  >
  <div class="container">
    <h4><b>${username}</b></h4> 
    <p>${email}</p> 
    <p>${phone}</p>
  </div>
</div>

        <h3>User posts</h3>
        <c:forEach items="${posts}" var="a" varStatus="cnt">
				<c:if test = "${ cnt.index %  3 == 0 }">
    				<tr>
				</c:if>
					<td>
					<a class="card-link" target="blank" href='new?id=<c:out value="${a.id}" />'>
					   <div class="card user-card" width="33%">
					       <div class="image">
                                
                                    <img src="${a.image }"  width="255" height="255" />
                                
					       
					       </div>
					       
					       <div class="content">
								 
									<c:out value="${a.title}" />
								
					       </div>
					   </div>
					</a>
					
					</td>
	
   	            <c:if test = "${ cnt.last ||  cnt.index % 3 == 2 }">
    				</tr>
                </c:if>
    
				
			</c:forEach>
		</table>
    </center>
    </div>
    	<%@include file="footer.jsp" %>
</body>
</html>