package com.ntl.pos.utill;

import com.ntl.pos.bean.CredentialsBean;

public interface Authentication {
	
	public boolean authenticate(CredentialsBean credentialsBean);
	public String authorize(String userId);
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);

}
