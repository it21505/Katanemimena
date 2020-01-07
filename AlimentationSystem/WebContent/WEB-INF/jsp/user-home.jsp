<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/user-home.css" />" rel="stylesheet">
<title>Employee Home Page</title>
</head>
<body>
<div class="top"><a href="home" class="panel">Alimentation System</a><p class="user"><sec:authorize access="isAuthenticated()"><b><sec:authentication property="principal.username" /> </b><sec:authentication property="principal.authorities"/></sec:authorize><a class="logout" href="logout">logout</a></p></div>
	<div class="sidenav">
		<a href="home">Home</a> 
		<a href="student-list">Check Students</a> 	
		 <sec:authorize access="hasAuthority('Supervisor')">	 
		 <a href="update-limit">Update Limit</a>
		 </sec:authorize>
	</div>
	<div class="main">
	<h2>Welcome to Alimentation System</h2>
	<p>Here you can manage the students that ask for alimentation</p>
		
	</div>
</body>
</html>