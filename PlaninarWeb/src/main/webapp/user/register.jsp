<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
}
.form input {
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  text-transform: uppercase;
  outline: 0;
  background: #4CAF50;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
 .form button:hover,.form button:active,.form button:focus {
  background: #43A047;
} 

</style>
</head>
<body>
<sf:form class="form" modelAttribute="user"  action="/Planinar/auth/register"  method="post">
			<!-- <form class="register-form"> -->
					<sf:input  path="ime" placeholder="Unesite ime"/> 
					<sf:input  path="username" placeholder="Unesite username"/>
					<%-- <sf:input  path="password"/> --%>
					<input type="password" name="password" placeholder="Unesite password">
					<button>create</button>
					<!-- <input type="submit" value="Sacuvaj"> -->
	</sf:form>				
				<!-- </form>  -->
  <%-- <table>
  	<tr>
  	   <td>Ime:</td><td><sf:input  path="ime"/>
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
  	</table> --%>


</body>
</html>