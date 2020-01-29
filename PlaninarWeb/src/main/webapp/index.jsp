<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix='sec'
	uri='http://www.springframework.org/security/tags'%>
<!DOCTYPE html>
<html>
<head>

 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="container">

<%@ include file="header.jsp"%>
<div id="main">
  
    <div id="text">
    	<br/>
		<br/>
		<br/>
		<br/>
		<h1>
		
		Welcome,
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.username" />
		</sec:authorize>
		
		</h1>
		<br/>
		<br/>
		<br/>
    </div>
    
		
  </div>
  <%@ include file="footer.jsp"%>
</div>
</body>
</html>