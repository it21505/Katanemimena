<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/user-check-application.css" />" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Check Applications</title>
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
<h5>Application Data</h5>
<hr>
Name:<br>
<input type="text" value="${student.name }" disabled style="width:300px"/><br>
Surname:<br>
<input type="text" value="${student.surname }" disabled style="width:300px"/><br>
City of University:<br>
<input type="text" value="${student.application.cityOfUniversity }" disabled style="width:300px"/><br>
City of Residence:<br>
<input type="text" value="${student.residence.city }" disabled style="width:300px"/><br>
Number of studying brothers:<br>
<input type="text" value="${student.application.numberOfStudyingBrothers }" disabled style="width:300px"/><br>
Student's Income:<br>
<input type="text" value="${student.application.income }" disabled style="width:300px"/><br>
Familys's Income:<br>
<input type="text" value="${student.application.familyIncome }" disabled style="width:300px"/><br>

<a class="decline" href="<c:url value="processDeclineApplication"> <c:param name="id" value="${student.id}" /></c:url>">Decline</a>
<a class="activate" href="<c:url value="processActivateApplication"> <c:param name="id" value="${student.id}" /></c:url>">Activate</a>


</div>
</body>
</html>