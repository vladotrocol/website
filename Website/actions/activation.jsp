<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Register</title>
</head>

<body><%@ page import="com.otrocol.app.*" %>
<%
	String user  = request.getParameter("u");
	String code  = request.getParameter("code");
	User act = new User();
	act.confirm(user, code);
	response.sendRedirect("../index.jsp");
%>
</body>
</html>
