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
			<th>Prikazi rezervisana nocenja</th>
			<th>Generisi pdf izvestaj</th>
			
		</tr>
		<c:if test="${not empty planine}">
			<c:forEach var="i" items="${planine}">
				<tr>
					<td>${i.naziv }</td>
					
					<td><a
						href="/Planinar/planinaController/admin/pronadjStatistikuNocenja?idP=${i.idPlanina }">Prikazi</a>
						</td>
						<td><a
						href="/Planinar/planinaController/admin/generisiPdfIzvestaj?idP=${i.idPlanina }">Generisi</a>
						</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<a class="insert" href="/Planinar/admin/dodajPlaninu.jsp">Add</a>
 </div>
		 
		
    
	
	<!-- content -->
   
<!--    </div> -->
  
  </div>
  <%@ include file="../footer.jsp"%>
  </div>
  
<!-- </div> -->




</body>
</html>