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
<form action="/Planinar/zakazivanjeController/user/zakazi" method="post">

Unesi datum zakazivanja<input type="date" name="datum">
<input type="submit" value="Dodaj">
</form><br/>
</div>
  </div>
  <%@ include file="../footer.jsp"%>
  </div>

</body>
</html>