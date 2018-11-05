package com.ntl.pos.bean;

public class CredentialsBean {
	private int userID;
	private String email;
	private String password;
	private String userType;
	private int loginStatus;
	public CredentialsBean() {
		
	}
	public CredentialsBean(int userID, String email, String password, String userType, int loginStatus) {
		super();
		this.userID = userID;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.loginStatus = loginStatus;
	}
	public CredentialsBean(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
	 
	 
}
