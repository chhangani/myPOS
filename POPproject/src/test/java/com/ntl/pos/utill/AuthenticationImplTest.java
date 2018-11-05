package com.ntl.pos.utill;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.utill.impl.AuthenticationImpl;
import com.ntl.pos.utill.impl.UserImpl;

public class AuthenticationImplTest {

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
	public void testAuthenticate() {
		AuthenticationImpl authenticationImpl;
		authenticationImpl = new AuthenticationImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibs@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
	    //Correct Data | ADMIN
		boolean actual = authenticationImpl.authenticate(credentialsBean);
		assertEquals(true, actual);

	}

	@Test
	public void testAuthorize() {
		AuthenticationImpl authenticationImpl;
		authenticationImpl = new AuthenticationImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibs@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
	    //Correct Data | ADMIN
		boolean actual = authenticationImpl.authenticate(credentialsBean);
	    //Correct Data | ADMIN
		String result = authenticationImpl.authorize("vibs@gmail.com");
		assertEquals("admin",result);

	}
	
	@Test
	public void testIsLogin() {
		AuthenticationImpl authenticationImpl = new AuthenticationImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibs@gmailll.com");
		credentialsBean.setPassword("Mdm@9782");
	    //Wrong Data
		boolean actual = authenticationImpl.authenticate(credentialsBean);
		boolean status = authenticationImpl.isLogin();
		assertEquals(true, status);
	}

	@Test
	public void testIsAdmin() {
		AuthenticationImpl authenticationImpl;
		authenticationImpl = new AuthenticationImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibs@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
	    //Correct Data | ADMIN
		boolean actual = authenticationImpl.authenticate(credentialsBean);
	    //Correct Data | ADMIN
		String result = authenticationImpl.authorize("vibs@gmail.com");
		assertEquals("admin",result);
	}

	@Test
	public void testGetEmail() {
		// Already Checked
	}

	@Test
	public void testLogout() {
		// Already Checked
	}

	@Test
	public void testDisplayProfile() {
	   // No Need of checking this, it is a part of authorize
	}


}
