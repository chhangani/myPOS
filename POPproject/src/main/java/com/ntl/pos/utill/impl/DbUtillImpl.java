package com.ntl.pos.utill.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.utill.DBUtil;

public class DbUtillImpl {

	static CredentialsBean cb  = new CredentialsBean();
	static int loginFlag = 0;
	static Connection conn=null; //Interface
	static Statement stmt; // Interface
	static ResultSet rs;
	static PreparedStatement pstmt;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/pizzSystem";
	static final String USER = "root";
	static final String PASS = "root";
	public DbUtillImpl() {
	    getDBConnection(JDBC_DRIVER);
	}	
	public Connection getDBConnection(String driverType) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
     return conn;
	}

}
