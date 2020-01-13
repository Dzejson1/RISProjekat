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
<sf:form modelAttribute="znamImg"  action="/Planinar/znamenitostController/admin/izmeniZnamenitost"  method="post" enctype="multipart/form-data">
   <%-- <sf:select path="planina56417">
      <c:forEach items="${staze }" var="s">
  		<option value="${s.idStaza }">${s.opis }</option>
  	  </c:forEach>
   </sf:select> --%>
   
    <select name="idZ">
  		<c:forEach items="${listaZ }" var="s">
  			<option value="${s.idZnamenitost }">${s.opis }</option>
  		</c:forEach>
	</select> <br/>
   
  	  Unesi novi opis<sf:input path="opis"/> <br/>

	  Biraj da li je potrebno zakazati <sf:checkbox path="potrebnoZakPom"/><br/>
  		
  	  Unesi novu sliku<sf:input type="file" path="slika"/><br/>
  	  
  	 <sf:select path="tipznamenitosti56417">
      <c:forEach items="${tipZ}" var="s">
  		<option value="${s.idTipZnamenitosti }">${s.opis }</option>
  	  </c:forEach>
    </sf:select> <br/>
    
    <sf:select path="staza56417">
      <c:forEach items="${staze }" var="s">
  		<option value="${s.idStaza }">${s.opis }</option>
  	  </c:forEach>
    </sf:select> 
  
  	<td><input type="submit" value="saveButton"></td>
  	
</sf:form><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>
</body>
</html>