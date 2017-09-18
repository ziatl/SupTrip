<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/jumbottron-narrow.css">
<title>Ajout de campus Supinfo</title>
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
          <a class="navbar-brand" href="index">SupTrip</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" method="post" action="<%=request.getContextPath()%>/login">
            <button type="submit" class="btn btn-success" name="bouton" value="deconnexion">Deconnection</button>         
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>
     </div>

      <div class="jumbotron">
      <fieldset>
      	<legend align="left" >Ajout de campus Supinfo</legend>
      
    
			<form method="post" action="<%=request.getContextPath()%>/admin">			
				<div class="form-group">
					<label for="ville">Ville</label> <input
						type="text" name="ville" class="form-control" id="ville"
						placeholder="Ville">
				</div>		
				<div class="form-group">
					<label for="Contact">Contact</label> <input
						type="text" name="contact" class="form-control" id="contact"
						placeholder="Contact">
				</div>	
				
				<div class="form-group">
					<label for="Email">Email address</label> <input
						type="email" name="email" class="form-control" id="email"
						placeholder="Email">
				</div>
				<div class="form-group">
					<label for="Dscription">Description</label>
					<textarea name="description" class="form-control" rows="3" placeholder="Donnez une description!!"></textarea>			
				</div>
							
				<button type="submit" class="btn btn-default" name="bouton" value="creer">Submit</button>
			</form>
		</fieldset>           
        </div>
      </div>

      <footer class="footer" align = "center">
        <p>&copy; 2015 Okpafaces, Inc.</p>
      </footer>

     <!-- /container -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"> </script> 
</body>
</html>