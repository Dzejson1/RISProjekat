<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<%-- <form action="/Planinar/stazaController/admin/UnesiStazu" method="post">
<select name="idDPlan">
  <c:forEach items="${listaPlan}" var="l">
 	 <option value="${l.idPlanina }">${l.naziv}</option>
  </c:forEach>
</select>
Unesi opis staze<input type="text" name="opisS"><br/>
<input type="submit" value="Dodaj">
</form><br/> --%>

<sf:form modelAttribute="stazaImg"  action="/Planinar/stazaController/admin/UnesiStazu"  method="post" enctype="multipart/form-data">
  
  
  
   <sf:select path="planina56417">
      <c:forEach items="${listaPlan}" var="l">
 	      <option value="${l.idPlanina }">${l.naziv}</option>
      </c:forEach>
   </sf:select>
    
    
    <!-- Unesi opis staze -->
     <sf:input path="opis"/> <br/>
    
  
  	
  		
  	  <sf:input type="file" path="mapa"/>
  
  	
  	
  	
  	<td><input type="submit" value="saveButton"></td>
  	
  	
  	
</sf:form>




<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>




</body>
</html>

