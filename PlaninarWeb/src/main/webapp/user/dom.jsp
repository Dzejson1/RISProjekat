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
	<h2>Dom</h2>
	<table border="1">
		<tr>
			<th>Naziv planine</th>
			<th>Odaberi dom za rezervaciju</th>
			
		</tr>
		<c:if test="${not empty listaP}">
			<c:forEach var="i" items="${listaP}">
				<tr>
					<td>${i.naziv }</td>
					
					<td><a
						href="/Planinar/rezervacijaSmestajaController/user/prikaziDomove?idP=${i.idPlanina }">Odaberi dom</a></td>
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