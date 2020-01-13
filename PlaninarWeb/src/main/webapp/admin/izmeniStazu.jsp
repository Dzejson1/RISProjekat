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

<sf:form modelAttribute="stazaImg"  action="/Planinar/stazaController/admin/izmeniStazu"  method="post" enctype="multipart/form-data">
   <%-- <sf:select path="planina56417">
      <c:forEach items="${staze }" var="s">
  		<option value="${s.idStaza }">${s.opis }</option>
  	  </c:forEach>
   </sf:select> --%>
    <select name="idS">
  		<c:forEach items="${staze }" var="s">
  			<option value="${s.idStaza }">${s.opis }</option>
  		</c:forEach>
	</select> 
   
    <!-- Unesi opis staze -->
     Unesi novi opis<sf:input path="opis"/> <br/>
     
     Unesi novu tezinu<sf:input path="tezina"/><br/>
     
  	 Unesi novu sliku<sf:input type="file" path="mapa"/>
  
  	<td><input type="submit" value="saveButton"></td>
  	
</sf:form><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>



<%-- <select name="idS">
  <c:forEach items="${staze }" var="s">
  	<option value="${s.idStaza }">${s.opis }</option>
  </c:forEach>
</select> --%>

</body>
</html>