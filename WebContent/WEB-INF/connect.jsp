<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/jumbottron-narrow.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/elfinder.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/style.css">
<title>Ajouter Voyage</title>
</head>
<body>
	<div class="container">
	<div class="header clearfix">      
     
      <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=request.getContextPath()%>/index">SupTrip</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
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

				</div><!--/.navbar-collapse -->
      </div>
    </nav>
     </div>
	<br><br>
      <div class="jumbotron">
      
      <fieldset>
      	<legend>Reservez vos voyages ici !! <br><i style="color: red;">${erreur}</i></legend>
		<br><br>	<form method="post" action="<%=request.getContextPath()%>/user/trip">	
			<div>		
				<div class="form-group col-md-6">
                   <p align="center"> <label for="idSource">Campus source</label> </p>
                   <div>
                 	<select class="form-control" name="idSource" id="idSource"  >
					  <c:forEach items="${listeCampus}" var="l"> 
					  	<option value="${l.idCampus}"> <c:out value="${l.nom}" />  </option>
					  </c:forEach>  
					</select></div>
                 </div>  
  
                 <div class="form-group col-md-6">
                   <div><p> <label for="idDest">Campus Destination</label> </p></div>
                   <div>
                 	<select class="form-control" name="idDest" id="idDest" >
					  <c:forEach items="${listeCampus}" var="l"> 
					  	<option value="${l.idCampus}"> <c:out value="${l.nom}" />  </option>
					  </c:forEach>  
					</select>
					</div>
                 </div>
                 <br><br>  
                 </div>	
                 	
				<button type="submit" class="btn btn-success" name="bouton" value="addTrip">Valider</button>
			</form>
	 </fieldset>	
        </div>
      </div>

      <footer class="footer" align = "center">
        <p>&copy; 2015 Okpafaces, Inc.</p>
      </footer>

    </div> <!-- /container -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"> </script>  
</body>
</html>