<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/user-login.css" />"
	rel="stylesheet">
<title>Employee/Supervisor Login Page</title>
</head>
<body>
<div class="top"></div>
	<div class="border">
		<h3>Employee/Supervisor Login</h3>
		<p>Please add your user credentials</p>
		<form:form action="authUser" method="POST">

			<input type="text" name="username" placeholder="Username" />


			<input type="password" name="password" placeholder="Password" />
			<button type="submit">Login</button><br>
			<a href="#">Forgot password?</a>
		</form:form><br>
		<c:if test="${param.error != null}">
           <i class="error">Sorry! Invalid username/password!</i>
   </c:if>
		
	</div>
	
</body>
</html>