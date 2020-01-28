<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"> 
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath }/css/styles.css">  --%>

</head>
<body>

<div id="container">

<%@ include file="../header.jsp"%>


<div id="main">
  
    <!-- content -->
	 
	
    <div id="text"> 
		
		<!-- <div class="content"> -->
	<h2>Planina</h2>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Spisak</th>
			<th>Generisi pdf izvestaj</th>
			
		</tr>
		<c:if test="${not empty listaZ}">
			<c:forEach var="i" items="${listaZ}">
				<tr>
					<td>${i.opis }</td>
					
					<td><a
						href="/Planinar/znamenitostController/admin/prikaziSpisakTerminaPosebeZnamenitosti?idZ=${i.idZnamenitost }">Prikazi spisak</a>
					</td>
					<td><a
						href="/Planinar/znamenitostController/admin/generisiPdfIzvestaj?idZ=${i.idZnamenitost }">Generisi</a>
					</td>
						
				</tr>
			</c:forEach>
		</c:if>
	</table>

 </div>
		 
		
    
	
	<!-- content -->
   
<!--    </div> -->
  
  </div>
  <%@ include file="../footer.jsp"%>
  </div>
  
<!-- </div> -->




</body>
</html>