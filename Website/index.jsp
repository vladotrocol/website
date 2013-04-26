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
ResultSet rs = st.executeQuery("select forenames, surnames from people");
%>
<table>
<% while (rs.next()) {
  String fn = rs.getString("forenames");
  String sn = rs.getString("surnames");
%>
<tr><td><%=fn%></td><td><%=sn%></td></tr>
<% } %>
</table>
<% st.close(); con.close(); %>
<% double r = Math.random(); %>
...
<% if (r < 0.5) { %>
<p>The dish of the day is duck.</p>
<% } else { %>
<p>Duck is off the menu.</p>
<% } %>
<% for (int n=0; n<10; n++) { %>
<p>The square of <%= n %> is <%= n*n %></p>
<% } %>
</body>
</html>