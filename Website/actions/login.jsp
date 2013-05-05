
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Query Results</title>
</head>

<body>
<%@ page import="com.otrocol.app.*" %>
<%
String userName = request.getParameter("userName");
String passWord = request.getParameter("passWord");
User checkUser = new User();
boolean ex = checkUser.exists(userName, passWord);
if(ex){
	Db data = new Db();
	int id = data.getId(userName);
	out.print(id);
	response.sendRedirect("../index.jsp?id="+id+"");
}
else{
	response.sendRedirect("../index.jsp?id="+0);
}

%>
</body>
</html>
