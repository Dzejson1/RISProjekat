<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h2>Staza</h2>
	<table>
		<tr>
			<th>Ime doma</th>
			<th>Datum rezervisanja</th>
			
		</tr>
		<c:if test="${not empty rezervacije}">
			<c:forEach var="i" items="${rezervacije}">
				<tr>
					<td>${i.planinarskidom56417.naziv }</td>
					<td>${i.datum }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<a class="insert" href="/Planinar/stazaController/admin/getDodajPlanine">Add</a>
 </div>
  </div>
  <%@ include file="../footer.jsp"%>
  </div>
</body>
</html>