
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Register</title>
</head>

<body>
<%@ page import="com.otrocol.app.*" %>
<%
	FormReader newForm = new FormReader(pageContext, request, response, out);
	response.sendRedirect("../index.jsp?l="+newForm.registered);
%>
</body>
</html>
