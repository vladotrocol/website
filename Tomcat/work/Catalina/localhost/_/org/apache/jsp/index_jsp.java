/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.39
 * Generated at: 2013-04-25 21:09:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.naming.*;
import java.sql.*;
import javax.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head><title>Testing</title></head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");

Context i = new InitialContext();
Context e = (Context) i.lookup("java:/comp/env");
DataSource d = (DataSource) e.lookup("jdbc/mydb");
Connection con = d.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select forenames, surnames from people");

      out.write("\r\n");
      out.write("<table>\r\n");
 while (rs.next()) {
  String fn = rs.getString("forenames");
  String sn = rs.getString("surnames");

      out.write("\r\n");
      out.write("<tr><td>");
      out.print(fn);
      out.write("</td><td>");
      out.print(sn);
      out.write("</td></tr>\r\n");
 } 
      out.write("\r\n");
      out.write("</table>\r\n");
 st.close(); con.close(); 
      out.write('\r');
      out.write('\n');
 double r = Math.random(); 
      out.write("\r\n");
      out.write("...\r\n");
 if (r < 0.5) { 
      out.write("\r\n");
      out.write("<p>The dish of the day is duck.</p>\r\n");
 } else { 
      out.write("\r\n");
      out.write("<p>Duck is off the menu.</p>\r\n");
 } 
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
