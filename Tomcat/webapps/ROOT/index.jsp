<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head><title>Testing</title></head>
<body>
<%@ page import="javax.naming.*,java.sql.*,javax.sql.*" %>
<%
Context i = new InitialContext();
Context e = (Context) i.lookup("java:/comp/env");
DataSource d = (DataSource) e.lookup("jdbc/mydb");
Connection con = d.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select forenames, surname from people");
%>
</body>
</html>