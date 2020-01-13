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

<c:if test="${! empty listaEditTipZnam }">
<form action="/Planinar/tipZnamenitostiController/admin/editTipZnamenitosti" method="post">
<select name="idETipZ">
  <c:forEach items="${listaEditTipZnam }" var="l">
 	 <option value="${l.idTipZnamenitosti }">${l.opis }</option>
  </c:forEach>
</select>
<br/>
Unesi novi opis znamenitosti<input type="text" name="eOpis">
<input type="submit" value="Edit">
</form>
</c:if><br/>
</body>
</html>