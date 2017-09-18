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
<title>Profil</title>
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
             <form class="navbar-form navbar-right" action="<%=request.getContextPath()%>/connexion" method="post">
                <button type="submit" class="btn btn-success" name="bouton" 
						value="disconnect">Deconnexion</button>
            </form>
            
        </div><!-- /.navbar-collapse -->     
      </div>
    </nav>
     </div> 
     <div>
     <br>	<h3 align="center">Votre profil utilisateur</h3> <br>
     </div>
     <div class="jumbotron">         
               <p align="left"><span class="glyphicon glyphicon-asterisk" aria-hidden="true" width="100px"></span> <strong>IdBooster</strong> </p>
                <p style="color: highlighttext;">${user.idBooster}</p>
          
          		<hr>
                 <p align="left"><span class="glyphicon glyphicon-tag" aria-hidden="true" width="100px"></span> <strong>Nom</strong> </p>
               <p style="color: highlighttext;">${user.nom}</p>
                
                <hr>
                 <p align="left"><span class="glyphicon glyphicon-tags" aria-hidden="true" width="100px"></span> <strong>Prenom</strong> </p>
                 <p style="color: highlighttext;">${user.prenom}</p>
                 
                <hr>
                 <p align="left"><span class="glyphicon glyphicon-comment" aria-hidden="true" width="100px"></span> <strong>Email</strong> </p>                      
                 <p style="color: highlighttext;">${user.email}</p>
                 
                 <hr>
                 <p align="left"><span class="glyphicon glyphicon-education" aria-hidden="true" width="100px"></span> <strong>Campus</strong> </p>
               <p style="color: highlighttext;">${user.campus.nom}</p><hr>
               <form class="navbar-form"
				action="<%=request.getContextPath()%>/user/modification" align="center">

				<button type="submit" class="btn btn-success" name="bouton"
					value="connexion" >Modification</button>
			</form>
               <div>
			
			
			
		</div>
            </div>
		


		<!-- /container -->  
      </div>

      <footer class="footer" align = "center">
        <p>&copy; 2015 Okpafaces, Inc.</p>
      </footer>

 
    
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"> </script>
</body>
</html>