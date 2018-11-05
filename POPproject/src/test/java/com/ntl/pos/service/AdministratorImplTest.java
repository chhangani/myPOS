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
import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.OrderBean;
import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.dao.impl.AdministratorDAOImpl;
import com.ntl.pos.dao.impl.CustomerDAOImpl;
import com.ntl.pos.service.impl.AdministratorImpl;
import com.ntl.pos.service.impl.CustomerImpl;
import com.ntl.pos.utill.impl.UserImpl;


public class AdministratorImplTest {

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
	public void testAddStore() {

		StoreBean sb = new StoreBean(0,"NIIT Pizza","abc","9876543210","Gr Noida","UP","136119");
	    AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
	    AdministratorImpl admin = new AdministratorImpl(testobj);
	    when(admin.addStore(sb)).thenReturn("SUCCESS");
		String result= admin.addStore(sb);
		assertEquals("SUCCESS",result);
	}
	@Test
	public void testModifyStore() {
		StoreBean sb = new StoreBean(5,"NIIT Pizza","abc","9876543210","Gr Noida","UP","136119");
	    AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
	    AdministratorImpl admin = new AdministratorImpl(testobj);
	    when(admin.modifyStore(sb)).thenReturn(true);
	 	
		boolean result= admin.modifyStore(sb);
		assertEquals(true,result);
	}

	@Test
	public void testRemoveStore() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("3");
		arr.add("4");
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
	    AdministratorImpl admin = new AdministratorImpl(testobj);
		when(admin.removeStore(arr)).thenReturn(2);
		int count  = admin.removeStore(arr);
		assertEquals(2,count);
	}

	@Test
	public void testViewStore() {
		String storeId = "4";
		AdministratorImpl testobj = new AdministratorImpl(); 
		StoreBean sb = new StoreBean();
		sb = testobj.viewStore(storeId);
		assertEquals(4,sb.getStoreID());
	}
	@Test
	public void testViewAllStore() {
		AdministratorImpl testobj = new AdministratorImpl(); 
		ArrayList<StoreBean> sb = new ArrayList<StoreBean>();
		sb = testobj.viewAllStore();
		int status = 0;
		if(sb.size()>0) {
			status = 1;
		}
		assertEquals(1,status);	
	}
	@Test
	public void testIsStoreId() {
		int storeId = 4;
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
	    AdministratorImpl admin = new AdministratorImpl(testobj);
	    
		when(admin.isStoreId(storeId)).thenReturn(true);
		boolean status = admin.isStoreId(storeId);
		assertEquals(true,status);
	}
	@Test
	public void testViewAllFood() {
		AdministratorImpl testobj = new AdministratorImpl(); 
		ArrayList<FoodBean> fb = new ArrayList<FoodBean>();
		fb = testobj.viewAllFood(4);
		int status = 0;
		if(fb.size()>0) {
			status = 1;
		}
		assertEquals(1,status);	
	}

	@Test
	public void testAddFood() {
		
		FoodBean fb = new FoodBean(0,"Demo","Demo","Demo",100,100,4);
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
	    AdministratorImpl admin = new AdministratorImpl(testobj);
		when(admin.addFood(fb,4)).thenReturn("SUCCESS");
		
		String result= admin.addFood(fb,4);
		assertEquals("SUCCESS",result);
	}

	@Test
	public void testViewFood() {
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
	    AdministratorImpl admin = new AdministratorImpl(testobj);
		FoodBean fb = new FoodBean(3,"Onion Pizza","Veg","Medium",10,149,4);
		when(admin.viewFood("3")).thenReturn(fb);
		fb = admin.viewFood("3");
		assertEquals(3,fb.getFoodId());
	}
	@Test
	public void testRemoveFood() {
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
	    AdministratorImpl admin = new AdministratorImpl(testobj);
		when(admin.removeFood(4, 4)).thenReturn(true);
		boolean status = admin.removeFood(4, 4);
		assertEquals(true,status);
	}

	@Test
	public void testModifyFood() {
		FoodBean fb = new FoodBean(4,"Demo","Demo","Demo",100,100,4);
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
	    AdministratorImpl admin = new AdministratorImpl(testobj);
		when(admin.modifyFood(fb)).thenReturn(true);
		boolean result= admin.modifyFood(fb);
		assertEquals(true,result);
	}

	@Test
	public void testIsFoodId() {
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
	    AdministratorImpl admin = new AdministratorImpl(testobj);
		when(admin.isFoodId(4)).thenReturn(true);
		boolean result = admin.isFoodId(4);
		assertEquals(true,result);
	}

	@Test
	public void testViewAllOrder() {
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
	    AdministratorImpl admin = new AdministratorImpl(testobj);
		ArrayList<OrderBean> ob = new ArrayList<OrderBean>();
		ob.add(new OrderBean());
		ob.add(new OrderBean());
		when(admin.viewAllOrder()).thenReturn(ob);
		ob = admin.viewAllOrder();
		assertEquals(2, ob.size());
	}

	@Test
	public void testIsThisOrderId() {
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
	    AdministratorImpl admin = new AdministratorImpl(testobj);
		when(admin.isThisOrderId(1)).thenReturn(true);
		boolean status = admin.isThisOrderId(1);
		assertEquals(true,status);
	}

	@Test
	public void testChangeOrderStatus() {
		//AdministratorImpl ad = new AdministratorImpl();
	}
}
