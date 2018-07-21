<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Domain</title>
<script src="resources/My_Design/angular.min.js"></script>
<link rel="stylesheet" href="resources/My_Design/bootstrap.min.css" >
<link rel="stylesheet" href="resources/My_Design/bootstrap-theme.min.css" >
<script src="resources/My_Design/bootstrap.min.js" ></script>

<script>
	var branches = ${mylist1};
	var fields = ${mylist2};
	var domains = ${mylist3};	
	angular.module('repeatSample', []).controller('repeatController',
			function($scope) {
				$scope.mylist1 = branches;
				$scope.mylist2 = fields ;
                $scope.mylist3 = domains;  
				
				$scope.sort = function(keyname) {
					$scope.sortKey = keyname; //set the sortKey to the param passed
					$scope.reverse = !$scope.reverse; //if true make it false and vice versa
				}
				

			});
</script>
</head>

<%@include file="header.jsp" %>
<body ng-app="repeatSample" ng-controller="repeatController">
<c:if test="${!checkk && sessionScope.Administrator}">
    <div >
<div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<sf:form role="form"  action="addDomain" commandName="domain" method="post" enctype="multipart/form-data">
			<h2>DOMAIN DETAILS</h2>
			<hr class="colorgraph">
			
				<div class="row">
					<div class="col-xs-12">
					
					
					
					<div class="form-group col-xs-12">
                        <sf:input path="dname" class="form-control input-lg" placeholder="Domain " tabindex="1"  required="true" ></sf:input>
					</div>
					
					<div ng-app="repeatSample"  ng-controller="repeatController">
					<sf:label path="fname">Field</sf:label>
                  <sf:select path="fname" class="form-control input-sm">
                  <sf:option ng-repeat="fields in mylist2" value="{{fields.fname}}">{{fields.fname}}</sf:option>
                  </sf:select>
					</div>
					
					<div ng-app="repeatSample"  ng-controller="repeatController">
					<sf:label path="bname">Branch</sf:label>
                  <sf:select path="bname" class="form-control input-sm">
                  <sf:option ng-repeat="fields in mylist1" value="{{fields.bname}}">{{fields.bname}}</sf:option>
                  </sf:select>
					</div>
					
					
					
					<div class="form-group col-xs-12">
                       <sf:input path="description" class="form-control input-lg" placeholder="Description" required="true" />
					</div>
					
					<sf:input type="file" path="dimage" class="form-control input-lg" />
                                     
					<div class="col-xs-12"><input type="submit" value="Add-Domain" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
					</div>
				</div>


	

			</sf:form>
			</div>
			</div>
			</div>
    </c:if>
    
    <c:if test="${checkk}">
			
			
<div >
<div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<sf:form role="form"  action="plzNowUpdatedDomain" commandName="domain" method="post" enctype="multipart/form-data">
			<h2>UPDATE DOMAIN</h2>
			<hr class="colorgraph">
			
				<div class="row">
					<div class="col-xs-12">
					
					
					<div class="form-group col-xs-12">
                        <sf:input path="did" class="form-control input-lg" placeholder="Domain ID" tabindex="1" required="true" ></sf:input>
					</div>
					<div class="form-group col-xs-12">
                        <sf:input path="dname" class="form-control input-lg" placeholder="Domain " tabindex="1"  required="true" ></sf:input>
					</div>
					
					<div ng-app="repeatSample"  ng-controller="repeatController">
					<sf:label path="fname">Field</sf:label>
                  <sf:select path="fname" class="form-control input-sm">
                  <sf:option ng-repeat="fields in mylist2" value="{{fields.fname}}">{{fields.fname}}</sf:option>
                  </sf:select>
					</div>
					
					<div ng-app="repeatSample"  ng-controller="repeatController">
					<sf:label path="bname">Branch</sf:label>
                  <sf:select path="bname" class="form-control input-sm">
                  <sf:option ng-repeat="fields in mylist1" value="{{fields.bname}}">{{fields.bname}}</sf:option>
                  </sf:select>
					</div>
					
					<div class="form-group col-xs-12">
                       <sf:input path="price" class="form-control input-lg" placeholder="price" required="true" />
					</div>
					
					<div class="form-group col-xs-12">
                       <sf:input path="description" class="form-control input-lg" placeholder="Description" required="true" />
					</div>
					
					<sf:input type="file" path="dimage" class="form-control input-lg" />
                                     
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
					    
					    
					    <th>DOMAIN</th>
					    
					    <th>BRANCH</th>
					    
						<th>FIELD</th>
						
						<th>FEE</th>
						
					
						<th>IMAGE</th>
					</tr>
				</thead>
				
				<tr>
				<tr ng-repeat="field in mylist3|filter:searchText">
				
				<td><a href="dDescription?did={{field.did}}">{{field.dname}}</a></td>
				<td>{{field.bname}}</td>
				<td>{{field.fname}}</td>
		        <td><a href="dDescription?did={{field.did}}">{{field.price}}</a></td>
				<td><a href="dDescription?did={{field.did}}"><img src="./resources/My_Design/Dimages/{{field.did}}.jpg" height="70px" 
                     width="70px"></a></td>
				
                   <c:if test="${sessionScope.Administrator}">				
                <td><a href="plzUpdatedDomain?did={{field.did}}">update</a></td>
                <td><a href="DeleteDomain?did={{field.did}}">Delete</a></td>
				
                </c:if>


                </tr>
       </table>

</div>
</body>
</html>