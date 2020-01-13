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
<form action="/Planinar/planinarskiDomController/admin/izmeniDom" method="post">
<select name="idDom">
  <c:forEach items="${listaDom }" var="l">
 	 <option value="${l.idPlaninarskiDom }">${l.naziv }</option>
  </c:forEach>
</select>
<br/>
<select name="idPl">
  <c:forEach items="${listaPlan }" var="l">
 	 <option value="${l.idPlanina }">${l.naziv }</option>
  </c:forEach>
</select>
<br/>
Unesi naziv doma<input type="text" name="naziv"><br/>
<input type="submit" value="Izmeni">
</form>
<br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>
</body>
</html>