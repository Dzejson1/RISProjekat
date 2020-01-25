<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="container"> 
<%@ include file="../header.jsp"%>
<div id="main">
    <div id="text">

<form action="/Planinar/planinarskiDomController/admin/izmeniDom" method="post">
 <select name="idP">
			<c:forEach items="${listaPlan }" var="p">
				<option value="${p.idPlanina }">${p.naziv }</option>
			</c:forEach>
		</select><br/> 
Unesi naziv doma<input type="text" value="${dom.naziv }" name="naziv"><br/>
<input type="submit" value="Izmeni">
</form>
<br/>

</div>
  </div>
  <%@ include file="../footer.jsp"%>
  </div>
</body>
</html>