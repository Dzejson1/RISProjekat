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
			<th>Editovanje</th>
			<th>Brisanje</th>
			
		</tr>
		<c:if test="${not empty listaEditTipZnam}">
			<c:forEach var="i" items="${listaEditTipZnam}">
				<tr>
					<td>${i.opis }</td>
					
					<td><a
						href="/Planinar/tipZnamenitostiController/admin/editTipoveZnamenitosti?idTZ=${i.idTipZnamenitosti }">Edit</a></td>
						<td><a
						href="/Planinar/tipZnamenitostiController/admin/obrisiTipZnamenitosti?idTZ=${i.idTipZnamenitosti }">Obrisii</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<a class="insert" href="/Planinar/znamenitostController/admin/getDodajZnamenitost">Add</a>
 </div>
		 
		
    
	
	<!-- content -->
   
<!--    </div> -->
  
  </div>
  <%@ include file="../footer.jsp"%>
  </div>
  
<!-- </div> -->




</body>
</html>