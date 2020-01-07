<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/admin-add.css" />" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>

<div class="top"><a href="home" class="admin">Admin-Panel</a><a href="home" class="home">Home</a><p class="user"><sec:authorize access="isAuthenticated()"><b><sec:authentication property="principal.username" /> </b><sec:authentication property="principal.authorities"/></sec:authorize><a class="logout" href="logout">logout</a></p></div>	
<div class="border">
<h3>Add New User</h3>
<p>Create a new user and add them to the site</p>
	<form:form action="processAdminAddForm" method="post">		
		<input name="username" type="text" placeholder="Username" required />		
		<input name="password" type="password" placeholder="Password" required />		
		<select name="role">
			<option value="Admin">Admin</option>
			<option value="Employee">Employee</option>
			<option value="Supervisor">Supervisor</option>
			<option value="Student">Student</option>
		</select><br>	
		<input name="name" type="text" placeholder="Name" required />		
		<input name="surname" type="text" placeholder="Surname" required />		
		<input name="email" type="email" placeholder="Email" required /><br>
		<button type="submit" >Save</button>
	</form:form>
</div>

	<c:if test="${not empty message}">
		<p>${message}</p>
	</c:if>

</body>
</html>