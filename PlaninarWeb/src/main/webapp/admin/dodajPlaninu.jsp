<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix='sec'
	uri='http://www.springframework.org/security/tags'%>  
	
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/styles.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



 <sec:authorize access="hasRole('admin')">
<form action="/Planinar/planinaController/admin/UnesiPlaninu" method="post">
Unesi naziv planine<input type="text" name="naziv"><br/>
<input type="submit" value="Dodaj">
</form><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>
</sec:authorize> 
</body>
</html>