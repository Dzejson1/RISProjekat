<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix='sec'
	uri='http://www.springframework.org/security/tags'%>  
	
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="container"> 
<%@ include file="../header.jsp"%>
<div id="main">
    <div id="text"> 
    
    
    
     <sec:authorize access="hasRole('admin')">
<form action="/Planinar/korisnikController/admin/izmeniDatumIsteka" method="get">
<br/>
		<br/>
		<br/>
Odaberi novi datum isteka  <input type="date" name="datum"><br/>
<br/>
		<br/>
		<br/>
		<br/>
		<br/>
<input type="submit" value="Dodaj">
</form><br/>

</sec:authorize> 
    
    
    
    
    </div>
  </div>
  <%@ include file="../footer.jsp"%>
  </div>
    
    



</body>
</html>