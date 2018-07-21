<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Organisation Details</title>
</head>
<%@include file="header.jsp" %>
<link rel="stylesheet" href="resources/My_Design/bootstrap.min.css" >
<link rel="stylesheet" href="resources/My_Design/bootstrap-theme.min.css" >
<script src="resources/My_Design/bootstrap.min.js" ></script>
<script src="resources/My_Design/angular.min.js"></script>


<body>
    <div align="center">
        <sf:form action="InsertOrganisation" method="post" commandName="org">
            <table border="0">
                <tr>
                    <td colspan="2" align="center">
                    <h2>Organisation Details</h2></td>
               
                
                    
                <tr>               
                <td>Company Name</td>
                    <td><sf:input path="orgName"  required="true"  /></td>
                </tr>
                <tr>               
                <td>Full Name</td>
                    <td><sf:input path="fullName" required="true" /></td>
                </tr>
                <tr>               
                <td>User name</td>
                    <td><sf:input path="username" pattern=".{3,15}" required="true" title="minimum length for Username 3" /></td>
                </tr>
                <tr>               
                <td>Phone Number</td>
                    <td><sf:input path="phone" pattern="^[789]\d{9}$" required="true" title="Enter valid 10 digit phone number" /></td>
                </tr>
                <tr>
                    <td>emailid</td>
                    <td><sf:input path="email" type="email" placeholder="abc@xyz.com" /></td>
                </tr>
                <tr>
                    <td>password</td>
                    <td><sf:input path="password"/></td>
                </tr>
                <tr>
                <td>Organisation Size</td>
                <td><select name="orgSize">
                <option value="1-100">1-100</option>
                <option value="101-1000">101-1000</option>
                <option value="1001-10000">1001-10000</option>
                <option value="10000+">10000+</option>
                </select>
                </td>
                </tr>
                <tr>
                
                <td>Objective</td>
                <td><input type="checkbox" name="objective" value="Recruitment">Recruitment <br>
                <input type="checkbox" name="objective" value="Intership">Internship <br>
                <input type="checkbox" name="objective" value="Career Counselling">Career Counselling <br>
                <input type="checkbox" name="objective" value="Life Skills">Life Skills <br>
                </td>
                </tr>
                
                
               
               
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Add User" /></td>
                </tr>
            </table>
        </sf:form>
    </div>
</body>
</html>