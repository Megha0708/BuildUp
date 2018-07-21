<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="resources/My_Design/angular.min.js"></script>

<%@ include file="header.jsp"%>

<script>

	var prod3 = ${cart};
	angular.module('repeatSample', []).controller('repeatController',['$scope', function($scope)
			 {
		
				$scope.products = prod3;
				$scope.value=1;

				 $scope.change=function(value)
                 {
                	 $scope.products.qty=Number($scope.value);
                 };
				

    }]);
</script>

<div class="container">
<sf:form class="form-horizontal" method="post" action="" commandName="addcart" enctype="multipart/form-data">

<div ng-app="repeatSample" ng-controller="repeatController">
<table class="table table-bordered table-hover table-striped">
<tr>
					<tr>
						
                        <th>Image</th>
                        <th>productname</th>
						<th>Quantity</th> 
						<th>prize</th>
				                                       
						<th>total</th>
						
						
						
					</tr>
				
				<tr class="success" ng-repeat="prod in products">
				<td><img src="./resources/My_Design/{{prod.pid}}.jpg" height="50px" 
                     width="50px"></td>
                    <td>{{prod.name}}</td>
                    	<td>{{prod.qty}}</td>
                    	
					<td>{{prod.price}}</td>
					
				
				
					
					
				 <td>{{prod.qty*prod.price}}</td>
					
					
                    <td><a href="Removecart?pid={{prod.pid}}">Remove</a></td>
                     <td>Grand Total:${sessionScope.grandtotal}</td>
                     
                     
                     </tr>
                     <tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>Grand Total:${sessionScope.grandtotal}</td>
				</tr>
                    
</table>
</div>
</sf:form>
</div>


   
      

 
  <center><a href="AddToCartgoback">Edit</a></center>
      <br>
		<br>
		<br>
	<b>	Customer Information</b>
      <div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6"> 
								<div class="form-group">
									<table class="table table-responsive">
									   
						<tr>
					<thead>
						

						<th>emailid</th>
						<th>Mobile</th>
						<th>Address</th>
						
					</tr>
				</thead>
									   <td>${emailid}</td>
									   <td>${mobile}</td>
									   <td>${address}</td>
									 
									    
									    </table>
									   
								</div>
								
						</div> 
						
						 <div class="col-md-10 ">
   <div class="pull-right">
<a href="OrderConfirmed"><h1>Confirm your Order</h1></a>

						</div>



</div>
</div>
                     