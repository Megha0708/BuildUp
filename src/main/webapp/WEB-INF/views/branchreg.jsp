<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Branch</title>
<script src="resources/My_Design/angular.min.js"></script>

<script>
	var branches = ${mylist1};
	var fields = ${mylist2};
	
	angular.module('repeatSample', []).controller('repeatController',
			function($scope) {
				$scope.mylist1 = branches;
				$scope.mylist2 = fields ;

				$scope.sort = function(keyname) {
					$scope.sortKey = keyname; //set the sortKey to the param passed
					$scope.reverse = !$scope.reverse; //if true make it false and vice versa
				}

			});
</script>
<%@include file="header.jsp" %>
<link rel="stylesheet" href="resources/My_Design/bootstrap.min.css" >
<link rel="stylesheet" href="resources/My_Design/bootstrap-theme.min.css" >
<script src="resources/My_Design/bootstrap.min.js" ></script>


</head>
<body ng-app="repeatSample" ng-controller="repeatController">
<c:if test="${!checkk  && sessionScope.Administrator}">
    <div>
<div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<sf:form role="form"  action="addBranch" commandName="branch" method="post" enctype="multipart/form-data"  class="form-control input-lg">
			<h2>BRANCH DETAILS</h2>
			<hr class="colorgraph">
			
				<div class="row">
					<div class="col-xs-12">
					
					
					
					<div class="form-group col-xs-12">
                        <sf:input path="bname" class="form-control input-lg" placeholder="Branch " tabindex="1"  required="true" ></sf:input>
					</div>
					
					<div>
					<sf:label path="fname">Field</sf:label>
                  <sf:select path="fname" class="form-control input-sm">
                  <sf:option ng-repeat="fields in mylist2" value="{{fields.fname}}">{{fields.fname}}</sf:option>
                  </sf:select>
					</div>
					
					<div class="form-group col-xs-12">
                       <sf:input path="description" class="form-control input-lg" placeholder="Description" required="true" />
					</div>
					
					<sf:input type="file" path="bimage" class="form-control input-lg" />
                                     
					<div class="col-xs-12"><input type="submit" value="Add-Branch" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
					</div>
				</div>


	

			</sf:form>
			</div>
			</div>
			</div>
</c:if>

<c:if test="${checkk}">
			
			
<div>
<div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<sf:form role="form"  action="plzNowUpdatedBranch" commandName="branch" method="post" enctype="multipart/form-data"  class="form-control input-lg">
			<h2>UPDATE BRANCH</h2>
			<hr class="colorgraph">
			
				<div class="row">
					<div class="col-xs-12">
					
					
					<div class="form-group col-xs-12">
                        <sf:input path="bid" class="form-control input-lg" placeholder="Branch ID" tabindex="1" required="true" ></sf:input>
					</div>
					<div class="form-group col-xs-12">
                        <sf:input path="bname" class="form-control input-lg" placeholder="Branch " tabindex="1"  required="true" ></sf:input>
					</div>
					
					<div>
					<sf:label path="fname">Field</sf:label>
                  <sf:select path="fname" class="form-control input-sm">
                  <sf:option ng-repeat="fields in mylist2" value="{{fields.fname}}">{{fields.fname}}</sf:option>
                  </sf:select>
					</div>
					
					<div class="form-group col-xs-12">
                       <sf:input path="description" class="form-control input-lg" placeholder="Description" required="true" />
					</div>
					
					<sf:input type="file" path="bimage" class="form-control input-lg" />
                                     
					<div class="col-xs-12"><input type="submit" value="Update-Branch" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
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


			
	</c:if>		
<div >
<center>
    <h1 >Search</h1>
<input type="text" class="search-query form-control" placeholder="Search" ng-model="searchText" />
</center>


<table class="table table-responsive" style="font-size:150%">
                 <thead>
					<tr>
					    
					    
					    <th>BRANCH</th>
					    
						<th>FIELD</th>
						
						

						<th>IMAGE</th>
					</tr>
				</thead>
				
				<tr ng-repeat="field in mylist1|filter:searchText">
				
				<td><a href="bDescription?bid={{field.bid}}">{{field.bname}}<a/></td>
				<td>{{field.fname}}</td>
			    
				<td><a href="bDescription?bid={{field.bid}}"><img src="./resources/My_Design/Bimages/{{field.bid}}.jpg" height="70px" 
                     width="70px"></a></td>	
                     
                  <c:if test="${sessionScope.Administrator}">					
                <td><a href="plzUpdatedBranch?bid={{field.bid}}">update</a></td>
                <td><a href="DeleteBranch?bid={{field.bid}}">Delete</a></td>
				</c:if>
                


                </tr>
       </table>

</div>
    
</body>
</html>