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
<title>Administration</title>
</head>
<body>
	<div class="container" >
	<div class="header clearfix ">      
     
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
                 
                
              
            </ul>
            
        </div><!-- /.navbar-collapse -->     
      </div>
    </nav>
     </div> 
      <br> 
     <div class="col-md-6 col-md-offset-3 container" align="center"><br><br><br>
    
      	  
      	   <div class="login-panel panel panel-primary" >
      	   <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                      <div class="panel-body" align="center">
			<form method="post" action="<%=request.getContextPath()%>/login" role="form" >	
			<fieldset>
			     
			        <div>
				        <label for="login" >Login</label>
				        <input type="text" id="login" class="form-control" placeholder="login" name="login" style="width : 200px" >
			        </div>
			        <div>
				        <label for="password">Password</label>
				        <input type="password" id="password" class="form-control" placeholder="Password" name="password" style="width : 200px"> <br>
			    	</div>  
     		  
			        <button class="btn btn-lg btn-primary btn-block" type="submit" name="bouton" value="campus" style="width : 100px">Sign in</button>
     		 
     		    </fieldset>
  </form>
     		 
     		 </div>   
     		 </div>  
		
		 <br> 
      </div>

      

    </div> <!-- /container --> <br>  <br>  <br>  <br>  <br>  <br>  <br> 
    <div class="footer clear-fix">
    <footer align = "center">
        <p>&copy; 2015 Okpafaces, Inc.</p>
      </footer>
    </div>
    
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"> </script>
</body>
</html>