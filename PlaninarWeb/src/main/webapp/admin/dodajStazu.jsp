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

<div id="container"> 
<%@ include file="../header.jsp"%>
<div id="main">
    <div id="text"> 


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
  
  
  
  Izaberi planinu <sf:select path="planina56417">
      <c:forEach items="${listaPlan}" var="l">
 	      <option value="${l.idPlanina }">${l.naziv}</option>
      </c:forEach>
   </sf:select>
    <br/>
		<br/>
		<br/>
    
    <!-- Unesi opis staze -->
    Unesi opis <sf:input path="opis"/> <br/>
    <br/>
		<br/>
		<br/>
  
  	
  		
  	 Unesi sliku <sf:input type="file" path="mapa"/>
  
  	<br/>
		<br/>
		<br/>
  	
  	
  	<td><input type="submit" value="saveButton"></td>
  	
  	
  	
</sf:form>
</div>
  </div>
  <%@ include file="../footer.jsp"%>
  </div>







</body>
</html>

