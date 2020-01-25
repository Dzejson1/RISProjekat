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
			<th>Name</th>
			<th>Editovanje</th>
			
		</tr>
		<c:if test="${not empty listaDom}">
			<c:forEach var="i" items="${listaDom}">
				<tr>
					<td>${i.naziv }</td>
					<td><a
						href="/Planinar/planinarskiDomController/admin/editujDom?idD=${i.idPlaninarskiDom }">Edit</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<a class="insert" href="/Planinar/planinarskiDomController/admin/getDodajDom">Add</a>
 </div>
  </div>
  <%@ include file="../footer.jsp"%>
  </div>
</body>
</html>