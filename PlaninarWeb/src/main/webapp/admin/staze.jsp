<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/styles.css"> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="content">
	<h2>Staza</h2>
	<table>
		<tr>
			<th>Name</th>
			<th></th>
			<th></th>
		</tr>
		<c:if test="${not empty staze}">
			<c:forEach var="i" items="${staze}">
				<tr>
					<td>${i.opis }</td>
					<td><a
						href="/Planinar/stazaController/admin/pronadjiCStazu?idS=${i.idStaza }">Edit</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<a class="insert" href="/Planinar/admin/dodajPlaninu.jsp">Add</a>
</div>
</body>
</html>