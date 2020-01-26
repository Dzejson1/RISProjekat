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
			<th>Slika</th>
			<th>Izaberi znamenitosti</th>
		</tr>
		<c:if test="${not empty staze}">
			<c:forEach var="staza" items="${staze}">
				<tr>
					<td>${staza.opis }</td>
					<td>
					<div >
 						<img height="100" width="100" src="/Planinar/stazaController/user/get-image/${staza.idStaza}"/><br/><br/>
					</div> 
					
					</td>
					<td><a
						href="/Planinar/znamenitostController/user/prikaziSveZnamenitosti?idS=${staza.idStaza }"><img src="${pageContext.request.contextPath }/images/edit.jpg"></a>
					</td>
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