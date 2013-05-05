package com.otrocol.app;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.naming.*;
import java.sql.*;
import javax.sql.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;

public class Details{
	public HashMap<String,String> VALUES = new HashMap<String,String>();
	public boolean confirmed;
	public Details(String id)throws SQLException{
		Db data = new Db();
		ResultSetMetaData rsmd = data.getRM();
		int l = rsmd.getColumnCount();
		for(int i=2;i<l;i++){
			VALUES.put(rsmd.getColumnName(i), data.get(id, rsmd.getColumnName(i)));
		}
		confirmed = data.confirmed(id);
	}

	public void print(JspWriter out)throws JspException, IOException{
		Set set = VALUES.entrySet(); 
		Iterator i = set.iterator(); 
		while(i.hasNext()) { 
		Map.Entry me = (Map.Entry)i.next(); 
		out.print(me.getKey() + ": "); 
		out.println(me.getValue()); 
		} 
	}

	public String get(String k){
		return VALUES.get(k);
	}
}