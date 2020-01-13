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
<form action="/Planinar/korisnikController/user/izmeniKorisnika" method="post">
<select name="idK">
  		<c:forEach items="${korisnici}" var="s">
  			<option value="${s.idKorisnik }">${s.ime }-${s.prezime }</option>
  		</c:forEach>
  </select><br/>
Unesi novo ime korisnika<input type="text" name="ime"><br/>
Unesi novo prezime korisnika<input type="text" name="prezime"><br/>
Unesi novi username korisnika<input type="text" name="username"><br/>
Unesi novi password korisnika<input type="password" name="password"><br/>
<input type="submit" value="Izmeni">
</form><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>

</body>
</html>