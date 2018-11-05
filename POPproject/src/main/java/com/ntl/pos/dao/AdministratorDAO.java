package com.ntl.pos.dao;

import java.util.ArrayList;

import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.OrderBean;
import com.ntl.pos.bean.StoreBean;

public interface AdministratorDAO {
	public String addStore(StoreBean storebean);
	public boolean modifyStore(StoreBean storebean);
	public int removeStore(ArrayList<String> storeId);
	public StoreBean viewStore(String storeId);
	public ArrayList <StoreBean> viewAllStore();
	public boolean isStoreId(int storeId);
	
	public ArrayList <OrderBean> viewAllOrder();
	String changeOrderStatus(int orderId,int option);
	boolean isThisOrderId(int orderId);
	
	ArrayList<FoodBean> viewAllFood(int storeId);
	String addFood(FoodBean foodbean,int storeId);
	FoodBean viewFood(String foodId);
	boolean removeFood(int foodId, int storeId);
	boolean modifyFood(FoodBean foodbean);
	public boolean isFoodId(int foodId);
	
	
}
