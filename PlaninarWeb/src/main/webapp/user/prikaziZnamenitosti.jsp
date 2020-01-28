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
			<th>Slika</th>
			<th>Unesi komentar</th>
			<th>Prikazi komentare</th>
			<th>Zakazi</th>
			
		</tr>
		<c:if test="${not empty listaZ}">
			<c:forEach var="i" items="${listaZ}">
				<tr>
					<td>${i.opis }</td>           
					<td>
					<div >  
 						<img height="100" width="100" src="/Planinar/znamenitostController/user/get-image/${i.idZnamenitost}"/><br/><br/>
					</div> 
					</td>
					<td><a
						href="/Planinar/komentarController/user/unesiKomentarZ?idZ=${i.idZnamenitost }">Unesi komentar</a>
					</td>
					
					<td><a
						href="/Planinar/komentarController/user/prikaziSveKomentareZaZnamenitost?idZ=${i.idZnamenitost }">Prikazi komentare</a>
					</td>
					<td>
					<c:if test="${i.potrebnoZakazati }">
					
					<a
						href="/Planinar/zakazivanjeController/user/unesiDatumZakaz?idZ=${i.idZnamenitost }">Zakazi
						
					</a>
					
					</c:if>
					<c:if test="${!i.potrebnoZakazati }">
						<h1>Ne treba zakazivanje!</h1>
					</c:if>
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