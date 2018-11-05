package com.ntl.pos.service.impl;

import java.util.ArrayList;

import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.OrderBean;
import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.dao.AdministratorDAO;
import com.ntl.pos.dao.impl.AdministratorDAOImpl;
import com.ntl.pos.service.Administrator;


public class AdministratorImpl implements AdministratorDAO{

	AdministratorDAO  admindao= new AdministratorDAOImpl();
	//public AdministratorDAOImpl admin = new AdministratorDAOImpl();
	public AdministratorImpl(AdministratorDAOImpl testobj) {
		// TODO Auto-generated constructor stub
		this.admindao = testobj;
	}
	public AdministratorImpl() {
		// TODO Auto-generated constructor stub
	}
	//@Override
	public String addStore(StoreBean storebean) {
		// TODO Auto-generated method stub
		String  s = admindao.addStore(storebean);;
		return s;
	}

	//@Override
	public boolean modifyStore(StoreBean storebean) {
		// TODO Auto-generated method stub
		boolean result = admindao.modifyStore(storebean);;
		return result;
	}

	//@Override
	public int removeStore(ArrayList<String> storeId) {
		// TODO Auto-generated method stub
		int result = admindao.removeStore(storeId);
		return result;
	}

	//@Override
	public StoreBean viewStore(String storeId) {
		// TODO Auto-generated method stub
		StoreBean sb = admindao.viewStore(storeId);
		return sb;
	}

	//@Override
	public ArrayList<StoreBean> viewAllStore() {
		// TODO Auto-generated method stub
		ArrayList<StoreBean> arr = admindao.viewAllStore();
		return arr;
	}
	public boolean isStoreId(int storeId) {
		boolean  result = admindao.isStoreId(storeId);
		return result;
	}

	//@Override
	public ArrayList<FoodBean> viewAllFood(int storeId) {
		// TODO Auto-generated method stub
		ArrayList<FoodBean> arr = admindao.viewAllFood(storeId);
		return arr;
	}

	//@Override
	public String addFood(FoodBean foodbean, int storeId) {
		// TODO Auto-generated method stub
		String result = admindao.addFood(foodbean, storeId);
		return result;
	}


	//@Override
	public FoodBean viewFood(String foodId) {
		// TODO Auto-generated method stub
		FoodBean fb = admindao.viewFood(foodId);
		return fb;
	}

	//@Override
	public boolean removeFood(int foodId, int storeId) {
		// TODO Auto-generated method stub
		boolean result = admindao.removeFood(foodId, storeId);
		return result;
	}

	//@Override
	public boolean modifyFood(FoodBean foodbean) {
		// TODO Auto-generated method stub
		boolean result = admindao.modifyFood(foodbean);
		return result;
	}

	//@Override
	public boolean isFoodId(int foodId) {
		// TODO Auto-generated method stub
		boolean result = admindao.isFoodId(foodId);
		return result;
	}

	//@Override
	public ArrayList<OrderBean> viewAllOrder() {
		// TODO Auto-generated method stub
		ArrayList<OrderBean> arr = admindao.viewAllOrder();
		return arr;
	}

	//@Override
	public boolean isThisOrderId(int orderId) {
		// TODO Auto-generated method stub
		boolean result = admindao.isThisOrderId(orderId);
		return result;
	}

	//@Override
	public String changeOrderStatus(int orderId, int option) {
		// TODO Auto-generated method stub
		String result = admindao.changeOrderStatus(orderId, option);
		return result;
	}

	

}
