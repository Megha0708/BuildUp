

<link rel="stylesheet" href="resources/My_Design/bootstrap.min.css" >
<link rel="stylesheet" href="resources/My_Design/bootstrap-theme.min.css" >
<script src="resources/My_Design/bootstrap.min.js" ></script>

<title>LOGIN</title>
<%@include file="header.jsp" %>
<div class="jumbotron">
<h1 align=center>Login Form</h1>
</div>
 <center><form action="perform_login" method="post">
				
				<div>
					<input type="text" placeholder="Username" required id="username" name="username" 
						pattern=".{1,20}" />
				</div>
				<div>
					<input type="password" placeholder="Password" required id="password" name="password" 
					title="Enter Valid credentials"/>
				</div>
				<div>
					<br><input type="submit" value="Log in" />
					<br>
					 
						
						 <a href="usersignup">Register</a>
				</div>
				
			</form></center>
