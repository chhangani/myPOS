package com.ntl.pos.utill;

import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.bean.ProfileBean;

public interface User {
	String login(CredentialsBean credentialsBean);
	boolean logout(String email);
	String changePassword(CredentialsBean credentialsBean, String newPassword);
	String register(ProfileBean profileBean);
}
