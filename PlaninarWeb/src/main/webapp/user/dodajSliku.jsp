<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"> 
</head>
<body>
<div id="container"> 
<%@ include file="../header.jsp"%>
<div id="main">
    <div id="text">  
<sf:form modelAttribute="slikaImg" action="/Planinar/slikeController/user/DodajSlike"  method="post" enctype="multipart/form-data">
  

    
  	 Odaberi sliku <sf:input type="file" path="pic"/>
  
  	<td><input type="submit" value="saveButton"></td>
  	
  	
  	
</sf:form>
</div>
  </div>
  <%@ include file="../footer.jsp"%>
  </div>



<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>

</body>
</html>