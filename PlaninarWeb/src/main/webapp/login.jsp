<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Uloguj se!</title>

<meta charset="iso-8859-2"/>

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
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #754caf;
  text-decoration: none;
}
.form .register-form {
  display: none;
}
</style>

</head>
<body>


<!--==============================Content=================================-->
<c:url var="loginUrl" value="/login" />
<div class="form">
	<form class="login-form" action="${loginUrl}" method="POST">

		<div class="login-page">
			<div class="form">
				
				
					<input type="text" name="username" placeholder="username" /> 
					<input type="password" name="password" placeholder="password" />
					<button>login</button>
					<p class="message">
						Nemate nalog? <a href="/Planinar/auth/registerUser">Registrujte se</a>
					</p>
			
			</div>
		</div>


		
	</form>
</div>
</body>
</html>