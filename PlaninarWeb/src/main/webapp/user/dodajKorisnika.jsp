<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sf:form modelAttribute="user"  action="/Planinar/korisnikController/user/dodajKorisnika"  method="post">
Unesi ime korisnika<sf:input  path="ime"/><br/>
Unesi prezime korisnika<sf:input  path="prezime"/><br/>
Unesi username korisnika<sf:input  path="username"/><br/>
Unesi password korisnika<sf:password  path="password"/><br/>
Unesi datum isteka <input type="date" name="datum"> 
 
<input type="submit" value="Dodaj">
</sf:form><br/>
<sf:form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</sf:form>

<%--   <table>
  	<tr>
  	   <td>Ime:</td><td><sf:input  path="name"/>
  	   </td>
  	</tr>
  		<tr>
  	   <td>Korisnicko ime:</td><td><sf:input  path="username"/>
  	 </td>
  	</tr>
  	<tr>
  	   <td>Sifra:</td><td><sf:password  path="password"/></td>
  	</tr>
  	<tr><td/><td><input type="submit" value="Sacuvaj"></tr>
  	</table>
</sf:form> --%>

<!-- <form action="/Planinar/korisnikController/user/UnesiKorisnika" method="post">
Unesi ime korisnika<input type="text" name="ime"><br/>
Unesi prezime korisnika<input type="text" name="prezime"><br/>
Unesi username korisnika<input type="text" name="username"><br/>
Unesi password korisnika<input type="password" name="password"><br/>
<input type="submit" value="Dodaj">
</form><br/>
<form action="/Planinar/index.jsp">
<input type="submit" value="Back home">
</form> -->
</body>
</html>