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


<sf:form modelAttribute="znamImg"  action="/Planinar/znamenitostController/admin/dodajZnamenitost"  method="post" enctype="multipart/form-data">
  
  
   <sf:select path="tipznamenitosti56417">
      <c:forEach items="${listaTR}" var="l">
 	      <option value="${l.idTipZnamenitosti }">${l.opis}</option>
      </c:forEach>
   </sf:select>
   
   <sf:select path="staza56417">
      <c:forEach items="${listaS}" var="l">
 	      <option value="${l.idStaza }">${l.opis}</option>
      </c:forEach>
   </sf:select>
    
    
    <!-- Unesi opis staze -->
     Unesi opis znamenitosti<sf:input path="opis"/> <br/>

  		
  	  <sf:input type="file" path="slika"/>
  	  <sf:checkbox path="potrebnoZakPom"/><br/>
  	
  	<td><input type="submit" value="saveButton"></td>
  	
  	
  	
</sf:form>
<br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>
</body>
</html>