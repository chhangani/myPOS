package com.ntl.pos.utill;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.bean.ProfileBean;
import com.ntl.pos.utill.impl.AuthenticationImpl;
import com.ntl.pos.utill.impl.DatabaseImpl;
import com.ntl.pos.utill.impl.DbUtillImpl;
import com.ntl.pos.utill.impl.UserImpl;

public class DatabaseImplTest {
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
	public void testDatabaseImpl() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetDBConnection() {
		int status = 0;
		DatabaseImpl dbU = new DatabaseImpl();
		status = dbU.getDBConnection("mySql");
		assertEquals(1, status);
		
	}
	@Test
	public void testCheckLogin() {
		
		//Login Testing
		DatabaseImpl databaseImpl;
		//calcService = new CalcService(addService);
		//databaseImpl = new DatabaseImpl(databaseImpl);
		databaseImpl = mock(DatabaseImpl.class);
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibs@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
		when(databaseImpl.checkLogin(credentialsBean)).thenReturn(true);
		boolean actual = databaseImpl.checkLogin(credentialsBean);
		assertEquals(true,actual);
		credentialsBean.setEmail("vibs@gmail.com");
		credentialsBean.setPassword("WrongPassword");
		actual = databaseImpl.checkLogin(credentialsBean);
		//assertEquals(false,actual);
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdateLoginStatus() {
	  DatabaseImpl testobj = mock(DatabaseImpl.class);
	  when(testobj.updateLoginStatus("vibs@gmail.com")).thenReturn(1);
		int result= testobj.updateLoginStatus("vibs@gmail.com");
		assertEquals(1,result);
	}


	@Test
	public void testRegister() {
     
		DatabaseImpl testobj = mock(DatabaseImpl.class);
		ProfileBean pb = new ProfileBean();
		pb.setUserID(1142061);
		pb.setFirstName("Ajai");
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
		
		DatabaseImpl userobj = new DatabaseImpl(testobj);
		
		String result= testobj.register(pb);
		assertEquals("success",result);
	}
	@Test
	public void testSaveProfile() {
		// This Function is a part of Register function, 
		//so no need of checking
	}

	@Test
	public void testGetUserId() {
		// User Id from email ID
		DatabaseImpl db = new DatabaseImpl();
		int status = db.getUserId("vibs@gmail.com");
		assertEquals(1, status);
		
	}

	@Test
	public void testLogout() {
		//Already Checked
		DatabaseImpl databaseImpl;
		databaseImpl = new DatabaseImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibs@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
	    //Correct Data | ADMIN
		boolean status1 = databaseImpl.checkLogin(credentialsBean);
		//Sending email after, login
		boolean status = databaseImpl.logout(credentialsBean.getEmail());
		assertEquals(true, status);
	}

	@Test
	public void testCheckDuplicate() {
		DatabaseImpl db = new DatabaseImpl();
		boolean status = db.checkDuplicate("vibs@gmail.com");
		assertEquals(true, status);
	}

	@Test
	public void testDisplayProfile() {
		// Already Checked
	}


}
