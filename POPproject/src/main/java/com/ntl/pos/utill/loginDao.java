package com.ntl.pos.utill;

import java.util.ArrayList;

import com.ntl.pos.bean.CredentialsBean;

public interface loginDao {
	public String createLogin(CredentialsBean cb);     
	public int deleteLogin(ArrayList<String> Arr);     
	public boolean updateLogin(CredentialsBean cb);     
	public CredentialsBean findByID(String email);  
	public ArrayList<CredentialsBean> findAll();
}
