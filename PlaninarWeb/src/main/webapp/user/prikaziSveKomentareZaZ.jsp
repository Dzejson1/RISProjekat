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
<c:if test="${! empty komentari}">

<c:forEach items="${komentari }" var="komentar">
<h1>Komentar:</h1> <br/>
<div class="paper">
    <div class="paper-content">
<textarea readonly><c:out value="${komentar.opis }" /> </textarea>
</div>
</div>

 
 </c:forEach>
  
 </c:if>
 <form action="/Planinar/user/prikaziZnamenitosti.jsp">
 <input type="submit" value="Back">
 </form>
 </div>
  </div>
  <%@ include file="../footer.jsp"%>
  </div>
</body>
</html>