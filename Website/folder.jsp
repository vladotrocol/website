<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
  lang="en-GB" xml:lang="en-GB">
<head>
<title>Odemia</title>
</head>
  <%@ page import="com.otrocol.app.*" %>
  <%@ page import="javax.naming.*,java.sql.*,javax.sql.*"%>
<body>  
  <h1>My Folder</h1>
  <%String id = request.getParameter("id"); %>
<form enctype="multipart/form-data" name="myForm" action="actions\upload.jsp?id=1" method="post">   
  <h2>Register</h2>  
    <label fro="upload">Upload a file:</label>
    <input type="file" name="avatar"/>
    <input type="submit"/>
</form>
 <% 
    if(id!=null){
    Db data = new Db();
	ResultSet rs = data.getRSf(id);
    %>
  	<table border="1" summary="files">
		<% while (rs.next()) { %>
  		<tr>
    	<td><%= rs.getString("path")%></td>
  		</tr>
		<% } %>
		</table>

	<%}%>
  </body>
</html>
