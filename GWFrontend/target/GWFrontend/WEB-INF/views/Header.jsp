    
<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

<title>GadgetsWorld-${title}</title>
</head>
<body>
<a href="<c:url value='/login'/>">Login</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
<a href="<c:url value="/register"/>">Register</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
<a href="<c:url value='/category'/>">Category</a>


</body>
</html>