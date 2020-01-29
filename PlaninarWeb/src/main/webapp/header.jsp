<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix='sec'
	uri='http://www.springframework.org/security/tags'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Planinarsko_drustvo</title>
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/style.css">
</head>
<body>
	<sec:authorize access="hasRole('admin')">
  <div id="header">
    <div id="logo">Planinarsko_drustvo</div>
  </div>
  <div id="menu"> 
  <a href="/Planinar/index.jsp">Home</a> 
  <a href="/Planinar/planinaController/admin/prikaziCPlanine">Planine</a>
  <a href="/Planinar/stazaController/admin/prikaziCStaze">Staza</a> 
  <a href="/Planinar/znamenitostController/admin/prikaziCZnamenitosti">Znamenitosti</a>
  <a href="/Planinar/tipZnamenitostiController/admin/getEditTipoveZnamenitosti">Tip_znamenitosti</a> 
  <a href="/Planinar/znamenitostController/admin/prikaziZnamenitosti">Spisak_termina</a>
  <a href="/Planinar/planinaController/admin/prikaziSvePlanine">Statistika_nocenja</a> 
  <a href="/Planinar/planinarskiDomController/admin/prikaziDomove">Planinarski_dom</a>   
  <a href="/Planinar/korisnikController/admin/UnesiKorisnika">Korisnik</a> 
  <a href="/Planinar/auth/logout">Logout</a>
  </div>
</sec:authorize>

<sec:authorize access="hasRole('user')">
<div id="header">
    <div id="logo">Planinarsko_drustvo</div>
  </div>
   <div id="menu"> 
   <a href="/Planinar/index.jsp">Home</a> &nbsp;
   <a href="/Planinar/rezervacijaSmestajaController/user/prikaziPlanine">Rezervacija smestaja</a> &nbsp;  
   <a href="/Planinar/znamenitostController/user/prikaziPlanine">Prikazi znamenitosti</a> &nbsp;  
   <a href="/Planinar/slikeController/user/prikaziPlanineZaSLike">Slike</a> &nbsp; 
   <a href="/Planinar/izvestajController/user/prikaziPlanineZaIzvestaj">Izvestaj</a> &nbsp; 
   <a href="/Planinar/auth/logout">Logout</a>
</div>
</sec:authorize>
