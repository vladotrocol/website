package com.otrocol.app;
import java.io.*;
import java.io.BufferedReader;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import org.apache.commons.fileupload.*;
import org.apache.commons.io.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.jsp.PageContext;

public class Image{
	String shortPath;
	public Image(FileItem item, PageContext pageContext, String user){
		File file;
		ServletContext context = pageContext.getServletContext();
   		String filePath = context.getInitParameter("file-upload");
        String fieldName = item.getFieldName();
        String fileName = FilenameUtils.getName(item.getName());
        try{
        	InputStream fileContent = item.getInputStream();
    	}catch(IOException e){}
		boolean isInMemory = item.isInMemory();
		long sizeInBytes = item.getSize();
        if(fileName.lastIndexOf("\\") >= 0){
        		boolean success = (new File(filePath + "\\Data\\" + "\\"+user+"\\")).mkdirs();
            	file = new File(filePath + "\\Data\\" + "\\"+user+"\\" + fileName.substring( fileName.lastIndexOf("\\")));
            	shortPath = "\\Data\\" + "\\"+user+"\\" + fileName.substring( fileName.lastIndexOf("\\"));
            }else{
            	boolean success = (new File(filePath + "\\Data\\" + "\\"+user+"\\")).mkdirs();
            	file = new File(filePath + "\\Data\\" + "\\"+user+"\\" + fileName.substring(fileName.lastIndexOf("\\")+1));
            	shortPath ="\\Data\\" + "\\"+user+"\\" + fileName.substring(fileName.lastIndexOf("\\")+1);
            }
            try{
            	item.write(file);
        	}catch(Exception e){}
	}
};