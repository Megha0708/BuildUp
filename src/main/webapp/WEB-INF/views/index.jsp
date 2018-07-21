<html>
<head>

<link rel="stylesheet" href="resources/My_Design/bootstrap.min.css" >
<link rel="stylesheet" href="resources/My_Design/bootstrap-theme.min.css" >
<script src="resources/My_Design/bootstrap.min.js" ></script>

  <title>BuildUp</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
</head>
<%@include file="header.jsp" %>
<body>



<center>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="resources/My_Design/a.png"  align="middle" width="50%" height="50%">
    </div>

    <div class="item">
      <img src="resources/My_Design/c.jpg"  align="middle" width="50%" height="50%">
    </div>

    <div class="item">
      <img src="resources/My_Design/d.jpg"  align="middle" width="50%" height="50%">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</center>

<br>
<br>
<br>
<br>
<%@include file="Footer.jsp" %>
</html>
