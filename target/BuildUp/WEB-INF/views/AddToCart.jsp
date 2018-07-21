<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link rel="stylesheet" href="resources/My_Design/bootstrap.min.css" >
<link rel="stylesheet" href="resources/My_Design/bootstrap-theme.min.css" >
<script src="resources/My_Design/bootstrap.min.js" ></script>

<script src="resources/My_Design/angular.min.js"></script>
<%@include file="header.jsp" %>

<title>CART</title>
<script>

	var prod3 = ${cart};
	angular.module('repeatSample', []).controller('repeatController',['$scope', function($scope)
			 {
		
				$scope.products = prod3;
				$scope.value;

				 $scope.change=function(value)
                 {
                	 $scope.products.qty=Number($scope.value);
                 };
				

    }]);
</script>
</head>
<c:choose>
<c:when test="${empty count}">
List is empty!!
</c:when>
<c:otherwise>
<sf:form class="form-horizontal" method="get" action="updateqty">
<div ng-app="repeatSample" ng-controller="repeatController">
<table class="table table-bordered table-hover table-striped">
<thead>
					<tr>
						
                        <th>IMAGE</th>
                        <th>NAME</th>
						<th>FEES</th>
				                                       
						<th>total</th>
						
						
					</tr>
				</thead>
				<c:forEach items="${cartitm}" var="product">
				<form action="updateqty" method="get">
				<tr >
			    <td><img src="resources/My_Design/Dimages/${product.did}.jpg" height="50px" 
                  width="50px"></td>
				<td>${product.name}</td>
				   
				  
				   <td>${product.price}</td>
				   <td>${product.total}</td>
					
                    <td><a href="Removecart?pid=${product.did}">Remove</a></td>
                     
                    </tr>
				</form>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>


							<td>GrandTotal:${sessionScope.grandtotal}</td>
						</tr>
	</table>
	</div>
	</sf:form>
				
				

</c:otherwise>

</c:choose>
</div>

<div class="container">
	<a href="domainAdd"><h1>Add More Domains<h1></a>
    <a href="giveMessage"><h1>CheckOut</h1></a>		


                  </div>
                 