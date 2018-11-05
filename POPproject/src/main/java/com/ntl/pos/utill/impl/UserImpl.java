package com.ntl.pos.utill.impl;

import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.bean.ProfileBean;
import com.ntl.pos.utill.User;

public class UserImpl implements User {

	public AuthenticationImpl auth = new AuthenticationImpl();
	public UserImpl(AuthenticationImpl auth) {
		this.auth = auth;
		// TODO Auto-generated constructor stub
	}
	public UserImpl() {
		// TODO Auto-generated constructor stub
		 auth= new AuthenticationImpl();
	}
	//@Override
	public String login(CredentialsBean credentialsBean) {
		boolean loginStatus = auth.authenticate(credentialsBean);
		String loginMessage = auth.authorize(credentialsBean.getEmail());
		return loginMessage;
	}
	public String getEmail() {
		String result = auth.getEmail();
		return result;
	}
	public boolean isLogin() {
		boolean result = auth.isLogin();
		return result;
	}
	public boolean isAdmin() {
	    boolean result = auth.isAdmin();
		return result;
	}
	public boolean register(CredentialsBean credentialsBean){
		return true;
	}
	public ProfileBean displayProfile(String email) {
		ProfileBean pb  = auth.displayProfile(email);
		return pb;
	}
	//@Override
	public boolean logout(String email) {
	    boolean result = auth.logout(email);
		return result;
	}

	//@Override
	public String register(ProfileBean profileBean) {
		String result = auth.register(profileBean);
		return result;
	}
	public String changePassword(CredentialsBean credentialsBean, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}
   
}
