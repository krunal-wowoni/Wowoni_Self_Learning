<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= ISO-8859-1">
<title>success</title>
</head>
<body>

<%
String name = request.getParameter("username");
%>

<h1>Welcome, <%=name %> you are succefully logged in....</h1>
</body>
</html>