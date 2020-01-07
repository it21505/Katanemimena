<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/admin-update.css" />" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body>
<div class="top"><a href="home" class="admin">Admin-Panel</a><a href="home" class="home">Home</a><p class="user"><sec:authorize access="isAuthenticated()"><b><sec:authentication property="principal.username" /> </b><sec:authentication property="principal.authorities"/></sec:authorize><a class="logout" href="logout">logout</a></p></div>
<div class="border">
<h3>Update User</h3>
<p>Update existing user</p>
<form:form action="processAdminUpdateForm" method="post">	
	<input name="username" type="text" placeholder="Username" value="${user.username}" required/> 
	<input name="password" type="password" placeholder="Password" value="" required/>
	<select name="role">
	    <option value="Admin">Admin</option>
	    <option value="Employee">Employee</option>
	    <option value="Supervisor">Supervisor</option>	
	    <option value="Student">Student</option>        
  </select>
	<input name="name" type="text" placeholder="Name" value="${user.name}" required/> 
	<input name="surname" type="text" placeholder="Surname" value="${user.surname}" required/> 
	<input name="email" type="email" placeholder="Email" value="${user.email}" required/><br>
	<button type="submit">Update</button>
</form:form>
</div>
</body>
</html>