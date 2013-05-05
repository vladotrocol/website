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

public class FormReader{
	public int registered = 0;
	public FormReader(PageContext pageContext, HttpServletRequest request, HttpServletResponse response, JspWriter out){
		try{
			doPost(pageContext, request, response, out);
		}catch(ServletException se){}
		catch(IOException e){}
	}

	public void doPost(PageContext pageContext, HttpServletRequest request, HttpServletResponse response, JspWriter out) throws ServletException, IOException {
		User newUser = new User();
	    try {
	        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	        for (FileItem item : items) {
	            if (item.isFormField()) {
	                String fieldName = item.getFieldName();
	                String fieldValue = item.getString();
	                newUser.insertValue(fieldName, fieldValue);
	            } else {
	            	Image profilePic = new Image(item, pageContext, newUser.VALUES.get("userName"));
	            	newUser.insertValue("avatar", profilePic.shortPath);
	            }
	        }
	    } catch (FileUploadException e) {
	        throw new ServletException("Cannot parse multipart request.", e);
	    }
	    Mailler myemail = new Mailler();
	    try{
			myemail.send("vladotrocol", "zubavacavarivatelnita", newUser.VALUES.get("email"), "", "Odemia Email Confirmation", "<p> Click on this link: <br> https://localhost/actions/activation.jsp?u="+newUser.VALUES.get("userName")+"&code=18934_897600 <p>");
			registered = 1;
		}catch(AddressException ad){}
		catch(MessagingException me){}
	    newUser.generateUser(request, response, out);
	}

	public static String convertStreamToString(InputStream is) {
    	Scanner s = new Scanner(is).useDelimiter("\\A");
    	return s.hasNext() ? s.next() : "";
	}
}