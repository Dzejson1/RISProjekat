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
<c:if test="${! empty listaObrisiTipZnam }">
<form action="/Planinar/tipZnamenitostiController/admin/obrisiTipZnamenitosti" method="get">
<select name="idOTipZ">
  <c:forEach items="${listaObrisiTipZnam }" var="l">
 	 <option value="${l.idTipZnamenitosti }">${l.opis }</option>
  </c:forEach>
</select>
<br/>
<input type="submit" value="Obrisi">
</form>
</c:if><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>

</body>
</html>