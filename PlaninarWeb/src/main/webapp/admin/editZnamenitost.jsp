<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
     <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
<title>Insert title here</title>
</head>
<body>
<div id="container"> 
<%@ include file="../header.jsp"%>
<div id="main">
    <div id="text">  
<sf:form modelAttribute="znamImg"  action="/Planinar/znamenitostController/admin/izmeniZnamenitost"  method="post" enctype="multipart/form-data">
   
  	  Unesi novi opis  <sf:input path="opis" value="${znam.opis}"/> <br/>
      <br/>

  	  <br/>
  	
	   		
	   		Unesi novu sliku  <sf:input type="file" path="slika"/><br/>
	   		 <div >
 			<img height="100" width="100" src="/Planinar/znamenitostController/user/get-image/${znam.idZnamenitost}"/><br/><br/>


		</div>
	   		
	   		
	   		
	   		
  	  <br/>
  	  <br/>
  	 <sf:select path="tipznamenitosti56417">
      <c:forEach items="${listaTR}" var="s">
  		<option value="${s.idTipZnamenitosti }">${s.opis }</option>
  	  </c:forEach>
    </sf:select> <br/>
    <br/>
  	  <br/>
    <sf:select path="staza56417">
      <c:forEach items="${listaS }" var="s">
  		<option value="${s.idStaza }">${s.opis }</option>
  	  </c:forEach>
    </sf:select> 
  
	   		
	   <c:if  test="${znam.potrebnoZakazati}"> 
	  Biraj da li je potrebno zakazati  <sf:checkbox path="potrebnoZakPom" value="${znam.potrebnoZakazati} " checked="checked" /><br/>
	 <%--  value="${znam.potrebnoZakazati} " --%>
	 </c:if> 
	 
	 
	 <c:if  test="${!znam.potrebnoZakazati}">
	  Biraj da li je potrebno zakazati  <sf:checkbox path="potrebnoZakPom"  value="${znam.potrebnoZakazati} " /><br/>
	  
	 </c:if> 
	   
	   
	   
	   
	   
	   
	   
  		<br/>
  	  <br/>
  	  
  	<td><input type="submit" value="saveButton"></td>
  	
</sf:form><br/>
</div>
  </div>
  <%@ include file="../footer.jsp"%>
  </div>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>
</body>
</html>