<%@ page import="javax.naming.*,java.sql.*,javax.sql.*" %>
<%@ page import="com.otrocol.shop.*" %>
<%
Context i = new InitialContext(); //javax.naming
Context e = (Context) i.lookup("java:/comp/env"); //javax.naming
DataSource d = (DataSource) e.lookup("jdbc/mydb"); //javax.sql
Connection con = d.getConnection(); //java.sql
Statement st = con.createStatement(); //java.sql
String h = request.getParameter("inputText");
st.executeUpdate("insert into people values('"+h+"', 'Otrocol')"); //java.sql
ResultSet rs2 = st.executeQuery("select forenames, surnames from people");

while (rs2.next()) {
 String fn = rs2.getString("forenames");
 String sn = rs2.getString("surnames");
 out.print(fn+" "+sn+"</BR>");
}

st.close();
con.close();
%>
