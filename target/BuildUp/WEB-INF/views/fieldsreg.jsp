<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header.jsp"%>
<link rel="stylesheet" href="resources/My_Design/bootstrap.min.css" >
<link rel="stylesheet" href="resources/My_Design/bootstrap-theme.min.css" >
<script src="resources/My_Design/bootstrap.min.js" ></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Field</title>
<script src="resources/My_Design/angular.min.js"></script>

<script>
	var prod = ${mylist};
	
	angular.module('repeatSample', []).controller('repeatController',
			function($scope) {
				$scope.mylist = prod;
				

				$scope.sort = function(keyname) {
					$scope.sortKey = keyname; //set the sortKey to the param passed
					$scope.reverse = !$scope.reverse; //if true make it false and vice versa
				}

			});
</script>


</head>



<body>
<c:if test="${!checkk && sessionScope.Administrator}">
    <div align="center">
        <sf:form role="form" action="addField" method="post" commandName="field" modelAttribute="field"  enctype="multipart/form-data" class="form-control input-lg">
            <table border="0">
                <tr>
                    <td colspan="2" align="center">
                    <h2>Field Details</h2></td>
               
                <tr>
                    <td>Field</td>
                    <td><sf:input type="text" path="fname" required="true"/></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><sf:input type="text" path="description" required="true" /></td>
                </tr>
                <tr>
                    <td>Image</td>
                    <td><sf:input path="fimage" type="file" required="true"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Add Field" /></td>
                </tr>
            </table>
        </sf:form>
        
    </div>
</c:if>

<c:if test="${checkk}">
			
			
<div >
<div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<sf:form role="form"  action="plzNowUpdatedField" commandName="field" method="post" enctype="multipart/form-data">
			<h2>UPDATE FIELD</h2>
			<hr class="colorgraph">
			
				
					
					<div class="form-group col-xs-12">
                        <sf:input path="fid" class="form-control input-lg" placeholder="Field ID" tabindex="1" required="true" ></sf:input>
					</div>
					<div class="form-group col-xs-12">
                        <sf:input path="fname" class="form-control input-lg" placeholder="Field " tabindex="1"  required="true" ></sf:input>
					</div>
					
					<div class="form-group col-xs-12">
                       <sf:input path="description" class="form-control input-lg" placeholder="Description" required="true" />
					</div>
					
					<sf:input type="file" path="fimage" class="form-control input-lg" />
                                     
					<div class="col-xs-12"><input type="submit" value="Update-Field" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
					</div>
				</div>


	

			</sf:form>
			</div>
			</div>
			</div>
			</c:if>
	<c:if test="${!checkk && sessionScope.Administrator}">		
<br>
<br>
<br>
<br>
<br>
<br>	
</c:if>		
<div ng-app="repeatSample" ng-controller="repeatController" >
<center>
    <h1 >Search for an item</h1>
<input type="text" class="search-query form-control" placeholder="Search" ng-model="searchText" />
</center>


<table class="table table-responsive" style="font-size:150%">
                 <thead>
					<tr>
					    
					    
						<th>FIELD</th>
						
						

						<th>IMAGE</th>
					</tr>
				</thead>
				<tr ng-repeat="field in mylist|filter:searchText">
				
				<td><a href="fDescription?fid={{field.fid}}">{{field.fname}}</a></td>
			  
				<td><a href="fDescription?fid={{field.fid}}"><img src="./resources/My_Design/Fimages/{{field.fid}}.jpg" height="70px" 
                     width="70px"></a></td>
                    
                 <c:if test="${sessionScope.Administrator}">					
                <td><a href="plzUpdatedField?fid={{field.fid}}">update</a></td>
                <td><a href="DeleteField?fid={{field.fid}}">Delete</a></td>
				
                  </c:if>

                </tr>
       </table>

</div>
    
</body>
</html>