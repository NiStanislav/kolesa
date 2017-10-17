<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search results</title>
<link type="text/css" rel="stylesheet" href="./css/styles.css" />
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="main">
	<center>
		<h1>Results</h1>	
		
	
	<table>
			<c:forEach items="${result}" var="a" varStatus="cnt">
				<c:if test = "${ cnt.index % 3 == 0 }">
    				<tr>
				</c:if>
					<td>
					<a class="card-link" target="blank" href='new?id=<c:out value="${a.id}" />'>
					   <div class="card card-hover">
					       <div class="image">
                                
                                    <img src="${a.image }"  width="300" height="255" />
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