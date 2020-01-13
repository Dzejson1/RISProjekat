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
<form action="/Planinar/komentarController/user/DodajKomentar" method="post">
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
Unesi opis komentara<input type="text" name="opisK">
<input type="submit" value="Dodaj">
</form><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>
</body>
</html>