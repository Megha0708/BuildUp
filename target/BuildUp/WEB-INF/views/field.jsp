<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fields</title>
<link rel="stylesheet" href="resources/My_Design/bootstrap.min.css" >
<link rel="stylesheet" href="resources/My_Design/bootstrap-theme.min.css" >
<script src="resources/My_Design/bootstrap.min.js" ></script>
<script src="resources/My_Design/angular.min.js"></script>
<script src="resources/My_Design/angular.min.js"></script>


<script>
	//var domains = ${mylist3};
	var fields = ${mylist1};
	
	angular.module('repeatSample', []).controller('repeatController',
			function($scope) {
				//$scope.mylist3 = domains;
				$scope.mylist1 = fields ;

				$scope.sort = function(keyname) {
					$scope.sortKey = keyname; //set the sortKey to the param passed
					$scope.reverse = !$scope.reverse; //if true make it false and vice versa
				}

			});
</script>
</head>
<body ng-app="repeatSample" ng-controller="repeatController">
<div ng-repeat="product in mylist1">
 <center><img src="./resources/My_Design/Fimages/{{product.fid}}.jpg" height="450px" width="500px"></center>
 </div> 
    
 <center>   
<table class="table table-responsive" ng-repeat="product in mylist1">

              <tr>
                
                 
                <td style="font-size:300%"><b>{{product.fname}}</b></td>
              </tr>
              <tr>
                 
                 <td>{{product.description}}</td>
              </tr>
              
                
                
</table>
</center>
<button><a href="branchAdd">SEE BRANCHES</a></button>
</body>
</html>