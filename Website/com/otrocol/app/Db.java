package com.otrocol.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.ServletException;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;

public class Db{
	public DataSource d;
	public Connection con;
	public Context i;
	public Context e;

	public Db(){}

		public void startDbConnection()throws SQLException{
		try{
			i = new InitialContext(); //javax.naming
			e = (Context) i.lookup("java:/comp/env"); //javax.naming
			d = (DataSource) e.lookup("jdbc/mydb"); //javax.sql
			try{
				con = d.getConnection(); //java.sql
			}catch(SQLException s){
				s.printStackTrace();
			};
		}catch(NamingException n){
			n.printStackTrace();
		};
	}

		public void closeDbConnection ()throws SQLException{
		try{
			con.close();
		}catch(SQLException s){
			s.printStackTrace();
		};
	}

	public int getId(String user)throws SQLException{
		startDbConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select userid from users where username = '"+user+"'");
		rs.next();
		int id = rs.getInt("userid");
		closeDbConnection();
		return id;
	}

	public String get(String id, String attribute)throws SQLException{
		startDbConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select "+attribute+" from users where userid = "+id);
		rs.next();
		String value = rs.getString(attribute);
		closeDbConnection();
		return value;
	}

	public boolean confirmed(String id)throws SQLException{
		startDbConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select confirmed from users where userid = "+id);
		rs.next();
		boolean value = rs.getBoolean("confirmed");
		closeDbConnection();
		return value;
	}

	public ResultSetMetaData getRM()throws SQLException{
		startDbConnection();
		Statement st = con.createStatement();
		String query = "select * from users";
		ResultSet rs = st.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		closeDbConnection();
		return rsmd;
	}
	// public void getUserFiles()throws SQLException{
	// 	startDbConnection();
	// 	Statement st = con.createStatement();
	// 	String query = "select * from files where userid = " + id;
	// 	ResultSet rs = st.executeQuery(query);
	// 	while(rs.next()){
	// 		VALUES.put(rs.getInt("userid"), rs.getString("path"));
	// 	}
	// }

	// public ResultSetMetaData getRMf(String id)throws SQLException{
	// 	startDbConnection();
	// 	Statement st = con.createStatement();
	// 	String query = "select path from files where userid = "+id;
	// 	ResultSet rs = st.executeQuery(query);
	// 	ResultSetMetaData rsmd = rs.getMetaData();
	// 	closeDbConnection();
	// 	return rsmd;
	// }

	public ResultSet getRSf(String id)throws SQLException{
		startDbConnection();
		Statement st = con.createStatement();
		String query = "select path from files where userid = " +id;
		ResultSet rs = st.executeQuery(query);
		return rs;
	}


} 