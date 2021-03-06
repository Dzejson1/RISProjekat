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
    <c:if test="${ empty listaTR }">
    <h1>Morate uneti tip znamenitosti</h1><br/><br/><br/>
    </c:if>
    <c:if test="${ empty listaS } }">
    <h1>Morate uneti stazu</h1>
    </c:if>
    
 <c:if test="${! empty listaTR && ! empty listaS }">
<%-- <c:if test="${! empty listaS } ">  --%>
<sf:form modelAttribute="znamImg"  action="/Planinar/znamenitostController/admin/dodajZnamenitost"  method="post" enctype="multipart/form-data">
  
  
   Izaberi tip znamenitosti <sf:select path="tipznamenitosti56417">
      <c:forEach items="${listaTR}" var="l">
 	      <option value="${l.idTipZnamenitosti }">${l.opis}</option>
      </c:forEach>
   </sf:select>
   <br/>
  	  <br/>
   Izaberi stazu <sf:select path="staza56417">
      <c:forEach items="${listaS}" var="l">
 	      <option value="${l.idStaza }">${l.opis}</option>
      </c:forEach>
   </sf:select>
    <br/>
  	  <br/>
    
    <!-- Unesi opis staze -->
     Unesi opis znamenitosti <sf:input path="opis"/> <br/>
<br/>
  	  <br/>
  		
  	  Odaberi sliku <sf:input type="file" path="slika"/> 
  	  <br/>
  	  <br/>
  	  Da li je potrebno zakazati <sf:checkbox path="potrebnoZakPom"/><br/>
  	<br/>
  	  <br/>
  	<td><input type="submit" value="saveButton"></td>
  	
  	
  	
</sf:form>
 </c:if>

</div>
  </div>
  <%@ include file="../footer.jsp"%>
  </div>
<br/>

</body>
</html>