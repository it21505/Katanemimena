<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/user-update-limit.css" />" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Update Student Limit</title>
</head>
<body>
	<div class="top">
		<a href="home" class="panel">Feeding System</a>
		<p class="user">
			<sec:authorize access="isAuthenticated()">
				<b><sec:authentication property="principal.username" /> </b>
				<sec:authentication property="principal.authorities" />
			</sec:authorize>
			<a class="logout" href="logout">logout</a>
		</p>
	</div>
	<div class="sidenav">
		<a href="home">Home</a> <a href="student-list">Check Students</a> <a
			href="application-list">Check Applications</a>
		<sec:authorize access="hasAuthority('Supervisor')">
			<a href="update-limit">Update Limit</a>
			<a href="options">Options</a>
		</sec:authorize>
	</div>
	<div class="main">
	<h2>Click here to finish the application process.</h2>
	<form:form action="processFinish">
	<button type="submit">Finish</button>
	</form:form>
	<hr>
	
	<h2>Change the total number of student in the university. </h2>
	<p>Current : <b>${total}</b></p><br>
	New :  <input name="total" type=text/>
	</div>
	
	</body>
</html>