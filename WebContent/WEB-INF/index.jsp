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
<title>Accueil</title>
</head>
<body>
	<div class="container">
	<div class="header clearfix">   
      </div>
     <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container container-fluid ">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand " href="<%=request.getContextPath()%>/index">SupTrip</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="<%=request.getContextPath()%>/index"><span class="glyphicon glyphicon-home" aria-hidden="true" style="color:white"></span> <span style="color: white"> Accueil </span></a></li>
                <li><a href="<%=request.getContextPath()%>/list"><span class="glyphicon glyphicon-plane" aria-hidden="true" style="color:white" ></span><span style="color: white"> Voyages </span></a></li>
                <li><a href="<%=request.getContextPath()%>/index#stat" class="page-scroll"><span class="glyphicon glyphicon-signal" aria-hidden="true" style="color:white" ></span><span style="color: white"> Statistiques</span></a></li>
                <li><a href="<%=request.getContextPath()%>/index#campus"><span class="glyphicon glyphicon-education" aria-hidden="true" style="color:white" ></span><span style="color: white"> Campus </span></a></li>

            </ul>
            <form class="navbar-form navbar-right" action="<%=request.getContextPath()%>/connexion" >

                <button type="submit" class="btn btn-primary" name="bouton" value="connexion">Connexion</button>
            </form>
            
        </div><!-- /.navbar-collapse -->
       
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
		</div>

      <div class="jumbotron">
      
        <h1 >Bienvenue sur Supinfo Trip</h1>
        <p class="lead" style="color: appworkspace;">En tant que etudiant a Supinfo, vous avez la possibilite de voyager autant que vous voulez entre campus. Reservez vos voyage ici!!!</p>
        
        <p><a class="btn btn-lg btn-primary" href=" <%=request.getContextPath()%>/inscription" >S'inscrire</a></p>
      </div> 
        <br><br id="stat"><hr style="height: 3px; color: #839D2D; width: 50%; border:2px dashed rgba(73, 121, 251, 0.97);"  >
       <br> <h3 align="center" class="hit-the-floor">Statistiques</h3><br><br>
	<div class="row" align="left">
			<div class="col-lg-3 col-md-6 col-md-offset-1">
                    <div class="panel panel-primary ">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3 ">
                                    <i class="fa fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><h4 style="color: yellow;">${nbC}</h4></div>
                                    <div>Campus</div> <br>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-md-offset-1">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><h4 style="color: yellow;">${nbV}</h4></div>
                                    <div>Voyages possibles</div>
                                </div>
                            </div>
                        </div>
                        <a href="<%=request.getContextPath()%>/list">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                  <div class="col-lg-3 col-md-6 col-md-offset-1">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><h4 style="color: yellow;">${nbE}</h4></div>
                                    <div>Etudiants inscrit</div><br>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        <br >    <hr  style="height: 3px; color: #839D2D; width: 75%; border: 2px dashed rgba(73, 121, 251, 0.97);">
     <br id="campus">   <h3  class="hit-the-floor">Les Campus SUPINFO</h3><br>
      <div class="row marketing">
           <c:forEach items="${listeCampus}" var="l" step="1"> 
            <div class="col-lg-6" align = "center">
         	 <h4>${l.nom}</h4>
      	     <p>${l.description}</p>
           </div>
          </c:forEach>              
        </div>
     

      <footer class="footer" align = "center">
        <p>&copy; 2015 Okpafaces, Inc.</p>
      </footer>

    </div> <!-- /container -->
    
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"> </script>

</body>
</html>