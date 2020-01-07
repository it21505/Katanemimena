<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/user-student-list.css" />" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Choose student</title>
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
<h2>The list of all students that want alimentation</h2>
<p>Click on a student to check his application and activate or decline him</p>
<table>
				<tr>							
					<th>Name</th>				
					<th>Surname</th>
					<th>Checked</th>
				</tr>
				<c:forEach items="${allstudents}" var="student">
					<tr onclick="window.location='check-student?id=${student.id}';">																
						<td>${student.name}</td>
						<td>${student.surname}</td>					
						<td>${student.checked}</td>																
					</tr>
				</c:forEach>
	</table>
	</div>
</body>
</html>