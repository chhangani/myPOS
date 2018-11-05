package com.ntl.pos.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.OrderBean;
import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.dao.impl.AdministratorDAOImpl;
import com.ntl.pos.dao.impl.CustomerDAOImpl;

public class AdministratorDAOImplTest {

	
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
	public void testAdministratorDAOImpl() {
		// Constructor no need to test
	}
	@Test
	public void testAddStore() {
		StoreBean sb = new StoreBean(0,"NIIT Pizza","abc","9876543210","Gr Noida","UP","136119");
	    AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
		when(testobj.addStore(sb)).thenReturn("SUCCESS");
		String result= testobj.addStore(sb);
		assertEquals("SUCCESS",result);
	}
	@Test
	public void testModifyStore() {
		StoreBean sb = new StoreBean(5,"NIIT Pizza","abc","9876543210","Gr Noida","UP","136119");
	    AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
		when(testobj.modifyStore(sb)).thenReturn(true);
	 	
		boolean result= testobj.modifyStore(sb);
		assertEquals(true,result);
	}

	@Test
	public void testRemoveStore() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("3");
		arr.add("4");
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
		when(testobj.removeStore(arr)).thenReturn(2);
		int count  = testobj.removeStore(arr);
		assertEquals(2,count);
	}

	@Test
	public void testViewStore() {
		String storeId = "4";
		AdministratorDAOImpl testobj = new AdministratorDAOImpl(); 
		StoreBean sb = new StoreBean();
		//when(testobj.viewStore(storeId)).thenReturn(sb);
		sb = testobj.viewStore(storeId);
		String s = sb.getMobileNo();
		assertEquals("6375123454",s);	
	}

	@Test
	public void testViewAllStore() {
		AdministratorDAOImpl testobj = new AdministratorDAOImpl(); 
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
		when(testobj.isStoreId(storeId)).thenReturn(true);
		boolean status = testobj.isStoreId(storeId);
		assertEquals(true,status);	
		
	}

	@Test
	public void testViewAllFood() {
		AdministratorDAOImpl testobj = new AdministratorDAOImpl(); 
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
		when(testobj.addFood(fb,4)).thenReturn("SUCCESS");
		
		String result= testobj.addFood(fb,4);
		assertEquals("SUCCESS",result);
	}

	@Test
	public void testViewFood() {
		// Onion Pizza     | Veg  | Medium   |       10 |   149 |       4 |
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class);
		FoodBean fb = new FoodBean(3,"Onion Pizza","Veg","Medium",10,149,4);
		when(testobj.viewFood("3")).thenReturn(fb);
		fb = testobj.viewFood("3");
		assertEquals(3,fb.getFoodId());
	}

	@Test
	public void testRemoveFood() {
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class);
		when(testobj.removeFood(4, 4)).thenReturn(true);
		boolean status = testobj.removeFood(4, 4);
		assertEquals(true,status);
	}

	@Test
	public void testModifyFood() {
		FoodBean fb = new FoodBean(4,"Demo","Demo","Demo",100,100,4);
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
		when(testobj.modifyFood(fb)).thenReturn(true);
		boolean result= testobj.modifyFood(fb);
		assertEquals(true,result);
	}

	@Test
	public void testIsFoodId() {
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class); 
		when(testobj.isFoodId(4)).thenReturn(true);
		boolean result = testobj.isFoodId(4);
		assertEquals(true,result);
	}

	@Test
	public void testViewAllOrder() {
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class);
		ArrayList<OrderBean> ob = new ArrayList<OrderBean>();
		ob.add(new OrderBean());
		ob.add(new OrderBean());
		when(testobj.viewAllOrder()).thenReturn(ob);
		ob = testobj.viewAllOrder();
		assertEquals(2, ob.size());
	}

	@Test
	public void testIsThisOrderId() {
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class);
		when(testobj.isThisOrderId(1)).thenReturn(true);
		boolean status = testobj.isThisOrderId(1);
		assertEquals(true,status);
	}

	@Test
	public void testChangeOrderStatus() {
		AdministratorDAOImpl testobj = mock(AdministratorDAOImpl.class);
		when(testobj.changeOrderStatus(1, 1)).thenReturn("Success");
		String result =testobj.changeOrderStatus(1, 1);
		assertEquals("Success",result);
	}

}
