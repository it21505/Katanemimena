<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/user-check-student.css" />" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Check Student</title>
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
<h5>Student Data</h5>
<hr>
Name:<br>
<input type="text" value="${student.name}" disabled style="width:300px"/><br>
Surname:<br>
<input type="text" value="${student.surname}" disabled style="width:300px"/><br>
E-mail:<br>
<input type="text" value="${student.email}" disabled style="width:300px"/><br>
Father's Name:<br>
<input type="text" value="${student.fatherName}" disabled style="width:300px"/><br>
Mother's Name:<br>
<input type="text" value="${student.motherName}" disabled style="width:300px"/><br>
University:<br>
<input type="text" value="${student.university}" disabled style="width:300px"/><br>
Department:<br>
<input type="text" value="${student.department}" disabled style="width:300px"/><br>
Semester:<br>
<input type="text" value="${student.semester}" disabled style="width:300px"/><br>
<!--  
<h5>Identification Data</h5>
<hr>
ID Number:<br>
<input type="text" value="${student.identification.id}" disabled style="width:300px"/><br>
Adoption Day:<br>
<input type="text" value="${student.identification.adoptionDay}" disabled style="width:300px"/><br>
Issuing Authority:<br>
<input type="text" value="${student.identification.issuingAuthority}" disabled style="width:300px"/><br>
Register number:<br>
<input type="text" value="${student.identification.record}" disabled style="width:300px"/><br>

<h5>Permanent Residence</h5>
<hr>
Street:<br>
<input type="text" value="${student.residence.street}" disabled style="width:300px"/><br>
Number:<br>
<input type="text" value="${student.residence.number}" disabled style="width:300px"/><br>
City:<br>
<input type="text" value="${student.residence.city}" disabled style="width:300px"/><br>
Postal Code:<br>
<input type="text" value="${student.residence.postalCode}" disabled style="width:300px"/><br>
Telephone:<br>
<input type="text" value="${student.residence.telephone}" disabled style="width:300px"/><br>
Mobile Phone:<br>
<input type="text" value="${student.residence.mobile}" disabled style="width:300px"/><br>
-->

<a class="decline" href="<c:url value="processDeclineStudent"> <c:param name="id" value="${student.id}" /></c:url>">Decline</a>
<a class="activate" href="<c:url value="processActivateStudent"> <c:param name="id" value="${student.id}" /></c:url>">Activate</a>
</div>
</body>
</html>