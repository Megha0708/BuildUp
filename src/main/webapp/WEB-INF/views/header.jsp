<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<link rel="stylesheet" href="resources/bootstrap.min.css" >
<link rel="stylesheet" href="resources/bootstrap-theme.min.css" >
<script src="resources/bootstrap.min.js" ></script>
<script src="resources/jquery.min.js"></script> 

    <!DOCTYPE html>  
<html lang="en">  
<head>  
  <title>ThinkNew</title>  
  <meta charset="utf-8">  
  <meta name="viewport" content="width=device-width, initial-scale=1">  
  <link rel="stylesheet" href="resources/bootstrap.min.css">  
    
</head>  
<body>  
<script type='text/javascript' data-cfasync='false'>window.purechatApi = { l: [], t: [], on: function () { this.l.push(arguments); } }; (function () { var done = false; var script = document.createElement('script'); script.async = true; script.type = 'text/javascript'; script.src = 'https://app.purechat.com/VisitorWidget/WidgetScript'; document.getElementsByTagName('HEAD').item(0).appendChild(script); script.onreadystatechange = script.onload = function (e) { if (!done && (!this.readyState || this.readyState == 'loaded' || this.readyState == 'complete')) { var w = new PCWidget({c: 'd9bb0de5-2a57-41c2-80e2-8d33f89617a3', f: true }); done = true; } }; })();</script>

<div class ="row">




<div class="col-xs-1 pull-left">
 <h1>Think<scan style="color:FC04A1">New</scan></h1>
</div>

    			<div class="col-xs-1 pull-right">
          
                        <a href="#" class="icoRss" title="Rss"><i class="fa fa-rss"></i></a></li>
                        <a href="#" class="icoFacebook" title="Facebook"><i class="fa fa-facebook"></i></a></li>
                        <a href="#" class="icoTwitter" title="Twitter"><i class="fa fa-twitter"></i></a></li>
                        <a href="#" class="icoGoogle" title="Google +"><i class="fa fa-google-plus"></i></a></li>
                        <a href="#" class="icoLinkedin" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
                   				
				</div>
	

    <c:if test="${not sessionScope.UserLoggedIn && not sessionScope.Administrator }">  

                <div class="pull-right">			
<a href="Login"><img src="resources/My_Design/cart.png" height="70px" 
                     width="70px"></img></a>
                     
                     <c:if test="${not empty count}">
                     <center>${count}</center>
                     
                     </c:if>
                    
                     
</div>        
</c:if>

<c:if test="${ sessionScope.UserLoggedIn }">  

                <div class="pull-right">			
<a href="GoToCart"><img src="resources/My_Design/cart.png" height="70px" 
                     width="70px"></img></a>
                     
                     <c:if test="${not empty count}">
                     <center>${count}</center>
                     
                     </c:if>
                    
                     
</div>        
</c:if>
</div>
   

 <nav class="navbar navbar-inverse"> 

  <div class="container-fluid">  
    <div class="navbar-header">  
      <a class="navbar-brand" href="index.jsp">ThinkNew</a>  
    </div>  
    <ul class="nav navbar-nav">  
      <li class="active"><a href="index.jsp"><span class="glyphicon glyphicon-user"></span> Home</a> 
      
     
<!--       <li><a href="AboutUs"><span class="glyphicon glyphicon-info-sign"></span> About Us</a></li>   -->
<!--       <li><a href="ContactUs"><span class="glyphicon glyphicon-phone-alt"></span> Contact Us</a></li>   -->
     
     
    
    
     <li><a href="fieldAdd"><span class="glyphicon glyphicon-th"></span> Explore Sectors</a></li> 
     
<c:if test="${ sessionScope.Administrator }"> 
      <li><a href="branchAdd"><span class="glyphicon glyphicon-th"></span> Branches</a></li> 
       <li><a href="domainAdd"><span class="glyphicon glyphicon-th"></span> Domains</a></li>
       </c:if> 
       <li><a href="postup"><span class="glyphicon glyphicon-th"></span> Timeline Updates</a></li>
   <li><a href="domainAdd"><span class="glyphicon glyphicon-th"></span> Give Mock Interview</a></li>
    </ul> 
    <ul class="nav navbar-nav navbar-right">  
    <c:if test="${not sessionScope.UserLoggedIn && not sessionScope.Administrator}">
     <li><a href="Login"><span class="glyphicon glyphicon-log-in"></span>SignIn</a></li>
      <li><a href="usersignup"><span class="glyphicon glyphicon-log-out"></span> Sign Up</a></li>
       <li><a href="orgsignup"><span class="glyphicon glyphicon-log-out"></span>Join Us as Mentor</a></li> 
      </c:if>
      <c:if test="${sessionScope.UserLoggedIn || sessionScope.Administrator}">  
       <li><a href="perform_logout">Log Out </a></li>
       </c:if>
        

      
         
       
      
      
    </ul>  
  </div>  
</nav>
    
<div class="container">  
<c:if test="${sessionScope.UserLoggedIn }">
<li style="font-size:150%;list-style-type:none"><b>Welcome ${Userid}</b></li>
</c:if>    
</div>  
 
 
</body>  
</html>  
