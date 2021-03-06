package com.ntl.pos.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ntl.pos.bean.CartBean;
import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.bean.CreditCardBean;
import com.ntl.pos.dao.impl.CustomerDAOImpl;
import com.ntl.pos.service.impl.CustomerImpl;
import com.ntl.pos.utill.impl.AuthenticationImpl;
import com.ntl.pos.utill.impl.UserImpl;


public class CustomerImplTest {

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
	public void testCustomerImpl() {
	     // Constructor No Need of test
	}
	@Test
	public void testAddToCart() {
		// Food Id and Cart Bean
		CustomerDAOImpl testobj = mock(CustomerDAOImpl.class);
		int foodId =  5;
		int Qty = 10;
		CartBean cartB = new CartBean(foodId,Qty);
		UserImpl userImpl;
		userImpl = new UserImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibhanshu@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
		String actual = userImpl.login(credentialsBean);
		CustomerImpl cust = new CustomerImpl(testobj);
		when(cust.addToCart(cartB)).thenReturn(1);
		
		int result= cust.addToCart(cartB);
		assertEquals(1,result);
	} 

	@Test
	public void testModifyCart() {
		CustomerDAOImpl testobj = mock(CustomerDAOImpl.class);
		int foodId =  3;
		int Qty = 5;
		CartBean cartB = new CartBean(foodId,Qty);
		UserImpl userImpl;
		userImpl = new UserImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibhanshu@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
		String actual = userImpl.login(credentialsBean);
		CustomerImpl cust = new CustomerImpl(testobj);
		when(cust.modifyCart(cartB)).thenReturn(true);
		
		boolean result= cust.modifyCart(cartB);
		assertEquals(true,result);
	}

	@Test
	public void testViewStore() {
	  //Already Implemented
		
	}
   @Test
   public void testViewCart() {
	   CustomerDAOImpl cust = new CustomerDAOImpl();
	   ArrayList<CartBean> cb = cust.viewCart("5");
	   int status = 0;
	   if(cb.size()>0) {
		   status = 1;
	   }
	   assertEquals(1, status);
   }
	
	@Test
	public void testAvailable() {		
		CustomerDAOImpl cust = new CustomerDAOImpl();
		int cb = cust.Available(3);
		int status = 0;
		if(cb>0) {
			status = 1;
		}
		assertEquals(1, status);
		
	}

	@Test
	public void testIsMyCartId() {
		CustomerImpl cust = new CustomerImpl();
		UserImpl userImpl;
		userImpl = new UserImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibhanshu@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
		String actual = userImpl.login(credentialsBean);
		boolean status = cust.isMyCartId(3);
		assertEquals(true, status);
	}
	@Test
	public void testMyQuantity() {
		CustomerImpl cust = new CustomerImpl();
		int qty = cust.myQuantity(3);
		if(qty>0) {
			qty = 1;
		}
		assertEquals(1, qty);
		
	}

	@Test
	public void testIsMyCreditCart() {
		CustomerImpl cust = new CustomerImpl();
		UserImpl userImpl;
		userImpl = new UserImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibhanshu@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
		String actual = userImpl.login(credentialsBean);
		boolean status = cust.isMyCreditCart();
		assertEquals(true, status);
	}

	@Test
	public void testAddCreditCard() {
		CustomerDAOImpl testobj = mock(CustomerDAOImpl.class);
		CreditCardBean ccb = new CreditCardBean();
		ccb.setBalance(10000);
		ccb.setCreditCardNumber("1234567876543216");
		ccb.setValidFrom("07/2018");
		ccb.setValidTo("09/2020");
		UserImpl userImpl;
		userImpl = new UserImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibhanshu@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
		String actual = userImpl.login(credentialsBean);
		CustomerImpl cust = new CustomerImpl(testobj);
		when(cust.addCreditCard(ccb)).thenReturn(true);
		
		boolean status= cust.addCreditCard(ccb);
		assertEquals(true,status);
	}

	@Test
	public void testConfirmOrder() {
		CustomerDAOImpl testobj = mock(CustomerDAOImpl.class);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(3);
		UserImpl userImpl;
		userImpl = new UserImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setEmail("vibhanshu@gmail.com");
		credentialsBean.setPassword("Mdm@9782");
		String actual = userImpl.login(credentialsBean);
		CustomerImpl cust = new CustomerImpl(testobj);
		when(cust.confirmOrder(arr)).thenReturn("Pending");
		String result = cust.confirmOrder(arr);
		assertEquals("Pending",result);
	}

}
