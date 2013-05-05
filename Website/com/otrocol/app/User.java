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
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;

public class User{

	public String message;
	public HashMap<String,String> VALUES = new HashMap<String,String>();
	public DataSource d;
	public Connection con;
	public Context i;
	public Context e;
	public Statement st;

	public User(){
	};

	public void insertValue(String fieldName, String fieldValue){
		VALUES.put(fieldName, fieldValue);
	}

	public int generateId(){
		int newId = 1;
		try{
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from users order by userid desc");
			rs.next();
			int prevId = rs.getInt("userid");
			newId = prevId+1;
			st.close();
		}catch(SQLException s){}
		return (newId);
	};

	public void closeDbConnection(){
		try{
			con.close();
		}catch(SQLException s){
			message = "Registration failed!Check stacktrace.";
			s.printStackTrace();
		};
	}

	public void startDbConnection(){
		try{
			i = new InitialContext(); //javax.naming
			e = (Context) i.lookup("java:/comp/env"); //javax.naming
			d = (DataSource) e.lookup("jdbc/mydb"); //javax.sql
			try{
				con = d.getConnection(); //java.sql
			}catch(SQLException s){
				message = "Registration failed!Check stacktrace.";
				s.printStackTrace();
			};
		}catch(NamingException n){
			message = "Registration failed!Check stacktrace.";
			n.printStackTrace();
		};
	}

	public void insertUser(int id){
		try{
			st = con.createStatement(); //java.sql
			String insertSql;
			insertSql = "insert into users values("+id+",'"+VALUES.get("userName")+"','"+VALUES.get("passWord")+"','"+VALUES.get("email")+"','"+VALUES.get("firstName")+"','"+VALUES.get("lastName")+"','"+VALUES.get("age")+"','"+ VALUES.get("avatar")+"','"+false+"')";
			st.executeUpdate(insertSql);
			st.close();
		}catch(SQLException s){
			message = "Registration failed!Check stacktrace.";
			s.printStackTrace();
		};
	}
	
	public void generateUser(HttpServletRequest request,HttpServletResponse response, JspWriter out){
		message = "Registration successful";
		startDbConnection();
		insertUser(generateId());
		closeDbConnection();
	};

	private boolean check(String userName, String passWord) throws SQLException{
		st = con.createStatement(); //java.sql
		ResultSet rs = st.executeQuery("select * from users where username = '" + userName+"' and password = '" + passWord + "'");
		int count=0;
        while(rs.next()){
        	count++;
        }
        if(count>0){
        	return true;
        }
        else {
        	return false;
        }
	}

	public boolean exists(String userName, String passWord) throws SQLException{
		startDbConnection();
		boolean exists = check(userName, passWord);
		closeDbConnection();
		return exists;
	}

	public void confirm(String user, String code){
		startDbConnection();
		try{
			Statement st3 = con.createStatement(); //java.sql
			String insertSql;
			insertSql = "update users set confirmed = true where username = '"+user+"'";
			if(code.equals("18934_897600")){
				st3.executeUpdate(insertSql);
			}
		}catch(SQLException s){
			message = "Registration failed!Check stacktrace.";
			s.printStackTrace();
		};
		closeDbConnection();
	}

};