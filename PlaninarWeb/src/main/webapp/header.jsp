<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix='sec'
	uri='http://www.springframework.org/security/tags'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebStore</title>
<%-- <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/styles.css"> --%>
	
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/style.css">
</head>
<body>



	<sec:authorize access="hasRole('admin')">
  <div id="header">
    <div id="logo"><a href="#">Natural blues</a></div>
  </div>
  <div id="menu"> <a href="/Planinar/index.jsp">Home</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
  <a href="/Planinar/planinaController/admin/prikaziCPlanine">Planine</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
  <a href="/Planinar/stazaController/admin/prikaziCStaze">Staza</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
  <a href="#">Pricing</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
  <a href="/Planinar/auth/logout">Log out</a>
  </div>
</sec:authorize>

<sec:authorize access="hasRole('user')">
<a href="/Planinar/stazaController/user/pretraziCStaze">Staza</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
</sec:authorize>
	<%-- <div class="menu">
		<a href="/WebStore/home" id="logo"><img src="${pageContext.request.contextPath }/images/e-commerce-icon-lg.png" width="50" height="45"></a>
		<sec:authorize access="hasRole('admin')">
			<a href="/Planinar/planinaController/admin/prikaziCPlanine"><button class="btn">Planina</button></a>
			<a href="/Planinar/stazaController/admin/prikaziCStaze"><button class="btn">Staza</button></a>
			<a href="/WebStore/discount/admin"><button class="btn">Discounts</button></a>
		</sec:authorize>
		<sec:authorize access="hasRole('user')">
			<a href="/WebStore/category/user"><button class="btn">Categories</button></a>
			<a href="/WebStore/cart/wishlist"><button class="btn">Wish list</button></a>
			<a href="/WebStore/cart"><button class="btn">Cart</button></a>
		</sec:authorize>
		<a href="/WebStore/home/account"><button class="btn">Account</button></a> 
		<a href="/Planinar/auth/logout"><button class="btn">Logout</button></a>
			<c:url var="loginUrl" value="/perform_logout" />
			<form action="${loginUrl }" method="post"> 
	</div> --%>