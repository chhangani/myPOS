package com.ntl.pos.dao;

import java.util.ArrayList;

import com.ntl.pos.bean.CartBean;
import com.ntl.pos.bean.CreditCardBean;
import com.ntl.pos.bean.OrderBean;
import com.ntl.pos.bean.StoreBean;

public interface CustomerDAO {
	int addToCart(CartBean cartBean);
	boolean modifyCart(CartBean cartBean);
	String confirmOrder(ArrayList<Integer> cartIds);
	String cancelOrder(String orderId);
	ArrayList<StoreBean> viewStore(String city);
	ArrayList<CartBean> viewCart(String userid);
	int Available(int foodId);
	boolean isMyCartId(int cartId);
	int getFoodId(int cartId);
	int myQuantity(int cartId);
	boolean isMyCreditCart();
	boolean addCreditCard(CreditCardBean creditCardBean);
	ArrayList <OrderBean> viewOrder();

}
