<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"> 
</head>
<body>
<div id="container"> 
<%@ include file="../header.jsp"%>
<div id="main">
    <div id="text">  
<form action="/Planinar/tipZnamenitostiController/admin/UnesiTipZnamenitosti" method="post">
Unesi opis znamenitosti<input type="text" name="opis"><br/>
<input type="submit" value="Dodaj">
</form><br/>

  </div>
  </div>
  <%@ include file="../footer.jsp"%>
  </div>
</body>
</html>