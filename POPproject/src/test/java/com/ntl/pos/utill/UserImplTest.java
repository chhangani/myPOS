package com.ntl.pos.utill;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.bean.ProfileBean;
import com.ntl.pos.utill.impl.AuthenticationImpl;
import com.ntl.pos.utill.impl.DatabaseImpl;
import com.ntl.pos.utill.impl.UserImpl;

public class UserImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testLogin() {
		//Login Testing
		//AuthenticationImpl auth;
		UserImpl userImpl;
		//auth = mock(AuthenticationImpl.class);
		
		CredentialsBean credentialsBean = new CredentialsBean();
		userImpl = new UserImpl();
		credentialsBean.setEmail("vibs@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
		String expected = "admin";
		//when(userImpl.login(credentialsBean)).thenReturn(expected);
		String actual = userImpl.login(credentialsBean);
		assertEquals(expected,actual);		
	}

	@Test
	public void testGetEmail() {
		UserImpl userImpl;
		userImpl = new UserImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibs@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
		String actual = userImpl.login(credentialsBean);
		String email = userImpl.getEmail();
		assertEquals("vibs@gmail.com", email);
	}

	@Test
	public void testIsLogin() {
		UserImpl userImpl;
		userImpl = new UserImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibs@gmailll.com");
		credentialsBean.setPassword("Mdm@9782");
	    //Wrong Data
		String actual = userImpl.login(credentialsBean);
		boolean status = userImpl.isLogin();
		assertEquals(false, status);
		//Correct data
		credentialsBean.setEmail("vibs@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
		actual = userImpl.login(credentialsBean);
		status = userImpl.isLogin();
		assertEquals(true, status);
	}
	@Test
	public void testIsAdmin() {
		UserImpl userImpl;
		userImpl = new UserImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibs@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
	    //Correct Data | ADMIN
		String actual = userImpl.login(credentialsBean);
		boolean status = userImpl.isAdmin();
		assertEquals(true, status);
		//Wrong Data
		credentialsBean.setEmail("vibhanshu@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
		actual = userImpl.login(credentialsBean);
		status = userImpl.isAdmin();
		assertEquals(false, status);
	}

	@Test
	public void testDisplayProfile() {
		//We are checking  | Reading of data from database;
		UserImpl userImpl;
		userImpl = new UserImpl();
		//Email exist then
		ProfileBean pb = userImpl.displayProfile("vibhanshu@gmail.com");
		assertEquals(5, pb.getUserID());
		pb = userImpl.displayProfile("noEistEmailAddress");
		int id= pb.getUserID();
		//Null object so id will be zero
		assertEquals(0, id);
	}

	@Test
	public void testLogout() {
	  // if and only if you are login, you can logout
		UserImpl userImpl;
		userImpl = new UserImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibs@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
	    //Correct Data | ADMIN
		String actual = userImpl.login(credentialsBean);
		//Sending email after, login
		boolean status = userImpl.logout(credentialsBean.getEmail());
		assertEquals(true, status);
			
	}
	@Test
	public void testRegisterProfileBean() {
		
		AuthenticationImpl testobj = mock(AuthenticationImpl.class);
		
		ProfileBean pb = new ProfileBean();
		pb.setUserID(1142061);
		pb.setFirstName("Vibhanshu");
		pb.setLastName("Chhangani");
		pb.setDateOfBirth("22/09/1997");
		pb.setGender("male");
		pb.setStreet("Housing Board");
		pb.setLocation("2 E 14");
		pb.setCity("Jodhpur");
		pb.setState("Rajasthan");
		pb.setPincode("232001");
		pb.setMobileNo("9672039091");
		pb.setEmailID("mittalsab@yahoo.com");
		pb.setPassword("Mdm@9782");
		when(testobj.register(pb)).thenReturn("success");
		
		UserImpl userobj = new UserImpl(testobj);
		
		String result= userobj.register(pb);
		assertEquals("success",result);
	}

}
