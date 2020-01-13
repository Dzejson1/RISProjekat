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
<sf:form modelAttribute="slikaImg"  action="/Planinar/slikeController/user/izmeniSlike"  method="post" enctype="multipart/form-data">
  
   
    <select name="idS">
  		<c:forEach items="${listaS }" var="s">
  			<option value="${s.idSlika }">${s.idSlika }</option>
  		</c:forEach>
	</select> <br/>
   

  	  Unesi novu sliku<sf:input type="file" path="pic"/><br/>
  	  
  	 <sf:select path="planina56417">
      <c:forEach items="${listaP}" var="l">
 	      <option value="${l.idPlanina }">${l.naziv}</option>
      </c:forEach>
   </sf:select>
    
    <sf:select path="korisnik56417">
      <c:forEach items="${listaK}" var="l">
 	      <option value="${l.idKorisnik }">${l.ime}</option>
      </c:forEach>
    </sf:select> <br/>
  
  	<td><input type="submit" value="izmeniButton"></td>
  	
</sf:form><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>
</body>
</html>