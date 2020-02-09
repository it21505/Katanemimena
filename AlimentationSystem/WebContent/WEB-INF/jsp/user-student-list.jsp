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
<title>Student list</title>
</head>
<body>
<div class="top"><a href="home" class="panel">Feeding System</a><p class="user"><sec:authorize access="isAuthenticated()"><b><sec:authentication property="principal.username" /> </b><sec:authentication property="principal.authorities"/></sec:authorize><a class="logout" href="logout">logout</a></p></div>
	<div class="sidenav">
		<a href="home">Home</a> 
		<a href="student-list">Check Students</a>
		<a href="application-list">Check Applications</a> 	 	
		 <sec:authorize access="hasAuthority('Supervisor')">	 
		 <a href="update-limit">Update Limit</a>
		 <a href="options">Options</a>
		 </sec:authorize>
	</div>
	<div class="main">
	<c:if test="${param.derror != null}">
           <div class="alert-error">  
  			<strong>Error</strong> declining student.
		</div>
   </c:if>
   <c:if test="${param.dsuccess != null}">
           <div class="alert-success">  
  			<strong>Success!</strong> Student declined successfully!
		</div>
   </c:if>
	<c:if test="${param.aerror != null}">
           <div class="alert-error">  
  			<strong>Error</strong> activating student.
		</div>
   </c:if>
   <c:if test="${param.asuccess != null}">
           <div class="alert-success">  
  			<strong>Success!</strong> Student activated successfully!
		</div>
   </c:if>
<h1>The list of all unchecked students that have logged in the system.</h1>
<p>Click on a student to check his data to allow him apply by activating him.</p>
<c:choose>
  		<c:when test="${not empty students}">
<table>
				<tr>							
					<th>Name</th>				
					<th>Surname</th>
					<th>Email</th>
				</tr>
				<c:forEach items="${students}" var="student">
					<tr onclick="window.location='check-student?id=${student.id}';">																
						<td>${student.name}</td>
						<td>${student.surname}</td>					
						<td>${student.email}</td>																
					</tr>
				</c:forEach>
	</table>
	</c:when>
	<c:when test="${empty students}">
	<div class="alert info">  
  <strong>Sorry!</strong> There are no unchecked students at this time.
</div>
	</c:when>
	</c:choose>
	</div>
	
</body>
</html>