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
<form action="/Planinar/slikeController/user/pretraziSlike" method="get">
Unesi id slike <input type="text" name="idS">
<input type="submit" value="Prikazi">
</form>
<c:if test="${! empty slika}">
<div >
<%-- 	<img height="100" width="100" src="/Planinar/stazaController/user/get-image/${slika.idStaza}"/><br/><br/> --%>
 	<img height="100" width="100" src="/Planinar/slikeController/user/get-image/${slika.idSlika}"/><br/><br/>
 </div>

</c:if>
<br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>

</body>
</html>