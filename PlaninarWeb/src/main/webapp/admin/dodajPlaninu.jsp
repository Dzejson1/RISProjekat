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
<form action="/Planinar/planinaController/admin/UnesiPlaninu" method="post">
<br/>
		<br/>
		<br/>
Unesi naziv planine  <input type="text" name="naziv"><br/>
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