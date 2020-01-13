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
<form action="/Planinar/zakazivanjeController/user/izmeniZakazivanje" method="post">

<select name="idZak">
  <c:forEach items="${listaZak}" var="l">
 	 <option value="${l.idZakazivanjeZnamenitosti }">${l.datum }</option>
  </c:forEach>
</select><br/>

<select name="idZ">
  <c:forEach items="${listaZ}" var="l">
 	 <option value="${l.idZnamenitost }">${l.opis }</option>
  </c:forEach>
</select><br/>

<select name="idK">
  <c:forEach items="${listaK}" var="l">
 	 <option value="${l.idKorisnik }">${l.ime }</option>
  </c:forEach>
</select>

Unesi novi datum <input type="date" name="datum">
<input type="submit" value="Izmeni">
</form><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>
</body>
</html>