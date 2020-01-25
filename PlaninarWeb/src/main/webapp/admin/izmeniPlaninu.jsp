<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%-- <%@ include file="../header.jsp"%> --%>
 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="container"> 
<%@ include file="../header.jsp"%>


<div id="main">
  
    <!-- content -->
	 
	
    <div id="text">  
	<form action="/Planinar/planinaController/admin/izmeniCPlaninu" method="post">
		<%-- <select name="idP">
			<c:forEach items="${planine }" var="p">
				<option value="${p.idPlanina }">${p.naziv }</option>
			</c:forEach>
		</select><br/> --%>

		<br/>
		<br/>
		<br/>
		<input type="text" value="${planina.naziv}" name="naziv"><br/>
		
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
	 <input type="submit" value="Izmeni">
	</form>
	
	<br />
	<!-- <form action="/Planinar/index.jsp">
		<input type="submit" value="Back home">
	</form> -->
	    </div>
		 
		
    
	
	<!-- content -->
   
<!--    </div> -->
  
  </div>
  <%@ include file="../footer.jsp"%>
  </div>
 
</body>
</html>