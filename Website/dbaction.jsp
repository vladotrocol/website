
<%@ page import="javax.naming.*,java.sql.*,javax.sql.*" %>


<%
String sql = request.getParameter("sql");
String sql2 = request.getParameter("sql2");
Context i = new InitialContext();
Context e = (Context) i.lookup("java:/comp/env");
DataSource d = (DataSource) e.lookup("jdbc/mydb");
Connection con = d.getConnection();
if(sql2.length>0){
Statement st2 = con.createStatement();
st2.executeUpdate(sql2);
}
if(sql.length>0){
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(sql);
ResultSetMetaData md = rs.getMetaData();
<table border="1" summary="query results">
<tr>
 for (int c=1; c<=md.getColumnCount(); c++) { 
  <th> md.getColumnName(c)</th>
 }
</tr>

 while (rs.next()) {
  <tr>
 for (int c=1; c<=md.getColumnCount(); c++) {
    <td> rs.getString(c)</td>
  }
  </tr>
 } 
</table>
}
 con.close(); %>
