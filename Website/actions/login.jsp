<%@ page import="javax.naming.*,java.sql.*,javax.sql.*" %>
<%@ page import="com.otrocol.app.*" %>
<%
Context i = new InitialContext(); //javax.naming
Context e = (Context) i.lookup("java:/comp/env"); //javax.naming
DataSource d = (DataSource) e.lookup("jdbc/mydb"); //javax.sql
Connection con = d.getConnection(); //java.sql
Statement st = con.createStatement(); //java.sql
String userName = request.getParameter("userName");
String passWord = request.getParameter("passWord");
// int prevId = 
User newUser = new User();
int id = newUser.generateId(2);
out.print(id);
st.close();
con.close();
%>
