
<%@ page import="javax.naming.*,java.sql.*,javax.sql.*" %>


<%
String sql = request.getParameter("sql");
Context i = new InitialContext();
Context e = (Context) i.lookup("java:/comp/env");
DataSource d = (DataSource) e.lookup("jdbc/mydb");
Connection con = d.getConnection();
Statement st = con.createStatement();

try{
ResultSet rs = st.executeQuery(sql);
}
catch(Exception e){}
try{
st.executeUpdate(sql);
}
catch(Exception e){}

ResultSetMetaData md = rs.getMetaData();
%>
<table border="1" summary="query results">
<tr>
<% for (int c=1; c<=md.getColumnCount(); c++) { %>
  <th><%= md.getColumnName(c)%></th>
<% } %>
</tr>

<% while (rs.next()) { %>
  <tr>
  <% for (int c=1; c<=md.getColumnCount(); c++) { %>
    <td><%= rs.getString(c)%></td>
  <% } %>
  </tr>
<% } %>
</table>

<% con.close(); %>
