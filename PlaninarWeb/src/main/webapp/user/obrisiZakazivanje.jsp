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

<form action="/Planinar/zakazivanjeController/user/obrisiZakazivanje" method="post">
<select name="idZ">
  <c:forEach items="${listaZ}" var="l">
 	 <option value="${l.idZakazivanjeZnamenitosti }">${l.datum }</option>
  </c:forEach>
</select><br/>
<input type="submit" value="Obrisi">
</form><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>
</body>
</html>