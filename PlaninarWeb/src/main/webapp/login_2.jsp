<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix='sec'
	uri='http://www.springframework.org/security/tags'%>
<%--  <sec:authorize access="!hasRole('ROLE_ANONYMOUS')">
	<%
		response.sendRedirect("/Planinar/index.jsp");
	%>
</sec:authorize>  --%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	font-family: "Times New Roman, Times, serif";
	text-align: center;
	background-color: cyan;
	text-align: center;
	color: white;
}

login {
	font-size: 56px;
	
	
	color: blue;
}
</style>

<meta charset="UTF-8">
 
<%--   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/styles.css">  --%>
  
  
<title>Webstore login</title> 
</head>
<body>
<%-- Putanja jeeeeeeeeeeee ${pageContext.request.contextPath } --%>
	<br>
	<h1>Welcome to Webstore</h1>
	<br>
	<br>
	<h2>Please log in</h2>
	<br>
	<c:url var="loginUrl" value="/login" />
	${loginUrl }
	<c:if test="${param.error ne null }">
		<div class="error">
			Invalid credentials.
		</div>
	</c:if>
	<form id="login" action="${loginUrl }" method="post">
		<label>Username: </label> <br> <input type="text" name="username">
		<br> <label>Password: </label> <br> <input type="password"
			name="password"> <br> <br> <input type="hidden"
			name="${_csrf.parameterName }" value="${_csrf.token }"> <input
			class="btn" type="submit" value="Log in">
	</form>
	<br>
	<a href="/WebStore/auth/register"><button class="btn">Register</button></a>
</body>
</html>