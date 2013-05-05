<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Query Results</title>
</head>

<body>

<h1>Query Results</h1>

<%@ page import="javax.naming.*,java.sql.*,javax.sql.*"%>
<%@ page isErrorPage="true" import="java.io.*"%>
<%
String sql = request.getParameter("sql");
String sql2 = request.getParameter("sql2");
Context i = new InitialContext();
Context e = (Context) i.lookup("java:/comp/env");
DataSource d = (DataSource) e.lookup("jdbc/mydb");
Connection con = d.getConnection();

	if(sql2.length()>0){
		
		try{
		Statement st2 = con.createStatement();
			st2.executeUpdate(sql2);
		}catch (SQLException s){%>
			<p>Update Error Stack</p><pre><%
			s.printStackTrace(new PrintWriter(out));
			%>
		</pre><%
		}
	}	
if(sql.length()>0){
	try{
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(sql);
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

<%
	}catch (SQLException s){%>
		<p>Query Error Stack</p><pre>
		<%s.printStackTrace(new PrintWriter(out));%>
</pre>
		<%
	}
}
con.close(); %>

</body>
</html>
