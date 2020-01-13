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
<form action="/Planinar/rezervacijaSmestajaController/user/ObrisiRezervacijuSmestaja" method="post">
<select name="idR">
  <c:forEach items="${listaR}" var="l">
 	 <option value="${l.idRezervacijaSmestaja }">${l.datum }</option>
  </c:forEach>
</select><br/>
<input type="submit" value="Obrisi">
</form><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>
</body>
</html>