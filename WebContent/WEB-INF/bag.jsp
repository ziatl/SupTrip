<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/bootstrap/css/jumbottron-narrow.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/bootstrap/css/style.css">
	
<title>Vos voyages</title>
</head>
<body>
	<div class="container">
		<div class="header clearfix"></div>
		<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=request.getContextPath()%>/index">SupTrip</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="<%=request.getContextPath()%>/index"><span
							class="glyphicon glyphicon-home" aria-hidden="true"
							style="color: white"></span> <span style="color: white">
								Acceuil </span></a></li>
					<li><a href="<%=request.getContextPath()%>/user/bag"><span
							class="glyphicon glyphicon-plane" aria-hidden="true"
							style="color: white"></span><span style="color: white">
								Voyages </span> <span class="badge color-theme " style="color: black">${taille}</span></a></li>
					<li><a href="<%=request.getContextPath()%>/user/profil"><span
							class="glyphicon glyphicon-user" aria-hidden="true"
							style="color: white"></span> <span style="color: white">
								Profil </span></a></li>
								 <li><a href="<%=request.getContextPath()%>/index#stat"><span class="glyphicon glyphicon-signal" aria-hidden="true" style="color:white" ></span><span style="color: white"> Statistiques</span></a></li>
                <li><a href="<%=request.getContextPath()%>/index#campus"><span class="glyphicon glyphicon-education" aria-hidden="true" style="color:white" ></span><span style="color: white"> Campus </span></a></li>
								
				</ul>
				<form class="navbar-form navbar-right"
					action="<%=request.getContextPath()%>/connexion" method="post">
					
					<button type="submit" class="btn btn-success" name="bouton"
						value="disconnect">Deconnexion</button>
				</form>
			</div>
			<!-- /.navbar-collapse -->

		</div>
		</nav>
		<div align="center">
			<form class="navbar-form navbar-center" role="search" method="post" action="<%=request.getContextPath() %>/list">
				<div class="form-group">
					<input list="ville" type="text" id="choix_ville" name="ville" class="form-control" placeholder="Chercher Voyage par Ville">
					<datalist id="ville">
						 <c:forEach items="${listeCampus}" var="l" step="1" > 
						 <option value="${l.ville}">			
						</c:forEach>
					</datalist>
				</div>
			</form>
		</div><br>
		<div align="center"><a href="<%=request.getContextPath() %>/user/trip">
		<button type="button" class="btn btn-primary">Add Trip</button></div>
		</a> <br>


		<div class="monback">
		<fieldset>
			<legend>Detail de vos voyages non valides.</legend>
			
			<table
				class="table table-striped table-bordered bootstrap-datatable datatable responsive dataTable"
				id="DataTables_Table_0" aria-describedby="DataTables_Table_0_info">
				<thead>
					<tr role="row" class="info">
						<th class="sorting_asc" role="columnheader" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							aria-sort="ascending"
							aria-label="Username: activate to sort column descending"
							style="width: 175px;">Nom du Voyage</th>
						<th class="sorting" role="columnheader" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							aria-label="Date registered: activate to sort column ascending"
							style="width: 150px;">Ville Source</th>
						<th class="sorting" role="columnheader" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							aria-label="Role: activate to sort column ascending"
							style="width: 150px;">Ville Destination</th>						
						<th class="sorting" role="columnheader" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							aria-label="Actions: activate to sort column ascending"
							style="width: 138px;">Actions</th>
					</tr>
				</thead>
				
				<tbody role="alert" aria-live="polite" aria-relevant="all">
					<c:forEach items="${userTrips}" var="l" step="1" > 
					<tr class="odd">		
						
						<td class="sorting_1">${l.nom}</td>
						<td class="center ">${l.source}</td>
						<td class="center ">${l.destination}</td>					
						<td class="center ">
						<a class="btn btn-success"  href="<%=request.getContextPath()%>/user/bag?valider=${l.idVoyage}">
			<i class="glyphicon glyphicon-ok icon-white"></i> Valider
						</a> 
						<a class="btn btn-danger" href="<%=request.getContextPath()%>/user/bag?supprimer=${l.idVoyage}"> <i
								class="glyphicon glyphicon-remove icon-white"></i> Supprimer
						</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
		<form action="<%=request.getContextPath()%>/user/bag" method="post">
			<div align="center"><input type="submit"  class="btn btn-primary" value="Valider tout"   style="width: 175px;"> </div>
		</form>
		
		</div><br>
			<footer class="footer" align="center">
			<p>&copy; 2015 Okpafaces, Inc.</p>
			</footer>
	</div>
		
	<!-- /container -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js" > </script> 
</body>
</html>