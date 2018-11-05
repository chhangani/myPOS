package com.ntl.pos.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import com.ntl.pos.bean.CartBean;
import com.ntl.pos.bean.CreditCardBean;
import com.ntl.pos.bean.OrderBean;
import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.dao.CustomerDAO;
import com.ntl.pos.dao.impl.CustomerDAOImpl;
import com.ntl.pos.service.Customer;

public class CustomerImpl implements Customer {

	CustomerDAOImpl custdao = new CustomerDAOImpl();
	public CustomerImpl(){
		
	}
	
	public CustomerImpl(CustomerDAOImpl testobj) {
		// TODO Auto-generated constructor stub
		this.custdao = testobj;
	}
	//@Override
	public int addToCart(CartBean cartBean) {
		// TODO Auto-generated method stub
		int result = custdao.addToCart(cartBean);
		return result;
	}

	//@Override
	public boolean modifyCart(CartBean cartBean) {
		// TODO Auto-generated method stub
		boolean result = custdao.modifyCart(cartBean);
		return result;
	}

	//@Override
	public String cancelOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public ArrayList<StoreBean> viewStore(String city) {
		// TODO Auto-generated method stub
		ArrayList<StoreBean> arr = custdao.viewStore(city);
		return arr;
	}

	//@Override
	public ArrayList<CartBean> viewCart(String userid) {
		// TODO Auto-generated method stub
		ArrayList<CartBean> arr = custdao.viewCart(userid);;
		return arr;
	}

	//@Override
	public int Available(int foodId) {
		// TODO Auto-generated method stub
		int result = custdao.Available(foodId);
		return result;
	}
	//@Override
	public boolean isMyCartId(int cartId) {
		// TODO Auto-generated method stub
		boolean result = custdao.isMyCartId(cartId);;
		return result;
	}
	//@Override
	public int getFoodId(int cartId) {
		// TODO Auto-generated method stub
		int result = custdao.getFoodId(cartId);;
		return result;
	}
	//@Override
	public int myQuantity(int cartId) {
		// TODO Auto-generated method stub
		int result = custdao.myQuantity(cartId);;
		return result;
	}
	//@Override
	public boolean isMyCreditCart() {
		// TODO Auto-generated method stub
		boolean result = custdao.isMyCreditCart();
		return result;
	}
	//@Override
	public boolean addCreditCard(CreditCardBean creditCardBean) {
		// TODO Auto-generated method stub
		boolean result = custdao.addCreditCard(creditCardBean);
		return result;
	}
	//@Override
	public String confirmOrder(ArrayList<Integer> cartIds) {
		// TODO Auto-generated method stub
		String result = custdao.confirmOrder(cartIds);
		return result;
	}
	//@Override
	public ArrayList<OrderBean> viewOrder() {
		// TODO Auto-generated method stub
		ArrayList<OrderBean> arr = custdao.viewOrder();
		return arr;
	}

}
