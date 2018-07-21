<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Domains</title>
<%@include file="header.jsp" %>
<link rel="stylesheet" href="resources/My_Design/bootstrap.min.css" >
<link rel="stylesheet" href="resources/My_Design/bootstrap-theme.min.css" >
<script src="resources/My_Design/bootstrap.min.js" ></script>
<script src="resources/My_Design/angular.min.js"></script>



<script>
	//var domains = ${mylist3};
	var domains = ${mylist3};
	
	angular.module('repeatSample', []).controller('repeatController',
			function($scope) {
				//$scope.mylist3 = domains;
				$scope.mylist3 = domains ;

				$scope.sort = function(keyname) {
					$scope.sortKey = keyname; //set the sortKey to the param passed
					$scope.reverse = !$scope.reverse; //if true make it false and vice versa
				}

			});
</script>
<script type="text/javascript" src="https://secure.skypeassets.com/i/scom/js/skype-uri.js"></script>
<div id="SkypeButton_Call_anjali.ait_1">
 <script type="text/javascript">
 Skype.ui({
 "name": "dropdown",
 "element": "SkypeButton_Call_anjali.ait_1",
 "participants": ["anjali.ait"],
 "imageSize": 32
 });
 </script>
</div>
</head>
<body ng-app="repeatSample" ng-controller="repeatController">
<div ng-repeat="product in mylist3">
 <center><img src="./resources/My_Design/Dimages/{{product.did}}.jpg" height="450px" width="500px"></center>
 </div> 
    
 <center>   
<table class="table table-responsive" ng-repeat="product in mylist3">

              <tr>
                
                 
                <td style="font-size:300%"><b>{{product.dname}}</b></td>
              </tr>
              <tr>
                 
                 <td>{{product.description}}</td>
              </tr>
              <tr>
                 
                 <td style="color:red;font-size:100%">FEE={{product.price}}</td>
              </tr>
</table>
</center>
<div >
<c:if test="${sessionScope.UserLoggedIn || sessionScope.Administrator}">
<button type="button"><a href="skypeview">Confused? Talk to Mentor</a></button>		
<button type="button"><a href="skypeview">Give Mock Interview</a></button>
<button ng-repeat="product in mylist3"><a href="Carddetails?pid={{product.did}}">Add to Cart</a></button>
</c:if>
<c:if test="${not sessionScope.UserLoggedIn && not sessionScope.Administrator}">
<button><a href="Login">Confused? Talk to Mentor</a></button>	
<button><a href="Login">Give Mock Interview</a></button>
<button><a href="Login">Add to Cart</a></button>
</c:if>	
</div>
</body>
</html>