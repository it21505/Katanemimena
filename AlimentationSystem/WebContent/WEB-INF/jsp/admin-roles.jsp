<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/select2@4.0.12/dist/css/select2.min.css" rel="stylesheet" />
	<script src="https://cdn.jsdelivr.net/npm/select2@4.0.12/dist/js/select2.min.js"></script>
  <link href="<c:url value="/resources/css/admin-roles.css" />" rel="stylesheet">
  
<title>User Roles</title>
</head>
<body>
<div class="top"><a href="home" class="panel">Admin-Panel</a><a href="home" class="home">Home</a><p class="user"><sec:authorize access="isAuthenticated()"><b><sec:authentication property="principal.username" /> </b><sec:authentication property="principal.authorities"/></sec:authorize><a class="logout" href="logout">logout</a></p></div>
		<div class="main">
		<h3>All the users in the database</h3>
		<c:if test="${not empty allusers}">
			<table>
				<tr>				
					<th>Username</th>								
					<th>Roles</th>
					<th>Actions</th>					
					<th></th>
				</tr>
				<c:forEach items="${allusers}" var="user">
					<tr>						
						<td>${user.username}</td>										
						<td><c:forEach items="${user.authorities}" var="authorities">${authorities.authority}  </c:forEach></td>												
						<td><a class="action"
							href="<c:url value="update"> <c:param name="userId" value="${user.username}" /></c:url>">UPDATE</a></td>
						<td><a class="action"
							href="<c:url value="processAdminDeleteForm"> <c:param name="userId" value="${user.username}" /> </c:url>">DELETE</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		</div>		
</body>
</html>