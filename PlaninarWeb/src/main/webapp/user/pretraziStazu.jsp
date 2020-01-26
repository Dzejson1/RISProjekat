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



<form action="/Planinar/stazaController/user/prikazi">
Unesi naziv <input type="text" name="idStaza">
<input type="submit" value="Prikazi">
</form>

<c:if test="${! empty slika }"> 

<%-- ${slika.id }<br/> --%>
<%-- ${slika.type}<br/> --%>
<%-- ${slika.name }<br/> --%>

<div >
 <img height="100" width="100" src="/Planinar/stazaController/user/get-image/${slika.idStaza}"/><br/><br/>
</div>
 <%-- <img src="${pageContext.request.contextPath}/img/JSA-ABOUT-IMAGE-BLACK-BACKGROUND.png" height="42" width="42"/> --%>
 
<%-- <img src="<c:url value="JSA-ABOUT-IMAGE-BLACK-BACKGROUND.png"/>"/> --%>

</c:if><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>
</body>
</html>