<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix='sec'
	uri='http://www.springframework.org/security/tags'%>
<!DOCTYPE html>
<html>
<head>

 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
markoooooooooooooooo
<div id="container">

<%@ include file="header.jsp"%>


<div id="main">
  
    content
	
	
    <div id="text">
		<h1>
		Welcome,
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.username" />
		</sec:authorize>
		</h1>
    </div>
	
	content
   
  </div>
  
  
  <%@ include file="footer.jsp"%>
  
  
</div>









<%-- <div class="content">
	<h1>
		Welcome,
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.username" />
			<sec:authentication property="principal.lastName" />
		</sec:authorize>
	</h1>
	<br>
	
	
	<sec:authorize access="hasRole('admin')">
		<h2>Orders</h2>
		<br>
		<form action="/WebStore/report/orders" method="get">
			<label>Date: </label> <br> <input type="date" name="date">
			<br> <br> <input type="submit" class="btn"
				value="Get report">
		</form>
	</sec:authorize>
	<sec:authorize access="hasRole('user')">
		<h2>Discounts</h2>
		<br>
		<div class="grid-container">
			<c:forEach var="i" items="${items }">
				<c:if test="${i.key.stock gt 0 }">
					<a href="/WebStore/product/user/details?idItem=${i.key.idItem }"><button
							class="grid-item">${i.key.name } (${i.value }% off:
							$${i.key.price - i.key.price * i.value / 100})</button></a>
				</c:if>
			</c:forEach>
		</div>
	</sec:authorize>
	<c:if test="${not empty errMsg }">
		<div class="erros">${errMsg }</div>
	</c:if>
</div> --%>




 <%-- <c:url var="loginUrl" value="/perform_logout" />
<form action="${loginUrl }" method="post"> 
<input type="submit" value="Logout">
</form><br/>

<a href="<c:url value="/perform_logout" />">Logout</a><br/>


<sec:authorize access="hasRole('admin')">
TIP ZNAMENITOSTI<br/>
<a href="/Planinar/admin/dodajTipZnamenitosti.jsp">Unesi tip znamenitosti</a><br/>
<a href="/Planinar/tipZnamenitostiController/admin/getEditTipoveZnamenitosti">Izmeni tip znamenitosti</a><br/>
<a href="/Planinar/tipZnamenitostiController/admin/getObrisiTipoveZnamenitosti">Obrisi tip znamenitosti</a><br/>


PLANINA<br/>
<a href="/Planinar/admin/dodajPlaninu.jsp">Unesi planinu</a><br/>
<a href="/Planinar/planinaController/admin/prikaziPlanine">Izmeni planinu</a><br/>


STAZA<br/>
<a href="/Planinar/stazaController/admin/getDodajPlanine">Unesi stazu</a><br/>
<a href="/Planinar/stazaController/admin/getIzmeniStaze">Izmeni stazu</a><br/>
</sec:authorize>
<sec:authorize access="hasRole('user')">
TIP ZNAMENITOSTI<br/>
</sec:authorize>
<a href="/Planinar/user/pretraziStazu.jsp">Pretrazi stazu za uneti id</a><br/>


<sec:authorize access="hasRole('admin')">
ZNAMENITOST<br/>
<a href="/Planinar/znamenitostController/admin/getDodajZnamenitost">Unesi znamenitost</a><br/>
<a href="/Planinar/znamenitostController/admin/getIzmeniZnamenitost">Izmeni znamenitost</a><br/>
<a href="/Planinar/znamenitostController/admin/getObrisiZnamenitost">Obrisi znamenitost</a><br/>
</sec:authorize>
<sec:authorize access="hasRole('user')">
ZNAMENITOST<br/>
</sec:authorize>
<a href="/Planinar/user/pretraziZnamenitost.jsp">Pretrazi znamenitost za uneti id</a><br/>


KORISNIK<br/>
<a href="/Planinar/korisnikController/user/getDodajKorisnika">Unesi korisnika</a><br/>
<a href="/Planinar/korisnikController/user/getIzmeniKorisnika">Izmeni korisnika</a><br/>


KOMENTAR<br/>
<a href="/Planinar/komentarController/user/getDodajKomentar">Unesi komentar</a><br/>
<a href="/Planinar/komentarController/user/getIzmeniKomentar">Izmeni komentar</a><br/>
<a href="/Planinar/komentarController/user/getObrisiKomentar">Obrisi komentar</a><br/>


ZAKAZIVANJE<br/>
<a href="/Planinar/zakazivanjeController/user/getDodajZakazivanje">Unesi zakazivanje</a><br/>
<a href="/Planinar/zakazivanjeController/user/getIzmeniZakazivanje">Izmeni zakazivanje</a><br/>
<a href="/Planinar/zakazivanjeController/user/getObrisiZakazivanje">Obrisi zakazivanje</a><br/>


<sec:authorize access="hasRole('admin')">
PLANINARSKI DOM<br/>
<a href="/Planinar/planinarskiDomController/admin/getDodajDom">Unesi planinarski dom</a><br/>
<a href="/Planinar/planinarskiDomController/admin/getIzmeniDom">Izmeni planinarski dom</a><br/>
</sec:authorize>


REZERVACIJA SMESTAJA<br/>
<a href="/Planinar/rezervacijaSmestajaController/user/getDodajRezervacijuSmestaja">Unesi rezervaciju smestaja</a><br/>
<a href="/Planinar/rezervacijaSmestajaController/user/getIzmeniRezervacijuSmestaja">Izmeni rezervaciju smestaja</a><br/>
<a href="/Planinar/rezervacijaSmestajaController/user/getObrisiRezervacijuSmestaja">Obrisi rezervaciju smestaja</a><br/>


IZVESTAJ<br/>
<a href="/Planinar/izvestajController/user/getDodajIzvestaj">Unesi izvestaj</a><br/>
<a href="/Planinar/izvestajController/user/getIzmeniIzvestaj">Izmeni izvestaj</a><br/>
<a href="/Planinar/izvestajController/user/getObrisiIzvestaj">Obrisi izvestaj</a><br/>


SLIKE<br/>
<a href="/Planinar/slikeController/user/getDodajSlike">Unesi sliku</a><br/>
<a href="/Planinar/slikeController/user/getIzmeniSlike">Izmeni sliku</a><br/>
<a href="/Planinar/slikeController/user/getObrisiSlike">Obrisi sliku</a><br/>
<a href="/Planinar/user/pretraziSlike.jsp">Pretrazi slike</a><br/> --%>


</body>
</html>