<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="resources/My_Design/angular.min.js"></script>



<script>
	var prod = ${mylist3};
	angular.module('repeatSample', []).controller('repeatController',
			function($scope) {
				$scope.products = prod;

				$scope.sort = function(keyname) {
					$scope.sortKey = keyname; //set the sortKey to the param passed
					$scope.reverse = !$scope.reverse; //if true make it false and vice versa
				}

			});
</script>

<link rel="stylesheet" href="resources/bootstrap.min.css" >


<link rel="stylesheet" href="resources/bootstrap-theme.min.css">


<script src="resources/bootstrap.min.js"></script>

<%@ include file="header.jsp"%>
		<div ng-app="repeatSample" ng-controller="repeatController">
			<div class="row">

				<div class="input-group col-md-12">
					<h2 align="center">Search And see Domains</h2>

					<input type="text" class="search-query form-control"
						placeholder="please Search all products" ng-model="searchText" />

				</div>
			</div>
<table class="table table-responsive" >
<thead>
					<tr>
						<th> id</th>

						<th> name  </th>
						
					</tr>
				</thead>
				<tr ng-repeat="product in products|filter:searchText">
				<td><a href="dDescription?pid={{product.did}}">{{product.did}}</a></td>
					<td><a href="dDescription?pid={{product.did}}">{{product.dname}}</a></td>
					
                     
</tr>
</table>
</div>














