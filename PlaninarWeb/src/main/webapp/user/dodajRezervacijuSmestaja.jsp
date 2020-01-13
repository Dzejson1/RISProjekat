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
<form action="/Planinar/rezervacijaSmestajaController/user/DodajRezervacijuSmestaja" method="post">
Unesi datum rezervacije smestaja<input type="date" name="datum"><br/>
<select name="idK">
  <c:forEach items="${listaK}" var="l">
 	 <option value="${l.idKorisnik }">${l.ime }</option>
  </c:forEach>
</select><br/>
<select name="idD">
  <c:forEach items="${listaD}" var="l">
 	 <option value="${l.idPlaninarskiDom }">${l.naziv}</option>
  </c:forEach>
</select><br/>
<input type="submit" value="Dodaj">
</form><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>
</body>
</html>