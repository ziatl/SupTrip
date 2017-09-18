<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/jumbottron-narrow.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/style.css">
<title>Modification</title>
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
       <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="<%=request.getContextPath()%>/index"><span class="glyphicon glyphicon-home" aria-hidden="true" style="color:white"></span> <span style="color: white"> Acceuil </span></a></li>
                <li><a href="<%=request.getContextPath()%>/user/bag"><span class="glyphicon glyphicon-plane" aria-hidden="true" style="color:white" ></span><span style="color: white"> Voyages </span> <span class="badge color-theme " style="color: black" ></span></a></li>
                <li><a href="<%=request.getContextPath()%>/user/profil"><span class="glyphicon glyphicon-user" aria-hidden="true" style="color:white" ></span> <span style="color: white"> Profil </span></a></li>
                 <li><a href="<%=request.getContextPath()%>/index#stat"><span class="glyphicon glyphicon-signal" aria-hidden="true" style="color:white" ></span><span style="color: white"> Statistiques</span></a></li>
                <li><a href="<%=request.getContextPath()%>/index#campus"><span class="glyphicon glyphicon-education" aria-hidden="true" style="color:white" ></span><span style="color: white"> Campus </span></a></li>
                
            </ul>
            <form class="navbar-form navbar-right"
					action="<%=request.getContextPath()%>/connexion" method="post">
					
					<button type="submit" class="btn btn-success" name="bouton"
						value="disconnect">Deconnexion</button>
				</form>
        </div><!-- /.navbar-collapse -->
      </div>
    </nav>
     </div>

     <div>
     
     </div>
     <div class="container">
      <fieldset >
      	<legend align="left" >Creation de compte Suptrip</legend>
			<form method="post" action="<%=request.getContextPath()%>/user/modification" >			
				<div class="col-md-6" >
					<div class="form-group">
						<label for="idBooster">IdBooster</label> <input  disabled
							type="text" name="idBooster" class="form-control" id="idBooster"
							placeholder="idBooster" value="${user.idBooster}"> <p style="color : red" >${erreurs.id}</p>
					</div>
					<div class="form-group">
						<label for="Nom">Nom</label> <input
							type="text" name="nom" class="form-control" id="nom"
							placeholder="Nom" value="${user.nom}"> <p style="color : red" >${erreurs.nom}</p>
					</div>		
					<div class="form-group ">
						<label for="Prenom">Prenom</label> <input
							type="text" name="prenom" class="form-control" id="prenom"
							placeholder="Prenom"  value="${user.prenom}" > <p style="color : red" >${erreurs.prenom}</p>
					</div>	
					
					<div class="form-group">
						<label for="Email">Email address</label> <input
							type="email" name="email" class="form-control" id="email"
							placeholder="Email"  value="${user.email}"><p style="color : red" >${erreurs.email}</p>
					</div>
					<div class="form-group">
						<label for="password">Mot de passe</label> <input
							type="password" name="password" class="form-control" id="passwordConf"
							placeholder="Password"  value="${user.password}"> <p style="color : red" >${erreurs.password}</p>
					</div>	
					<div class="form-group">
						<label for="passwordConf">Confirmation de mot de passe</label> <input
							type="password" name="passwordConf" class="form-control" id="passwordConf"
							placeholder="Password confirmation">
					</div>	
					<div class="form-group">
	                    <label for="idCategorie">Campus</label>
	                 	<select class="form-control" name="idCampus" id="idCampus"  >
						  <c:forEach items="${listeCampus}" var="l"> 
						  	<option value="${l.idCampus}"> <c:out value="${l.nom}" />  </option>
						  </c:forEach>  
						</select>
	                 </div>  	
	                 		
					<button type="submit" class="btn btn-default" name="bouton" value="modification">Submit</button>
					
				</div>
				</form>		
			
	 </fieldset>	
	 					 
			<br>
      </div>
      <div sytle= "margin-top : 134px"></div>
      <footer class="footer" align = "center">
        <p>&copy; 2015 Okpafaces, Inc.</p>
      </footer>
</div>
    
</body>
</html>