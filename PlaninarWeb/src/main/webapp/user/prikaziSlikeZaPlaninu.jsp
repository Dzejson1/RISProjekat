<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="container"> 
<%@ include file="../header.jsp"%>
<div id="main">
    <div id="text">  
<c:if test="${! empty slike}">
 <section id="photos"> -->
<c:forEach items="${slike }" var="slika">


 	<img height="100" width="100" src="/Planinar/slikeController/user/get-image/${slika.idSlika}"/><br/><br/>


 
 </c:forEach>
   </section> 
 </c:if>
 </div>
  </div>
  <%@ include file="../footer.jsp"%>
  </div>
</body>
</html>