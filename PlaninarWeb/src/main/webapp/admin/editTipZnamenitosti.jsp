<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
<c:if test="${! empty listaEditTipZnam }">
<form action="/Planinar/tipZnamenitostiController/admin/editTipZnamenitosti" method="post">


Unesi novi opis znamenitosti<input type="text" value="${tipZ.opis }" name="eOpis">
<br/>
<br/>
<input type="submit" value="Edit">
</form>
</c:if><br/>
 </div>
  </div>
  <%@ include file="../footer.jsp"%>
  </div>
</body>
</html>