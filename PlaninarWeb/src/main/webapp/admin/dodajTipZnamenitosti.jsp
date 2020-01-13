<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/Planinar/tipZnamenitostiController/admin/UnesiTipZnamenitosti" method="post">
Unesi opis znamenitosti<input type="text" name="opis"><br/>
<input type="submit" value="Dodaj">
</form><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form>

</body>
</html>