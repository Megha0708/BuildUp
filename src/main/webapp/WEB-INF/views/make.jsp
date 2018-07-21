
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<title>Post</title>
<%@include file="header.jsp" %>
<link rel="stylesheet" href="resources/My_Design/bootstrap.min.css" >
<link rel="stylesheet" href="resources/My_Design/bootstrap-theme.min.css" >
<script src="resources/My_Design/bootstrap.min.js" ></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="resources/My_Design/angular.min.js"></script>



<script>
   var isFramed = top.frames.length > 0;

   // call this function to reload the page
   function reloadScroll()
   {
      var scrollAmount = document.body.scrollTop; // this is the current scroll position
      if (isFramed)
      {
         top.scrollValue = scrollAmount; // save it in the top frame's namespace
      }
      else
      {
         document.cookie="scrollAmount=" + scrollAmount; // save it in cookie
         window.dontkillcookie = true; // just a flag used in onunload
      }
      window.location.reload();
   }

   window.onload = function () // when the window is reloaded, check if a scroll value has been saved
   {
      var scrollAmount;
      if (isFramed)
      {
         scrollAmount = top.scrollValue;
      }
      else
      {
         var cook = document.cookie; // parse the cookie
         var pos = cook.indexOf("scrollAmount=");
         if (pos >= 0)
         {
            scrollAmount = parseInt(cook.substr(pos + 13));
         }
      }
      if (scrollAmount) // and reset the scrolling. et voilà.
      {
         document.body.scrollTop = scrollAmount;
      }
   }

   window.onunload = function()
   {
      // reset the cookie to zero, this way the window won't
      // scroll the next time the user accesses it
      if (!window.dontkillcookie)
      {
         document.cookie="scrollAmount=0";
      }
   }
</script>



<script>
	var prod = ${mylist};
    var comm = ${comments};
	angular.module('repeatSample', []).controller('repeatController',
			function($scope) {
				$scope.mylist = prod;
 				$scope.comments=comm;

				$scope.sort = function(keyname) {
					$scope.sortKey = keyname; //set the sortKey to the param passed
					$scope.reverse = !$scope.reverse; //if true make it false and vice versa
				}

			});
	
</script>



</head>
<body class="container" ng-app="repeatSample" ng-controller="repeatController">
    <c:if test="${!checkk}">




		
			<sf:form role="form" action="Insertpost" commandName="po" method="post" modelAttribute="po"  enctype="multipart/form-data">
				<h1>
					Hello User !!! Share UR Ideas Here...............
				</h1>
									   
						   
							<sf:textarea path="mpost" placeholder="POST HERE..."
									class="form-control input-lg" 
									tabindex="1" pattern=".{4,10000}" required="true"  rows="3" cols="100" align="center"
									></sf:textarea>
									<br>
							<sf:input type="file" path="pimage" class="form-control input-lg" />

						
						<br>
						
				<br>
				 <c:if test="${sessionScope.UserLoggedIn || sessionScope.Administrator }">  
       
       	
			    <input type="submit" value="Post it"
				class="btn btn-primary btn-block btn-lg" tabindex="7">
			
			   </c:if>	
			   	   
				<c:if test="${not sessionScope.UserLoggedIn && not sessionScope.Administrator }">  
       
       	
			   <button> <a href="Login">login to submit</a></button>
			
			   </c:if>	
			   	   					
			</sf:form>
		
	

</c:if>



<h2 align="left">Search A Post</h2>
<input type="text" class="search-query form-control" placeholder="Search" ng-model="searchText" />


<div>
<table class="table table-responsive" ng-repeat="post in mylist|filter:searchText">
                 
			
				
			<tr><td>{{post.mpost}}</td></tr>
            <tr><td align="middle"><img src="./resources/My_Design/Pimages/{{post.pId}}.jpg" height="500px" width="500px"><td></tr>
                     
            
          <tr>        
              <c:if test="${sessionScope.UserLoggedIn || sessionScope.Administrator }"> 	
                  <td><a href="likepost?pid={{post.pId}}&userid=${sessionScope.Userid}"  onclick="reloadScroll(); return true"><button>{{post.likes}} likes</button></a></td>
                  
              </c:if>
                     
              <c:if test="${not sessionScope.UserLoggedIn && not sessionScope.Administrator }"> 
                   <td> <button> <a href="Login">{{post.likes}} likes</a></button></td>
                   
              </c:if>
          </tr>
                     
                     
<!--           <tr> -->
             
<%--              <c:if test="${sessionScope.UserLoggedIn || sessionScope.Administrator }">   --%>
<!--               <td> -->
<!--                   <input type="textarea" placeholder="Comment" ng-model="co"> -->
<%--                   <td><button><a href="makeComment?pid={{post.pId}}&uid=${sessionScope.Userid}&comment={{co}}">Comment</a></button></td> --%>
<!--               <td> -->
<%--               </c:if> --%>
<%--                <c:if test="${not sessionScope.UserLoggedIn && not sessionScope.Administrator }">  --%>
<!--                <td> <button> <a href="Login">Comment</a></button></td> -->
<%--                </c:if> --%>
<!--           </tr> -->
<!--           ng-show="po.pid={{post.pId}} -->
<!--           <tr> -->
<!--               <td> -->
<!--                   <table > -->
<!--                      <tr ng-repeat="po in comments " > -->
                    
<!--                         <td><b>{{po.uid}}</b> -->
                        
                                        
                        
<!--                         </td> -->
<!--                         <td></td> -->
<!-- 				        <td ng repeat>{{po.comment}}</td> -->
<!-- 				      </tr> -->
<!--                   </table> -->
<!--               </td> -->
<!--           </tr> -->
                   
                 
              
       </table>

</div>




</body>
</html>