package com.ntl.pos.utill.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.bean.ProfileBean;
import com.ntl.pos.utill.DBUtil;



public class DatabaseImpl implements DBUtil {

	static CredentialsBean cb  = new CredentialsBean();
	static int loginFlag = 0;
	static Connection conn; //Interface
	static Statement stmt; // Interface
	static ResultSet rs;
	static PreparedStatement pstmt;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/pizzSystem";
	static final String USER = "root";
	static final String PASS = "root";
	private DatabaseImpl db;
	public DatabaseImpl() {
	    getDBConnection(JDBC_DRIVER);
	}
	public DatabaseImpl(DatabaseImpl db) {
		// TODO Auto-generated constructor stub
		this.db = db;
	}
	//@Override
	public int getDBConnection(String driverType) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			return 1;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 return 0;
	}
	public boolean checkLogin(CredentialsBean credentialsBean) {
		try {
			stmt = conn.createStatement();
			String useremail  = credentialsBean.getEmail();
			String sql = "select * from userlogin where email = '"+useremail + "'";
			rs = stmt.executeQuery(sql);
			 if(rs.next()){
				 cb.setUserID(rs.getInt("userId"));
				 cb.setEmail(rs.getString("email"));
				 cb.setPassword(rs.getString("password"));
				 cb.setUserType(rs.getString("userType"));
				 cb.setLoginStatus(rs.getInt("loginStatus"));	
				 
				 if(cb.getPassword().equals(credentialsBean.getPassword())) {
					 updateLoginStatus(credentialsBean.getEmail());
					 loginFlag = 1;
					 return true;
				 }
			 }
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		return false;
	}
	public int updateLoginStatus(String email) {
		 try {
			 String sql = "update userlogin set loginStatus = 1";
			 sql += " where email = '" + email +"'";
			 int flag = stmt.executeUpdate(sql);
			 return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return 0;
	}
	public String printMessage(String email) {
		String message = "";
		if(loginFlag==1 && cb.getEmail().equals(email))
		message = cb.getUserType();	
		else{
			if(cb!=null) {
				if(cb.getEmail()!=null) {
					 if(cb.getEmail().equals(email)) {
						 loginFlag = 0;
						 message = "Invallid";	
					 }
					 else {
						 loginFlag = 0;
						 message = "Failed";	 
					 }
				}
				 else {
					 loginFlag = 0;
					 message = "Failed";	 
				 }
			}
			 else {
				 loginFlag = 0;
				 message = "Failed";	 
			 }
		
		
		}
		return message;
	}
	public boolean isLogin() {
		if(loginFlag==1)
			return true;
		return false;
	}
	public boolean isAdmin() {
		if(cb.getUserType().equals("admin"))
			return true;
		return false;
	}
	public String getEmail() {
		return cb.getEmail();
	}
	public String register(ProfileBean pb) {
		int z = 0;
		try {
			
			 if(checkDuplicate(pb.getEmailID())) {
				 System.out.println("Email Already Used");
				 return null;
			 }
			 pstmt = conn.prepareStatement("insert into userlogin (email,password,userType,loginStatus) values (?,?,?,?)");
			 
			 pstmt.setString(1,pb.getEmailID());
			 pstmt.setString(2,pb.getPassword());
			 pstmt.setString(3,"user");
			 pstmt.setInt(4,0);
			 z = pstmt.executeUpdate();
			 if(z!=0) {
				 saveProfile(pb);
				 System.out.println("Saved Successfully.");
			 }
			 else {
				 System.out.println("Error | Try Again");
			 }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		 if(z==1)
		 return "success";
		 return null;
	}
	
	public void saveProfile(ProfileBean pb) {
		//Profile Bean
		int userId = getUserId(pb.getEmailID());
		int z = 0;
		try {
			 String sql  = "insert into usersprofile";
			 sql += "(userId,firstName,lastName,dateOfBirth,gender,street,location,city,state,pinCode,mobileNo)";
			 sql += "values (?,?,?,?,?,?,?,?,?,?,?)";
			 SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
			 sdfrmt.setLenient(false);
			 Date javaDate = null;
			 try {
			    javaDate = sdfrmt.parse(pb.getDateOfBirth());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, userId);
			 pstmt.setString(2, pb.getFirstName());
			 pstmt.setString(3, pb.getLastName());
			 pstmt.setString(4, pb.getDateOfBirth());
			 pstmt.setString(5, pb.getGender());
			 pstmt.setString(6, pb.getStreet());
			 pstmt.setString(7, pb.getLocation());
			 pstmt.setString(8, pb.getCity());
			 pstmt.setString(9, pb.getState());
			 pstmt.setString(10, pb.getPincode());
			 pstmt.setString(11, pb.getMobileNo());
			 z = pstmt.executeUpdate();
			 if(z!=0) {
				 System.out.println("Saved Successfully.");
			 }
			 else {
				 System.out.println("Error | Try Again");
			 }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	
		
	}
	
	public int getUserId(String email) {
		try {
			stmt = conn.createStatement();
			String sql = "select * from userlogin where email = '"+email + "'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt("userId");
			}
		}
			 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;

	}
	public boolean logout(String email) {
		if (rs != null) {
	        try {
	            rs.close();
	        } catch (SQLException e) { /* ignored */}
	    }
	    if (pstmt != null) {
	        try {
	            pstmt.close();
	        } catch (SQLException e) { /* ignored */}
	    }
	    if (conn != null) {
	        try {
	            conn.close();
	        } catch (SQLException e) { /* ignored */}
	    }
	    if (stmt != null) {
	        try {
	            stmt.close();
	        } catch (SQLException e) { /* ignored */}
	    }
	    
		if(cb.getEmail().equals(email)) {
			loginFlag = 0;
			cb = new CredentialsBean();
			return true;
		}
		return false;
	}
	public boolean checkDuplicate(String email) {
		try {
			stmt = conn.createStatement();
			String sql = "select * from userlogin where email = '"+email + "'";
			rs = stmt.executeQuery(sql);
			 if(rs.next()) {
				 return true;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false;
	}
	public ProfileBean displayProfile(String email) {
		ProfileBean pb = new ProfileBean();;
		try {
			stmt = conn.createStatement();
			int userId = getUserId(email);
			String sql = "select * from usersProfile where userId ="+userId;
			rs = stmt.executeQuery(sql);
		    if(rs.next()) {
		    	pb.setFirstName(rs.getString("firstName"));
		    	pb.setLastName(rs.getString("lastName"));
		    	pb.setUserID(rs.getInt("userId"));
		    }
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pb;
	}
}
  
