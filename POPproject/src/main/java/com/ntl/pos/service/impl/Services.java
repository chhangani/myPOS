package com.ntl.pos.service.impl;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import com.ntl.pos.utill.impl.DatabaseImpl;

import java.util.Date;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.util.*;
import java.io.*;
public class Services {

	public static boolean checkDuplicate(String userEmail){
		DatabaseImpl db = new DatabaseImpl();
		return db.checkDuplicate(userEmail);
	}
	public static boolean validateEmail(String email){
		 if (email == null) 
				return false; 
		 
		 String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                 "[a-zA-Z0-9_+&*-]+)*@" + 
                 "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                 "A-Z]{2,7}$"; 
         Pattern pat = Pattern.compile(emailRegex); 
		 return pat.matcher(email).matches(); 
	}
	
	public static boolean validatePassword(String pass){
		 if (pass == null) 
				return false;  
		 String passRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"; 
         Pattern pat = Pattern.compile(passRegex); 
		 return pat.matcher(pass).matches(); 
	}
	public static boolean validateDate(String strDate)
	   {
		if (strDate.trim().equals(""))
		{
		    return false;
		}
		else
		{

		    SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
		    sdfrmt.setLenient(false);
		    try
		    { 
		    
		      Date javaDate = sdfrmt.parse(strDate); 
		        return true;
		    }
		    /* Date format is invalid */
		    catch (ParseException e)
		    {
		        return false;
		    }
		}
	   }
}
