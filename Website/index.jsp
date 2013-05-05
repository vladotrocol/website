<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
  lang="en-GB" xml:lang="en-GB">
<head>
<title>Odemia</title>
</head>
<body>  
  <h1>Home</h1>
  <%@ page import="com.otrocol.app.*" %>    
    <%
    String id = request.getParameter("id"); 
    if(id!=null){
            if(id.equals("0")){%>
                <a href="registerPage.html">Register</a>
                <a href="loginPage.html">Login</a>
            <%}else{
                Details d = new Details(id);%>
                <h2>Welcome <%= d.get("FIRSTNAME")%></h2>
                <img src="<%=d.get("AVATAR")%>" width = "100" height = "50"/>
                <p>Your birth date is <%= d.get("AGE")%></p>
                <p>Your last name is <%= d.get("LASTNAME")%></p>
                <%if(!d.confirmed){%>
                    <p>You have not confirmed your email address</p>
                <%}
                else{%>
                    <p>Your email address is confirmed</p>
                <%}%>
                <a href="folder.jsp?id=1">Go to your folder</a>
            <%}
        }
    else{%>
        <a href="registerPage.html">Register</a>
        <a href="loginPage.html">Login</a>
    <%}%>
</body>
</html>

