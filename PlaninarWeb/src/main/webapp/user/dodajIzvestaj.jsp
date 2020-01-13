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
<form action="/Planinar//izvestajController/user/DodajIzvestaj" method="post">
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

Unesi izvestaj<input type="text" name="izvestaj">
<input type="submit" value="Dodaj">
</form><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>
</body>
</html>