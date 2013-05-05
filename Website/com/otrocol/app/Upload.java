package com.otrocol.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.ServletException;
import org.apache.commons.fileupload.*;
import org.apache.commons.io.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.mail.*;
import javax.mail.internet.*;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletException;

public class Upload{
	public int registered = 0;
	public String id;
	public String user;
	public Upload(PageContext pageContext, HttpServletRequest request, HttpServletResponse response, JspWriter out, String ids, String users){
		id = ids;
		user = users;
		try{
			doPost(pageContext, request, response, out);
		}catch(ServletException se){}
		catch(IOException e){}
	}

	public void doPost(PageContext pageContext, HttpServletRequest request, HttpServletResponse response, JspWriter out) throws ServletException, IOException {
	    try {
	        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	        for (FileItem item : items) {
	            if (item.isFormField()) {
	            } else {
	            	Fille f = new Fille(item, pageContext, user);
	            	try{
	            	f.insert(id, f.shortPath);
	            	}
	            	catch(SQLException r){}
	            }
	        }
	    } catch (FileUploadException e) {
	        throw new ServletException("Cannot parse multipart request.", e);
	    }
	}
}