<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student Limit</title>
</head>
<body>
<h5>Choose the percentage of the student that can take alimentation </h5>

<p>Number of Student in the university this year : <b>1150</b></p>

<form:form>
<input type="number">
</form:form>
<button type="submit">Update</button>
</body>
</html>