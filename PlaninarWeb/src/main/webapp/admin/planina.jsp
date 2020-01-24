<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../header.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/styles.css"> 
</head>
<body>


<div class="content">
	<h2>Planina</h2>
	<table>
		<tr>
			<th>Name</th>
			<th></th>
			<th></th>
		</tr>
		<c:if test="${not empty planine}">
			<c:forEach var="i" items="${planine}">
				<tr>
					<td>${i.naziv }</td>
					<td><a
						href="/Planinar/planinaController/admin/pronadjiCPlaninu?idP=${i.idPlanina }">Edit</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<a class="insert" href="/Planinar/admin/dodajPlaninu.jsp">Add</a>
</div>
</body>
</html>