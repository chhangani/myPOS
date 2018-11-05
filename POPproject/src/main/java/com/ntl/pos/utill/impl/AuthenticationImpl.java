package com.ntl.pos.utill.impl;

import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.bean.ProfileBean;
import com.ntl.pos.utill.Authentication;

public class AuthenticationImpl implements Authentication {

	DatabaseImpl db = new DatabaseImpl();
	//@Override
	public boolean authenticate(CredentialsBean credentialsBean) {
		// TODO Auto-generated method stub
		boolean  loginStatus = db.checkLogin(credentialsBean);
		return loginStatus;
	}
   //@Override
	public String authorize(String email) {
		String result = db.printMessage(email);
		return result;
	}
	//@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isLogin() {
		
		boolean result = db.isLogin();
		return result;
	}
	public boolean isAdmin() {
		boolean result = db.isAdmin();
		return result;
	}
	public String getEmail() {
		String result = db.getEmail();
		return result;
	}
	public boolean logout(String email) {
        boolean result = db.logout(email);
		return result;
	}
	public ProfileBean displayProfile(String email) {
		ProfileBean pb= db.displayProfile(email);
		return pb;
	}
	public String register(ProfileBean pb) {
		String result = db.register(pb);
		return result;
	}
}
