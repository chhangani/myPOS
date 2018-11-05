package com.ntl.pos.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ntl.pos.service.impl.Services;


public class ServicesTest {

	
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
	public void testCheckDuplicate() {
        // Already Implemented
	}

	@Test
	public void testValidateEmail() {
		Services serv = new Services();
		boolean status = serv.validateEmail("vibhanshu@gmail.com");
		assertEquals(true, status);
		status = serv.validateEmail("vibhanshu@gmail.com.com");
		assertEquals(true, status);
		status = serv.validateEmail("@gmail.com");
		assertEquals(false, status);
	}

	@Test
	public void testValidatePassword() {
		Services serv = new Services();
		boolean status = serv.validatePassword("Mdm@9782");
		assertEquals(true, status);
		status = serv.validatePassword("mdm@8763P");
		assertEquals(true, status);
		status = serv.validatePassword("vibhanshu");
		assertEquals(false, status);
	}

	@Test
	public void testValidateDate() {
		Services serv = new Services();
		boolean status = serv.validateDate("22/09/1997");
		assertEquals(true, status);
		status = serv.validatePassword("Other then above format");
		assertEquals(false, status);
	}
}
