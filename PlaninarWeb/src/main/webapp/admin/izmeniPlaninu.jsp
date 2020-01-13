<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/Planinar/planinaController/admin/izmeniPlaninu" method="post">
		<select name="idP">
			<c:forEach items="${planine }" var="p">
				<option value="${p.idPlanina }">${p.naziv }</option>
			</c:forEach>
		</select><br/>
		Unesi novi naziv planine<input type="text" name="naziv"><br/>
	 <input type="submit" value="Izmeni">
	</form>
	
	<br />
	<form action="/Planinar/index.jsp">
		<input type="submit" value="Back home">
	</form>
</body>
</html>