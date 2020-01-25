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
<sf:form modelAttribute="stazaImg"  action="/Planinar/stazaController/admin/izmeniStazu"  method="post" enctype="multipart/form-data">
 
   <br/>
		<br/>
		<br/>
		<br/>
    <!-- Unesi opis staze -->
     Unesi novi opis  <sf:input path="opis" value="${staza.opis}" /> <br/>
     <br/>
		<br/>
		<br/>
		<br/>
           
     Unesi novu tezinu  <sf:input path="tezina" value="${staza.tezina}"/><br/>
     <br/>
		<br/>
		<br/>
		<br/>
     
  	 Unesi novu sliku  <sf:input type="file" path="mapa" />
  	 <br/>
		<br/>
		<br/>
		<br/>
  	 <div >
 		<img height="100" width="100" src="/Planinar/stazaController/user/get-image/${staza.idStaza}"/><br/><br/>


		</div>
		<br/>
		<br/>
		<br/>
		<br/>
  
  	<td><input type="submit" value="saveButton"></td>
  	
</sf:form><br/>

</div>
  </div>
  <%@ include file="../footer.jsp"%>
  </div>




<%-- <select name="idS">
  <c:forEach items="${staze }" var="s">
  	<option value="${s.idStaza }">${s.opis }</option>
  </c:forEach>
</select> --%>

</body>
</html>