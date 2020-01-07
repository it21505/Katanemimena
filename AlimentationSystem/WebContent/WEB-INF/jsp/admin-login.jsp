<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
 <link href="<c:url value="/resources/css/admin-login.css" />" rel="stylesheet">
<title>Admin Login Page</title>
</head>
<body>
<div class="top"></div>  
<div class="border">

   <form:form action="authAdmin" method="POST">
  
   					<h3>Administrative Login</h3>
                   
                   <input type="text" name="username" placeholder="Username"/>                          
                   <input type="password" name="password" placeholder="Password"/>             
                   <button  type="submit">Login</button><br>
                   <a href="#">Forgot password?</a>
                  
   </form:form>
   <br>
   <c:if test="${param.error != null}">
           <i>Sorry! Invalid username/password!</i>
   </c:if>
   
</div>

</body>
</html>