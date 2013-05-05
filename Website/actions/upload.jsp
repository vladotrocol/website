<%@ page import="com.otrocol.app.*" %>
<%
	String id = request.getParameter("id");
	String user = request.getParameter("u");
	Upload newupload = new Upload(pageContext, request, response, out, id, "lizozom");
	response.sendRedirect(request.getHeader("referer"));
%>
