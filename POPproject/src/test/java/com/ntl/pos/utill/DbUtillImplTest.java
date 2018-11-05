package com.ntl.pos.utill;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.ntl.pos.utill.impl.DbUtillImpl;

public class DbUtillImplTest {

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
	public void testDbUtillImpl() {
		// Constructor,  No need to test
	}
	

	@Test
	public void testGetDBConnection() {
		java.sql.Connection conn;
		DbUtillImpl dbU = new DbUtillImpl();
		conn  = dbU.getDBConnection("com.mysql.jdbc.Driver");
		boolean status = true;
		try {
			if(conn.isClosed()) {
				status = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, status);
	}
}
