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
<form action="/Planinar/izvestajController/user/IzmeniIzvestaj" method="post">
<select name="idI">
  <c:forEach items="${listaI}" var="l">
 	 <option value="${l.idIzvestaj }">${l.opis }</option>
  </c:forEach>
</select><br/>
<select name="idK">
  <c:forEach items="${listaK}" var="l">
 	 <option value="${l.idKorisnik }">${l.ime }</option>
  </c:forEach>
</select><br/>
<select name="idP">
  <c:forEach items="${listaP}" var="l">
 	 <option value="${l.idPlanina }">${l.naziv }</option>
  </c:forEach>
</select><br/>

Unesi novi izvestaj<input type="text" name="izvestaj">
<input type="submit" value="Izmeni">
</form><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>
</body>
</html>