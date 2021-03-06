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
		<h2>Write the percentage of the student that can use the feeding services this year.</h2>
		<h3>By hitting the button you also start the process to allow students send applications</h3>
		<p>Total number of students in the university this year : <b>${total}</b> and from those the number of students that got freeding is : <b>${number}</b></p>
		<form:form action="processUpdateLimit">
			<input name="limit" type="text" required><b> %</b>
			<button type="submit">Update</button>
		</form:form>
		<c:if test="${param.success != null}">
           <div class="alert-info">  
  			Database is successfully updated ! The number of students that are entitled for the feeding services are <strong>${number}</strong>
		</div>
   </c:if>
	</div>
</body>
</html>